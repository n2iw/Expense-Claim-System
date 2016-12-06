<%@ page import="edu.ualbany.icis518.team6.Projects"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="edu.ualbany.icis518.team6.Employee"%>
<%@ page import="edu.ualbany.icis518.team6.Trips"%>
<%
	String title = "Project Details";
%>
<%@include file="Header.jsp"%>
<link rel="stylesheet" href="/css/form_error_style.css">

<% Projects project = (Projects)request.getAttribute("project");
   List<Trips> trips = Trips.getbyProject(project);
   List<Employee> emps = (List<Employee>) request.getAttribute("emps");
   List<Integer> currentEmpIds = (List<Integer>) request.getAttribute("currentEmpIds");
   String error = (String)request.getAttribute("error");
   if (error == null) {
       error = "";
   }
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
					   <div class = "form-group" id="form-error">
                            <div class="col-sm-10 col-sm-offset-2"><%= error %></div>
                        </div>	
						<div class="form-group">
							<label class="control-label col-sm-2">Budget</label>
							<div class="col-sm-10">
								<input name="budget" type="text" class="form-control" value="<%= project.getBudget() %>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Employees</label>
							<div class="col-sm-10">
								<select name="employeeIds" class="form-control" multiple size="10" width="100%">
								<% for (Employee e : emps) { %>
								<option value="<%= e.getEmployeeId() %>" <%= currentEmpIds.contains(e.getEmployeeId()) ? "selected" : "" %>><%= e.getLastName() + ", " + e.getFirstName() %></option>
								<% } %>
								</select>
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
									List<String> names = new ArrayList<>();
									for (Employee e: employees) {
										names.add(e.getFirstName() + " " + e.getLastName());
									}
									%>
								 
									<tbody>
										<tr>
											<td><a href="/trip/<%= trip.getTripId() %>"><%= trip.getDescription() %></a></td>
											<td>
											<%= String.join(", ", names) %>
											</td>
											<td>From: <%= trip.DateToString(trip.getStartDate()) %> to <%= trip.DateToString(trip.getEndDate()) %></td>
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
