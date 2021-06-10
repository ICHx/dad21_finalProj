// import {navcomp} from '/components/nav.js';
'use strict'

const formApp = {
    data() {
        return {
            message: "Hello",
        }
    },
    methods: {
        test() {
            console.log("hello world");
        },
    }
}

const app = Vue.createApp(formApp)
// navcomp(app);
const vm = app.mount("#deptform")
