

<%@include file="Header.jsp"%>

<div class="container">
	<div class="row well">
	<div class="col-sm-12">
		<form action="login" method="post" name="myForm" id="form-signin">
			<h2 id="form-signin-heading" align="center">Login</h2>
			<br>
			<%if(!"string".isEmpty()){ %>
			<p></p>
			<%} %>
			<div class="form-group">
		 	  <input class="form-control" id="userName" name="userName" value="${user.userName }"
				type="text" class="input-block-level" placeholder="username...">
			</div>
			
			<div class="form-group">
			<input class="form-control" id="password" name="password" value="${user.password }"
				type="password" class="input-block-level" placeholder="password...">
			<label> <font id="error" color="red">${error }</font>
			</label>
			</div>
			
			<button class="btn btn-large btn-primary" type="submit">Login</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="btn btn-large btn-primary" type="button">Reset</button>
		</form>
	</div>
	</div>

</div>

<%@include file="Footer.jsp"%>