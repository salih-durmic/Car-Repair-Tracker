<template>
  <div class="details">
      <h1 style="font-size: 46px;">Customer Vehicle Details</h1>
      <table>
        <thead>
            <tr>
                <!-- <th>Name</th> -->
                <th class="make">Make</th>
                <th class="model">Model</th>
                <th class="year">Year</th>
                <th class="color">Color</th>

                <th class="service">Service Details</th>
                <!-- <th>Estimated Repair Cost</th> -->
                <!-- <th>Ready for Pick-Up</th> -->
            </tr>
        </thead>
         <tbody>  
            <tr v-for="car in this.$store.state.cars" v-bind:key="car.carId">
                
                <!-- <td>{{this.$store.state.user.firstName}} {{this.$store.state.user.lastName}}</td> -->
                <!-- <div> -->
                  
                        <td class="make">{{car.make}}</td>
                        <td class="model">{{car.model}}</td>
                        <td class="year">{{car.year}}</td>
                        <td class="color">{{car.color}}</td>
                       
                       
                         <td class="service"><router-link v-bind:to="{name: 'carServices', params: {id: car.carId}}">Details</router-link></td>
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
#details{
justify-content: center;
text-align: center;
}
table{
  display: flex;
  flex-direction: row;
  text-align: left;
  justify-content: center;
  align-content: center;
  /* margin: auto; */

}
table thead{
  padding: 2%;
  text-align: left;
  justify-content: left;
}
table thead tr{
    display: flex;
  flex-direction: column;
}
table tbody{
  padding: 2%;
     display: flex;
  flex-direction: row;
}
table tbody tr{
   display: flex;
  flex-direction: column;
}
table tbody tr div{
     display: flex;
  flex-direction: column;
}
table thead th{
  font-size: 30px;
}
table tbody td{
  /* border: solid 1px black; */
  padding: 20px 20px;
  margin: 10px 0px;
  font-size: 24px;
}
.make{
  display: flex;
  padding: 10px 20px;
  margin: auto;
  
}
.model{
  display: flex;
    padding: 10px 20px;
      margin: auto;


}
.year{
  display: flex;
    padding: 10px 20px;
      margin: auto;


}
.color{
  display: flex;
    padding: 10px 20px;
      margin: auto;


}
.service{
  display: flex;
    padding: 10px 20px;
      margin: 5px;


}
</style>