<template>
  <div class="root">
    <div v-if="isLoaded">
      <!-- {{ allServices }} -->

      <div id="userAndCars" class="user" v-for="user in this.users" v-bind:key="user.id">
        <div id="userFandL">
        <p id="userFirstAndLast">Name: {{ user.firstName }} {{ user.lastName }} <br>
        Number: {{ user.phoneNumber }}</p>
</div>
        <!-- <p>Car Object {{ user.cars.length }}</p> -->
        <!-- {{hasCarsFromUser(user)}}  -->
        <!-- v-show="hasCarsFromUser(user)" -->

        <div class="car" v-for="car in user.cars" v-bind:key="car.carId">
          <p>Make: {{ car.make }}</p>
          <p>Model: {{ car.model }}</p>
          <p>Year: {{ car.year }}</p>
          <p>Color: {{ car.color }}</p>
          <p>Oil: {{ car.services.service.oil }}</p>
          <p>Front Brakes: {{ car.services.service.frontBrakes }}</p>
          <p>Back Brakes: {{ car.services.service.backBrakes }}</p>
          <p>Tires: {{ car.services.service.tires }}</p>
        </div>
        <!-- <h1>Hello World</h1> -->
        <!-- <form v-on:submit.prevent="saveRequest1(car.services.service.serviceId)">
              <input type="text" disabled v-model="service.serviceId" />
              <input
                id="completion-date"
                name="completion-date"
                class="completion-date-input"
                type="date"
                v-model="service.date"
              />
              <select v-model="service.labor">
                <option value="">--- Select Labor Cost ---</option>
                <option value="Basic Labor">Basic Labor</option>
                <option value="Half Day Labor">Half Day Labor</option>
                <option value="Full Day Labor">Full Day Labor</option>
              </select>

              <input
                class="estimated-cost-input"
                type="text"
                placeholder="Estimated Cost"
                v-model="service.estimatedCost"
              />

              <select v-model="service.status">
                <option value="">--- Select Status ---</option>
                <option value="Pending">Pending</option>
                <option value="Active">Active</option>
                <option value="Completed">Completed</option>
              </select>

              Paid:

              <input type="checkbox" v-model="service.paid" />

              <button type="submit">Submit</button>
            </form> -->
      </div>

      <!-- <div
            class="service-box"
            v-for="service in allServices"
            v-bind:key="service.serviceId"
          >
            <p>Oil: {{ service.oil }}</p>
            <p>Front Brakes: {{ service.frontBrakes }}</p>
            <p>Back Brakes: {{ service.backBrakes }}</p>
            <p>Tires: {{ service.tires }}</p>

            <form v-on:submit.prevent="saveRequest1(service.serviceId)">
              <input type="text" disabled v-model="service.serviceId" />

              <input
                id="completion-date"
                name="completion-date"
                class="completion-date-input"
                type="date"
                v-model="service.date"
              />
              <select v-model="service.labor">
                <option value="">--- Select Labor Cost ---</option>
                <option value="Basic Labor">Basic Labor</option>
                <option value="Half Day Labor">Half Day Labor</option>
                <option value="Full Day Labor">Full Day Labor</option>
              </select>

              <input
                class="estimated-cost-input"
                type="text"
                placeholder="Estimated Cost"
                v-model="service.estimatedCost"
              />

              <select v-model="service.status">
                <option value="">--- Select Status ---</option>
                <option value="Pending">Pending</option>
                <option value="Active">Active</option>
                <option value="Completed">Completed</option>
              </select>

              Paid:

              <input type="checkbox" v-model="service.paid" />

              <button type="submit">Submit</button>
            </form>
          </div> -->

      <!-- 1st Draft of doing page -->

      <!-- <table>
            <thead>
              <tr> -->

      <!-- <th>Name</th> -->
      <!-- <th>Phone Number</th> -->
      <!-- <th>Make</th> -->
      <!-- <th>Model</th> -->
      <!-- <th>Year</th> -->
      <!-- <th>Color</th> -->
      <!-- <th>Oil</th>
                <th>Front Brakes</th>
                <th>Back Brakes</th>
                <th>Tires</th> -->

      <!-- <th>Date Reported</th> -->

      <!-- <th>Estimated Completion</th>
                <th>Labor</th>
                <th>Estimated Cost</th>
                <th>Status</th>
                <th>Paid</th>
              </tr>
            </thead>
            <tbody>
              <tr -->
      <!-- v-for="service in this.$store.state.serviceList"
                v-bind:key="service.serviceId"
              > -->
      <!-- <td>{{this.$store.state.user.firstName}} {{this.$store.state.user.lastName}}</td> -->
      <!-- <td></td> -->
      <!-- <td></td> -->
      <!-- <td></td> -->
      <!-- <td></td> -->
      <!-- <td></td> -->
      <!-- 
                <td>{{ service.oil }}</td>
                <td>{{ service.frontBrakes }}</td>
                <td>{{ service.backBrakes }}</td>
                <td>{{ service.tires }}</td> -->

      <!-- <td>Today's date</td> -->

      <!-- <td>
                  <form v-on:submit.prevent="saveRequest">
                    <input
                      id="completion-date"
                      name="completion-date"
                      class="completion-date-input"
                      type="date"
                      v-model="serviceRequest.date"
                    />
                    <select>
                      <option value="">--- Select Labor Cost ---</option>
                      <option value="Basic Labor">Basic Labor</option>
                      <option value="Half Day Labor">Half Day Labor</option>
                      <option value="Full Day Labor">Full Day Labor</option>
                    </select>

                    $$$
                    <select>
                      <option value="">--- Select Status ---</option>
                      <option value="Pending">Pending</option>
                      <option value="Active">Active</option>
                      <option value="Completed">Completed</option>
                    </select>
                    No
                    <button type="submit">Submit</button>
                  </form>
                </td>
              </tr>
            </tbody>
          </table>  -->
    </div>
  </div>
</template>

<script>
import repairsService from "../services/RepairsService";
import userService from "../services/UserService";

export default {
  name: "employee-details",
  data() {
    return {
      isLoaded: false,
      users: [],
      allServices: [],
      serviceRequest: {
        requestId: -1,
        serviceId: -1,
        completionDate: "",
        laborCost: "",
        estimatedCost: "",
        status: "",
        paid: false,
      },
    };
  },
  // computed: {
  //   hasCarsFromUser(user){
  //     return user.cars.length!=0
  //   }
  // },
  methods: {
    saveRequest1(serviceId) {
      console.log(this.allServices);
      console.log(serviceId);
      let tempArr = this.allServices.filter(
        (obj) => obj.serviceId == serviceId
      );
      let requestObj = tempArr[0];
      console.log("DEBUG");
      console.log(requestObj);

      repairsService.create(requestObj).then((response) => {
        if (response.status == 200) {
          window.alert("success");
          this.$router.push("/employee/:id");
        }
      });
    },
    saveRequest() {
      alert("button clicked");

      repairsService.create(this.serviceRequest).then((response) => {
        if (response.status === 200) {
          alert("success");
          this.$router.push("/employee/:id");
        } else {
          alert(response.status);
        }
      });
    },
  },

  created() {
    userService.getUsers().then((response) => {
      this.users = response.data;
      for (let i = 0; i < this.users.length; i++) {
        let userId = this.users[i].id;
        this.users[i].cars = [];
        userService.getCarsByUser(userId).then((response) => {
          let cars = response.data;
          for (let j = 0; j < cars.length; j++) {
            this.users[i].cars.push(cars[j]);
            repairsService.getServices(cars[j].carId).then((response) => {
              let services = response.data;
              this.users[i].cars[j].services = services;
            });
          }
        });
      }
      this.$store.commit("SET_USERS", this.users);
    });

    repairsService.getServiceList().then((response) => {
      console.log(response);
      this.allServices = response.data.services;
      this.$store.commit("SET_SERVICELIST", response.data.services);
      this.$store.commit("SET_REQUESTS", response.data.requests);
    });

    const delayInMilliseconds = 800;
    setTimeout(() => (this.isLoaded = true), delayInMilliseconds);
  },
};
</script>

<style>
#userFandL{
  text-align: center;
}
.service-box {
  width: 500px;
  height: 350px;
  margin: 20px;
  padding: 20px;
  background-color: cornflowerblue;
}
.car {
  border: solid 5px;
  border-radius: 5px;
  margin: 10px;
  padding: 10px;
}
#userAndCars{
display: flex;
flex-direction: row;
justify-content: left;

}
#userFirstAndLast{
  font-size: 25px;
  font-weight:bolder;
  /* text-align: center; */
  padding: 20px;
  padding-top: 0px;
}
</style>