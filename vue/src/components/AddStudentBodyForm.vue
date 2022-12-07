<template>
  <div class="d-flex justify-content-center">
    <form class="border border-primary p-4" @submit.prevent="submitData()">
      <h1 class="mb-5">{{ $route.name }}</h1>
      <div class="form-row">
        <div class="col-6">
          <div class="form-group">
            <label for="">Student Name</label>
            <input
              type="text"
              class="form-control"
              name="name"
              placeholder="Enter name"
              required
              v-model="student.name"
            />
          </div>
          <div class="form-row">
            <div class="form-group col-6">
              <label for="">Student Age</label>
              <input
                type="number"
                class="form-control"
                name="age"
                placeholder="Enter age"
                required
                v-model="student.age"
              />
            </div>
            <div class="form-group col-6">
              <label for="">Gender</label>
              <select
                name="gender"
                class="form-control"
                required
                v-model="student.gender"
              >
                <option selected disabled value="">Select Gender</option>
                <option>Male</option>
                <option>Female</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label for="">Student Email</label>
            <input
              type="email"
              class="form-control"
              name="email"
              placeholder="Enter email"
              required
              v-model="student.email"
            />
          </div>
        </div>
        <div class="col-6">
          <div class="form-group">
            <label for="">Soft Skill</label>
            <input
              type="text"
              class="form-control"
              name="soft-skill"
              placeholder="Enter soft skills"
              required
              v-model="student.soft_skill"
            />
          </div>
          <div class="form-group">
            <label for="">Hard Skill</label>
            <input
              type="text"
              class="form-control"
              name="hard-skill"
              placeholder="Enter hard skills"
              required
              v-model="student.hard_skill"
            />
          </div>
          <div class="form-group">
            <label for="">Interest</label>
            <select
              name=""
              id=""
              class="form-control"
              required
              v-model="student.interest"
            >
              <option selected disabled value="">Select Interest</option>
              <option>Data Science</option>
              <option>Network</option>
              <option>Web Frontend</option>
              <option>Web Backend</option>
              <option>Mobile Apps</option>
            </select>
          </div>
        </div>
      </div>
      <div class="form-group">
        <label for="">Self Description</label>
        <textarea
          name="self_description"
          cols="30"
          rows="5"
          class="form-control"
          required
          v-model="student.self_description"
        ></textarea>
      </div>
      <button type="submit" class="btn btn-primary">{{ buttonValue }}</button>
    </form>
  </div>
</template>

<script>
import studentService from "../services/studentService";

export default {
  name: "AddStudentBodyVue",
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
      success: false,
      buttonValue: "Submit",
    };
  },
  methods: {
    submitData() {
      let data = this.student;
      if (this.buttonValue === "Submit") {
        studentService
          .insertStudent(data)
          .then((this.success = true), this.$emit("success", this.success))
          .catch((e) => {
            console.log(e);
          });
      } else {
        studentService
          .updateStudent(data.id, data)
          .then((this.success = true), this.$emit("success", this.success))
          .catch((e) => {
            console.log(e);
          });
      }
    },
    // getParams() {
    //   console.log(this.$route.params.id);
    // },
  },
  mounted() {
    if (this.$route.name === "Update Student") {
      this.buttonValue = "Update";
      let id = this.$route.params.id;
      studentService
        .getSelectedStudent(id)
        .then((response) => {
          this.student = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    }
  },
};
</script>

<style scoped>
form {
  width: 70%;
}
h1 {
  text-align: center;
}
</style>