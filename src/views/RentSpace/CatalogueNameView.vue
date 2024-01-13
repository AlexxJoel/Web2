<template>
  <main>
    <b-breadcrumb :items="items"></b-breadcrumb>

    <h4>Catalogo de Espacios</h4>

    <b-card class="mt-4 me-3 px-5 shadow">


      <b-row>
        <b-col cols="12" md="3">
          <b-card>
            <p>NAME {{ form.name }}</p>
            <p>LOCATION {{ form.location }}</p>
            <p>CAPACITY {{ form.capacity }}</p>
          </b-card>
        </b-col>

        <b-col cols="12" md="3">
          <b-card>
            <p>NAME {{ form.name }}</p>
            <p>LOCATION {{ form.location }}</p>
            <p>CAPACITY {{ form.capacity }}</p>
          </b-card>
        </b-col>

        <b-col cols="12" md="3">
          <b-card>
            <p>NAME {{ form.name }}</p>
            <p>LOCATION {{ form.location }}</p>
            <p>CAPACITY {{ form.capacity }}</p>
          </b-card>
        </b-col>

        <b-col cols="12" md="3">
          <b-card>
            <p>NAME {{ form.name }}</p>
            <p>LOCATION {{ form.location }}</p>
            <p>CAPACITY {{ form.capacity }}</p>
          </b-card>
        </b-col>
      </b-row>



      <div class="mt-2 d-flex justify-content-between">
        <b-button @click="$router.back()" class="me-3">Regresar</b-button>
        <b-button variant="primary" :to="{ name: 'rentSpaceDetails' }">Continuar</b-button>
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
          text: 'Rentar algun espacio',
          to: { name: 'rentSpace' },
        },
        {
          text: 'Catalogo de Espacios',
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