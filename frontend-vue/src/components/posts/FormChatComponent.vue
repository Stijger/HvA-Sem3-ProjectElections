<script setup lang="ts">
import {onMounted, ref} from 'vue';
import axios from "axios";

/**
 * @type {Array<{id: number, title: string, body: string, dateTime: string}>}
 */
const posts = ref<Array<{id: number, title: string, body: string, dateTime: string}>>([]);

/**
 * Fetches posts from the backend
 */
const fetchPosts = async () => {
  try {
    const response = await axios.get("http://localhost:8080/api/posts");
    posts.value = response.data;
  } catch (error) {
    console.error("Error while fetching posts", error || error.response);
  }
}

/**
 * Fetch posts when the component is mounted
 */
onMounted(() => {
  fetchPosts()
})

/**
 * Expose the fetchPosts function to the template
 */
defineExpose({
  fetchPosts
})
</script>

<template>
<div class="chat-container">
    <div v-if="posts.length === 0" class="no-messages"> <!-- If there are no posts, show this message -->
      No messages yet.
    </div>
    <div v-for="post in posts" :key="post.id" class="chat-message"> <!-- Loop through all posts and show them -->
      <h3>{{ post.title }}</h3>
      <p>{{ post.body }}</p>
      <small>{{ new Date(post.dateTime).toLocaleString() }}</small> <!-- Convert the date to a readable format -->
    </div>
  </div>
</template>

<style scoped>
/* Chat component */
.chat-container{
  background-color: #d1d5db;
  padding: 10px;
  border-radius: 8px;
  min-height: 300px;
  margin: 20px;
  max-height: 500px;
  overflow-y: auto;
}
/* Chat message */
.chat-message{
  background-color: #ffffff;
  margin: 5px 0;
  padding: 8px;
  border-radius: 5px;
}
/* No messages */
.no-messages {
  text-align: center;
  color: #777;
}
</style>