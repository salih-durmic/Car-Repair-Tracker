<template>
  <div> 
      <h1>hello world</h1>
      <tbody>
           <!-- v-for="service in this.$store.state.services" v-bind="" -->
          <tr>
              <td>{{this.$store.state.services}}</td>
          </tr>
      </tbody>

  </div>
</template>

<script>
import repairsService from '../services/RepairsService';

export default {
name: 'carServices',
created(){
    repairsService.getServices(this.$route.params.id).then(
        (response) => {
            console.log(response)
            this.$store.commit("SET_SERVICES", response.data);
        }
    )
}
}
</script>

<style>

</style>