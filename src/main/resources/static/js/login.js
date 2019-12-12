$(document).ready(function(){

    let animation = function(){
        //Select objects to animate
        const Vector1 = document.querySelector("#login-left-vector");
        const Vector2 = document.querySelector("#login-right-vector");
        const Form = document.querySelector(".login-form");
        //Declare timeline
        const tl = new TimelineMax();
        //Animate objects
        tl.fromTo(Vector1, .9, { left: '-200px'}, { left: '0' } , "+=.5")
            .fromTo(Vector2, .9, { right: '-200px'}, { right: '0' }, "-=.9")
            .fromTo(Form, 0.5, { opacity: 0 }, {opacity: 1}, "-=.5");
    }

    animation();

})