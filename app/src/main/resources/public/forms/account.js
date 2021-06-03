'use strict'
class schema {
    netid;
    firstname;
    lastname;
    deptid;
    gender;
    phone;
}

const schemabean = new schema();
const fields = Object.keys(schemabean);


const formApp = {
    data() {
        return {
            message: "Hello",
            fields: fields,
            bean: {...schemabean},
        }
    },
    computed: {
    },
    methods: {
        test() {
            console.log("hello world");
        },
        async submitBean() {
            const resp = await fetch("/api/account/add", {
                method: 'PUT',
                cache: 'no-cache',
                body: JSON.stringify(this.bean)
            });

            const msg = await resp.text();
            alert(msg);
        },
        async getBean() {
            console.log(this.bean)  //!@Before: same as vm.$data.bean
            const req = await fetch(`/api/account/get?key=${this.bean['netid']}`, {
                method: 'GET',
                cache: 'no-cache',
            });

            this.bean = await req.json();
            console.log(this.bean); //!@After
        },
        async delBean() {
            const resp = await fetch("/api/account/del", {
                method: 'PUT',
                cache: 'no-cache',
                body: JSON.stringify(this.bean)
            });

            const msg = await resp.text();
            alert(msg);
        }
    }
}

const app = Vue.createApp(formApp)
const vm = app.mount("#deptform")

vm.test();
