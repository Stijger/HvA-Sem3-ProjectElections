<script lang="ts">
import {defineComponent} from 'vue'

export default defineComponent({
  name: "LoginBox",
  props: {
    fields: {disp: String, form: String, hide: Boolean},
    title: String,
  },
  data() {
    return {
      values: [],
      feedbackShow: false,
      feedbackMessage: "",
      feedbackColor: "green",
    }
  },
  emits: [
      "submit-form"
  ],
  methods: {
    submit() {
      let form = {};
      for(let [field, value] of this.fields.map((x,i) => [x.form, this.values[i]])) {
        form[field] = value;
      }

      this.$emit('submit-form', form);
    },

    setFeedback(text: string, colour: string) {
      this.feedbackShow = true;
      this.feedbackColor = colour;
      this.feedbackMessage = text;
    }
  },
  components: {

  }
})
</script>

<template>
  <div class="Background">
    <div class="BoxTitle">{{title}}</div>
    <div class="FeedbackText" v-if="feedbackShow">{{feedbackMessage}}</div>
    <div class="Fields">

      <table>
        <tr v-for="(field, idx) in fields" :key="idx">
          <td>{{field.disp}}</td>
          <td v-if="field.hide"><input v-model="values[idx]" type="password"/></td>
          <td v-else><input v-model="values[idx]" type="text"/></td>
        </tr>
      </table>

      <button class="Button" @click="submit">{{title}}</button>
    </div>
  </div>
</template>

<style scoped>

.Background {
  border-radius: 10px;
  border: 1px solid #154273;
  background: #A3BFDD;
}

.FeedbackText {
  text-align: center;
  color: v-bind(feedbackColor);
}

.BoxTitle {
  color: #154273;
  text-align: center;
  font-family: Montserrat;
  font-size: 36px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
}

.Fields {
  display: flex;
  justify-content: center;
  flex-direction: column;
  margin: 1rem;
  gap: 10px;
}

.Button {
  border-radius: 10px;
  background: #154273;
  color: white;
  font-size: 1rem;
}

</style>