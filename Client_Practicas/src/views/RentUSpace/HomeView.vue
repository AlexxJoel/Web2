<template>
  <main>
    <b-breadcrumb :items="items"></b-breadcrumb>

    <h4>Rentar tu espacio</h4>
    <b-card class="mt-4 me-3 px-5 shadow">
      <div>
        <b-form-group label="Nombre del espacio" label-for="input-1">
          <b-form-input id="input-1" v-model="form.name"></b-form-input>
        </b-form-group>

        <b-form-group label="Ubicación" label-for="input-3">
          <b-form-input id="input-3" v-model="form.location"></b-form-input>
        </b-form-group>

        <b-row>
          <b-col cols="12" md="6"> <b-form-group label="Capacidad" label-for="input-4">
              <b-form-input id="input-4" v-model="form.capacity"></b-form-input>
            </b-form-group>

          </b-col>
          <b-col cols="12" md="6">
            <b-form-group label="Precio" label-for="input-5">
              <b-form-input id="input-5" v-model="form.price"></b-form-input>
            </b-form-group>
          </b-col>
        </b-row>

        <b-form-group label="Fecha de inicio" label-for="input-6">
          <b-form-input id="input-6" v-model="form.startDate"></b-form-input>
        </b-form-group>

        <b-form-group label="Fecha de fin" label-for="input-7">
          <b-form-input id="input-7" v-model="form.endDate"></b-form-input>
        </b-form-group>

        <b-form-group label="Hora de inicio" label-for="input-8">
          <b-form-input id="input-8" v-model="form.startTime"></b-form-input>
        </b-form-group>

        <b-form-group label="Hora de fin" label-for="input-9">
          <b-form-input id="input-9" v-model="form.endTime"></b-form-input>
        </b-form-group>

        <b-form-group label="Tipo de espacio" label-for="input-10">
          <b-form-input id="input-10" v-model="form.type"></b-form-input>
        </b-form-group>

        <b-form-group label="Tipo de espacio" label-for="input-11">
          <b-form-input id="input-11" v-model="form.type"></b-form-input>
        </b-form-group>

      </div>



      <div class="mt-2 d-flex justify-content-between">
        <b-button @click="$router.back()" class="me-3">Regresar</b-button>
        <b-button variant="primary" :to="{ name: 'rentUspaceInformation' }">Continuar</b-button>
      </div>

    </b-card>



  </main>
</template>
  
<script>
export default {
  data() {
    return {
      items: [
        {
          text: 'Home',
          to: { name: 'home' },
        },
        {
          text: 'Rentar tu espacio',
          active: true
        }
      ],
      form: {
        name: 'Lugar de trabajo',
        location: 'Calle 1 # 2-3',
        capacity: '34',
        price: '100000',
        startDate: '2021-10-10',
        endDate: '2021-10-11',
        startTime: '10:00',
        endTime: '12:00',
        type: 'Oficina',
      }
    }
  }
}
</script>
  
<style scoped></style>