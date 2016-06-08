<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="TopBanner.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Seven</title>

<link rel="stylesheet" type="text/css" href="SiteDefault.css" />
<link rel="stylesheet" href="jquery-ui-smoothness.css" />
<!--  link rather than script for portability -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"></script>
<script src="https://www.google.com/recaptcha/api.js"></script> <!--  script for recaptcha -->

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
    $('#mainBody').fadeOut(500);
    $('#' + elemName).fadeIn(500);    
}
function hideDiv(elemName){
	$('#mainBody').fadeIn(500);
	$('#' + elemName).fadeOut(500);  
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
	<p id="descriptionText">A blog for the seven intrepid code warriors to stay in touch, to exchange code, to help with projects and in general to support each other. </p>
	<div id="signUpButton" onclick="showForm('signUpFormDiv')">Join Us</div>
	<div id="signInButton" onclick="showForm('signInFormDiv')">Sign In</div>
</div>

<div id="signUpFormDiv" class="transparent">
	<h1 class="mainHeading">The Seven</h1>
	<p class="exitButton" onclick="hideDiv('signUpFormDiv')">  &#x2716;</p>
	<!--  Form calls the RegisterServlet on submit -->
		<form action="RegisterServlet" id="regForm" method="post" name="register">
		<p>
			<!-- AJAX to check availability -->
			<input type="text" 
			name="username" 
			id="username" 
			required="required" 
			size="15" max="15"
			placeholder="Username" onblur="checkUser()"/><span id="respond"></span><!--  Ajax call, response message in span element -->
		</p>
		<p>
			<input type="text" 
			name="firstname" 
			id="firstNameId" 
			required="required" 
			size="15" max="15"
			placeholder="First Name" 
			onchange="validateTextField(this)"
			onblur="validateTextField(this)" /> 
			
			<input type="text" 
			name="lastname" 
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
<!-- 		<p>
			Check confirm email is the same - do not need this
			<input type="email" 
			id="emailConfirmId" 
			required="required" 
			size="30" 
			placeholder="Confirm email address" />
		</p> -->
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
		<!--  Recaptcha feature -->
		<div class="g-recaptcha" data-sitekey="6LdMAgMTAAAAAGYY5PEQeW7b3L3tqACmUcU6alQf"> </div> 
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
	<form name="signInForm" id="signInForm" action="LoginServlet">
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
<script>
         function checkUser(){
					// AJAX call XMLHTTP
					var xmlhttp = new XMLHttpRequest();
					// picks up 'username' value entered in the 'register' form
              		var username = document.forms["register"]["username"].value;
            		var url = "CheckUser?username=" + username;
             		 xmlhttp.onreadystatechange = function(){
		             // readyState of 4 signifies request is complete
		             // status of 200 signifies sucessful HTTP call
		             if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
		                  if(xmlhttp.responseText == "False"){
		                   	// change color to indicate success or fail and responds on span elament
		                       document.getElementById("respond").style.color = "red";
		                       document.getElementById("respond").innerHTML = "Username already exists";
		                  }else{
		                        document.getElementById("respond").style.color = "white";
		                        document.getElementById("respond").innerHTML = "Username is valid";
		                  }  
		                      
		              }
              };
              
              try{
              // make an AJAX GET request to the URL asynchronously	
              xmlhttp.open("GET",url,true);
              xmlhttp.send();
          }catch(e){
        	  alert("unable to connect to server");
          }
          }
    
  </script>        
  

</body>
</html>