<template>
  <div>
    <h4>Rentar tu espacio</h4>
    <b-breadcrumb :items="items"></b-breadcrumb>
    <b-button to="/your-info-space"> Información de tu espacio </b-button>
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
          text: "Rentar tu espacio",
          to: { name: "RentYourSpace" },
          active: true,
        },
      ],
    };
  },
});
</script>
