
<template>
  <div id="wholePage">
    <div id="topImage">
        <article>
      <h1>Tell us what kind of car you are looking to service</h1>
      </article>
    </div>

<div id="form">
    <form class="request-service-form" v-on:submit.prevent="saveService">
      <!-- 
          <select v-model="car.type">
        <option value="">--- Select your vehicle ---</option>
        <option value="???">{{car.make}}</option>
        
      </select>

      <button >Add New Car</button> -->

      <div id="makeModel">
        <input
          class="make-input"
          type="text"
          placeholder="Make"
          v-model="car.make"
        />
        <input
          class="model-input"
          type="text"
          placeholder="Model"
          v-model="car.model"
        />
        <input
          class="year-input"
          type="text"
          placeholder="Year"
          v-model="car.year"
        />
        <input
          class="color-input"
          type="text"
          placeholder="Color"
          v-model="car.color"
        />
      </div>
<div id="typeOfService">
      <select id="dropDownService" v-model="service.type">
        <option value="">--- Type of Service ---</option>
        <option value="Oil">Oil</option>
        <option value="Brakes">Brakes</option>
        <option value="Tires">Tires</option>
        <option value="Body">Body</option>
      </select>

      <label id="dropOffDate" for="drop-off-date">Drop Off Date: </label>
      <input
        id="drop-off-date"
        name="drop-off-date"
        class="drop-off-date-input"
        type="date"
        v-model="service.date"
      />
      </div>
<br>
      <button id="submitRequestButton" type="submit">Submit Request</button>
    </form>
    </div>
  </div>
</template>

<script>
import repairService from "../services/RepairService";

export default {
  name: "requestService",
  data() {
    return {
      car: {
        make: "",
        model: "",
        year: "",
        color: "",
        type: "",
      },
      service: {
        oil: "",
        brakes: "",
        tires: "",
        body: "",
        date: "",
        type: "",
      },
    };
  },
  methods: {
    saveService() {
      alert("button clicked");

      repairService.create(this.service).then((response) => {
        if (response.status === 201) {
          alert("success");
          this.$router.push("/user/:id");
        }
      });
    },
  },
};
</script>

<style>
#makeModel {
  display: flex;
  flex-direction: row;
  margin: auto;
}
.make-input {
font-size: 25px;
margin-right: 20px;
}
.model-input{
font-size: 25px;
margin-right: 20px;
}
.year-input{
font-size: 25px;
margin-right: 20px;
}
.color-input{
font-size: 25px;
/* margin-right: 20px; */
}
#topImage {
  background-color: lightgray;
  text-align: center;
  justify-content: center;
  align-items: center;
  margin: auto;
}
#topImage h1{
    margin: auto;
    padding-top: 100px;
height: 200px;
font-size: 40px;
}
.request-service-form{
    display: flex;
    flex-direction: column;
    background-color: rgb(228, 228, 228);
    padding: 30px 300px;
    justify-content: center;
    align-items: center;
    margin: auto;
    text-align: center;
    height: 300px;
}
#form{
    /* width:max-content; */
    display: flex;
    padding-top: 20px;
    justify-content: center;
    align-items: center;
    text-align: center;
}
#wholePage{

    display: flex;
    flex-direction: column;
    margin: auto;

}
#typeOfService{
    font-size: 25px;
    display: flex;
    justify-content: space-evenly;
}
#dropDownService{
    font-size: 25px;
    

}
#drop-off-date{
    font-size: 25px;

}
#dropOffDate{
    margin-left: 15px;
    margin-right: 10px;
}
#submitRequestButton{
    font-size: 30px;
}
</style>