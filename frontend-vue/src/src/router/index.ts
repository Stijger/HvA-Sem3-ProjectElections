import  Homepage from "@/components/homepage/homepage.vue";
import {createRouter, createWebHistory} from "vue-router";
import QueryElectionResult from "@/components/queryelectionresult/QueryElectionResult.vue";
import SignUpPage from "@/components/signuppage/SignUpPage.vue";
import FormPage from "@/components/posts/FormPage.vue";
import ProfilePage from "@/components/profilepage/ProfilePage.vue";
import adminpage from "@/components/admin/adminpage.vue";

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Homepage
    },

    {
        path: '/electionresult',
        name: 'Election Result',
        component: QueryElectionResult

    },

    {
        path: '/signup',
        name: 'Sign up',
        component: SignUpPage,
    },

    // Add more routes here
    {
        path: '/form',
        name: 'Form',
        component: FormPage,
    },

    {
        path: '/profile',
        name: 'Profile',
        component: ProfilePage,
    },
    {
        path: '/admin',
        name: 'admin',
        component: adminpage,
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;