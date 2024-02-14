<template>
    <div>
      <b-modal
        id="modal-update-movie"
        ref="modal-update-movie"
        title="Actualizar película"
        centered
        @hidden="cleanForm"
        @close="cleanForm"
        size="lg"
        hide-footer
        :no-close-on-backdrop="true"
      >
        <b-form ref="form" @submit.stop.prevent="updateMovie">
          <b-row>
            <b-col cols="12" sm="6">
              <b-form-group>
                <label for="name">
                  Nombre de la película:&nbsp;<b class="text-danger">*</b></label
                >
                <b-form-input
                  id="name-input"
                  type="text"
                  placeholder="Ingresa el nombre"
                  v-model="v$.newMovie.title.$model"
                  @blur="v$.newMovie.title.$touch"
                  :state="
                    v$.newMovie.title.$dirty ? !v$.newMovie.title.$error : null
                  "
                >
                </b-form-input>
                <b-form-invalid-feedback v-if="v$.newMovie.title.$error"
                  >Campo obligatorio</b-form-invalid-feedback
                >
              </b-form-group>
            </b-col>
            <b-col cols="12" sm="6">
              <b-form-group>
                <label for="description">
                  Descripción:&nbsp;<b class="text-danger">*</b></label
                >
                <b-form-input
                  id="description-input"
                  type="text"
                  placeholder="Ingresa la descripción"
                  v-model="v$.newMovie.description.$model"
                  @blur="v$.newMovie.description.$touch"
                  :state="
                    v$.newMovie.description.$dirty
                      ? !v$.newMovie.description.$error
                      : null
                  "
                >
                </b-form-input>
                <b-form-invalid-feedback v-if="v$.newMovie.description.$error"
                  >Campo obligatorio</b-form-invalid-feedback
                >
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col cols="12" sm="6">
              <b-form-group>
                <label for="director">
                  Nombre del director:&nbsp;<b class="text-danger">*</b></label
                >
                <b-form-input
                  id="director"
                  type="text"
                  placeholder="Ingresa el nombre"
                  v-model="v$.newMovie.director.$model"
                  @blur="v$.newMovie.director.$touch"
                  :state="
                    v$.newMovie.director.$dirty
                      ? !v$.newMovie.director.$error
                      : null
                  "
                >
                </b-form-input>
                <b-form-invalid-feedback v-if="v$.newMovie.director.$error"
                  >Campo obligatorio</b-form-invalid-feedback
                >
              </b-form-group>
            </b-col>
            <b-col cols="12" sm="6">
              <b-form-group>
                <label for="atPublish">
                  Fecha de publicación:&nbsp;<b class="text-danger">*</b></label
                >
                <b-form-datepicker
                  id="atPublish"
                  v-model="v$.newMovie.atPublish.$model"
                  class="mb-2"
                  @blur="v$.newMovie.atPublish.$touch"
                  :state="
                    v$.newMovie.atPublish.$dirty
                      ? !v$.newMovie.atPublish.$error
                      : null
                  "
                ></b-form-datepicker>
                <b-form-invalid-feedback v-if="v$.newMovie.atPublish.$error"
                  >Campo obligatorio</b-form-invalid-feedback
                >
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <!-- <b-col cols="12" sm="6">
              <b-form-group>
                <label for="name">
                  Imagen/Portada:&nbsp;<b class="text-danger">*</b></label
                >
                <b-form-file
                  multiple
                  placeholder="Selecciona un archivo"
                  browse-text="Buscar"
                  accept="image/png"
                ></b-form-file>
              </b-form-group>
            </b-col> -->
            <b-col cols="12" sm="12">
              <b-form-group>
                <label for="description">
                  Categoria:&nbsp;<b class="text-danger">*</b></label
                >
                <b-form-select
                  v-model="v$.newMovie.category.id.$model"
                  :options="options"
                  @blur="v$.newMovie.category.id.$touch"
                  :state="
                    v$.newMovie.category.id.$dirty
                      ? !v$.newMovie.category.id.$error
                      : null
                  "
                ></b-form-select>
                <b-form-invalid-feedback v-if="v$.newMovie.category.id.$error"
                  >Campo obligatorio</b-form-invalid-feedback
                >
              </b-form-group>
            </b-col>
          </b-row>
        </b-form>
        <div class="col-12 mt-3 px-0 text-right">
          <b-button variant="outline-danger" @click="closeModal"
            >Cancelar</b-button
          >
          <b-button
            variant="secondary"
            class="ml-2"
            @click="handleOk"
            :disabled="v$.newMovie.$invalid"
            >Guardar</b-button
          >
        </div>
      </b-modal>
    </div>
  </template>
  
  <script>
  import Vue from "vue";
  import { useVuelidate } from "@vuelidate/core";
  import { required } from "@vuelidate/validators";
  import Axios from "axios";
  export default Vue.extend({
    name: "UpdateMovie",
    setup() {
      return { v$: useVuelidate() };
    },
    props: {
    item: {
      type: Object,
      required: true,
    },
  },
  watch: {
    item() {
      this.newMovie = { ...this.item };
      console.log("itemprops",this.newMovie)
    },
  },
    data() {
      return {
        newMovie: {
            ...this.item
        },
        selected: null,
        options: [],
      };
    },
    methods: {
      async getCategories() {
        try {
          const response = await Axios.get("http://localhost:8080/api/category/");
          console.log("ayuya", response.data.content);
          this.options = response.data.content.map((element) => ({
            text: element.name,
            value: element.id,
          }));
          this.options.push({ value: null, text: "Selecciona una opción" });
          return response.data;
        } catch (error) {
          throw error;
        }
      },
      async updateMovie() {
        try {
          this.$swal
            .fire({
              title: "Cuidado",
              text: "¿Seguro que desea realizar la acción?",
              icon: "question",
              confirmButtonText: "Aceptar",
              showCancelButton: true,
              cancelButtonText: "Cancelar",
            })
            .then(async (result) => {
              if (result.isConfirmed) {
                console.log(this.newMovie);
                const response = await Axios.put(
                  " http://localhost:8080/api/movie/update/",
                  this.newMovie
                );
                console.log(response);
                this.$emit("reload");
                this.$nextTick(() => this.$bvModal.hide("modal-update-movie"));
                this.cleanForm();
                this.makeToast();
                return response.data;
              }
            });
        } catch (error) {
          throw error;
        }
      },
      cleanForm() {
        this.newMovie = {
          title: "",
          description: "",
          image: "",
          director: "",
          atPublish: "",
          category: {
            id: null,
          },
        };
        this.v$.newMovie.$reset();
      },
      handleOk(bvModalEvent) {
        bvModalEvent.preventDefault();
        this.updateMovie();
      },
      makeToast() {
        this.$bvToast.toast("Registro exitoso", {
          title: `Éxito`,
          variant: "success",
          solid: true,
        });
      },
      closeModal() {
        this.$bvModal.hide("modal-update-movie");
      },
    },
    validations() {
      return {
        newMovie: {
          title: {
            required,
          },
          description: {
            required,
          },
          atPublish: {
            required,
          },
          director: {
            required,
          },
          category: {
            id: {
              required,
            },
          },
        },
      };
    },
    mounted() {
      this.getCategories();
    },
  });
  </script>
  