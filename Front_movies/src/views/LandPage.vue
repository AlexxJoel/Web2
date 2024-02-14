<template>
  <div>
    <b-breadcrumb :items="items"></b-breadcrumb>
    <b-button to="/rent-your-space"> Rentar tu espacio </b-button>
    <b-button class="ms-3" to="/rent-space"> Rentar espacio </b-button>
  </div>
</template>
<script>
import Vue from "vue";
export default Vue.extend({
  name: "LandPage",
  data() {
    return {
      items: [
        {
          text: "Inicio",
          to: {name: 'LandPage'},
          active: true
        },
      ],
    };
  },
});
</script>
