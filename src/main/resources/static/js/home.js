$(document).ready(function(){


    let animation = function(){
        //select objects to animate
        const navigation = document.querySelector(".navigation-right");
        //declare timeline
        const tl = new TimelineMax();
        tl.fromTo(navigation, .9, {transform: 'translateX(70px)'}, {transform: 'translateX(0px)'}, "+=.5");
        //animate
    }
    animation();

})