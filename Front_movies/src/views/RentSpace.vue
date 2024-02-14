<template>
    <div>
      <h4>Rentar espacio de otros</h4>
      <b-breadcrumb :items="items"></b-breadcrumb>
      <b-button to="/catalogue-space"> Cátalogo de espacios </b-button>
    </div>
  </template>
  <script>
  import Vue from "vue";
  export default Vue.extend({
    name: "RentYourSpace",
    data() {
      return {
        items: [
          {
            text: "Inicio",
            to: { name: "LandPage" },
          },
          {
            text: "Rentar espacio",
            to: { name: "RentSpace" },
            active: true,
          },
        ],
      };
    },
  });
  </script>
  