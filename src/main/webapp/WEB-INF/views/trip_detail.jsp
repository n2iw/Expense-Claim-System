<%@ page import="edu.ualbany.icis518.team6.Trips"%>
<%@ page import="java.util.List"%>
<%@include file="Header.jsp"%>
<%
	Trips trip = (Trips) request.getAttribute("trip");
	List<Employee> employees = trip.getAllEmployeeOfThisTrip();
	int employeeId = 0;
	if (employees.size() > 0) {
		employeeId = employees.get(0).getEmployeeId();
	}
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
									<input name="description" type="text" class="form-control" value="<%= trip.getDescription()%>">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">Employee ID </label>
								<div class="col-sm-10">
									<input name="employeeId" type="text" class="form-control" value="<%= employeeId %>">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">Date </label>
								<div class="col-sm-10">
									<input name="startDate" type="text" class="form-control" value="<%= trip.getStartDate()%>">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">Date </label>
								<div class="col-sm-10">
									<input name="endDate" type="text" class="form-control" value="<%= trip.getEndDate()%>">
								</div>
							</div>
							<input type="hidden" name="projectId" value="<%= trip.getProj().getProjectId() %>">
							<input type="hidden" name="tripId" value="<%= trip.getTripId() %>">
						</fieldset>

					</div>

					<div class="form-group">
						<div class="col-sm-3">
							<a class="btn btn-danger form-control"
								href="/trip/<%= trip.getTripId() %>/delete" role="button">Delete</a>
						</div>
						<div class="col-sm-offset-6 col-sm-3">
							<input type="submit" class="btn btn-primary form-control" value="Save">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="Footer.jsp"%>