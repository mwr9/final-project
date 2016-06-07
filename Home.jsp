<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="TopBanner.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Seven</title>

<link rel="stylesheet" type="text/css" href="SiteDefault.css" />

<link rel="stylesheet" href="jquery-ui-smoothness.css" />
<script src="jquery.min.js" ></script>
<script src="jquery-ui.min.js" ></script>

<!-- FadeIN/OUT for signupDiv is moving the position of the background image?????????? -->

<!-- TODO mouseover pointers change as appropriate -->
<!-- TODO smooth transiiton between form and menu -->
<!-- Standard font over text and submit buttons and text fields -->
<!-- AJAX to check username availability -->
<!-- Add Captcha -->
<!-- Form error handling -->



<!-- STYLE just for this page -->
<style>
	.bannerTitle {
		visibility: hidden;
	}
</style>

<script>

function showForm(elemName) {
    $('#mainBody').fadeOut(1000);
    //Coundn't get passing in variable i.e. elemName to work correctly 
    //so had to check value and fade the appropriate div
    if(elemName == "signUpFormDiv"){
    	$('#signUpFormDiv').fadeIn(500);
    } else {
    	$('#signInFormDiv').fadeIn(500);
    }  
}
function hideDiv(elemName){
	$('#mainBody').fadeIn(1000);
    if(elemName == "signUpFormDiv"){
    	$('#signUpFormDiv').fadeOut(500);
    } else {
    	$('#signInFormDiv').fadeOut(500);
    }  
}

function validateField(elemName){
	var thisElem = document.getElementById(elemName);
	if(thisElem.type == "text" ){
		alert();
	}
	thisElem.style.border = "solid red 1px";
	document.getElementById('errorsDiv').innerHTML = "ERROR";
}
function validateForm(){
	
}

function validateTextField(element){
	var text = element.value;
	if(text.matches("^[A-z0-9]+$")){
		element.className += "valid";
		alert(element.value);
	} else {
		element.className -= "valid";
		element.className += "invalid";
	}
}

</script>
</head>
<body>


<div id="mainBody" class="transparent">
	<h1 class="mainHeading">The Seven</h1>
	<p id="descriptionText">This is information. about loads of things and how wonderful this blog is and everyone who will use it</p>
	<div id="signUpButton" onclick="showForm('signUpFormDiv')">Join Us</div>
	<div id="signInButton" onclick="showForm('signInFormDiv')">Sign In</div>
</div>

<div id="signUpFormDiv" class="transparent">
	<h1 class="mainHeading">The Seven</h1>
	<p class="exitButton" onclick="hideDiv('signUpFormDiv')">  &#x2716;</p>
	
		<form name="signUpForm" id="regForm" method="post" action="">
		<p>
			<!-- AJAX to check availability -->
			<input type="text" 
			name="username" 
			id="username" 
			required="required" 
			size="15" max="15"
			placeholder="Username" />
		</p>
		<p>
			<input type="text" 
			name="firstName" 
			id="firstNameId" 
			required="required" 
			size="15" max="15"
			placeholder="First Name" 
			onchange="validateTextField(this)"
			onblur="validateTextField(this)" /> 
			<input type="text" 
			name="lastName" 
			id="lastNameId"
			required 
			size="15" max="15"  
			placeholder="Last Name" />
		</p>
		<p>
			<!-- Check email is valid -->
			<input type="email" 
			name="email" 
			id="email" 
			required="required" 
			size="30" 
			placeholder="Email address" />
		</p>
		<p>
			<!-- Check confirm email is the same -->
			<input type="email" 
			id="emailConfirmId" 
			required="required" 
			size="30" 
			placeholder="Confirm email address" />
		</p>
		<p>
			<!-- Check password is valid - longer than 8 characters, 1 number, 1 capital, 1 lowercase -->
			<input type="password" 
			name="password" 
			id="password" 
			required="required" 
			size="15" 
			placeholder="Password" />
		</p>
		<p>
			<!-- Check confirm password is the same -->
			<input type="password" 
			id="passwordConfirmId" 
			required="required" 
			size="15" 
			placeholder="Confirm password" />
		</p>
		<div id="errorsDiv"></div>
		<p>
			<input type="submit" 
			name="submitButton" 
			id="submitId" 
			value="Sign Up"  />
		</p>
		</form>

</div>
<div id="signInFormDiv" class="transparent">
	<h1 class="mainHeading">The Seven</h1>
	<p class="exitButton" onclick="hideDiv('signInFormDiv')">  &#x2716;</p>
	<br/><br/>
	<form name="signInForm" id="signInForm" action="">
	<p>
		<input type="text" size="15" max="15" onchange="validateField('usernameId')"
				name="username" id="usernameId" placeholder="Username" />
	</p>
	<p>
		<input type="password" name="password" id="passwordId" 
				size="15" placeholder="Password" />
	</p>
	<br/>
	<div id="errorsDiv"></div>
	<p>
		<input type="submit" name="submitButton" id="submitId" value="Sign In" />
	</p>
	</form>
	
</div>

</body>
</html>