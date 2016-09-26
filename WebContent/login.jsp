<% String title = "Login here"; %>
<%@include file="WEB-INF/Header.jsp" %>

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

<%@include file="WEB-INF/Footer.jsp" %>