<template>
  <div>
    <h4>Información de tu espacio</h4>
    <b-breadcrumb :items="items"></b-breadcrumb>
    <b-button to="/offer-your-space">Ofertar tu espacio </b-button>
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
        },
        {
          text: "Información de tu espacio",
          to: { name: "YourInfoSpace" },
          active: true,
        },
      ],
    };
  },
});
</script>
