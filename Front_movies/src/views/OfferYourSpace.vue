<template>
  <div>
    <h4>Ofertar tu espacio</h4>
    <b-breadcrumb :items="items"></b-breadcrumb>
    Oferta tu espacio aqui
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
        },
        {
          text: "Ofertar tu espacio",
          to: { name: "OfferYourSpace" },
          active: true,
        },
      ],
    };
  },
});
</script>
