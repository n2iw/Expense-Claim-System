<%@ page import="edu.ualbany.icis518.team6.Expense" %>
<%@ page import="java.util.List" %>

<% String title = "Claim List"; %>
<%@include file="Header.jsp" %>
<% Expense exp  = (Expense)request.getAttribute("expense");%>

<div class="container">
<div class="row"><p></p></div>
<div class="well">
<h4>Claim For <%= exp.getEmpl().getFirstName() + " " + exp.getEmpl().getLastName()%></h4>
</div>
<form action="/hr/claim/approve?id=${id}<%= exp.getExpenseId()%>" method="post">
<div class="table-responsive">
   <table class="table table-hover table-striped table-condensed">
	<thead>
	  <tr>
	    <th>Employee Name</th>
	    <th>Trip Description</th>
	    <th>Project Code</th>
	    <th>Type of Expense</th>
	    <th>Amount</th>
	    <th>Status</th>
	  </tr>
	</thead>
	<tbody>
			<tr>
			<td><%= (exp.getEmpl().getFirstName() + " " + exp.getEmpl().getLastName())%></td>
			<td><%= exp.getTrip().getDescription() %></td>
			<td><%= exp.getTrip().getProj().getProjectId() %></td>
			<td><%= exp.getType() %>
			<td><%= exp.getAmount() %>
			<td><%= exp.getStatus() %>
			</tr>
	</tbody>
	</table>
    <div class="form-group">
		<div class="col-sm-6">
			<input class="btn btn-primary form-control" name="claimAction" value="Approve" type="submit">
		</div>
		<div class="col-sm-6">
			<input class="btn btn-primary form-control" name="claimAction" value="Decline" type="submit">
		</div>
	</div>
</div>
</form>

<br><br><br>

<div class="well">
<h4>Details of <%= exp.getTrip().getProj().getProjectName()%> Project</h4>
</div>
<br>
<div class="table-responsive">
   <table class="table table-hover table-striped table-condensed">
	<thead>
	  <tr>
	    <th>Project Code</th>
	    <th>Project Name</th>
	    <th>Manager Name</th>
	    <th>Budget</th>
	  </tr>
	</thead>
	<tbody>
			<tr>
			<td><%= exp.getTrip().getProj().getProjectId() %></td>
			<td><%= exp.getTrip().getProj().getProjectName() %></td>
			<td><%= exp.getTrip().getProj().getProjectManager().getFirstName() + " " + exp.getTrip().getProj().getProjectManager().getLastName() %></td>
			<td><%= exp.getTrip().getProj().getBudget() %>
			</tr>
	</tbody>
	</table>
</div>
</div>
