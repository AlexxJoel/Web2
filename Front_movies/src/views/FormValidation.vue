<template>
  <div>
    <b-form>
      <b-row>
        <b-col cols="12" sm="12" md="4">
          <b-form-group id="name-group">
            <label for="name">Nombre:&nbsp;<b class="text-danger">*</b> </label>
            <b-form-input
              id="name-input"
              type="text"
              placeholder="Ingresa tu nombre"
              v-model="v$.name.$model"
              @blur="v$.name.$touch"
              :state="v$.name.$dirty ? !v$.name.$error : null"
            >
            </b-form-input>
            <b-form-invalid-feedback v-if="v$.name.$error"
              >Campo obligatorio</b-form-invalid-feedback
            >
          </b-form-group>
        </b-col>
        <b-col cols="12" sm="12" md="4">
          <b-form-group id="surname-group">
            <label for="surname-input"
              >Apellido paterno:&nbsp;<b class="text-danger">*</b>
            </label>
            <b-form-input
              id="surname-input"
              type="text"
              placeholder="Ingresa tu apellido paterno"
              v-model="v$.surname.$model"
              @blur="v$.surname.$touch"
              :state="v$.surname.$dirty ? !v$.surname.$error : null"
            >
            </b-form-input>
            <b-form-invalid-feedback v-if="v$.surname.$error"
              >Campo obligatorio</b-form-invalid-feedback
            >
          </b-form-group>
        </b-col>
        <b-col cols="12" sm="12" md="4">
          <b-form-group id="lastname-group">
            <label for="lastname-input">Apellido materno:</label>
            <b-form-input
              id="lastname-input"
              type="text"
              placeholder="Ingresa tu apellido materno"
              v-model="v$.lastname.$model"
              @blur="v$.lastname.$touch"
              :state="v$.lastname.$dirty ? !v$.lastname.$error : null"
            >
            </b-form-input>
            <b-form-invalid-feedback v-if="v$.lastname.$error"
              >Campo obligatorio</b-form-invalid-feedback
            >
          </b-form-group>
        </b-col>
      </b-row>
      <b-row class="mt-4">
        <b-col cols="12" sm="12" md="4">
          <b-form-group id="cp-group">
            <label for="cp-input"
              >Cógido postal:&nbsp;<b class="text-danger">*</b></label
            >
            <b-form-input
              id="cp-input"
              type="text"
              placeholder="Ingresa tu código postal"
              @keypress="signal"
              maxlength="5"
              v-model="v$.postalCode.$model"
              @blur="v$.postalCode.$touch"
              :state="v$.postalCode.$dirty ? !v$.postalCode.$error : null"
            >
            </b-form-input>
            <b-form-invalid-feedback v-if="!v$.postalCode.required.$response"
              >Campo obligatorio</b-form-invalid-feedback
            >
            <b-form-invalid-feedback
              v-if="
                !v$.postalCode.valid.$response &&
                v$.postalCode.required.$response
              "
              >C.P inválido (Mínimo 5 caracteres)</b-form-invalid-feedback
            >
          </b-form-group>
        </b-col>
        <b-col cols="12" sm="12" md="4">
          <b-form-group id="street-group">
            <label for="street-input"
              >Calle:&nbsp;<b class="text-danger">*</b></label
            >
            <b-form-input
              id="street-input"
              type="text"
              placeholder="Ingresa tu calle"
              v-model="v$.street.$model"
              @blur="v$.street.$touch"
              :state="v$.street.$dirty ? !v$.street.$error : null"
            >
            </b-form-input>
            <b-form-invalid-feedback v-if="v$.street.$error"
              >Campo obligatorio</b-form-invalid-feedback
            >
          </b-form-group>
        </b-col>
        <b-col cols="12" sm="12" md="4">
          <b-form-group id="number-group">
            <label for="number-input"
              >Número (#):&nbsp;<b class="text-danger">*</b></label
            >
            <b-form-input
              id="number-input"
              type="text"
              placeholder="Ingresa el número de tu dirección"
              v-model="v$.number.$model"
              @blur="v$.number.$touch"
              :state="v$.number.$dirty ? !v$.number.$error : null"
            >
            </b-form-input>
            <b-form-invalid-feedback v-if="v$.number.$error"
              >Campo obligatorio</b-form-invalid-feedback
            >
          </b-form-group>
        </b-col>
      </b-row>
      <b-row class="mt-4">
        <b-col cols="12" sm="12" md="4">
          <b-form-group id="city-group">
            <label for="city-input"
              >Ciudad:&nbsp;<b class="text-danger">*</b></label
            >
            <b-form-input
              id="city-input"
              type="text"
              placeholder="Ingresa tu ciudad"
              v-model="v$.city.$model"
              @blur="v$.city.$touch"
              :state="v$.city.$dirty ? !v$.city.$error : null"
            >
            </b-form-input>
            <b-form-invalid-feedback v-if="v$.city.$error"
              >Campo obligatorio</b-form-invalid-feedback
            >
          </b-form-group>
        </b-col>
        <b-col cols="12" sm="12" md="4">
          <b-form-group id="birthday-group">
            <label for="birthday-input"
              >Fecha de nacimiento:&nbsp;<b class="text-danger">*</b></label
            >
            <b-form-input
              id="birthday-input"
              type="date"
              placeholder="Ingresa tu fecha de naciemiento"
              v-model="v$.birthday.$model"
              @blur="v$.birthday.$touch"
              :state="v$.birthday.$dirty ? !v$.birthday.$error : null"
            >
            </b-form-input>
            <b-form-invalid-feedback v-if="!v$.birthday.required.$response"
              >Campo obligatorio</b-form-invalid-feedback
            >
            <b-form-invalid-feedback
              v-if="
                !v$.birthday.valid.$response && v$.birthday.required.$response
              "
              >Fecha de nacimiento inválida (Debe ser mayor a 18
              años)</b-form-invalid-feedback
            >
          </b-form-group>
        </b-col>
        <b-col cols="12" sm="12" md="4">
          <b-form-group id="email-group">
            <label for="email-input"
              >Correo electrónico:&nbsp;<b class="text-danger">*</b></label
            >
            <b-form-input
              id="email-input"
              type="email"
              placeholder="Ingresa tu correo"
              v-model="v$.email.$model"
              @blur="v$.email.$touch"
              :state="v$.email.$dirty ? !v$.email.$error : null"
            >
            </b-form-input>
            <b-form-invalid-feedback v-if="!v$.email.required.$response"
              >Campo obligatorio</b-form-invalid-feedback
            >
            <b-form-invalid-feedback
              v-if="!v$.email.valid.$response && v$.email.required.$response"
              >Correo inválido</b-form-invalid-feedback
            >
          </b-form-group>
        </b-col>
      </b-row>
      <b-row class="mt-4">
        <b-col cols="12" sm="12" md="4">
          <b-form-group id="phone-group">
            <label for="phone-input"
              >Teléfono:&nbsp;<b class="text-danger">*</b></label
            >
            <b-form-input
              id="phone-input"
              type="text"
              placeholder="Ingresa tu número de teléfono"
              v-model="v$.phone.$model"
              @keypress="signal"
              @blur="v$.phone.$touch"
              :state="v$.phone.$dirty ? !v$.phone.$error : null"
              maxlength="10"
            >
            </b-form-input>
            <b-form-invalid-feedback v-if="!v$.phone.required.$response"
              >Campo obligatorio</b-form-invalid-feedback
            >
            <b-form-invalid-feedback
              v-if="!v$.phone.valid.$response && v$.phone.required.$response"
              >Teléfono inválido (Min. 10 caracteres)</b-form-invalid-feedback
            >
          </b-form-group>
        </b-col>
        <b-col cols="12" sm="12" md="8">
          <b-form-group>
            <label for="photo-input"
              >Fotografía:&nbsp;<b class="text-danger">*</b></label
            >
            <b-form-file
              multiple
              placeholder="Selecciona un archivo"
              browse-text="Buscar"
              accept="image/png"
              @change="handleFile"
              :state="fileState"
              @blur="handleFile"
            ></b-form-file>
            <b-form-invalid-feedback v-if="fileTypeError"
              >Tipo de archivo incorrecto</b-form-invalid-feedback
            >
            <b-form-invalid-feedback v-else-if="fileSizeError"
              >El archivo debe tener un tamaño menor a
              3MB</b-form-invalid-feedback
            >
            <b-form-invalid-feedback v-else-if="noneFileError"
              >Campo obligatori</b-form-invalid-feedback
            >
          </b-form-group>
        </b-col>
      </b-row>
      <b-row class="mt-4">
        <b-col cols="12" sm="12" class="d-flex flex-row-reverse">
          <b-button
            variant="success"
            :disabled="
              v$.name.$invalid ||
              v$.surname.$invalid ||
              v$.lastname.$invalid ||
              v$.street.$invalid ||
              v$.number.$invalid ||
              v$.city.$invalid ||
              v$.birthday.$invalid ||
              v$.email.$invalid ||
              v$.phone.$invalid ||
              !fileState
            "
          >
            Enviar
          </b-button>
        </b-col>
      </b-row>
    </b-form>
  </div>
</template>
ß
<script>
import Vue from "vue";
import { useVuelidate } from "@vuelidate/core";
import { required } from "@vuelidate/validators";
export default Vue.extend({
  name: "FormValidation",
  setup() {
    return { v$: useVuelidate() };
  },
  data() {
    return {
      name: "",
      surname: "",
      lastname: "",
      postalCode: "",
      street: "",
      number: "",
      city: "",
      birthday: "",
      email: "",
      photo: "",
      phone: "",
      fileSizeError: false,
      fileTypeError: false,
      noneFileError: false,
      fileState: null,
    };
  },
  methods: {
    signal(event) {
      // Verifica si el evento contiene un dígito del 0 al 9
      if (event.keyCode >= 48 && event.keyCode <= 57) {
        return true; // Permitir dígitos del 0 al 9
      } else {
        event.preventDefault(); // Previene la acción predeterminada del evento
        return false; // Rechazar cualquier otro carácter
      }
    },
    fileSize(event) {
      const file = event.target.files[0];
      if (file) {
        this.noneFileError = false;
        if (file.size > 3 * 1024 * 1024) {
          this.fileSizeError = true;
          this.fileState = false;
        } else {
          this.fileSizeError = false;
          this.fileState = true;
        }
      }
    },
    fileType(event) {
      const file = event.target.files[0];
      console.log(file);
      if (file && file.type !== "image/png") {
        console.log("entro a type");
        this.fileTypeError = true;
        this.fileState = false;
      } else {
        this.fileTypeError = false;
        this.fileState = true;
      }
    },
    handleFile(event) {
      const file = event.target.files[0];
      if (!file) {
        this.noneFileError = true;
        this.fileState = false;
      } else {
        this.noneFileError = false;
        this.fileState = true;
      }
      this.fileSize(event);
      this.fileType(event);
    },
  },
  validations() {
    return {
      name: { required },
      surname: { required },
      lastname: {},
      postalCode: {
        required,
        valid: function (value) {
          const isValid = /^[0-9]{5}/.test(value);
          return isValid;
        },
      },
      street: { required },
      number: { required },
      city: { required },
      birthday: {
        required,
        valid: function (value) {
          const parts = value.split("-");
          const year = parseInt(parts[0]);
          const month = parseInt(parts[1]) - 1;
          const day = parseInt(parts[2]);
          const birthdate = new Date(year, month, day);
          const today = new Date();
          const minAgeDate = new Date(
            today.getFullYear() - 18,
            today.getMonth(),
            today.getDate()
          );

          return birthdate <= minAgeDate;
        },
      },
      email: {
        required,
        valid: function (value) {
          const isValid =
            /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(
              value
            );
          return isValid;
        },
      },
      phone: {
        required,
        valid: function (value) {
          const isValid = /^[0-9]{10}/.test(value);
          return isValid;
        },
      },
    };
  },
});
</script>
