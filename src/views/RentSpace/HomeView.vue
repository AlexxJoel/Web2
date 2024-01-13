<template>
  <main>
    <b-breadcrumb :items="items"></b-breadcrumb>

    <h4>Rentar algun espacio</h4>
    <b-card class="mt-4 me-3 px-5 shadow">


       <h3>
        Hola! Estas buscando algun espacio para rentar, nostros contamos con un catalogo de espacios para ti.

       </h3>

      <div class="mt-2 d-flex justify-content-between">
        <b-button @click="$router.back()" class="me-3">Regresar</b-button>
        <b-button variant="primary" :to="{ name: 'rentSpaceCatalogue' }">Continuar</b-button>
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