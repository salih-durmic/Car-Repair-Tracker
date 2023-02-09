<template>
  <div>
      <table>
      <thead>
        <tr >
           <!-- <th>Name</th> -->
          <!-- <th>Phone Number</th> -->
          <!-- <th>Make</th> -->
          <!-- <th>Model</th> -->
          <!-- <th>Year</th> -->
          <!-- <th>Color</th> -->
          <th>Oil</th>
          <th>Front Brakes</th>
          <th>Back Brakes</th>
          <th>Tires</th>

          <th>Date Reported</th>
          <th>Estimated Completion</th>
          <th>Labor</th>
          <th>Estimated Cost</th>
          <th>Status</th>
          <th>Paid</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="service in this.$store.state.serviceList" v-bind:key="service.serviceId">
             <!-- <td>{{this.$store.state.user.firstName}} {{this.$store.state.user.lastName}}</td> -->
            <!-- <td></td> -->
            <!-- <td></td> -->
            <!-- <td></td> -->
            <!-- <td></td> -->
            <!-- <td></td> -->
            <td>{{service.oil}}</td>
            <td>{{service.frontBrakes}}</td>
          <td>{{service.backBrakes}}</td>
          <td>{{service.tires}}</td>

            <td>Today's date</td>
            
            <td><input id='completion-date' name='completion-date' class="completion-date-input" type="date" v-model="serviceRequest.date" /></td>
            <td><select v-model="serviceRequest.laborCost">
        <option value="">--- Select Labor Cost ---</option>
        <option value="Basic Labor">Basic Labor</option>
        <option value="Half Day Labor">Half Day Labor</option>
        <option value="Full Day Labor">Full Day Labor</option>
        </select></td>
        
            <td>$$$</td>
            <td><select v-model="serviceRequest.status">
        <option value="">--- Select Status ---</option>
        <option value="Pending">Pending</option>
        <option value="Active">Active</option>
        <option value="Completed">Completed</option>
        </select></td>
            <td>No</td>
             <td><button v-on:click="saveRequest" type="submit">Submit</button></td>

             
            
        </tr>
      </tbody>
      </table>



  </div>
</template>

<script>
import repairsService from "../services/RepairsService";

export default {
    name: 'employee-details',
    data() {
    return {
      serviceRequest: {
                completionDate: '',
                laborCost: '',
                estimatedCost: '',
                status: '',
                paid: false
     
    }
  }
    },
    methods: {
        saveRequest() {
           
            alert("button clicked")
            

            repairsService.create(this.serviceRequest).then((response) => {
                if(response.status===200) {
                    alert("success")
                    this.$router.push("/employee/:id");
                  
                    
                } else {
                  alert(response.status)
                }
            })
        }
    },
    
  created() {
    repairsService.getServiceList().then((response) => {
      console.log(response)
      this.$store.commit("SET_SERVICELIST", response.data.services);
      this.$store.commit("SET_REQUESTS", response.data.requests);
    });
  }


}
</script>

<style>

</style>