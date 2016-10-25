<%@ page import="edu.ualbany.icis518.team6.Expense" %>
<%@ page import="java.util.List" %>

<% String title = "Claim List"; %>
<%@include file="Header.jsp" %>

<div class="container">
<div class="row"><p></p></div>
<div class="well">
<h4>Travel List</h4>
</div>
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
	    <% Expense exp  = (Expense)request.getAttribute("expense");%>
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
                        <a class="btn btn-primary form-control" href="/hr" role="button">Approve</a>
                    </div>
                    <div class="col-sm-6">
                        <a class="btn btn-primary form-control" href="/hr" role="button">Decline</a>
                    </div>
                </div>
	
	<ul>
	</ul>
	</div>
</div>
