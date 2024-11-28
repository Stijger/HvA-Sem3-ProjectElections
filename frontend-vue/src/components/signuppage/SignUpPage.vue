<script lang="ts">
import {defineComponent} from 'vue'
import LoginBox from "@/components/signuppage/LoginBox.vue";
import axios from "axios";

export default defineComponent({
  name: "SignUpPage",
  components: {LoginBox},
  methods: {
    test(form) { console.log(form); },

    async sendLoginForm(form): Promise<void> {
      if(!this.validateLoginForm(form)) {
        this.$refs.LoginFormObject.setFeedback("please fill in all fields", "red");
        return;
      }

      try {
        let result = await axios.post(this.backend_url.concat("/api/auth/login"), form);

        if(result.status !== 200) throw "Login failed";

        let jwtToken = result.data.token;
        this.$refs.LoginFormObject.setFeedback("You are logged in", "green");
        localStorage.setItem("ElectionWebsiteLoginCredentials", jwtToken);
        window.location.href = "/";
      } catch(msg) {
        this.$refs.LoginFormObject.setFeedback("Could not log in", "red");
      }
    },

    async sendRegisterFrom(form): Promise<void> {
      if(!this.validateLoginForm(form)) {
        this.$refs.RegisterFormObject.setFeedback("Please fill in all fields", "red");
        return;
      }

      if(form.password !== form.password2) {
        this.$refs.RegisterFormObject.setFeedback("Re-password does not match original", "red");
        return;
      }

      delete form.password2;

      try {
        let result = await axios.post(this.backend_url.concat("/api/auth/signup"), form);

        if(result.status !== 200) throw "Sign up failed";

        this.$refs.RegisterFormObject.setFeedback("Your account has been created", "green");
      } catch(msg) {
        this.$refs.RegisterFormObject.setFeedback("An error occurred during account creation", "red");
      }
    },

    /**
     * validates if any of the fields are empty before sending an obviously bad form
     * @param form {Object} the form to check the fields for
     * @returns {boolean} true if the form contains no empty fields, false if otherwise
     */
    validateLoginForm(form) {
      for(let value of Object.values(form)) {
        if(value === undefined || value === "") return false;
      }
      return true;
    },

  },
  data() {
    return {
      backend_url: "http://localhost:8080",

      loginFields: [
        {disp: "Username", form: "username", hide: false},
        {disp: "Password", form: "password", hide: true},
      ],

      registerFields: [
        {disp: "First name", form: "firstName", hide: false},
        {disp: "Last name", form: "lastName", hide: false},
        {disp: "Username", form: "username", hide: false},
        {disp: "Email address", form: "email", hide: false},
        {disp: "Password", form: "password", hide: true},
        {disp: "Re-enter password", form: "password2", hide: true},
      ]
    };
  },
})
</script>

<template>
  <div class="MainIndeling">
    <div class="LeftSide">
      <a href="/">
        <img src='../../wwwroot/assets/img/logo-overheid.png' alt="Rijksoverheid Logo" class="logo" />
      </a>
      <LoginBox
          :fields="loginFields"
          title="Log in"
          @submit-form="sendLoginForm"
          ref="LoginFormObject"
      />
    </div>
    <div class="RightSide">
      <LoginBox
          :fields="registerFields"
          title="Sign up"
          @submit-form="sendRegisterFrom"
          ref="RegisterFormObject"
      />
    </div>
  </div>
</template>

<style scoped>

.MainIndeling {
  display: flex;
  justify-content: center;
  column-gap: 4vw;
}

.logo {
  width: 25vw;
  flex-shrink: 0;
  padding: 1rem;
}

.RightSide {
  margin-top: 30vh;
}

</style>