// import {navcomp} from '/components/nav.js';

/**
 * Changelog:
 * 22-June: fixed switch case(2) would be edited by other cases.
 */

'use strict'

class schema {
    teacherid;
    deptid;
    courseid;
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
            acList: [],
            eList: [],
            selected: [null, null, null], //c,ac,e
            filters: [null, null, null],

        }
    },
    computed: {
        filteredCList: function () {
            if (this.filters[0]) {
                return this.cList
                    .filter(n => {
                        return Object.values(n).join('')
                            .includes(this.filters[0])
                    })
            } else {
                return this.cList;
            }
        },
        filteredAcList: function () {
            if (this.filters[1]) {
                return this.acList
                    .filter(n => {
                        return Object.values(n).join('')
                            .includes(this.filters[1])
                    })
            } else {
                return this.acList;
            }
        },
        filteredEList: function () {
            if (this.filters[2]) {
                return this.eList
                    .filter(n => {
                        return Object.values(n).join('')
                            .includes(this.filters[2])
                    })
            } else {
                return this.eList;
            }
        },

    },
    created() {
        this.init();
    },
    methods: {
        async init() {

            var pcList = async () => {
                var res = await fetch("/api/course/list", {});
                return res.json();
            }

            var pacList = async () => {
                var res = await fetch("/api/account/list", {});
                return res.json();
            }

            var peList = async () => {
                var res = await fetch("/api/teach/list", {});
                return res.json();
            }


            this.acList = await pacList();
            this.acList = this.acList.filter(n => !n.netid.endsWith('d'));

            this.cList = await pcList();
            this.eList = await peList();
            this.filters = [null, null, null];
            this.selected = [null, null, null]; // course, accounts, teach
        },
        async getBean() {
            console.log(this.bean)  //!@Before: same as vm.$data.bean
            this.bean = { ...this.selected };
        },
        async submitBean() {
            const resp = await fetch("/api/teach/add", {
                method: 'PUT',
                cache: 'no-cache',
                body: JSON.stringify(this.bean)
            });

            const msg = await resp.text();
            alert(msg);

            // refresh list
            await this.init();
        },
        async delBean() {
            const resp = await fetch("/api/teach/del", {
                method: 'PUT',
                cache: 'no-cache',
                body: JSON.stringify(this.bean)
            });

            const msg = await resp.text();
            alert(msg);

            // refresh list
            await this.init();
        },
        select(key) {

            switch (key) {
                case 0:
                    //course
                    this.bean["deptid"] = this.selected[0]["deptid"];
                    this.bean["courseid"] = this.selected[0]["courseid"];
                    break;
                case 1:
                    //account
                    this.bean["teacherid"] = this.selected[1]["netid"];
                    break;
                case 2:
                    //teach
                    this.bean = {...this.selected[2]};
                    break;
                default:
                    console.log("E: Illegal select")
                    break;
            }
        }

    }
}

const app = Vue.createApp(formApp)
// navcomp(app);
const vm = app.mount("#deptform")
