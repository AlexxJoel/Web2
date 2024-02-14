<template>
  <div>
    <b-navbar toggleable="lg" type="dark" style="background-color: #563d7c;">
      <b-navbar-brand to="/">FISRTAPP</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item
            v-for="link in links"
            :key="link.title"
            active-class="text-white"
            >{{ link.title }}</b-nav-item
          >
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>
<script>
import Vue from "vue";
export default Vue.extend({
  name: "navbar",
  data() {
    return {
      links: [
        { title: "Docs" },
        { title: "Vue.js 3" },
        { title: "Components" },
        { title: "Directives" },
        { title: "Icons" },
        { title: "Reference" },
        { title: "Theme" },
        { title: "Play" },
      ],
    };
  },
});
</script>
