const navApp = {
    data() {
        return {
            links: [
                {name: 'Home', link: '/'},
                {name: 'Account', link: '/forms/account.html'},
                {name: 'Department', link: '/forms/dept.html'},
                {name: 'Department Head', link: '/forms/depthead.html'},
                {name: 'Course List', link: '/forms/course.html'},
                {name: 'Course Enroll', link: '/forms/enroll.html'},
                {name: 'Instructor Enroll', link: '/forms/teach.html'},
            ],
        }
    },
    template: `
    <nav>
     <a v-for="link in links" :href="link.link">
     {{link.name}}
     </a>
    </nav>
    `
}

const app = Vue.createApp(navApp)
export const vm = app.mount("#navApp")


// auto-theming bootstrap
window.addEventListener('load',()=>{
   const arrayOfButtons = document.querySelectorAll("button");
    console.log(arrayOfButtons);
    arrayOfButtons.forEach(n=>{
        n.className +=" btn btn-secondary btn-sm ";
    })
});