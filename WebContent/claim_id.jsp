<% String title = "Expenses for \"New York city\""; %>
<%@include file="WEB-INF/Header.jsp" %>

		<div class="container">
			<div class="row">
				<h1 class="col-sm-8 col-sm-offset-2">Expenses for "New York city"</h1>
			</div>
			<form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
				<div class="well">
					<fieldset>
						<legend>Expense Claim Details</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Project Code: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="123">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Job Code: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="456">
							</div>
						</div>
					</fieldset>
				</div>
				 	<div class="form-group">
						<div class="col-sm-6">
								<input class="btn btn-primary form-control" type="submit" value="Save">
						</div>
						<div class="col-sm-6">
								<a href="submit.jsp" class="btn btn-danger form-control">Submit</a>
						</div>
					</div>
			</form>
		</div>

<%@include file="WEB-INF/Footer.jsp" %>