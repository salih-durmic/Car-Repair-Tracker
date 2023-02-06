<template>
  <div>
      <h1>Tell us what kind of service you want</h1>
      <request-service-form />


  </div>
</template>

<script>
import RequestServiceForm from '../components/RequestServiceForm.vue'


export default {
    name: 'requestService',
    components: {
        RequestServiceForm
    }

}
</script>

<style>

</style>