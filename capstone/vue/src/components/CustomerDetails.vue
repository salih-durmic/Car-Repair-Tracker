<template>
  <div class="details">
      <h1>Customer Vehicle Details</h1>
      <table>
        <thead>
            <tr>
                <!-- <th>Name</th> -->
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Color</th>

                <th>Issues Reported</th>
                <!-- <th>Estimated Repair Cost</th> -->
                <!-- <th>Ready for Pick-Up</th> -->
            </tr>
        </thead>
         <tbody>  
            <tr v-for="car in this.$store.state.cars" v-bind:key="car.carId">
                
                <!-- <td>{{this.$store.state.user.firstName}} {{this.$store.state.user.lastName}}</td> -->
                <!-- <div> -->
                        <td>{{car.make}}</td>
                        <td>{{car.model}}</td>
                        <td>{{car.year}}</td>
                        <td>{{car.color}}</td>
                       
                       
                         <td><router-link v-bind:to="{name: 'carServices', params: {id: car.carId}}">number</router-link></td>
                        <!-- <td>???</td> -->
                        <!-- <td>No</td> -->

                <!-- </div> -->
                   
                    
                   
                    </tr>
          </tbody>
      </table>


  </div>
</template>

<script>
import UserService from "../services/UserService";

export default {
    name: 'customer-details',
    created() {
    UserService.getCarsByUser(this.$route.params.id).then((response) => {
      console.log(response)
      this.$store.commit("SET_CARS", response.data);
      
    });
  }
}
   
    


</script>

<style>

</style>