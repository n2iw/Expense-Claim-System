<%@ page import="edu.ualbany.icis518.team6.Projects"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="edu.ualbany.icis518.team6.Trips"%>
<% String title = "Project Details"; %>
<%@include file="Header.jsp" %>

<% List<Projects> projects = (List<Projects>)request.getAttribute("projects"); %>

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
			<% for(Projects project: projects ){ 
			   List<Trips> trips = Trips.getbyProject(project);
			%>
			    <% for(Trips trip: trips) { %>
					<tr>
						<td><a href="/manager/project?id=<%= project.getProjectId()%>"><%= project.getProjectName() %></a></td><td><%= trip.getDescription() %></td>
					</tr>
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