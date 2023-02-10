<template>
  <div id="entireService">
    <h1 style="font-size: 45px;">Your Service</h1>
    <table>
    <thead>
      <tr>
        <th style="font-size: 35px;" class="oil">Oil</th>
        <th style="font-size: 35px;" class="FB">Front Brakes</th>
        <th style="font-size: 35px;" class="BB">Back Brakes</th>
        <th style="font-size: 35px;" class="tires">Tires</th>
      </tr>
    </thead>
    <tbody>
      <!-- v-for="service in this.$store.state.services" v-bind="" -->
      <tr>
        <td class="oil">{{ this.$store.state.services.service.oil }}</td>
        <td class="FB">{{ this.$store.state.services.service.frontBrakes }}</td>
        <td class="BB">{{ this.$store.state.services.service.backBrakes }}</td>
        <td class="tires">{{ this.$store.state.services.service.tires }}</td>
      </tr>
    </tbody>
    </table>
  </div>
</template>

<script>
import repairsService from "../services/RepairsService";

export default {
  name: "carServices",
  computed:{
      getService() {
          return {
              oil: this.$store.state.services.service.oil,
              frontBrakes: this.$store.state.services.service.frontBrakes,
              backBrakes: this.$store.state.services.service.backBrakes,
              tires: this.$store.state.services.service.tires

          }
      }
  },
  created() {
    repairsService.getServices(this.$route.params.id).then((response) => {
      console.log(response);
      this.$store.commit("SET_SERVICES", response.data);
    });
  },
};
</script>

<style>
#entireService{
  display: flex;
  flex-direction: column;
  justify-content: center;
  text-align: center;
  margin: auto;
}
th{
  font-size: 35px;
}
.oil{
  display: flex;
  padding: 10px 20px;
  margin: auto;
  
}
.FB{
  display: flex;
    padding: 10px 20px;
      margin: auto;


}
.BB{
  display: flex;
    padding: 10px 20px;
      margin: auto;


}
.tires{
  display: flex;
    padding: 10px 20px;
      margin: auto;


}

</style>