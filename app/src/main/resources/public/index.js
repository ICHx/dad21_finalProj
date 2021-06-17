// import {navcomp} from '/components/nav.js';
'use strict'
class loginBean {
    netid;
    pin;

    hash() {
        // a silly hash for concept
        var str = this.pin;
        this.pin = str.length + str;
    }
    clear(){
        netid=null;
        pin=null;
    }
}

const formApp = {
    data() {
        return {
            message: "Hello",
            isLoggedIn: false,
            bean: new loginBean,
        }
    },
    mounted() {
        this.init();
    },
    methods: {
        test() {
            console.log("hello world");
        },
        async init() {
            var pLogin = await fetch("/isLoggedIn");
            var status = await pLogin.text();
            this.isLoggedIn = status;
        },
        async submitLogin() {
            this.bean.hash();
            var psubmit = await fetch("/login", {
                method: 'POST',
                cache: 'no-cache',
                body: JSON.stringify(this.bean)
            });

            var status = await psubmit.text();

            alert(status==1?"Success":"Failed login");
            location.reload();

            // test case:
            // insert into Password(NetID,PIN) values("239242t","512345"); ,for password="12345"
        }
    }
}

const app = Vue.createApp(formApp)
// navcomp(app);
const vm = app.mount("#deptform")
