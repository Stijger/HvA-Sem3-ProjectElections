<script setup lang="ts">
import Navbar from "@/components/general/NavBar.vue";
import HomepageBody from "@/components/homepage/homepage_image.vue";
import HomepageNavigation from "@/components/homepage/homepage_navigation.vue";
import Footer from "@/components/general/footer.vue";

</script>

<template>
  <Navbar>  </Navbar>


  <main>
    <section>
      <homepage-body />
    </section>
<!--    <section>-->
      <homepage-navigation />
<!--    </section>-->
    <footer>
      <Footer />
    </footer>
  </main>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
