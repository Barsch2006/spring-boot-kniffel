<script lang="ts">
import { RouterView } from "./plugins/router";

export default {
  components: {
    RouterView,
  },
};
</script>

<template>
  <VApp dark>
    <VMain>
      <RouterView></RouterView>
    </VMain>
  </VApp>
</template>
