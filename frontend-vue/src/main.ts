import { createApp } from "vue";
import App from "./App.vue";
import router from "@/src/router";
import axios from "axios";
import { BASE_URL } from "./config";

axios.defaults.baseURL = BASE_URL;
const app = createApp(App);
app.use(router);
app.mount("#app");