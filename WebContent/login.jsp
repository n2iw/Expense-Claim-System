<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login here</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<style type="text/css">
	  body {
        padding-top: 200px;
        padding-bottom: 40px;
        /*background-image: url('images/bg3.jpg');*/
      }
      
      .form-signin-heading{
      	text-align: center;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 0px;
        margin: 0 auto 20px;
        background-color: #eed;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

</style>
</head>
<body>
<div class="container">
<form action="login" method="post" name="myForm" class="form-signin">
 <h2 class="form-signin-heading">Login here</h2>
 <input id="userName" name="userName" value="${user.userName }"  type="text" class="input-block-level" placeholder="username...">
        <input id="password" name="password" value="${user.password }"   type="password" class="input-block-level" placeholder="password..." >
<label>
         <font id="error" color="red">${error }</font>  
        </label>
 <button class="btn btn-large btn-primary" type="submit">Login</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-large btn-primary" type="button" >Reset</button>
  </form>
</div>

</body>
</html>