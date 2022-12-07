<template>
  <div class="mb-5">
    <router-link to="/add" class="pl-3">
      <button class="btn btn-primary my-3">Add Data</button>
    </router-link>
    <HomeBodyCard @hasDeleted="takeDelete" />
  </div>
</template>

<script>
import HomeBodyCard from "./HomeBodyCard";
export default {
  name: "HomeBody",
  components: {
    HomeBodyCard,
  },
  methods: {
    takeDelete(deleted) {
      this.$emit("hasDelete", deleted);
    },
  },
};
</script>

<style>
</style>