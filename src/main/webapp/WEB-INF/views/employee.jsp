<%@ page import="edu.ualbany.icis518.team6.Trips" %>
<%@ page import="java.util.List" %>

<% String title = "Travel List"; %>
<%@include file="Header.jsp" %>
<link rel="stylesheet" href="/css/employee_style.css">

<div class="container">
<div class="row">
<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
<div class="row well">
<div class="col-sm-offset-4 col-sm-4 col-sm-offset-4">
<h3 align="center">Travel List</h3>
</div>
</div>
<div class="row">
<div class="col-sm-12">
<div class="table-responsive">
   <table class="table table-hover table-striped table-condensed">
	<thead>
	  <tr>
	    <th>Travel Name</th> 
	  </tr>
	</thead>
	<tbody>
	    <% for(Trips trip : (List<Trips>)request.getAttribute("trips")) {%>
			<tr>
			<td><a href="employee/trip/<%= trip.getTripId() %>"><%= trip.getDescription() %></a></td>
			</tr>
	    <% } %>
	</tbody>
	</table>
	<ul>
	</ul>
	</div>
	</div>
	</div>
</div>
</div>
</div>
<%@include file="Footer.jsp" %>