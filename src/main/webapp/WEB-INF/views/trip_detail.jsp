<%@ page import="edu.ualbany.icis518.team6.Trips"%>
<%@ page import="java.util.List"%>
<%@include file="Header.jsp"%>
<%
	Trips trip = (Trips) request.getAttribute("trip");
    List<Employee> emps = (List<Employee>) request.getAttribute("employees");
	List<Integer> currentEmpIds = (List<Integer>) request.getAttribute("currentEmpIds");
%>
<div class="container">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
			<div class="row">
				<form class="form-horizontal" action="/trip" method="post">
					<div class="well">
						<fieldset>
							<legend>Trip</legend>
							<div class="form-group">
								<label class="control-label col-sm-2">Description</label>
								<div class="col-sm-10">
									<input name="description" type="text" class="form-control"
										value="<%= trip.getDescription()%>">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">Employee ID </label>
								<div class="col-sm-10">
									<select multiple name="employeeIds" size="5" style="width: 100%">
										<% for (Employee e : emps) { %>
										<option value="<%= e.getEmployeeId() %>" <%= currentEmpIds.contains(e.getEmployeeId()) ? "selected": "" %> >
										<%= e.getLastName() + ", " + e.getFirstName() %>
									    </option>
									<% } %>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">Start Date</label>
								<div class="col-sm-10">
									<input name="startDate" type="text" class="form-control" value="<%= trip.DateToString(trip.getStartDate()) %>">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">End Date</label>
								<div class="col-sm-10">
									<input name="endDate" type="text" class="form-control" value="<%= trip.DateToString(trip.getEndDate()) %>">
								</div>
							</div>
							<input type="hidden" name="projectId" value="<%= trip.getProj().getProjectId() %>">
							<input type="hidden" name="tripId" value="<%= trip.getTripId() %>">
						</fieldset>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-8 col-sm-2">
						   <% if ( trip.getTripId() != 0) { %>
						   <button type="button" class="btn btn-danger form-control" id="delete_confirmation">Delete</button>
								<!--<a class="btn btn-danger form-control" href="/trip/<%= trip.getTripId() %>/delete" role="button">Delete</a>-->
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
													<p>Are you sure that you want to delete this trip?</p>
												</div>
												<div class="modal-footer">
												<a class="btn btn-danger" href="/trip/<%= trip.getTripId() %>/delete" role="button">Delete</a>
							
												<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
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
	</div>
</div>
<script src="/js/trip_details.js"></script>

<%@include file="Footer.jsp"%>