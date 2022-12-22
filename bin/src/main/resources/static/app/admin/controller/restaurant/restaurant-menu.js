app.controller("restaurantMenuCtrl", function($scope, $http, $document){
	
	$document.ready(function(){
			
      var swiper = new Swiper(".mySwiper-1", {
		loop:true,
		dots:true,
       
        pagination: {
          el: ".swiper-pagination-banner",
        },
        mousewheel: true,
        keyboard: true,
      });

	  var swiper = new Swiper(".mySwiper-2", {
        slidesPerView: 7,
        spaceBetween: 30,
		loop:true,
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
		breakpoints: {
          360: {
            slidesPerView: 2,
            spaceBetween: 20,
          },
		  600: {
            slidesPerView: 3,
            spaceBetween: 20,
          },
		  768: {
            slidesPerView: 4,
            spaceBetween: 20,
          },
          1024: {
            slidesPerView: 5,
            spaceBetween: 20,
          },
		  1200: {
            slidesPerView: 6,
            spaceBetween: 20,
          },
		  1480: {
            slidesPerView: 6,
            spaceBetween: 20,
          },
		  1600: {
            slidesPerView: 6,
            spaceBetween: 20,
          },
		  1920: {
            slidesPerView: 6,
            spaceBetween: 10,
          },
          
        },
		
      });
	  
	  var swiper = new Swiper(".mySwiper-3", {
        slidesPerView: 3,
        spaceBetween: 20,
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
		breakpoints: {
          360: {
            slidesPerView: 1,
            spaceBetween: 20,
          },
		  600: {
            slidesPerView: 1,
            spaceBetween: 20,
          },
		  768: {
            slidesPerView: 2,
            spaceBetween: 20,
          },
          1024: {
            slidesPerView: 2,
            spaceBetween: 20,
          },
		  1200: {
            slidesPerView: 2,
            spaceBetween: 20,
			},
		1480: {
            slidesPerView: 3,
            spaceBetween: 20,
          },
		1600: {
			slidesPerView: 3,
			spaceBetween: 20,
          },
		  1920: {
            slidesPerView: 3,
            spaceBetween: 20,
          },
          
        },
      });
	  
      var swiper = new Swiper(".mySwiper-6", {
        slidesPerView: 5,
        spaceBetween: 30,
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
		breakpoints: {
          360: {
            slidesPerView: 1,
            spaceBetween: 20,
          },
		  600: {
            slidesPerView: 2,
            spaceBetween: 20,
          },
          1024: {
            slidesPerView: 3,
            spaceBetween: 20,
          },
		 1480: {
            slidesPerView: 5,
            spaceBetween: 20,
          },

		  1600: {
            slidesPerView: 5,
            spaceBetween: 20,
          },
		  1920: {
            slidesPerView: 5,
            spaceBetween: 20,
          },
          
        },
      });
	  var swiper = new Swiper(".mySwiper-5", {
        slidesPerView: 3,
        spaceBetween: 30,
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
		breakpoints: {
          360: {
            slidesPerView: 1,
            spaceBetween: 20,
          },
		  768: {
            slidesPerView: 3,
            spaceBetween: 20,
          },
		  768: {
            slidesPerView: 2,
            spaceBetween: 20,
          },
          1024: {
            slidesPerView: 2,
            spaceBetween: 20,
          },
		  1200: {
            slidesPerView: 2,
            spaceBetween: 20,
          },
		  1480: {
            slidesPerView: 3,
            spaceBetween: 20,
          },
		  1600: {
            slidesPerView: 3,
            spaceBetween: 20,
          },
		  1920: {
            slidesPerView: 3,
            spaceBetween: 20,
          },
          
        },
      });
    

    })
	
})