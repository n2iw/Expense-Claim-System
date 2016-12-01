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
					<div class="col-sm-offset-6 col-sm-2">
					   <% if (project.getProjectId() != 0) { %>
					    	<a class="btn btn-primary form-control" href="/trip/new?projectId=<%= project.getProjectId() %> " role="button">Add Trip</a>
					   <% } %>
					</div>
					<div class="col-sm-2">
					   <% if (project.getProjectId() != 0) { %>
					   <button type="button" class="btn btn-danger form-control" id="delete_confirmation">Delete</button>
							<!--a class="btn btn-danger form-control" href="/project/<%= project.getProjectId() %>/delete" role="button">Delete</a>-->
							<div class="modal fade" id="secondModal" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h4 class="modal-title" id="myModalLabel">Alert</h4>
												</div>
												<div class="modal-body" id="imagecontainer">
													<p>Are you sure that you want to delete this project?</p>
												</div>
												<div class="modal-footer">
												<a class="btn btn-danger" href="/project/<%= project.getProjectId() %>/delete" role="button">Delete</a>
						
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Cancel</button>
											</div>
											</div>
										</div>
									</div>
					   <% } %>
					</div>
					<div class="col-sm-2">
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
<script src="/js/project_details.js"></script>

<%@include file="Footer.jsp"%>
