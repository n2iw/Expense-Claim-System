<%@ page import="edu.ualbany.icis518.team6.Expense" %>
<%@ page import="java.util.List" %>

<% String title = "Claim List"; %>
<%@include file="Header.jsp" %>
<link rel="stylesheet" href="/css/hr_style.css">
<div class="container">
<div class="row">
<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
<div class="row well">
<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2"><h3 align="center">Expense Claim List</h3>
</div>
</div>
<div class="row">
<div class="col-sm-12">
<div class="table-responsive">
   <table class="table table-hover table-striped table-condensed">
	<thead>
	  <tr>
	    <th>Expense ID</th>
	    <th>Employee ID</th>
	    <th>Amount</th>
	    <th>Type of Expense</th>
	    <th>Status</th>
	    <th>Receipt</th>
	  </tr>
	</thead>
	<tbody>
	    <% for(Expense exp : (List<Expense>)request.getAttribute("expList")) {%>
			<tr>
			<td><a href="hr/claim?id=${id}<%= exp.getExpenseId() %>"><%= exp.getExpenseId()%></td>
			<td><%= exp.getEmpl().getEmployeeId() %></td>
			<td><%= exp.getAmount() %>
			<td><%= exp.getType() %>
			<td><%= exp.getStatus() %>
			<td>file</td>
			</tr>
	    <% } %>
	</tbody>
	</table>
	</div>
	</div>
	</div>
	
	<div class="row well">
	<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
		<h3 align="center">Claim History</h3>
		</div>
		</div>
		<div class="row">
		<div class="col-sm-12">
	<div class="table-responsive">
	<table class="table table-hover table-striped table-condensed">
	<thead>
	  <tr>
	    <th>Expense ID</th>
	    <th>Employee ID</th>
	    <th>Amount</th>
	    <th>Type of Expense</th>
	    <th>Status</th>
	    <th>Receipt</th>
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
			<td>file</td>
			</tr>
	    <% } %>
	</tbody>	
	</table>
	</div>
	</div>
	</div>
</div>
</div>
</div>

<%@include file="Footer.jsp" %>