<%
	String title = "Project Details";
%>
<%@include file="Header.jsp"%>

<div class="container">
	<div class="row">
		<h1 class="col-sm-8 col-sm-offset-2"></h1>
	</div>
		<form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
			<div class="well">
				<fieldset>
					<legend>Expense Claim System</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Project Name </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="Expense Claim System">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Project Code : </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="123">
							</div>
						</div>
					</fieldset>
				</div>
				<div class="form-group">
					<div class="col-sm-6">
						<a class="btn btn-primary form-control" href="add_trip.jsp" role="button">Add Trip</a>
					</div>
					<div class="col-sm-6">
						<a class="btn btn-primary form-control" href="employee_form.jsp" role="button">Add Expense Claim</a>
					</div>
				</div>
			</form>
			<form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
				<div class="well">
					<fieldset>
						<legend>Trips Planned</legend>
						<div class="table-responsive">
   							<table class="table table-hover table-striped table-condensed">
								<thead>
	  								<tr>
	    								<th>Employee Name</th> <th>Trip To</th> <th>Dates</th>
	  								</tr>
								</thead>
								<tbody>
	    							<tr>
	    								<td>Sam</td><td>New York city</td><td>9/27-10/3</td>
	    							</tr>
								</tbody>
							</table>
						</div>
					</fieldset>
				</div>
			</form>
</div>

<%@include file="Footer.jsp"%>