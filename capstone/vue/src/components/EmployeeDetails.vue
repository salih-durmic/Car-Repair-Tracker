<template>
  <div>
      <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Phone Number</th>
          <th>Make</th>
          <th>Model</th>
          <th>Year</th>
          <th>Color</th>
          <th>Services Requested</th>

          <th>Date Reported</th>
          <th>Estimated Completion</th>
          <th>Labor</th>
          <th>Estimated Cost</th>
          <th>Status</th>
          <th>Paid</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="service in services" v-bind:key="service.id">
            <td>{{service.firstName}} {{service.lastName}}</td>
            <td>Phone Number</td>
            <td>Make</td>
            <td>Model</td>
            <td>Year</td>
            <td>Color</td>
            <td>x</td>

            <td>Today</td>
            <td>Date</td>
            <td>$$$</td>
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
     // services: []
    }
  },
  created() {
    repairsService.getServiceList().then((response) => {
      this.$store.commit("SET_SERVICES", response.data);
    });
  }


}
</script>

<style>

</style>