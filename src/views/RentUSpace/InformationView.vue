<template>
  <main>
    <b-breadcrumb :items="items"></b-breadcrumb>

    <h4>Información de espacio</h4>

    <b-card class="mt-4 me-3 px-5 shadow">

      <h1 class="text-uppercase">{{ form.name }}</h1>
      <h5 class="text-uppercase">Locación: {{ form.location }}</h5>
      <h5 class="text-uppercase">Capacidad: {{ form.capacity }}</h5>
      <h5 class="text-uppercase">Precio: {{ form.price }}</h5>
      <h5 class="text-uppercase">Fecha de inicio: {{ form.startDate }}</h5>
      <h5 class="text-uppercase">Fecha de fin: {{ form.endDate }}</h5>
      <h5 class="text-uppercase">Hora de inicio: {{ form.startTime }}</h5>
      <h5 class="text-uppercase">Hora de fin: {{ form.endTime }}</h5>
      <h5 class="text-uppercase">Tipo de espacio: {{ form.type }}</h5>
      

      <div class="mt-2 d-flex justify-content-between">
        <b-button @click="$router.back()" class="me-3">Regresar</b-button>
        <b-button :to="{ name: 'rentUspacePromotion' }" variant="primary">Continuar</b-button>
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