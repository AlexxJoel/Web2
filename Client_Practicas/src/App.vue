<template>
  <b-container class="mt-5">
    <h2>Formulario</h2>


    <div>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">
        <b-form-group v-for="(item, index) in fields" :key="index" :label="item.label" :label-for="item.name" class="mb-2"
          :invalid-feedback="item.feedback" :state="item.valid">
          <b-form-input :id="item.name" v-model="item.value" :type="item.type" :placeholder="item.placeholder" :maxlength="item.maxlength"
            :required="item.required" @input="item.validation(item)" @blur="item.validation(item)" :state="item.valid"
            trim></b-form-input>
        </b-form-group>

        <b-form-group :label="file1.label" label-for="food" class="mb-4" :invalid-feedback="file1.feedback" :state="file1.valid">
          <b-form-file browse-text="Buscar" :accept="file1.accept" v-model="file1.value" :state="file1.valid" 
            @input="file1.validation(file1)" @blur="file1.validation(file1)"
            placeholder="Escoge una imagen o arrastrala aqui..." drop-placeholder="Arrastrala aqui..."
            :required="file1.required"></b-form-file>

        </b-form-group>

        <b-button type="submit" variant="primary" class="mr-4">Enviar</b-button>
        <b-button type="reset" variant="danger">Limpiar</b-button>
      </b-form>

      <div v-else> 
        <h1 class="alert alert-success"> Registro exitoso </h1>
        <h3>Datos finales</h3>
        <ul>
          <li v-for="(item, index) in fields" :key="index">
            <b>{{item.label}}: </b> {{item.value}}
          </li>
        </ul>

        <b>{{ file1.label }}</b>
        <br>
        <div  class="text-center">
          <img :src="file1.value" alt="" width="25%">
        </div>
        <hr>

        <b-button type="reset" variant="danger" @click="()=> {
          show = true
          onReset()
        }">Volver a llenar</b-button>
      </div>

    </div>
  </b-container>
</template>


<script>

import { Patterns } from '@/assets/js/pattern'
import { isEmptyValue, isLengthValid, isImageSizeValid, isImageTypeValid } from '@/assets/js/validations.js'

export default {
  data() {
    return {
      fields: [
        {
          label: 'Nombre(s)',
          type: 'text',
          placeholder: 'Ingresa nombre(s)',
          required: true,
          value: null,
          valid: null,
          maxlength: 45,
          feedback: 'El dato es requerido',
          validation: (item) => {
            if (isEmptyValue(item.value)) {
              item.valid = false
              return
            }
            if (!isLengthValid(item.value, 1, 45)) {
              item.valid = false
              item.feedback = 'El dato debe tener entre 1 y 45 caracteres'
              return
            }
            //only letters
            if (!Patterns.letter(item.value)) {
              item.feedback = 'Solo ingresa letras'
              item.valid = false
              return
            }
            item.valid = true
          }
        },
        {
          label: 'Apellido paterno',
          type: 'text',
          placeholder: 'Ingresa apellido paterno',
          required: true,
          value: null,
          valid: null,
          maxlength: 20,
          feedback: 'El dato es requerido',
          validation: (item) => {
            if (isEmptyValue(item.value)) {
              item.valid = false
              return
            }
            if (!isLengthValid(item.value, 1, 20)) {
              item.valid = false
              item.feedback = 'El dato debe tener entre 1 y 20 caracteres'
              return
            }
            //only letters
            if (!Patterns.letter(item.value)) {
              item.feedback = 'Solo ingresa letras'
              item.valid = false
              return
            }
            item.valid = true
          }
        },
        {
          label: 'Apellido materno',
          type: 'text',
          placeholder: 'Ingresa apellido materno',
          value: null,
          valid: null,
          maxlength: 20,
          feedback: 'El dato es requerido',
          validation: (item) => {

            if (!isEmptyValue(item.value)) {
              if (!isLengthValid(item.value, 0, 20)) {
                item.valid = false
                item.feedback = 'El dato debe tener maximo 20 caracteres'
                return
              }
              //only letters
              if (!Patterns.letter(item.value)) {
                item.feedback = 'Solo ingresa letras'
                item.valid = false
                return
              }
            }
            item.valid = true
          }
        },
        {
          label: 'Código Postal',
          type: 'text',
          placeholder: 'Ingresa código postal',
          required: true,
          value: null,
          valid: null,
          maxlength: 5,
          feedback: 'El dato es requerido',
          validation: (item) => {
            if (isEmptyValue(item.value)) {
              item.valid = false
              return
            }

            if (!Patterns.cp(item.value)) {
              item.feedback = 'Formato incorrecto, solo se permiten numeros y debe tener 5 caracteres'
              item.valid = false
              return
            }

            item.valid = true
          }
        },
        {
          label: 'Calle',
          type: 'text',
          placeholder: 'Ingresa calle',
          required: true,
          value: null,
          valid: null,
          maxlength: 70,
          feedback: 'El dato es requerido',
          validation: (item) => {
            if (isEmptyValue(item.value)) {
              item.valid = false
              return
            }
            if (!isLengthValid(item.value, 1, 70)) {
              item.valid = false
              item.feedback = 'El dato debe tener entre 1 y 70 caracteres'
              return
            }
            //only letters
            if (!Patterns.notSpecialCharacters(item.value)) {
              item.feedback = 'Tipo de caracter(es) ingresado(s) invalido(s)'
              item.valid = false
              return
            }
            item.valid = true
          }
        },
        {
          label: 'Numero exterior',
          type: 'text',
          placeholder: 'Ingresa numero',
          required: true,
          value: null,
          valid: null,
          maxlength: 5,
          feedback: 'El dato es requerido',
          validation: (item) => {
            if (isEmptyValue(item.value)) {
              item.valid = false
              return
            }
            if (!isLengthValid(item.value, 1, 5)) {
              item.valid = false
              item.feedback = 'El dato debe tener entre 1 y 5 caracteres'
              return
            }
            if (!Patterns.numbers(item.value)) {
              item.feedback = 'Ingresa solo numeros'
              item.valid = false
              return
            }
            item.valid = true
          }
        },
        {
          label: 'Ciudad',
          type: 'text',
          placeholder: 'Ingresa ciudad',
          required: true,
          value: null,
          valid: null,
          maxlength: 20,
          feedback: 'El dato es requerido',
          validation: (item) => {
            if (isEmptyValue(item.value)) {
              item.valid = false
              return
            }
            if (!isLengthValid(item.value, 1, 20)) {
              item.valid = false
              item.feedback = 'El dato debe tener entre 1 y 20 caracteres'
              return
            }
            if (!Patterns.letter(item.value)) {
              item.feedback = 'Ingresa solo letras'
              item.valid = false
              return
            }
            item.valid = true
          }
        },
        {
          label: 'Fecha de nacimiento',
          type: 'date',
          placeholder: 'Ejem: 01/01/2000',
          value: null,
          valid: null,
          feedback: 'El dato es requerido',
          validation: (item) => {


            if (isEmptyValue(item.value) || item.value === '') {
              item.valid = false
              return
            }
            if (!Patterns.birthdate(item.value)) {
              item.feedback = 'El formato de fecha es incorrecto, formato correcto: dd/mm/aaaa'
              item.valid = false
              return
            }

            const date = new Date(item.value)
            date.setDate(date.getDate() + 1)
            date.setHours(0, 0, 0, 0)
            const today = new Date()
            today.setHours(0, 0, 0, 0)
            const eighteenYearsAgo = new Date(new Date().setFullYear(today.getFullYear() - 18))

            if (date >= today) {
              item.feedback = 'La fecha no puede ser mayor o igual a la fecha actual'
              item.valid = false
              return
            }

            if (date <= eighteenYearsAgo) {
              item.feedback = 'Escoge una fecha mas cercana'
              item.valid = false
              return
            }

            item.valid = true
          }
        },
        {
          label: 'Correo electrónico',
          type: 'email',
          placeholder: 'Ingresa correo electrónico',
          value: null,
          valid: null,
          maxlength: 45,
          feedback: 'El dato es requerido',
          validation: (item) => {
            if (isEmptyValue(item.value)) {
              item.valid = false
              return
            }

            if (!isLengthValid(item.value, 1, 45)) {
              item.valid = false
              item.feedback = 'El dato debe tener entre 1 y 45 caracteres'
              return
            }

            if (!Patterns.email(item.value)) {
              item.feedback = 'El formato de correo es incorrecto'
              item.valid = false
              return
            }
            item.valid = true
          }
        },
        {
          label: 'Número telefónico',
          type: 'text',
          placeholder: 'Ingresa número telefónico',
          value: null,
          valid: null,
          maxlength: 10,
          feedback: 'El dato es requerido',
          validation: (item) => {
            if (isEmptyValue(item.value)) {
              item.valid = false
              return
            }
            if (!Patterns.phone(item.value)) {
              item.feedback = 'El formato de teléfono es incorrecto'
              item.valid = false
              return
            }
            item.valid = true
          }
        },
      ],
      file1: {
        id: 11,
        label: 'Fotografía',
        type: 'file',
        placeholder: 'Ingresa fotografía',
        value: null,
        valid: null,
        required: true,
        accept: 'image/*',
        validation: (item) => {
          if (isEmptyValue(item.value)) {
            item.valid = false
            return
          }

          
          if (!isImageTypeValid(item.value)) {
            item.feedback = 'El formato de imagen es incorrecto'
            item.valid = false
            return
          }

          if (!isImageSizeValid(item.value)) {
            item.feedback = 'El tamaño de imagen es muy grande'
            item.valid = false
            return
          }
          item.valid = true
        }
      },
      show: true
    }
  },
  methods: {
    onSubmit(event) {
      event.preventDefault()
      this.show = false
      this.file1.value = URL.createObjectURL(this.file1.value)
    },
    onReset(event) {
      event.preventDefault()
      // Reset our form values
      for (let i = 0; i < this.fields.length; i++) {
        const element = this.fields[i];
        element.value = null
        element.valid = null
        
      }
    }
  }
}
</script>

<style scoped>
.custom-file-input:lang(en)~.custom-file-label::after {
  content: 'Browse';
}
</style>
