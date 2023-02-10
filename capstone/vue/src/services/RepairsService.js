import axios from "axios";

// const http = axios.create({
//   baseURL: "http://localhost:9000"
// });

export default {

  getServiceList() {
    return axios.get('/services');
  },

  getServices(id) {
    return axios.get(`/services/${id}`)
  },

  create(serviceRequest) {
    console.log('debug')
    console.log(serviceRequest)
    return axios.post('/services', serviceRequest);
  },

  update(id, service) {
    return axios.put(`/services/${id}`, service);
  },

  delete(id) {
    return axios.delete(`/services/${id}`);
  }





}