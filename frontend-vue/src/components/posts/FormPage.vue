<script setup lang="ts">
import {ref} from 'vue';
import Navbar from "@/components/general/NavBar.vue";
import FormHeaderComponent from "@/components/posts/FormHeaderComponent.vue";
import FormChatComponent from "@/components/posts/FormChatComponent.vue";
import FormReplyComponent from "@/components/posts/FormReplyComponent.vue";
import Footer from "@/components/general/footer.vue";

/**
 * Reference to the chat component
 */
const chatComponent = ref(null);

/**
 * Handles the post message event
 * @param message The message that was posted
 */
const handlePostMessage = (message: { title: string, body: string, dateTime: string}) => {
  chatComponent.value?.fetchPosts();
}
</script>

<template>
  <Navbar />
  <FormHeaderComponent />
  <FormChatComponent ref="chatComponent" /> <!-- Reference the chat component -->
  <FormReplyComponent @postMessage="handlePostMessage" /> <!-- Listen for the postMessage event -->
  <Footer />
</template>
