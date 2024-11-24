(function ($) {
    "use strict";

    // Spinner
    var spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner();
    
    
    // Initiate the wowjs
    new WOW().init();
    
    
    // Dropdown on mouse hover
    const $dropdown = $(".dropdown");
    const $dropdownToggle = $(".dropdown-toggle");
    const $dropdownMenu = $(".dropdown-menu");
    const showClass = "show";
    
    $(window).on("load resize", function() {
        if (this.matchMedia("(min-width: 992px)").matches) {
            $dropdown.hover(
            function() {
                const $this = $(this);
                $this.addClass(showClass);
                $this.find($dropdownToggle).attr("aria-expanded", "true");
                $this.find($dropdownMenu).addClass(showClass);
            },
            function() {
                const $this = $(this);
                $this.removeClass(showClass);
                $this.find($dropdownToggle).attr("aria-expanded", "false");
                $this.find($dropdownMenu).removeClass(showClass);
            }
            );
        } else {
            $dropdown.off("mouseenter mouseleave");
        }
    });
    
    
    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });


    // Facts counter
    $('[data-toggle="counter-up"]').counterUp({
        delay: 10,
        time: 2000
    });


    // Modal Video
    $(document).ready(function () {
        var $videoSrc;
        $('.btn-play').click(function () {
            $videoSrc = $(this).data("src");
        });
        console.log($videoSrc);

        $('#videoModal').on('shown.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc + "?autoplay=1&amp;modestbranding=1&amp;showinfo=0");
        })

        $('#videoModal').on('hide.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc);
        })
    });


    // Testimonials carousel
    $(".testimonial-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1000,
        margin: 25,
        dots: false,
        loop: true,
        nav : true,
        navText : [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsive: {
            0:{
                items:1
            },
            768:{
                items:2
            }
        }
    });
    
})(jQuery);
$(function () {
    $('#checkoutDate').datetimepicker({
        format: 'YYYY-MM-DD', // Định dạng ngày mong muốn khi lưu vào database
        icons: { time: 'd-none' }, // Ẩn biểu tượng đồng hồ để chỉ chọn ngày
        pickTime: false // Không cho phép chọn giờ
    });
});
$(function () {
    $('#checkinDate').datetimepicker({
        format: 'YYYY-MM-DD', // Định dạng ngày mong muốn khi lưu vào database
        icons: { time: 'd-none' }, // Ẩn biểu tượng đồng hồ để chỉ chọn ngày
        pickTime: false // Không cho phép chọn giờ
    });
});
$(document).ready(function () {
    $('#checkinDate input').datetimepicker({
        format: 'YYYY-MM-DD',
        useCurrent: false
    });

    $('#checkoutDate input').datetimepicker({
        format: 'YYYY-MM-DD',
        useCurrent: false
    });
});
// dateValidation.js

function validateDates() {
    // Lấy giá trị ngày từ các trường input
    const checkinDate = document.getElementById("checkinDate").value;
    const checkoutDate = document.getElementById("checkoutDate").value;



    // Chuyển đổi chuỗi ngày thành đối tượng Date
    const inDate = new Date(checkinDate);
    const outDate = new Date(checkoutDate);

    // Kiểm tra nếu ngày check-out lớn hơn ngày check-in
    if (outDate <= inDate) {
        alert("Ngày check-out phải lớn hơn ngày check-in.");
        return false; // Ngăn chặn gửi biểu mẫu
    }

    return true; // Cho phép gửi biểu mẫu nếu ngày hợp lệ
}
//start check full name empty
let isFullnameEmpty = false; 
function checFullnameEmpty()
{
	    const fname = document.getElementById("fname").value;
		const errorFname = document.getElementById("error-fname");
		if (fname==="")
			{
				isFullnameEmpty=true;
				errorFname.style.display="block";
				errorFname.innerHTML=`<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Vui lòng nhập họ và tên`
			}
			else {	
				  isFullnameEmpty=false;
			                    errorFname.style.display = "none";
			     }
}
document.getElementById("fname").addEventListener("blur", checFullnameEmpty);
//end
//start check confirm password sạme
let iscpass = false; 
function checkPasswordConfirm()
{
	    const pword = document.getElementById("pword").value;
	    const cpword = document.getElementById("cpword").value;
		const errorcpword = document.getElementById("error-cpword");
		if (pword !== cpword)
			{
			
				iscpass=true;
				errorcpword.style.display="block";
				errorcpword.innerHTML=`<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Mật khẩu không trùng khớp`
			}
			else {
						
							    iscpass=false;
			                    errorcpword.style.display = "none";
			     }
}
document.getElementById("cpword").addEventListener("blur", checkPasswordConfirm);
//end check same pass

//start check password lenght
let ispassLenght = false; 
function checkPasswordLenght()
{
		
	    const pword = document.getElementById("pword").value;
		const errorPword = document.getElementById("error-pword");
		if (pword.length < 6 || pword.length > 16)
			{
				
				ispassLenght=true;
				errorPword.style.display="block";
				errorPword.innerHTML=`<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Mật khẩu phải đủ 6 ký tự trở lên và nhỏ hơn 16 ký tự`
			}
			else {
						
							   ispassLenght=false;
			                    errorPword.style.display = "none";
			     }
}
document.getElementById("pword").addEventListener("blur", checkPasswordLenght);
//end
//start check email valid
let isEmailValid = false; 
function checkEmailValid()
{
		
	    const email = document.getElementById("emailvali").value;
		const errorEmail = document.getElementById("error-email");
		const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		if (!emailRegex.test(email))
			{
				
				isEmailValid=true;
				errorEmail.style.display="block";
				errorEmail.innerHTML=`<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Vui lòng nhập email hợp lệ`
			}
			else {
						
							   isEmailValid=false;
			                    errorEmail.style.display = "none";
			     }
}
document.getElementById("emailvali").addEventListener("blur", checkEmailValid);
//end
//start check sdt valid
let isPhoneValid = false; 
function checkPhoneValid()
{
		
	    const phone= document.getElementById("phonevali").value;
		const errorphone = document.getElementById("error-phone");
		const phoneRegex = /^\d{10}$/;
		if (!phoneRegex.test(phone))
			{
				
				isPhoneValid=true;
				errorphone.style.display="block";
				errorphone.innerHTML=`<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Vui lòng nhập số điện thoại hợp lệ`
			}
			else {
						
							   isPhoneValid=false;
			                    errorphone.style.display = "none";
			     }
}
document.getElementById("phonevali").addEventListener("blur", checkPhoneValid);
//end
let isUsernameTaken = false; //  kiểm tra username ton tai chua
function checkUsername() {
    const uname = document.getElementById("uname").value;
    const errorUnameElement = document.getElementById("error-uname");

    if (uname) {
        fetch(`/rest/accounts/check-username?username=${encodeURIComponent(uname)}`)
            .then(response => response.json())
            .then(isTaken => {
                isUsernameTaken = isTaken; // Cập nhật cờ

                if (isTaken) {
                    errorUnameElement.innerHTML = `<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Username đã tồn tại`;
                    errorUnameElement.style.display = "block";
                } else {
                    errorUnameElement.style.display = "none";
                }
            })
            .catch(error => {
                console.error("Error checking username:", error);
            });
    }
}

// Gọi hàm checkUsername khi blur khỏi ô username
document.getElementById("uname").addEventListener("blur", checkUsername);
function validateRegisterForm(){
	let isValid = true;
	const fname = document.getElementById("fname").value;
	const errorFname = document.getElementById("error-fname");
	const uname = document.getElementById("uname").value;
	const errorUname = document.getElementById("error-uname");
	const pword = document.getElementById("pword").value;
	const errorPword = document.getElementById("error-pword");
	const cpword = document.getElementById("cpword").value;
	const errorcpword = document.getElementById("error-cpword");
	const email = document.getElementById("emailvali").value;
	const errorEmail = document.getElementById("error-email");
	const phone= document.getElementById("phonevali").value;
	const errorphone = document.getElementById("error-phone");
				if(isFullnameEmpty)
					{
						return false;
					}
					if (fname === "" )
								   		{
								   					errorFname.style.display="block";
								   					errorFname.innerHTML=`<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Vui lòng nhập họ và tên`
								   					isValid=false;
								   		}
			   // username khong dc bo trog 
			        if (uname === "" )
			   		{
			   					errorUname.style.display="block";
			   					errorUname.innerHTML=`<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Vui lòng nhập username`
			   					isValid=false;
			   		}
					if (isUsernameTaken) {
					       
					       isValid=false;
					 }
					 if (ispassLenght)
						{
							isValid=false;
						}
						
					 if(pword==="")
						{
							errorPword.style.display="block";
							errorPword.innerHTML=`<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Vui lòng nhập mật khẩu`
							isValid=false;
						}
						if(cpword ==="")
							{
									errorcpword.style.display="block";
									errorcpword.innerHTML=`<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Vui lòng xác nhận mật khẩu`
									isValid=false;
							}
						if(iscpass)
							{
								isValid=false;
							}
						if (email==="")
							{
								errorEmail.style.display="block";
								errorEmail.innerHTML=`<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Vui lòng nhập Email `
							    isValid=false;
							}
						if(phone==="")
							{
								errorphone.style.display="block";
								errorphone.innerHTML=`<span><svg aria-hidden="true" class="Qk3oof xTjuxe" fill="currentColor" focusable="false" width="16px" height="16px" viewBox="0 0 24 24" xmlns="https://www.w3.org/2000/svg"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-2h2v2zm0-4h-2V7h2v6z"></path></svg></span> Vui lòng nhập số điện thoại `
								isValid=false;
							}	
							if(isPhoneValid)
							{
								isValid=false;
						    }
							if(isEmailValid)
							{
							     isValid=false;
							}
													
						
	return isValid;
	
}

