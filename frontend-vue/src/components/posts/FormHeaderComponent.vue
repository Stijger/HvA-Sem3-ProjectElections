<script setup lang="ts">
</script>

<template>
  <div class="header">
    <img src="../../wwwroot/assets/img/form_image.jpg" alt="Form Image" class="form-image" /> <!-- Form image -->
  </div>
</template>

<style scoped>
/* Header component */
  .header{
    position: relative;
    width: 98vw;
    height: 500px;
    margin: 0;
    padding: 0;
    overflow: hidden;
  }
/* Form image */
  .form-image {
    width: 100%;
    height: 100%;
    object-fit: cover; /* Zorgt ervoor dat de afbeelding proportioneel wordt gevuld */
    display: block; /* Verwijdert eventuele ruimte onder afbeeldingen */
  }
</style>