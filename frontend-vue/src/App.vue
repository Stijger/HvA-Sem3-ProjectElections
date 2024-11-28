<template>
  <div id="app">
    <router-view /> <!-- Deze tag wordt vervangen door de juiste component op basis van de route -->
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
</style>

<script setup lang="ts">
// Geen imports meer nodig hier behalve eventuele basisinstellingen.
import Homepage from "@/components/homepage/homepage.vue";
</script>
