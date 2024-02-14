<script>
import Vue from "vue";
export default Vue.extend({
  name: "SideBar",
});
</script>
<template>
  <div>
    <b-sidebar
      id="sidebar-1"
      title="Sidebar"
      shadow
      :visible="true"
      z-index="-1"
      width="250px"
      class="mt-5"
      no-close-on-route-change
    >
      <div class="px-3 py-2">
        <nav class="mb-3">
          <b-nav vertical>
            <b-nav-item active >Active</b-nav-item>
            <b-nav-item href="#link-1">Link</b-nav-item>
            <b-nav-item href="#link-2" >Another Link</b-nav-item>
          </b-nav>
        </nav>
      </div>
    </b-sidebar>
  </div>
</template>
<style></style>
