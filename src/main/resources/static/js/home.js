$(window).on('load', function () {
    //? Search user START---------------------------------------------------------------------------------------------
    var url = "http://localhost:8080/search/SearchByUsername";
    var mainUrl = "http://localhost:8080";
    var username;
    var postItems;
    var btnSearch = $("#slideSearchBtn");
    var txtSearch = $("#searchTxt");
    var loadingSpinner = $('.loading-spinner');
    let URLGetEmail = mainUrl + '/authentication/getloggedusername';
    let URLGetPosts = mainUrl + '/search/getNewsfeedByEmail';
    let currentPage = 0;
    var tl = new TimelineMax();

    //For scroll events
    var input = {
        scrollY: {
            start: 0,
            end: document.documentElement.scrollHeight - window.innerHeight,
            current: 0
        }
    }
    input.scrollY.inputRange = input.scrollY.end - input.scrollY.start;

    var updateInputRange = function () {
        input.scrollY.end = document.documentElement.scrollHeight - window.innerHeight;
        input.scrollY.inputRange = input.scrollY.end - input.scrollY.start;
    }
    //

    let onBtnnSearch = function () {
        fetchData();
    }

    var showSpinner = function () { loadingSpinner.css('display', 'block'); }
    var hideSpinner = function () { loadingSpinner.css('display', 'none'); }

    var hideNothingHere = function () { $('.home-nothing-here').css('display', 'none') };

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
    // Search user
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
        tl.fromTo(navigation, 1, { transform: 'translateX(70px)' }, { transform: 'translateX(0px)' });
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
    //? Search user END----------------------------------------------------------------------------------------------
    //? Get posts start ---------------------------------------------------------------------------------------------

    //Getting posts step 1
    let getPosts = function () {

        const fetchPromise = fetch(URLGetEmail);
        fetchPromise.then(response => {
            return response.text()
        }).then(loggedEmail => {
            getPostsByEmail(loggedEmail);
        });
    }
    //Getting posts step 2
    let getPostsByEmail = function (email) {
        $.ajax(
            URLGetPosts + '?email=' + email + '&page=' + currentPage++,
            {
                type: 'GET',
                success: onGetPostSuccess,
                complete: function () { },
                error: function (error) { console.log(error); }

            }
        )
    }

    let onGetPostSuccess = function (response) {
        let responseJSON = response;//JSON.parse(response);
        let responseLength = Object.keys(responseJSON).length;
        let postItemContainer = $('.home-main-post-container');
        //$('.home-main-post-container');
        if (responseLength > 0) {
            hideNothingHere();
            responseJSON.forEach(function (element, index) {
                let commentCount;
                let likeCount;
                //function to generate HTML
                let generateHtml = function () {
                    //Create item
                    let postItem = $('<div>', { class: 'home-main-post-container-item' })
                    //Create left item
                    let postItemLeft = $('<div>', { class: 'home-main-post-container-item-left' });
                    //Create left item img
                    let postItemImg = $('<img>', { src: element.postPath })
                    //Add elements to left item
                    postItemLeft.append(postItemImg)

                    //Create right item
                    let postItemRight = $('<div>', { class: 'home-main-post-container-item-right' });
                    //Create Profile, Comment, Like elements for right side of item
                    let postItemRightProfile = $('<div>', { class: 'home-main-post-container-item-right-profile' });
                    let postItemRightComment = $('<div>', { class: 'home-main-post-container-item-right-comment' });
                    let postItemRightLike = $('<div>', { class: 'home-main-post-container-item-right-like' });
                    //Create ProfileImage, and username for postItemRightProfile
                    let postItemRightProfileImg = $('<img>', { src: element.profilePath });
                    let postItemRightProfileUsername = $('<p>').append($('<a>', { href: mainUrl + '/profile/' + element.username }).text(element.username));
                    //Add profile img and username
                    postItemRightProfile.append(postItemRightProfileImg, postItemRightProfileUsername)
                    //Create items for Commect section
                    let postItemRightCommentItem = $('<div>', { class: 'home-main-post-container-item-right-comment-item' });
                    let postItemRightCommentItemP = $('<p>')
                        .append($('<a>', { href: mainUrl + '/profile/' + element.username }).append($('<span>', { class: 'comment-username' }).text(element.username + ' ')));
                    postItemRightCommentItemP.append($('<span>', { class: 'comment-text' }).text(element.description));
                    //Add to comment item
                    postItemRightCommentItem.append(postItemRightCommentItemP);

                    //Create elements for comments section
                    let postCommentItemViewComments = $('<div>', { class: 'home-main-post-container-item-right-comment-item viewComments' })
                        .append(
                            $('<p>')
                                .append($('<span>', { class: 'comment-username' }).text('View all'))
                                .append($('<span>', { class: 'comment-username' }).text(' ' + commentCount + ' '))
                                .append($('<span>', { class: 'comment-username' }).text('comments'))
                        );
                    //Append elements to comment section
                    postItemRightComment.append(postItemRightCommentItem);
                    //postItemRightComment.append(postItemRightCommentItem, postCommentItemViewComments);
                    //Create elements for like section
                    let likeIcon = $('<img>', {src: '../Icons/Heart.svg'});
                    let likeText = $('<p>').text(likeCount + ' ')
                    let commentIcon = $('<img>', {src: '../Icons/comment.svg'});
                    let commentText = $('<p>').text(commentCount + ' ');                   
                    //Append Like section elements
                    postItemRightLike.append(likeIcon, likeText, commentIcon, commentText );
                    //Append items to the right
                    postItemRight.append(postItemRightProfile, postItemRightComment, postItemRightLike);
                    //Add main 2 elements to postItem
                    postItem.append(postItemLeft, postItemRight);
                    //Add postitem to the postItemContainer
                    postItemContainer.append(postItem);
                    //Animate
                    tl.fromTo(postItem, 1, { opacity: 0 }, { opacity: 1 });
                    updateInputRange();
                }
                //Fetches for comment and like counts
                const fetchPromiseComment = fetch(mainUrl + '/search/getCommentCountByPost?postID=' + element.id);
                const fetchPromiseLike = fetch(mainUrl + '/search/getLikeCountByPost?postID=' + element.id);

                fetchPromiseComment.then(response => {
                    return response.text()
                }).then(count => {
                    commentCount = count;
                    fetchPromiseLike.then(response => {
                        return response.text()
                    }).then(count => {
                        likeCount = count;
                        generateHtml();
                    });
                });
            })
        }
    }

    //? Get posts end -----------------------------------------------------------------------------------------------
    //? Load more posts on scroll start -------------------------------------------------------------------------------------------
    var updateInput = function () {
        //Scroll
        input.scrollY.current = document.documentElement.scrollTop;
        input.scrollY.fraction = (input.scrollY.current - input.scrollY.start) / input.scrollY.inputRange;
    }

    var handleScrolling = function () {
        updateInput();
        //console.log(input.scrollY.current);
        if (input.scrollY.fraction == 1) {
            console.log('More posts');
            getPosts();
        }
    }

    //? Load more post on scroll end -------------------------------------------------------------------------------------------
    //? add new post hover start -----------------------------------------------------------------------------------------------
    let slidePostEvent = function () {
        const addNewPostBtn = $("#addPost");
        const slidePost = document.querySelector(".slidePost");
        const navigationRight = document.querySelector(".navigation-right");
        const slidePostSlidedIn = $('#slidePost1');
        const tl = new TimelineMax({ paused: true, reversed: true });

        tl.to(slidePost, .5, { right: "100px" })
            .to( navigationRight, .5, {'border-top-left-radius': '0px'}, '-=.5' );

        addNewPostBtn.hover(function () {
            tl.reversed() ? tl.play() : '';
        })
        slidePostSlidedIn.mouseleave(function(){
            tl.reversed() ? '' : tl.reverse();
        })
    }
    //? add new post hover start -----------------------------------------------------------------------------------------------

    animation();
    slideEvent();
    slidePostEvent();
    setTimeout(function () {
        getPosts();
    }, 1000);
    window.addEventListener('scroll', handleScrolling);
    btnSearch.click(onBtnnSearch);
    txtSearch.on('input', onBtnnSearch);
})
$(document).ready(function () {

})