'use strict'
class schema {
    netid;
    firstname;
    lastname;
    deptid ;
    gender;
    phone;
}

const bean = new schema();
const fields = Object.keys(bean);


const formApp = {
    data() {
        return {
            message: "Hello",
            bean: bean,
            fields: fields,
        }
    },
    computed(){
    },
    methods:{
        test(){
            console.log("hello world");
        },
        async submitBean(){
            const resp = await fetch("/api/account/add",{
                method: 'PUT',
                cache: 'no-cache',
                body: JSON.stringify(bean)
            });
            
            const msg = await resp.text();
            alert(msg);
        }
    }
}

const app = Vue.createApp(formApp)
const vm = app.mount("#deptform")

vm.test();