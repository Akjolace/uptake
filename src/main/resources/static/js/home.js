$(document).ready(function () {
    var url = "http://localhost:8080/search/SearchByUsername";
    var mainUrl = "http://localhost:8080";
    var username;
    var btnSearch = $("#slideSearchBtn");
    var txtSearch = $("#searchTxt");
    var loadingSpinner = $('.loading-spinner');
    var tl = new TimelineMax();

    let onBtnnSearch = function () {
        fetchData();
    }

    var showSpinner = function(){ loadingSpinner.css('display','block'); }
    var hideSpinner = function(){ loadingSpinner.css('display', 'none'); }
    
    let fetchData = function () {
        username = txtSearch.val();
        
        $(".slide-search-container-item").remove();
        if (username.length > 0) {
            showSpinner();
            $.ajax(
                url + "?username=" + username,
                {
                    type: "GET",
                    success: generateResult,
                    complete: function () { },
                    error: function () { console.log(error); }
                }
            )
        }
    }

    var generateResult = function (response) {
        let responseJSON = response;//JSON.parse(response);
        let responseLength = Object.keys(responseJSON).length;
        let itemContainerMain = $(".slide-search-container");

        if (responseLength > 0) {
            responseJSON.forEach(function (element, index) {
                //Create slide-search-container-item
                let itemContainer = document.createElement('div');
                itemContainer.classList.add('slide-search-container-item');
                //Create slide-search-container-item-left and right
                let itemContainerLeft = document.createElement('div')
                itemContainerLeft.classList.add('slide-search-container-item-left');
                let itemContainerRight = document.createElement('div');
                itemContainerRight.classList.add('slide-search-container-item-right');
                //Create image
                let itemContainerLeftImg = document.createElement('img');
                //Create 2 paragraphs
                let itemContainerRightUsername = document.createElement('p');
                let itemContainerRightBio = document.createElement('p');
                //Create hyperlink to profile
                let itemContainerRightLink = document.createElement('a');
                //Add values
                itemContainerRightUsername.innerHTML = element.username;
                itemContainerRightBio.innerHTML = element.bio;
                itemContainerLeftImg.src = element.path;
                //Add link inside href
                itemContainerRightLink.href = mainUrl + "/profile/" + element.username;
                //Append right side of elements
                itemContainerRightLink.appendChild(itemContainerRightUsername);
                itemContainerRight.append(itemContainerRightLink, itemContainerRightBio);
                //Append left side of elements
                itemContainerLeft.appendChild(itemContainerLeftImg);
                //Append childs to its mother
                itemContainer.append(itemContainerLeft, itemContainerRight);
                //Add item to the list
                itemContainerMain.append(itemContainer);
                //Animate
                tl.fromTo(itemContainer, .2, { opacity: 0 }, { opacity: 1 });
            })
        }
        //Hide spinner
        hideSpinner();
    }

    //Right navigation start animation
    let animation = function () {
        //select objects to animate
        const navigation = document.querySelector(".navigation-right");
        //declare timeline
        const tl = new TimelineMax();
        tl.fromTo(navigation, .5, { transform: 'translateX(70px)' }, { transform: 'translateX(0px)' }, "+=.5");
        //animate
    }
    //Slide in and out animation with event listener
    let slideEvent = function () {
        const searchBtn = $("#searchBtn");
        const slide = document.querySelector(".slide");
        const tl = new TimelineMax({ paused: true, reversed: true });

        tl.to(slide, .5, { right: "100px" });

        searchBtn.click(function () {
            tl.reversed() ? tl.play() : tl.reverse();
        })
    }


    animation();
    slideEvent();
    btnSearch.click(onBtnnSearch);
    txtSearch.on('input', onBtnnSearch);

})