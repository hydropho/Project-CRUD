<template>
  <div>
    <Header />
    <div v-if="!success">
      <router-link to="/">
        <button class="btn btn-primary ml-3 mt-3">Back</button>
      </router-link>
      <Form class="my-5" @success="setSuccess" />
    </div>
    <div v-else>
      <SuccessMessage />
    </div>
    <Footer />
  </div>
</template>

<script>
import Header from "../components/Header";
import Form from "../components/AddStudentBodyForm";
import SuccessMessage from "../components/AddStudentBodySuccess";
import Footer from "../components/Footer";
export default {
  name: "UpdateStudentPage",
  components: {
    Header,
    Form,
    Footer,
    SuccessMessage,
  },
  data() {
    return {
      success: false,
    };
  },
  methods: {
    setSuccess(suc) {
      this.success = suc;
    },
  },
};
</script>

<style>
</style>