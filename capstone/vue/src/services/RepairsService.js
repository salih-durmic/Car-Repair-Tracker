import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000"
  });

  export default {

    getServiceList() {
        return http.get('/services');
      },

      get(id) {
        return http.get(`/services/${id}`)
      },

    create(service) {
        return http.post('/services', service);
      },
    update(id, service) {
        return http.put(`/services/${id}`, service);
      },
    
    delete(id) {
          return http.delete(`/services/${id}`);
        }



}