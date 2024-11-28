<template>
  <div class="page-container">
    <!-- Hier kan de content van de pagina komen -->
    <footer class="footer">
      <div class="footer-container">
        <div class="footer-left">
          <ul class="footer-links">
            <li><a href="/">Home</a></li>
            <li><a href="/electionresult">Election Results</a></li>
            <li><a href="/form">Form</a></li>
          </ul>
        </div>
        <div class="footer-right">
          <p><a href="/electionresult">Terms</a> | <a href="/electionresult">Privacy</a> &copy; Election Project 2024</p>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
export default {
  name: "Footer",
}
</script>

<style scoped>
html, body {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  box-sizing: border-box;
}

.page-container {
  min-height: 30vh;
  display: flex;
  flex-direction: column;
}

.footer {
  margin-top: 30vh;
  width: 100%;
  background-color: #003366;
  color: white;
  padding: 40px 0px;
  box-sizing: border-box;
}

.footer-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  max-width: none;
  margin: 0;
}

.footer-left {
  display: flex;
  flex-direction: column;
  padding-left: 20px;
}

.footer-right {
  font-size: 0.9em;
  text-align: right;
  padding-right: 20px;
}

.footer-links {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

.footer-links li {
  margin-bottom: 10px;
}

.footer-links a {
  color: white;
  text-decoration: none;
}

.footer-links a:hover {
  text-decoration: underline;
}

a {
  color: white;
  text-decoration: none;
}
</style>
