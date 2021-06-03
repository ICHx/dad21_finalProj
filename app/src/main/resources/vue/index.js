const Counter={
    data(){
        return{
            counter: 0
        }
        
    },
    mounted() {
        setInterval(()=>{
            this.counter++
        },1000)
    },
}

window.onload = ()=>{
    Vue.createApp(Counter).mount('#counter')
}