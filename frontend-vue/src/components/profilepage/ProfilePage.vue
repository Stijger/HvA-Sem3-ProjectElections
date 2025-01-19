<script lang="ts">
import {defineComponent} from 'vue'
import axios from "axios";
import Navbar from "@/components/general/NavBar.vue";
import EditorInput from "@/components/profilepage/EditorInput.vue";
import {BASE_URL} from "@/config";

export default defineComponent({
  name: "ProfilePage",
  components: {EditorInput, Navbar},
  data() {
    return {
      backend_url: BASE_URL,
      jwtToken: "",
      feedbackColour: "green",
      feedbackText: "",
    }
  },
  async beforeMount() {
    const jwtToken = localStorage.getItem("ElectionWebsiteLoginCredentials");
    if(jwtToken === null) { window.location.replace("/signup"); return; }
    this.jwtToken = jwtToken;

    const response = await axios.get(this.backend_url.concat("/api/users/me"), {
      headers: {
        "Authorization": `Bearer ${jwtToken}`
      }
    });

    console.log(response.data);
    this.$refs.firstNameBox.setContent(response.data.firstName);
    this.$refs.lastNameBox.setContent(response.data.lastName);
    this.$refs.emailBox.setContent(response.data.email);
    this.$refs.usernameBox.setContent(response.data.username);
  },
  methods: {
    async postChanges(form) {
      try {
        const _response = await axios.post(this.backend_url.concat("/api/users/edit"), form, {
          headers: {
            "Authorization": `Bearer ${this.jwtToken}`
          }
        });

        this.setFeedback("The changes have been saved", "green");
      } catch(msg) {
        console.error(msg);
        this.setFeedback("Something went wrong", "red");
      }
    },

    setFeedback(text, colour) {
      this.feedbackText = text;
      this.feedbackColour = colour;
    }
  },
})
</script>

<template>
  <Navbar></Navbar>
  <div class="section-header">My Account</div>
  <div class="separator">
    <div class="portrait">

    </div>
    <div class="props-editor">
      <!-- Should be it's own component -->
      <div class="box">
        <div class="details-header">Account details</div>
        <div v-if="feedbackText !== ''" class="feedback-label">{{feedbackText}}</div>

        <EditorInput
            ref="firstNameBox"
            placeholder="Your first name"
            @post-change="name => this.postChanges({newFirstName: name})"
        ></EditorInput>

        <EditorInput
            ref="lastNameBox"
            placeholder="Your last name"
            @post-change="name => this.postChanges({newLastName: name})"
        ></EditorInput>

        <EditorInput
            ref="emailBox"
            placeholder="Your email address"
            @post-change="name => this.postChanges({newEmail: name})"
        ></EditorInput>

        <EditorInput
            ref="usernameBox"
            placeholder="Your username"
            @post-change="name => this.postChanges({newUsername: name})"
        ></EditorInput>

        <!-- button class="btn btn-save">Save changes</button -->
      </div>
    </div>
  </div>
</template>

<style scoped>
.section-header {
  width: 466px;
  height: 59px;
  flex-shrink: 0;
  color: #000;
  font-family: Montserrat;
  font-size: 40px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
}

.feedback-label {
  text-align: center;
  color: v-bind(feedbackColour);
}

.details-header {
  color: #154273;
  text-align: center;
  font-family: Montserrat;
  font-size: 36px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
}

.box {
  width: 40vw;
  display: flex;
  border: 1px solid #154273;
  flex-direction: column;
  justify-content: flex-end;
}

.separator {
  display: flex;
  justify-content: center;
  column-gap: 4vw;
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

.btn-save {
  width: 25vw;
}

.btn:hover {
  background-color: #a0b0c0;
}

</style>