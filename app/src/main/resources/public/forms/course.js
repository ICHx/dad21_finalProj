// import {navcomp} from '/components/nav.js';

'use strict'

class schema {
    deptid;
    courseid;
    coursename;
    remarks;
}

const schemabean = new schema();
const fields = Object.keys(schemabean);


const formApp = {
    data() {
        return {
            message: "Hello",
            bean: { ...schemabean },
            fields: fields,
            cList: [],
            selected: [],
        }
    },
    computed: {},
    created() {
        this.init();
    },
    methods: {
        test() {
            console.log("hello world");
        },
        async init() {

            var pcList = async () => {
                var res = await fetch("/api/course/list", {});
                return res.json();
            }

            this.cList = await pcList();
            this.bean = { ...schemabean }
        },
        async getBean() {
            console.log(this.bean)  //!@Before: same as vm.$data.bean
            this.bean = { ...this.selected };
        },
        async submitBean() {
            const resp = await fetch("/api/course/add", {
                method: 'PUT',
                cache: 'no-cache',
                body: JSON.stringify(this.bean)
            });

            const msg = await resp.text();
            alert(msg);

            // refresh list
            await this.init();
        },

    }
}

const app = Vue.createApp(formApp)
// navcomp(app);
const vm = app.mount("#deptform")
