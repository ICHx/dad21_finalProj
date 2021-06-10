// import {navcomp} from '/components/nav.js';
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
            bean: { ...schemabean },
            acList: [],
            selected: {},
            filter: null,
        }
    },
    created() {
        this.init();
    },
    computed: {
        filteredList: function () {
            if (this.filter) {
                return this.acList
                    .filter(n => {
                        return Object.values(n).join()
                            .includes(this.filter)
                    })
            } else {
                return this.acList;
            }
        }
    },
    methods: {
        async init() {
            var pacList = async () => {
                var res = await fetch("/api/account/list", {});
                return res.json();
            }
            this.acList = await pacList();
            this.bean = { ...schemabean };
            this.selected = {};
            this.filter = null;

        },
        async submitBean() {
            const resp = await fetch("/api/account/add", {
                method: 'PUT',
                cache: 'no-cache',
                body: JSON.stringify(this.bean)
            });

            const msg = await resp.text();
            alert(msg);

            // refresh list
            await this.init();
        },
        async getBean() {
            console.log(this.bean)  //!@Before: same as vm.$data.bean
            this.bean = { ...this.selected };

        },
        async delBean() {
            const resp = await fetch("/api/account/del", {
                method: 'PUT',
                cache: 'no-cache',
                body: JSON.stringify(this.bean)
            });

            const msg = await resp.text();
            alert(msg);

            // refresh list
            await this.init();
        }
    }
}

const app = Vue.createApp(formApp)
// navcomp(app);
const vm = app.mount("#deptform")
