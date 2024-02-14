<template>
  <div>
    <b-overlay :show="isLoading" rounded="sm">
      <b-row class="justify-content-end">
        <b-col cols="12" sm="auto">
          <b-button variant="success" v-b-modal.modal-save-movie>
            Registrar</b-button
          >
        </b-col>
      </b-row>
      <b-row class="align-items-stretch" v-if="movies.length != 0">
        <b-col
          cols="12"
          sm="6"
          md="4"
          lg="3"
          v-for="movie in movies"
          :key="movie.id"
          class="my-2"
        >
          <b-card
            :title="movie.title"
            img-src="https://picsum.photos/id/870/600/400?grayscale&blur=2"
            img-alt="Image"
            img-top
            tag="article"
            style="max-width: 20rem"
            class="my-3 h-100"
          >
            <b-card-text>
              <p>Descripción: {{ movie.description }}</p>
              <p>Fecha de publicación: {{ movie.atPublish }}</p>
            </b-card-text>
            <b-row>
              <b-col cols="12" sm="12">
                <b-button
                  variant="danger"
                  block
                  v-b-tooltip.hover
                  title="Desactivar"
                  v-if="movie.status == true"
                  @click="changeStatus(movie)"
                  ><b-icon icon="arrow-down"></b-icon
                ></b-button>
                <b-button
                  variant="success"
                  block
                  v-b-tooltip.hover
                  title="Activar"
                  v-else
                  @click="changeStatus(movie)"
                  ><b-icon icon="arrow-up"></b-icon
                ></b-button>
              </b-col>
              <b-col cols="12" sm="12" class="mt-2">
                <b-button
                  variant="info"
                  block
                  v-b-tooltip.hover
                  title="Actualizar"
                  @click="onRecordSelected(movie)"
                  >Actualizar</b-button
                >
              </b-col>
            </b-row>
          </b-card>
        </b-col>
      </b-row>
      <b-row v-else-if="movies.length == 0 && !isLoading">
        <b-col cols="12" sm="12" class="text-center">
          <h3>Sin registros</h3>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <div class="mt-3">
            <b-pagination
              v-model="currentPage"
              pills
              :total-rows="totalRows"
              :per-page="perPage"
              @input="getMovies"
            ></b-pagination>
          </div>
        </b-col>
      </b-row>
      <SaveMovie @reload="getMovies"
    />
    <UpdateMovie :item="recordForUpdate" @reload="getMovies"/>
  </b-overlay>
  </div>
</template>
<script>
import Vue, { defineAsyncComponent } from "vue";
import SaveMovie from "../views/SaveMovie.vue";
import UpdateMovie from "../views/UpdateMovie.vue";
import Axios from "axios";
export default Vue.extend({
  name: "Movies",
  components: {
    SaveMovie,
    UpdateMovie,
  },
  data() {
    return {
      movies: [],
      isLoading: false,
      currentPage: 1,
      perPage: 4,
      totalRows: 0,
      recordForUpdate: {}
    };
  },
  methods: {
    makeToast() {
      this.$bvToast.toast("Cambio de estado exitoso", {
        title: `Éxito`,
        variant: "success",
        solid: true,
      });
    },
    onRecordSelected(item) {
      this.recordForUpdate = { ...item };
      this.$bvModal.show("modal-update-movie");
    },
    async getMovies() {
      try {
        this.isLoading = true;
        const pageable = `?sort=id&direction=asc&page=${this.currentPage - 1}&size=${this.perPage}`
        const response = await Axios.get(`http://localhost:8080/api/movie/${pageable}`);
        this.totalRows = response.data.totalElements
        console.log(response.data.content);
        console.log(response.data);
        this.movies = response.data.content;
      } catch (error) {
        throw error;
      } finally {
        this.isLoading = false;
      }
    },
    async changeStatus(item) {
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
              this.isLoading = true;
              const response = await Axios.patch(
                `http://localhost:8080/api/movie/change-status/${item.id}`
              );
              this.getMovies();
              this.makeToast();
              console.log(response);
            }
          });
      } catch (error) {
        console.log(error);
      } finally {
        this.isLoading = false;
      }
    },
  },
  mounted() {
    this.getMovies();
  },
  // computed: {
  //     rows() {
  //       return this.movies.length
  //     }
  //   }
});
</script>
