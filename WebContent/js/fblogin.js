function setFBLogin(_fblogin, _applogin){
	var notfblogin = $('.notfblogin');
	var notapplogin = $('.notapplogin');
	var fbapplogin = $('.fbapplogin');
	var userfbappid = "";
	
	
	fblogin = _fblogin;
	applogin = _applogin;
	
	if (!fblogin) {
		notfblogin.show();
	}else if (!applogin){
		notapplogin.show();
	}
	if (fblogin && applogin) {
		FB.api('/me', function(response) {
			userfbappid = response.id;
			$('.greeting').text("Hello " + response.name);
			$('input:text[name=fullname]').val(response.name);
			$('input[name=userfbappid]').val(userfbappid);
			if (userfbappid.length > 0) {
				// get user profile picture
				FB.api("/" + userfbappid + "/picture?width=9999&height=9999", function(response) {
					if (response && !response.error) {
						/* handle the result */
						$('.fbprofileimg').attr('src', response.data.url);
						fbapplogin.show();
					}else{
						fbapplogin.show();
					}
				});
			}else{
				fbapplogin.show();
			}
		});
	}
}

function hasCommentSent(){
	if (userfbappid.length > 0) {
		
		
	}else{
		return 0;
	}
}

function loginFB(){
	FB.login(function(response){
		if (response.status === 'connected') // status login and accepted
			location.reload();
	});
}

$(function(){
	$('.btnjoinlogin, .btnfblogin').on('click', function(){
		loginFB();
	});
});