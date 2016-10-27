<%@ page import="edu.ualbany.icis518.team6.Projects"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="edu.ualbany.icis518.team6.Trips"%>
<% String title = "Project Details"; %>
<%@include file="Header.jsp" %>


<div class="container">
	<div class="row"><p></p></div>
		<div class="well">
			<h4>Project Details</h4>
		</div>

		<div class="table-responsive">
   			<table class="table table-hover table-striped table-condensed">
			<thead>
	  		<tr>
	    		<th>Projects</th> <th>Trips</th>
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
									<td rowspan="<%=trips.size()%>"><a
										href="/manager/project?id=<%=project.getProjectId()%>"><%=project.getProjectName()%></a></td>
									<td><%=trips.get(0).getDescription()%></td>
								</tr>
								<%
									for (int i = 1; i < trips.size(); i++) {
										Trips trip = trips.get(i); %>
										<tr>
											<td><%=trip.getDescription()%></td>
										</tr>
								<% } %>
							<% } %>
					<% } %>
				<% } %>
			</tbody>
			</table>
		</div>
		<div>
			<a href="/manager/project/new" class="btn btn-primary active" role="button">Add Project</a>
		</div>
	</div>

<%@include file="Footer.jsp" %>