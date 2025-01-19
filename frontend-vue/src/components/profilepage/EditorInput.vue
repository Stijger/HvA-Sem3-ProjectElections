<script lang="ts">
import {defineComponent} from 'vue'
import axios from "axios";
import {BASE_URL} from "@/config";

export default defineComponent({
  name: "EditorInput",
  emits: [ "post-change" ],
  data() {
    return {
      backend_url: BASE_URL,
      is_editing: 1,
      boxContent: "",
      lastChange: "",
    };
  },
  methods: {
    toggle() {
      switch(this.is_editing) {
        case 1:
          this.lastChange = this.boxContent;
          break;

        case 0:
          if(this.boxContent !== this.lastChange)
            this.$emit("post-change", this.boxContent);
          break;
      }

      this.is_editing = (this.is_editing+1) % 2;
    },
    setContent(value) {
      this.boxContent = value;
    }
  },
  props: {
    placeholder: String,
  },
})
</script>

<template>
  <div>
    <input type="text" v-model="boxContent" :disabled="is_editing" :placeholder="placeholder" />

    <svg @click="toggle" fill="#000000" height="20px" width="20px" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
       viewBox="0 0 306.637 306.637" xml:space="preserve">
      <g><g>
      <path d="M12.809,238.52L0,306.637l68.118-12.809l184.277-184.277l-55.309-55.309L12.809,238.52z M60.79,279.943l-41.992,7.896
			  l7.896-41.992L197.086,75.455l34.096,34.096L60.79,279.943z"/>
      <path d="M251.329,0l-41.507,41.507l55.308,55.308l41.507-41.507L251.329,0z M231.035,41.507l20.294-20.294l34.095,34.095
			  L265.13,75.602L231.035,41.507z"/>
	    </g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></g>
    </svg>
  </div>
</template>

<style scoped>
* {
  padding: 5px;
  align-self: center;
}
</style>