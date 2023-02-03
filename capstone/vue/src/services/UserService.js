import axios from "axios";

export default {

    getId(id) {
        return axios.get(`/user/${id}`)
    }
}