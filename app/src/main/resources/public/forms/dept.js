// import {navcomp} from '/components/nav.js';

'use strict'

class dept {
    deptid;
    deptname;
    deptaddress;
    deptphone;
}

const schemabean = new dept();
const fields = Object.keys(schemabean);


const formApp = {
    data() {
        return {
            message: "Hello",
            bean: schemabean,
            fields: fields,
        }
    },
    computed: {},
    methods: {
        test() {
            console.log("hello world");
        },
        async submitBean() {
            const resp = await fetch("/api/dept/add", {
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
// navcomp(app);
const vm = app.mount("#deptform")
