var notfblogin = $('.notfblogin');
var notapplogin = $('.notapplogin');
var fbapplogin = $('.fbapplogin');

var userfbappid = "";
var username = "";
var profileimg = "img/silhouette.png";

function setFBLogin(_fblogin, _applogin) {
	setFBProfile(function() {
		setProfileImg(function() {
			setContentForm(fblogin, applogin);
		});
	});
}

function setFBProfile(callback){
	FB.api('/me', function(response) {
		userfbappid = response.id;
		username = response.name;
		callback();
	});
}

function setProfileImg(callback){
	if (userfbappid && userfbappid.length > 0) {
		// get user profile picture
		FB.api("/" + userfbappid + "/picture?width=9999&height=9999", function(response) {
			if (response && !response.error) {
				/* handle the result */
				profileimg = response.data.url;
				$('.fbprofileimg').attr('src', profileimg);				
			}
		});
	}
	callback();
}

function setContentForm() {
	console.log(fblogin);
	console.log(applogin)
	console.log(userfbappid);
	console.log(username);
	console.log(profileimg);
	
	if (!fblogin) {
		notfblogin.show();
	}else if (!applogin){
		notapplogin.show();
	}
	if (fblogin && applogin) {
		checkUserComments(
			function(){			
				$('.greeting').text("Hello " + username);
				$('input:text[name=fullname]').val(username);
				$('input[name=userfbappid]').val(userfbappid);
				if (userfbappid.length > 0) {
					fbapplogin.show();
				}
			},
			function(){			
				console.log('option2');
			}
		);
	}
}

function checkUserComments(cbOptionSendComment, cbOptionWelcome) {
	if (userfbappid && userfbappid.length > 0) {
		$.ajax({
			method : "POST",
			url : "FetchUserComments",
			data : {
				"userfbappid" : userfbappid
			}
		}).done(function(reply) {
			console.log('reply, ', reply);
			if (reply && reply.fullname)
				cbOptionWelcome();
			else
				cbOptionSendComment();
		});
	} else {
		cbOptionSendComment();
	}
}

function loginFB(){
	FB.login(function(response){
		if (response.status === 'connected') // status login and accepted
			location.reload();
	});
}

$(function(){
	syncFBAccount(function(){
		setFBLogin();
	});
	
	$('.btnjoinlogin, .btnfblogin').on('click', function(){
		loginFB();
	});
});