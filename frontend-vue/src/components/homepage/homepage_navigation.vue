<template>
  <div class="cards-container">
    <div class="card">
      <h2><a href="/electionresult">Elections 2023</a></h2>
      <p>Results of the 2023 elections.</p>
    </div>
    <div class="card">
      <h2><a href="/form">Form</a></h2>
      <p>Discuss your opinion.</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "homepage-navigation",
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.cards-container {
  margin-top: 10vh; /* Gebruik vh voor een meer dynamische marge bovenaan */
  display: flex;
  justify-content: center; /* Centreer de kaarten */
  flex-wrap: wrap; /* Hierdoor kunnen de kaarten naast elkaar staan op grotere schermen en stapelen op kleinere schermen */
  gap: 2vw; /* Voegt ruimte toe tussen de kaarten afhankelijk van de viewport breedte */
  padding: 2vw;
  width: 100%;
}

.card {
  background-color: #f8f9fa;
  padding: 2vw; /* Dynamische padding op basis van de viewport breedte */
  border: 1px solid #d3d3d3;
  border-radius: 8px;
  width: calc(50% - 2vw); /* Zorgt ervoor dat twee kaarten naast elkaar passen */
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  text-align: left;
  margin-bottom: 2vw;
}

.card h2 {
  color: #003366;
  font-size: 1.5em;
  margin-bottom: 1vw;
}

.card p {
  font-size: 1em;
  color: #333;
}

a {
  text-decoration: none;
  color: #003366;
}

a:hover {
  text-decoration: underline;
}

/* Media queries voor tablets */
@media (max-width: 768px) {
  .card {
    width: calc(100% - 2vw); /* Zorgt ervoor dat de kaarten één kolom innemen op tablets */
    margin-right: 0;
  }
}

/* Media queries voor mobiele telefoons */
@media (max-width: 480px) {
  .cards-container {
    margin-top: 8vh; /* Minder margin op kleinere schermen */
  }

  .card {
    width: 100%; /* Kaarten nemen de volledige breedte in op mobiele schermen */
  }

  .card h2 {
    font-size: 1.2em; /* Iets kleinere titels op mobiele schermen */
  }

  .card p {
    font-size: 0.9em; /* Iets kleinere tekst op mobiele schermen */
  }
}
</style>
