<template>
  <div>
    <Header />
    <Body @hasDelete="setDeleted" />
    <Footer />
  </div>
</template>

<script>
import Header from "../components/Header";
import Body from "../components/HomeBody";
import Footer from "../components/Footer";
export default {
  name: "HomePage",
  components: {
    Header,
    Body,
    Footer,
  },
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
      deleted: false,
    };
  },
  methods: {
    makeToast(variant = null) {
      this.$bvToast.toast("Data has been deleted!", {
        title: `Success`,
        variant: variant,
        solid: true,
      });
    },
    setDeleted(isDeleted) {
      this.deleted = isDeleted;
    },
  },
  watch: {
    deleted(newValue) {
      if (newValue) {
        this.makeToast("danger");
      }
    },
  },
};
</script>

<style>
</style>