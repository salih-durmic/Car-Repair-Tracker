<template>
  <div>
      <table>
      <thead>
        <tr>
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
        <tr >
            <!-- <td></td> -->
            <!-- <td></td> -->
            <!-- <td></td> -->
            <!-- <td></td> -->
            <!-- <td></td> -->
            <!-- <td></td> -->
            <td>{{this.$store.state.services.oil}}</td>
            <td>{{this.$store.state.services.frontBrakes}}</td>
          <td>{{this.$store.state.services.backBrakes}}</td>
          <td>{{this.$store.state.services.tires}}</td>

            <td>Today's date</td>
            <!-- <form v-on:submit.prevent="saveRequest"> -->
            <td><input id='completion-date' name='completion-date' class="completion-date-input" type="date" v-model="serviceRequest.date" /></td>
            <td><select v-model="serviceRequest.laborCost">
        <option value="">--- Select Labor Cost ---</option>
        <option value="Basic Labor">Basic Labor</option>
        <option value="Half Day Labor">Half Day Labor</option>
        <option value="Full Day Labor">Full Day Labor</option>
        </select></td>
        <!-- <button type="submit">Submit Request</button> -->
            <!-- </form> -->
            <td>$$$</td>
            <td>Pending</td>
            <td>No</td>
            
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
    repairsService.get(2).then((response) => {
      console.log(response)
      this.$store.commit("SET_SERVICES", response.data.service);
      this.$store.commit("SET_REQUESTS", response.data.requests);
    });
  }


}
</script>

<style>

</style>