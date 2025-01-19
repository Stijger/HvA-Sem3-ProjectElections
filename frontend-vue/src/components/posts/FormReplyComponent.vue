<script setup lang="ts">
  import {ref} from "vue";
  import axios from "axios";
  import {useRouter} from "vue-router";

  /**
   * @type {Ref<string>}
   */
  const emit = defineEmits<{
    (event: 'postMessage', message: { title: string, body: string, dateTime: string}): void
  }>();

  const newMessage = ref('');
  const newTitle = ref('');
  const errorMessage = ref('');

  /**
   * @type {Ref<boolean>}
   */
  const isLoggedIn = ref(!!localStorage.getItem('ElectionWebsiteLoginCredentials'));
  const router = useRouter();

  /**
   * Posts a message to the backend
   */
  const postMessageToBackend = async () => {
    // If the user is not logged in, redirect to the signup page
    if(!isLoggedIn.value) {
      await router.push('/signup');
      return;
    }

    // If the message or title is empty, show an error message
    try {
      if(newMessage.value.trim()==="" || newTitle.value.trim()==="") {
        errorMessage.value = "Both title and body are required";
        return;
      }
      // Post the message to the backend
      const response = await axios.post('/api/posts', {
        title: newTitle.value,
        body: newMessage.value },
      {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('ElectionWebsiteLoginCredentials')}`
        }
      });

      // Emit the postMessage event
      emit("postMessage", response.data);
      newMessage.value = "";
      newTitle.value = "";
      errorMessage.value = "";
    } catch (error) {
      console.error("Error while posting message", error || error.response);
    }
  };

  /**
   * Handles the keydown event
   * @param {KeyboardEvent} event
   */
  const handleKeydown = (event: KeyboardEvent) => {
    if (event.key === 'Enter') {
      postMessageToBackend();
    }
  };
</script>

<template>
  <div class="reply-container">
    <h2>Share your opinion</h2>
    <input v-model="newTitle" placeholder="*Enter your title..." class="title-input" required/> <!-- Title input -->
    <input v-model="newMessage" @keydown="handleKeydown" placeholder="*Enter your message..." class="content-input" required/> <!-- Message input -->
    <button @click="postMessageToBackend">{{ isLoggedIn ? 'Send' : 'Login' }}</button> <!-- Send button -->
    <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div> <!-- Error message -->
  </div>
</template>

<style scoped>
/* Reply container */
.reply-container {
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin: 20px;
}
/* Title input */
.content-input{
  height: 50px;
}
/* Message input */
input {
  flex-grow: 1;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}
/* Send button */
button {
  padding: 8px 12px;
  background-color: #3b82f6;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
/* Error message */
.error-message {
  color: red;
  margin: 10px;
}
</style>