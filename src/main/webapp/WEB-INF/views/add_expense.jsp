<%@ page import="edu.ualbany.icis518.team6.Projects"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="edu.ualbany.icis518.team6.Trips"%>

<%@include file="Header.jsp"%>

<% Projects project = (Projects)request.getAttribute("project"); 
   Trips trip = (Trips)request.getAttribute("trip");
%>

<div class="container">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
			<div class="row">
				<h4 class="col-sm-offset-2 col-sm-8 col-sm-offset-2" align="center">Expenses for "<%= trip.getDescription() %>"</h4>
			</div>
			<div class="row">
			<form class="form-horizontal" action="#" method="post"
				enctype="multipart/form-data">
				<div class="well">
					<fieldset>
						<legend>Project Information</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Project Name: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="<%= project.getProjectName() %>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Project Code: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="<%= project.getProjectId() %>">
							</div>
						</div>
					</fieldset>
				</div>
				</form>
				</div>
			<form class="form-horizontal" action="#" method="post"
				enctype="multipart/form-data">
				<div class="well">
					<fieldset>
						<legend>Add New Expense</legend>
						<div class="form-group">
							<label class="control-label col-sm-2" for="type">Type:
							</label>
							<div class="col-sm-10">
								<select class="form-control" id="type" name="type">
									<option value="Food">Food</option>
									<option value="Travel">Travel</option>
									<option value="Hotel">Hotel</option>
									<option value="Misc">Misc</option>
								</select> 
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="food">Amount:
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="food" name="food"
									placeholder="$ Amount" >
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2">Upload Receipts: </label>
							<div class="col-sm-10">
								<input type="file" class="form-control" name="food_receipt"
									multiple>
							</div>
						</div>
					</fieldset>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-9 col-sm-3">
						<input class="btn btn-primary form-control" type="submit"
							value="Save">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<%@include file="Footer.jsp"%>
