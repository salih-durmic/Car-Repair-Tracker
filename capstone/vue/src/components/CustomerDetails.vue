<template>
  <div class="details">
      <h1>Actual Customer Details</h1>
      <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Color</th>

                <th>Issues Reported</th>
                <th>Estimated Repair Cost</th>
                <th>Ready for Pick-Up</th>
            </tr>
        </thead>
         <tbody>  
            <tr>
                <td>{{this.$store.state.user.firstName}} {{this.$store.state.user.lastName}}</td>
                <div>
                        <td>???</td>
                        <td>???</td>
                        <td>???</td>
                        <td>???</td>
                        <td>???</td>
                        <td>No</td>
                </div>
                   
                    
                   
                    </tr>
          </tbody>
      </table>


  </div>
</template>

<script>
import repairsService from "../services/RepairsService";

export default {
    name: 'customer-details',
    created() {
    repairsService.getCarsByUser(this.$route.params.id).then((response) => {
      console.log(response)
      
    });
  }
}
   
    


</script>

<style>

</style>