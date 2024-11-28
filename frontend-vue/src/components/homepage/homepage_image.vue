<template>
  <div class="hero-section">
    <img src="../../wwwroot/assets/img/voting.jpg" alt="Voting Image" class="hero-image" />
    <div class="overlay-text">
      Curious about what people in your area are voting for?
    </div>
  </div>
</template>

<script>
export default {
  name: "homepage-image",
};
</script>

<style scoped>
html, body {
  margin: 0;
  padding: 0;
  width: 100%;
}

.hero-section {
  position: relative;
  width: 98vw;
  height: 500px;
  margin: 0;
  padding: 0;
  overflow: hidden; /* Zorg ervoor dat de afbeelding niet uit de container treedt */
}

.hero-image {
  width: 100%;
  height: 100%;
  object-fit: cover; /* Zorgt ervoor dat de afbeelding proportioneel wordt gevuld */
  display: block; /* Verwijdert eventuele ruimte onder afbeeldingen */
}

.overlay-text {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
  font-size: 36px;
  font-weight: bold;
  text-align: center;
  font-family: 'Georgia', serif;
  background: rgba(0, 0, 0, 0.5);
  padding: 20px;
  border-radius: 5px;
}

/* Media queries voor tablets */
@media (max-width: 768px) {
  .hero-section {
    height: 400px; /* Verklein de hoogte voor tablets */
  }

  .overlay-text {
    font-size: 28px; /* Kleinere tekst voor tablets */
    padding: 15px; /* Minder padding rond de tekst */
  }
}

/* Media queries voor mobiele telefoons */
@media (max-width: 480px) {
  .hero-section {
    height: 300px; /* Nog kleinere hoogte voor mobiele schermen */
  }

  .overlay-text {
    font-size: 20px; /* Nog kleinere tekst voor mobiele schermen */
    padding: 10px; /* Minder padding om ruimte te besparen */
  }
}
</style>
