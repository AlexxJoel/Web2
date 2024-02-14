<script>
import Vue from "vue";
import NavBar from "./components/NavBar.vue";
import { defineAsyncComponent } from "vue";
export default Vue.extend({
  name: "HomeView",
  components: {
    NavBar,
    SideBar: defineAsyncComponent(() => import("./components/SideBar.vue")),
  },
});
</script>

<template>
  <div>
    <nav-bar />
    <b-row class="w-100">
      <b-col cols="12" sm="12" md="3" class="mt-5">
        <side-bar />
      </b-col>
      <b-col cols="12" sm="12" md="9" class="mt-3">
        <div class="mb-3"><h3>Películas</h3></div>
        <router-view></router-view>
      </b-col>
    </b-row>
  </div>
</template>
