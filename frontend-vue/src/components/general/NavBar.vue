<template>
  <nav class="navbar">
    <div class="navbar-left">
      <a href="/" class="nav-link"><img src='../../wwwroot/assets/img/logo-overheid.png' alt="Rijksoverheid Logo" class="logo" /></a>
      <a href="/" class="nav-link">Home</a>
      <a href="/electionresult" class="nav-link">Election Results</a>
      <a href="/form" class="nav-link">Form</a>
      <a href="/admin"
         class="nav-link"
          v-if="userLoggedIn"
         @click="redirectToAdmin"
      >Admin</a>
    </div>
    <div class="navbar-right">
      <button
          v-if="!userLoggedIn"
          class="btn btn-login btn-right"
          @click="redirectToSignup"
      >Login</button>
      <button
          v-else
          class="btn btn-login btn-right"
          @click="redirectToProfile"
      >Profile</button>
      <button
          v-if="!userLoggedIn"
          class="btn btn-signup btn-right"
          @click="redirectToSignup"
      >Sign Up</button>
      <button
          v-else
          class="btn btn-login btn-right"
          @click="logout"
      >Log out</button>

    </div>
  </nav>
</template>

<script>
const TOKEN_KEY = "ElectionWebsiteLoginCredentials";

export default {
  name: "Navbar",
  methods: {
    redirectToSignup() { window.location.href = '/signup' },
    redirectToProfile() { window.location.href = '/profile'; },
    redirectToAdmin() { window.location.href = '/admin'; },
    removeToken() { localStorage.removeItem(TOKEN_KEY); },
    logout() { this.removeToken(); this.$router.go(); }
  },
  data() {
    return {
      userLoggedIn: false,
    }
  },
  beforeMount() {
    const token = localStorage.getItem(TOKEN_KEY);
    this.userLoggedIn = !(token===null);
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html, body {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
}

body {
  padding-top: 70px; /* Zorgt ervoor dat de inhoud onder de navbar begint */
}

.navbar {
  position: relative;
  top: 0;
  left: 0;
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px; /* Oorspronkelijke padding */
  background-color: white;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Oorspronkelijke schaduw */
  z-index: 1000;
}

.navbar-left {
  display: flex;
  align-items: center;
}

.logo {
  width: 150px; /* Oorspronkelijke grootte van het logo */
  flex-shrink: 0;
}

.nav-link {
  margin-left: 20px;
  color: #000;
  text-align: center;
  font-family: Georgia, serif;
  font-size: 20px; /* Originele grootte voor de tekst */
  text-decoration: none;
  transition: color 0.3s ease;
}

.nav-link:hover {
  color: #0076ff;
  text-decoration: underline;
}

.navbar-right {
  display: flex;
  align-items: center;
}

.btn {
  background-color: #A3BFDD;
  border: 1px solid #a0b0c0;
  padding: 10px 20px; /* Oorspronkelijke padding */
  border-radius: 5px;
  margin-left: 10px;
  cursor: pointer;
  font-size: 16px; /* Oorspronkelijke knopgrootte */
  flex-shrink: 0;
}

.btn:hover {
  background-color: #a0b0c0;
}

.btn-right {
  margin-right: 10px;
}

/* Media queries voor tablets en kleinere schermen */
@media (max-width: 768px) {
  .navbar {
    padding: 10px; /* Iets kleinere padding voor tablets */
    flex-direction: column;
    align-items: flex-start;
  }

  .navbar-left, .navbar-right {
    width: 100%;
    justify-content: space-between;
    margin-top: 10px;
  }

  .nav-link {
    font-size: 18px; /* Iets kleinere tekst op tablets */
    margin-left: 10px;
  }

  .btn {
    padding: 8px 15px; /* Kleinere knoppen voor tablets */
    font-size: 14px;
  }
}

/* Media queries voor mobiele telefoons */
@media (max-width: 480px) {
  .logo {
    width: 120px; /* Kleinere logo voor mobiele schermen */
  }

  .nav-link {
    font-size: 16px; /* Nog kleinere tekst voor mobiele schermen */
    margin-left: 5px;
  }

  .btn {
    padding: 5px 10px; /* Nog kleinere knoppen voor mobiele schermen */
    font-size: 14px;
  }

  .navbar-left, .navbar-right {
    flex-direction: column;
    align-items: flex-start;
  }

  .navbar-right {
    margin-top: 10px;
  }

  body {
    padding-top: 60px; /* Verklein de padding-top op mobiele schermen */
  }
}
</style>
