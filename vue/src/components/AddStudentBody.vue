<template>
  <div>
    <div v-if="!success" class="my-3">
      <router-link to="/" class="ml-3">
        <button class="btn btn-primary">Back</button>
      </router-link>
      <Form @success="setSuccess" />
    </div>
    <div v-else>
      <Message />
    </div>
  </div>
</template>

<script>
import Form from "./AddStudentBodyForm";
import Message from "./AddStudentBodySuccess.vue";
export default {
  name: "AddStudentBody",
  components: {
    Form,
    Message,
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