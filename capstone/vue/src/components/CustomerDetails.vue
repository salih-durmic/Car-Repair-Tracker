<template>
  <div class="details">
      <h1>Actual Customer Details</h1>
      <table>
          <tbody>  
                    <tr>
                        <td>Name</td>
                        <td>{{this.$store.state.user.firstName}} {{this.$store.state.user.lastName}}</td>
                    </tr>
                    <tr>
                        <td>Make</td>
                        <td>???</td>
                    </tr>
                    <tr>
                        <td>Model</td>
                        <td>???</td>
                    </tr>
                    <tr>
                        <td>Year</td>
                        <td>???</td>
                    </tr>
                    <tr>
                        <td>Issues Reported</td>
                        <td>???</td>
                    </tr>
                    <tr>
                        <td>Estimated Repair Cost</td>
                        <td>???</td>
                    </tr>
                    <tr>
                        <td>Ready for Pick-Up</td>
                        <td>No</td>
                    </tr>
          </tbody>
      </table>


  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>