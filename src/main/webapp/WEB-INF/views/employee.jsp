<%@ page import="edu.ualbany.icis518.team6.Trips" %>
<%@ page import="java.util.List" %>

<% String title = "Travel List"; %>
<%@include file="Header.jsp" %>


<div class="container">
<div class="row">
<div class="col-sm-offset-4 col-sm-4 col-sm-offset-4">
<center><h3>Travel List</h3></center>
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
			<td><a href="employee/trip?id=${id}&tripId=<%= trip.getTripId() %>"><%= trip.getDescription() %></a></td>
			</tr>
	    <% } %>
	</tbody>
	</table>
	</div>
	</div>
	</div>
</div>
<%@include file="Footer.jsp" %>