<%@include file="includes/header.jsp"%>
	<div class="page">
		<div class="content">
			<h1>Welcome</h1>			
			<div class="defaulthidden notfblogin">
				<button class="button login btnfblogin">Please login to your Facebook account and join in our Facebook page.</button>
				<!-- <fb:login-button scope="public_profile,email"></fb:login-button> -->
			</div>
			<div class="defaulthidden notapplogin">
				<button class="button login btnjoinlogin">Please join to our Facebook page app here.</button>
			</div>
			<div class="defaulthidden fbapplogin">								
				<img class="fbprofileimg" id="fbprofile" src="img/silhouette.png" />
				<p class="greeting">Hello</p>
				<p>Please fill-in the following to send your feedback.</p>
				<form id="commentform" action="InsertUserComments" method="post">
					<p>Name: <input type="text" name="fullname"/></p>
					<input type="hidden" name="userfbappid" value=""/>
					<p>Comments: </p>
					<textarea cols="40" rows="10" name="usercomments" form="commentform">Enter text here...</textarea><br/>
					<input type="submit"/>
				</form>
			</div>
			<div id="status"></div>
		</div>
	</div>
<%@include file="includes/scripts.jsp"%>
<%@include file="includes/fbscripts.jsp"%>
<%@include file="includes/footer.jsp"%>