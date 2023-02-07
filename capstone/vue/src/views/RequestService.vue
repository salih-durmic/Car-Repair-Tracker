
<template>
  <div id="wholePage">
    <div id="topImage">
        <article id="topImageH1">
      <h1>Tell us what kind of car you are looking to service</h1>
      </article>
    </div>

    <request-service-form />
  


      
          <!-- <select v-model="car.type">
        <option value="">--- Select your vehicle ---</option>
        <option value="???">{{car.make}}</option>
        
      </select>

      <button >Add New Car</button> -->

    
  </div>
</template>

<script>
import RequestServiceForm from '../components/RequestServiceForm.vue'


export default {
  name: "requestService",
  components: {
        RequestServiceForm
    }
 
  
};
</script>

<style>
#car {
  display: flex;
  flex-direction: row;
  margin: auto;
}
.make-input {
font-size: 25px;
margin-right: 20px;
padding: 15px;
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
  background-image: url('~@/assets/img-01.jpg');
  background-repeat: no-repeat ;
  background-color: lightgray;
  /* border: 50px solid rgb(32, 121, 156); */
  text-align: center;
  justify-content: center;
  align-items: center;
  margin: auto;
  padding-top: 5%;
  padding-bottom: 5%
}
#topImage article{
    margin: auto;
    padding-top: 100px;
height: 200px;
font-size: 40px;
}
#topImage h1{
  margin-top: -100px;
  font-size: 70px;
}
.request-service-form{
    display: flex;
    flex-direction: column;
    background-color: rgb(228, 228, 228);
    padding: 30px 30px;
    justify-content: center;
    align-items: center;
    margin: auto;
    text-align: center;
    height: 300px;
}
#form{
    /* width:max-content; */
    display: flex;
    padding:10px 10px;
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
    padding: 2%;
}
#dropDownService{
    font-size: 25px;
    padding:2%;

}
#drop-off-date{
    font-size: 25px;
    padding: 14px;
    width: 50%;


}
#dropOffDate{
    margin-left: 15px;
    margin-right: 10px;
}
#submitRequestButton{
    font-size: 30px;
}
</style>