import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  //path base
  {
    path: "/",
    redirect: "/home",
  },
  //path assignment
  {
    path: "/",
    component: {
      render(c) {
        return c("router-view");
      },
    },
    //components that will be rendered in router-view
    children: [
      {
        path: "/home",
        name: "home",
        component: () => import("@/views/HomeView.vue"),
      },
      {
        path: "/dashboard",
        name: "dashboard",
        component: () => import("@/views/DashboardView.vue"),
      },
      {
        path: "/about",
        name: "about",
        component: () => import("@/views/AboutView.vue"),
      },
    ],
  },
];


const router = new VueRouter({routes})
export default router;
