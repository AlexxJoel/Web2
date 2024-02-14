import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

Vue.use(VueRouter);
const DEFAULT_TTTLE = "FIRSTAPP";

const router = new VueRouter({
  mode: "history",
  base: import.meta.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
      redirect: "movies",
      children: [
        {
          path: "/land-page",
          name: "LandPage",
          component: () => import("../views/LandPage.vue"),
        },
        {
          path: "/rent-your-space",
          name: "RentYourSpace",
          component: () => import("../views/RentYourSpace.vue"),
        },
        {
          path: "/your-info-space",
          name: "YourInfoSpace",
          component: () => import("../views/YourInfoSpace.vue"),
        },
        {
          path: "/offer-your-space",
          name: "OfferYourSpace",
          component: () => import("../views/OfferYourSpace.vue"),
        },
        {
          path: "/rent-space",
          name: "RentSpace",
          component: () => import("../views/RentSpace.vue"),
        },
        {
          path: "/catalogue-space",
          name: "CatalogueSpace",
          component: () => import("../views/CatalogueSpace.vue"),
        },
        {
          path: "/space-details",
          name: "SpaceDetails",
          component: () => import("../views/SpaceDetails.vue"),
        },
        {
          path: "/form-validation",
          name: "FormValidation",
          component: () => import("../views/FormValidation.vue"),
        },
        {
          path: "/movies",
          name: "Movies",
          component: () => import("../views/Movies.vue"),
        },
      ],
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/AboutView.vue"),
    },
  ],
});

export default router;
