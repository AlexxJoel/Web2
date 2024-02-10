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
      {
        path: "/rent-u-space",
        name: "rentUspace",
        component: () => import("@/views/RentUSpace/HomeView.vue"),
      },
      {
        path: "/rent-u-space/information",
        name: "rentUspaceInformation",
        component: () => import("@/views/RentUSpace/InformationView.vue"),
      },
      {
        path: "/rent-u-space/promotion",
        name: "rentUspacePromotion",
        component: () => import("@/views/RentUSpace/PromotionSpace.vue"),  
      },

      {
        path: "/rent-space",
        name: "rentSpace",
        component: () => import("@/views/RentSpace/HomeView.vue"),
      },
      {
        path: "/rent-space/catalogue",
        name: "rentSpaceCatalogue",
        component: () => import("@/views/RentSpace/CatalogueNameView.vue"),
      },
      {
        path: "/rent-space/details",
        name: "rentSpaceDetails",
        component: () => import("@/views/RentSpace/DetailsView.vue"),
      },
    ],
  },
];


const router = new VueRouter({routes})
export default router;
