/*!

 =========================================================
 * Vue Now UI Kit - v1.1.0
 =========================================================

 * Product Page: https://www.creative-tim.com/product/now-ui-kit
 * Copyright 2019 Creative Tim (http://www.creative-tim.com)

 * Designed by www.invisionapp.com Coded by www.creative-tim.com

 =========================================================

 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 */
import Vue from "vue";
import App from "./App.vue";
// You can change this import to `import router from './starterRouter'` to quickly start development from a blank layout.
import router from "./router";
import NowUiKit from "./plugins/now-ui-kit";

/* 뷰 쿠키 */
import VueCookie from "vue-cookie";
/* Axios 임포트 */
import axios from 'axios'

Vue.use(VueCookie);

Vue.prototype.$axios = axios;
axios.defaults.baseURL = 'http://i3d205.p.ssafy.io:8080'

Vue.config.productionTip = false;

Vue.use(NowUiKit);

new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");

/* vue-session 추가*/
import VueSession from "vue-session";
var sessionOptions = {
  persist: true,
};
Vue.use(VueSession, sessionOptions);
