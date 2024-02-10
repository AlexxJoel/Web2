<template>
  <main>
    <b-breadcrumb :items="items"></b-breadcrumb>

    <h4>Oferta de espacio</h4>

    <b-card class="mt-4 d-inline-flex px-5 shadow">


      <b-row>
        <b-col cols="12" md="3">
          <b-card>Oferta 1</b-card>
        </b-col>
        <b-col cols="12" md="3">
          <b-card>Oferta 2</b-card>
        </b-col>
        <b-col cols="12" md="3">
          <b-card>Oferta 3</b-card>
        </b-col>
        <b-col cols="12" md="3">
          <b-card>Oferta 4</b-card>
        </b-col>
      </b-row>

      <div class="mt-2 d-flex justify-content-between">
        <b-button @click="$router.back()" class="me-3">Regresar</b-button>
        <b-button :to="{ name: 'home' }" variant="primary">Terminar</b-button>
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
          to: { name: 'rentUspace' },
        },
        {
          text: 'Información de espacio',
          to: { name: 'rentUspaceInformation' },
        },
        {
          text: 'Oferta de espacio',
          active: true
        }
      ],
    }
  }
}
</script>
  
<style scoped></style>