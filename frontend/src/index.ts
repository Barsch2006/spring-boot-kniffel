import { createApp } from "vue";
import App from "./App.vue";
import router from "./plugins/router";
import vuetify from "./plugins/vuetify";

import "vuetify/styles";
import "@mdi/font/css/materialdesignicons.css";
import "./style.css";

createApp(App).use(router).use(vuetify).mount("#app");
