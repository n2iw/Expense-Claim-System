<%@ page import="edu.ualbany.icis518.team6.Projects"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="edu.ualbany.icis518.team6.Trips"%>
<% String title = "Project Details"; %>
<%@include file="Header.jsp" %>

<link rel="stylesheet" href="/css/manager_style.css">
<div class="container">
<div class="row">
<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
	<div class="row well">
		<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
			<h3 align="center">Project Details</h3>
		</div>
</div>
<div class="row">
<div class="col-sm-12">
		<div class="table-responsive">
   			<table class="table table-hover table-striped table-condensed">
			<thead>
	  		<tr>
	    		<th>Projects</th> <th>Budget</th> <th>Trips</th>
	  		</tr>
			</thead>
			<tbody>
			<%
				Object temp = request.getAttribute("projects");
				if (temp instanceof List) {
					List<Projects> projects = (List<Projects>) temp;
					for (Projects project : projects) {
							List<Trips> trips = Trips.getbyProject(project);

							if (trips.size() > 0) { 
			%>
								<tr>
									<td rowspan="<%=trips.size()%>">
										<a href="/project/<%=project.getProjectId()%>"><%=project.getProjectName()%></a>
									</td>
									<td rowspan="<%=trips.size()%>"> <%=project.getBudget()%> </td>
									<td><%=trips.get(0).getDescription()%></td>
								</tr>
								<%
									for (int i = 1; i < trips.size(); i++) {
										Trips trip = trips.get(i); %>
										<tr>
											<td><%=trip.getDescription()%></td>
										</tr>
								<% } %>
							<% } else {%>
								<tr>
									<td><a href="/project/<%=project.getProjectId()%>"><%=project.getProjectName()%></a></td>
									<td> <%=project.getBudget()%> </td>
									<td></td>
								</tr>
							<% } %>
					<% } %>
				<% } %>
			</tbody>
			</table>
		</div>
		</div>
		</div>
		<div class="row">
		<div class="col-sm-12">
			<a href="/project/new" class="btn btn-primary active" role="button">Add Project</a>
		</div>
		</div>
	</div>
	</div>
	</div>

<%@include file="Footer.jsp" %>