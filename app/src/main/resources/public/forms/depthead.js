// import {navcomp} from '/components/nav.js';

'use strict'

class schema {
    headid;
    fordeptid;
}

const schemabean = new schema();
const fields = Object.keys(schemabean);


const formApp = {
    data() {
        return {
            message: "Hello",
            bean: {...schemabean},
            fields: fields,
            dhList: [],
            deptList: [],
            teacherList: [],
            selectedDept: [],
            selectedDh: [],
            selectedTeacher: [],
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
        async submitBean() {
            const resp = await fetch("/api/depthead/add", {
                method: 'PUT',
                cache: 'no-cache',
                body: JSON.stringify(this.bean)
            });

            const msg = await resp.text();
            alert(msg);

            // refresh list
            await this.init();
        },
        async init() {
            var pdeptList = async () => {
                var res = await fetch("/api/dept/list", {});
                return res.json();
            }
            var pteacherList = async () => {
                var res = await fetch("/api/account/list", {});
                return res.json();
            }
            var pdhList = async () => {
                var res = await fetch("/api/depthead/list", {});
                return res.json();
            }

            this.dhList = await pdhList();
            this.deptList = await pdeptList();
            this.teacherList = await pteacherList();
            this.teacherList = this.teacherList.filter(n => n.netid.endsWith('t'));

        },


    }
}

const app = Vue.createApp(formApp)
// navcomp(app);
const vm = app.mount("#deptform")
