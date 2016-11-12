<%@ page import="edu.ualbany.icis518.team6.Expense" %>
<%@ page import="java.util.List" %>

<% String title = "Claim List"; %>
<%@include file="Header.jsp" %>

<div class="container">
<div class="row"><p></p></div>
<div class="well">
<h4>Travel List</h4>
</div>

<div class="well well-sm"><h4>Expense Claim List</h4></div>
<div class="table-responsive">
   <table class="table table-hover table-striped table-condensed">
	<thead>
	  <tr>
	    <th>Expense ID</th>
	    <th>Employee ID</th>
	    <th>Amount</th>
	    <th>Type of Expense</th>
	    <th>Status</th>
	    <th>Reciept</th>
	  </tr>
	</thead>
	<tbody>
	    <% for(Expense exp : (List<Expense>)request.getAttribute("expList")) {%>
			<tr>
			<td><a href="hr/claim?id=${id}<%= exp.getExpenseId() %>"><%= exp.getExpenseId()%></td>
			<td><%= exp.getEmpl().getEmployeeId() %></td>
			<td><%= exp.getAmount() %></td>
			<td><%= exp.getType() %></td>
			<td><%= exp.getStatus() %></td>
			<td>image</td>
			</tr>
	    <% } %>
	</tbody>
	</table>

	
	<div class="well well-sm">
		<h4>Claim History</h4>
	</div>
	<table class="table table-hover table-striped table-condensed">
	<thead>
	  <tr>
	    <th>Expense ID</th>
	    <th>Employee ID</th>
	    <th>Amount</th>
	    <th>Type of Expense</th>
	    <th>Status</th>
	  </tr>
	</thead>
	<tbody>
	    <% for(Expense exp : (List<Expense>)request.getAttribute("historyExpList")) {%>
			<tr>
			<td><a href="hr/claim?id=${id}<%= exp.getExpenseId() %>"><%= exp.getExpenseId()%></td>
			<td><%= exp.getEmpl().getEmployeeId() %></td>
			<td><%= exp.getAmount() %>
			<td><%= exp.getType() %>
			<td><%= exp.getStatus() %>
			</tr>
	    <% } %>
	</tbody>	
	</table>
	</div>
</div>

<%@include file="Footer.jsp" %>