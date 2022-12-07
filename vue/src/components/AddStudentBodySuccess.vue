<template>
  <div class="d-flex justify-content-center mt-5">
    <div class="text-container border p-3">
      <h2>Success!</h2>
      <p>{{ message }}</p>
      <router-link to="/">
        <button class="btn btn-primary">Close</button>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "AddStudentBodySuccess",
  data() {
    return {
      message: "Student data has been inputed!",
    };
  },
  mounted() {
    if (this.$route.name === "Update Student") {
      this.message = "Student data has been updated!";
    }
  },
};
</script>

<style scoped>
.text-container {
  width: 60%;
}
</style>