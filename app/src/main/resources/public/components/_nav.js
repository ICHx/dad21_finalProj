// Vue Component as a module
// ! disabled and replaced by navApp, which is a new Vue instance.

const navcomp = function(app){
    app.component('global-navbar', {
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
    });
}

export {navcomp};