<template>
  <main>
    <b-breadcrumb :items="items"></b-breadcrumb>

    <h4>Acciones</h4>

    <b-card class="mt-4 d-inline-flex px-5 shadow" >
      <div class="d-flex justify-content-between">
        <b-button :to="{name: 'rentUspace'}" class="card btn  btn-outline-dark fw-bold mx-5 px-5 py-3">
          Rentar tu espacio
          <div class="text-center h2 mt-1">
            <b-icon icon="calendar"></b-icon>
          </div>
        </b-button>
        <b-button :to="{name: 'rentSpace'}" class="card btn btn-outline-dark  fw-bold mx-5 px-5 py-3">
          Rentar algún espacio
          <div class="text-center h2 mt-1">
            <b-icon icon="house"></b-icon>
          </div>
        </b-button>
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
            href: '#',
            active: true
          },
        ]
      }
    }
  }
</script>

<style scoped>

</style>