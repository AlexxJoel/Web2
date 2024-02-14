<template>
  <div>
    <h4>Detalles del espacio</h4>
    <b-breadcrumb :items="items"></b-breadcrumb>
    Detalles del espacio ofertado
  </div>
</template>
<script>
import Vue from "vue";
export default Vue.extend({
  name: "SpaceDetails",
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
        },
        {
          text: "Detalles del espacio",
          to: { name: "SpaceDetails" },
          active: true,
        },
      ],
    };
  },
});
</script>
