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
		<form class="form-horizontal" action="/project" method="post">
			<div class="well">
				<fieldset>
					<legend>Project</legend>
						<div class="form-group">
						    <input type="hidden" name="projectId" value="<%= project.getProjectId() %>">
							<label class="control-label col-sm-2">Name</label>
							<div class="col-sm-10">
								<input name="name" type="text" class="form-control" value="<%= project.getProjectName() %>">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Budget</label>
							<div class="col-sm-10">
								<input name="budget" type="text" class="form-control" value="<%= project.getBudget() %>">
							</div>
						</div>
					</fieldset>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-3">
						<a class="btn btn-primary form-control" href="/trip/new?projectId=<%= project.getProjectId() %>" role="button">Add Trip</a>
					</div>
					<div class="col-sm-3">
						<a class="btn btn-danger form-control" href="/project/<%= project.getProjectId() %>/delete" role="button">Delete</a>
					</div>
					<div class="col-sm-3">
						<input type="submit" class="btn btn-primary form-control" value="Save">
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
	    								 <th>Description</th> <th>Employee Name</th> <th>Dates</th>
	  								</tr>
								</thead>
								<% for (Trips trip: trips) {
									List<Employee> employees = trip.getAllEmployeeOfThisTrip();
									Employee e = new Employee();
									    if (employees.size() > 0) {
									        e = employees.get(0);
									    }
									%>
								 
									<tbody>
										<tr>
											<td><a href="/trip/<%= trip.getTripId() %>"><%= trip.getDescription() %></a></td><td><%= e.getFirstName() %></td><td>From: <%= trip.DateToString(trip.getStartDate()) %> to <%= trip.DateToString(trip.getEndDate()) %></td>
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
