<template>
  <div>
      <form class="request-service-form" v-on:submit.prevent="saveService">

          <select v-model="car.type">
        <option value="">--- Select your vehicle ---</option>
        <option value="???">{{car.make}}</option>
        
      </select>

      <button >Add New Car</button>
      <div>
          <input class="make-input" type="text" placeholder="Make" v-model="car.make" />
          <input class="model-input" type="text" placeholder="Model" v-model="car.model" />
          <input class="year-input" type="text" placeholder="Year" v-model="car.year" />
          <input class="color-input" type="text" placeholder="Color" v-model="car.color" />

      </div>

      <select v-model="service.type">
        <option value="">--- Type of Service ---</option>
        <option value="Oil">Oil</option>
        <option value="Brakes">Brakes</option>
        <option value="Tires">Tires</option>
        <option value="Body">Body</option>
        </select>

        <label for='drop-off-date'>Drop Off Date: </label>
        <input id='drop-off-date' name='drop-off-date' class="drop-off-date-input" type="date" v-model="service.date" />
    
    <button type="submit">Submit Request</button>
  </form>

  </div>
</template>

<script>
import repairService from "../services/RepairService";

export default {
    name: "repair-service-form",
    data() {
        return {
            car: {
                make: '',
                model: '',
                year: '',
                color: '',
                type: ''
            },
            service: {
                oil: '',
                brakes: '',
                tires: '',
                body: '',
                date:'',
                type: ''
            }
        }
    },
    methods: {
        saveService() {
           
            alert("button clicked")

            repairService.create(this.service).then((response) => {
                if(response.status===201) {
                    alert("success")
                    this.$router.push("/user/:id");
                    
                }
            })
        }
    }

}
</script>

<style>

</style>