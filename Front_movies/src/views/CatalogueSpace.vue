<template>
  <div>
    <h4>Información de tu espacio</h4>
    <b-breadcrumb :items="items"></b-breadcrumb>
    <b-button to="/space-details">Detalles de espacio </b-button>
  </div>
</template>
<script>
import Vue from "vue";
export default Vue.extend({
  name: "CatalogueSpace",
  data() {
    return {
      items: [
        {
          text: "Inicio",
          to: { name: "LandPage" },
        },
        {
          text: "Rentar espacio de otros",
          to: { name: "RentSpace" },
        },
        {
          text: "Catalogo de espacios",
          to: { name: "CatalogueSpace" },
          active: true,
        },
      ],
    };
  },
});
</script>
