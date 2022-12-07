<template>
  <div>
    <div v-if="student.length > 0" class="card-container d-flex flex-wrap">
      <div class="col-4 mt-4" v-for="(item, index) in student" :key="item.id">
        <div class="card p-3 border">
          <h5>{{ item.name }}, {{ item.age }} years old.</h5>
          <p>{{ item.self_description }}</p>
          <table>
            <tr>
              <td>Email</td>
              <td>: {{ item.email }}</td>
            </tr>
            <tr>
              <td>Soft Skill</td>
              <td>: {{ item.soft_skill }}</td>
            </tr>
            <tr>
              <td>Hard Skill</td>
              <td>: {{ item.hard_skill }}</td>
            </tr>
            <tr>
              <td>Interest</td>
              <td>: {{ item.interest }}</td>
            </tr>
          </table>
          <div class="d-flex justify-content-between mt-3">
            <div>
              <!-- <router-link :to="'/update/' + item.id"> -->
              <button
                class="btn btn-primary mr-2"
                @click="$router.push({ path: `/update/${item.id}` })"
              >
                Update
              </button>
              <!-- </router-link> -->
              <button
                class="btn btn-danger"
                @click="deleteStudentData(item.id, index)"
              >
                Delete
              </button>
            </div>
            <img
              v-if="item.gender == 'Male'"
              :class="item.gender"
              src="../assets/male.png"
              alt=""
            />
            <img
              v-else
              :class="item.gender"
              src="../assets/female.png"
              alt=""
            />
          </div>
        </div>
      </div>
    </div>
    <div v-else>
      <center>
        <h1>There is no data!</h1>
      </center>
    </div>
  </div>
</template>

<script>
import studentService from "../services/studentService";

export default {
  name: "HomeBodyCard",
  data() {
    return {
      student: {
        name: "",
        age: null,
        gender: "",
        email: "",
        soft_skill: "",
        hard_skill: "",
        self_description: "",
        interest: "",
      },
      isDeleted: false,
    };
  },
  methods: {
    getAllStudentData() {
      studentService
        .getAllStudent()
        .then((response) => {
          this.student = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    deleteStudentData(id, index) {
      if (confirm("Are you sure want to delete?")) {
        studentService
          .deleteStudent(id)
          .then(
            this.student.splice(index, 1),
            (this.isDeleted = true),
            this.$emit("hasDeleted", this.isDeleted)
          )
          .catch((e) => {
            console.log(e);
          });
      } else {
        alert("Delete canceled");
      }
    },
    // sendUpdateData(item) {
    //   this.$root.$emit("updateData", item);
    //   this.$router.push({ path: "/update/" });
    // },
  },
  mounted() {
    this.getAllStudentData();
  },
};
</script>

<style scoped>
img {
  width: 50px;
  height: auto;
}

.Female {
  width: auto;
  height: 50px;
}
</style>