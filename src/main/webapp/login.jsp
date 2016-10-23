
<% String title = "Login here"; %>
<%@include file="WEB-INF/Header.jsp"%>

<div class="container">
	<div class="well">
		<form action="login" method="post" name="myForm" id="form-signin">
			<h2 id="form-signin-heading">Login here</h2>
			<div class="form-group">
				<input class="form-control" id="userName" name="userName"
					value="${user.userName }" type="text" class="input-block-level"
					placeholder="username...">
			</div>

			<div class="form-group">
				<input class="form-control" id="password" name="password"
					value="${user.password }" type="password" class="input-block-level"
					placeholder="password..."> <label> <font id="error"
					color="red">${error }</font>
				</label>
			</div>

			<button class="btn btn-large btn-primary" type="submit">Login</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="btn btn-large btn-primary" type="button">Reset</button>
		</form>
	</div>

</div>

<%@include file="WEB-INF/Footer.jsp"%>