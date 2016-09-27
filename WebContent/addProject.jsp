<% String title = "Add Project"; %>
<%@include file="WEB-INF/Header.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="row">
				<h4 class="col-sm-8 center-block">Welcome Mike</h4>
			</div>
			<form class="form-horizontal" action="/ExpenseClaimSystem/manager.jsp"
				enctype="multipart/form-data">
				<div class="well">
					<fieldset>
						<legend>Add Project</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Project Name: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Project Code: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control">
							</div>
						</div>
					</fieldset>
				</div>
				<div class="form-group">
					<div class="col-sm-6 col-sm-offset-6">
						<input class="btn btn-primary form-control" type="submit"
							value="Save">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<%@include file="WEB-INF/Footer.jsp" %>