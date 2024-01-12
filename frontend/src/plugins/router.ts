import {
  createRouter,
  createWebHistory,
  RouteRecordRaw,
  RouterView,
} from "vue-router";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      component: () => import("../pages/Index.vue"),
    },
    {
      path: "/game",
      component: () => import("../pages/Game.vue"),
    },
  ] as RouteRecordRaw[],
});

export default router;
export { RouterView };
