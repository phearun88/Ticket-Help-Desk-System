$(document).ready(function(){
	sessionStorage.removeItem('USER');
	sessionStorage.removeItem('ACT');
	$(".btn_login").click(function(){
		sessionStorage.setItem('USER', $("#username").val());
		sessionStorage.setItem('ACT', "1");
	});
});




