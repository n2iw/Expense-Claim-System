<%@ page import="edu.ualbany.icis518.team6.Projects"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="edu.ualbany.icis518.team6.Employee"%>
<%@ page import="edu.ualbany.icis518.team6.Trips"%>
<%
	String title = "Project Details";
%>
<%@include file="Header.jsp"%>

<% Projects project = (Projects)request.getAttribute("project");
   List<Trips> trips = Trips.getbyProject(project);
%>

<div class="container">
<div class="row">
<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
	<div class="row">
		<div class="col-sm-12">
		<form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
			<div class="well">
				<fieldset>
					<legend>Expense Claim System</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Project Name </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="<%= project.getProjectName() %>">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Project Code : </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="<%= project.getProjectId() %>">
							</div>
						</div>
					</fieldset>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-9 col-sm-3">
						<a class="btn btn-primary form-control" href="/manager/trip/new" role="button">Add Trip</a>
					</div>
					
				</div>
			</form>
			</div>
			</div>
			<div class="row">
			<div class="col-sm-12">
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
								<% for (Trips trip: trips) {
									Employee e = trip.getAllEmployeeOfThisTrip().get(0);
									%>
								 
									<tbody>
										<tr>
											<td><%= e.getFirstName() %></td><td><%= trip.getDescription() %></td><td>From: <%= trip.DateToString(trip.getStartDate()) %> to <%= trip.DateToString(trip.getEndDate()) %></td>
										</tr>
									</tbody>
								<% } %>
							</table>
						</div>
					</fieldset>
				</div>
			</form>
			</div>
			</div>
</div>
</div>
</div>

<%@include file="Footer.jsp"%>