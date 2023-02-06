import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000"
  });

  export default {

    getServiceList() {
        return http.get('/services');
      },

    create(service) {
        return http.post('/services', service);
      }


}