<template>
  <div>
    <h1 class = "table-title">User List</h1>
    <table v-if="users.length">
      <thead>
      <tr>
        <th>ID</th>
        <th>name</th>
        <th>Email</th>
        <th>Role</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="user in users" :key="user.id">
        <td>{{ user.id }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.email }}</td>
        <td>{{ user.roleId }}</td>
        <td><button><a href="https://youtube.com">Edit User</a></button></td>
        <td><button><a href="https://youtube.com">Delete User</a></button></td>
      </tr>
      </tbody>
    </table>
    <p v-else>You currently do not have access to this page, please contact your IT-Manager.</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'UsersTable',
  data() {
    return {
      users: [],
    };
  },
  created() {
    this.fetchUsers();
  },
  methods: {
    async fetchUsers() {
      try {
        const response = await axios.get('http://localhost:8080/api/users/all', {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("ElectionWebsiteLoginCredentials")}`
          }
        });

        this.users = response.data;
      } catch (error) {
        console.error("Fout bij het ophalen van gebruikers:", error);
      }
    },
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
  margin: 1vw;
}

p {
  color: red;
  text-align: center;
  font-size: large;
}

table {
  width: 98%;
  margin: 0 auto;
  border-collapse: collapse;
}

th, td {
  padding: 8px;
  border: 1px solid #ddd;
}

th {
  background-color: #f4f4f4;
  text-align: left;
}
</style>
