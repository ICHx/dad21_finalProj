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
            bean: {...schemabean},
            fields: fields,
            dList:[],
            selected:{},
        }
    },
    created(){
        this.init();
    },
    computed: {},
    methods: {
        async init() {
            var pdList = async () => {
                var res = await fetch("/api/dept/list", {});
                return res.json();
            }
            this.dList = await pdList();
            this.bean={...schemabean};
            this.selected={};

        },
        async getBean() {
            console.log(this.bean)  //!@Before: same as vm.$data.bean
            this.bean = {...this.selected};
            console.log(this.bean); //!@After
        },
        
        // ?no delete for department

        async submitBean() {
            const resp = await fetch("/api/dept/add", {
                method: 'PUT',
                cache: 'no-cache',
                body: JSON.stringify(this.bean)
            });

            const msg = await resp.text();
            alert(msg);

            await this.init();
        }
    }
}

const app = Vue.createApp(formApp)
// navcomp(app);
const vm = app.mount("#deptform")
