<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="java.util.List"%>

<%
	String title = "Claim List";
%>
<%@include file="Header.jsp"%>
<%
	Expense exp = (Expense) request.getAttribute("expense");
%>
<link rel="stylesheet" href="/css/show_claim_style.css">
<div class="container">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
			<div class="row well">
				<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
					<h3 align="center">
						Claim For
						<%=exp.getEmpl().getFirstName() + " " + exp.getEmpl().getLastName()%></h3>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<form action="/hr/claim/approve?id=${id}<%= exp.getExpenseId()%>"
						method="post">
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
										<td><%=(exp.getEmpl().getFirstName() + " " + exp.getEmpl().getLastName())%></td>
										<td><%=exp.getTrip().getDescription()%></td>
										<td><%=exp.getTrip().getProj().getProjectId()%></td>
										<td><%=exp.getType()%>
										<td><%=exp.getAmount()%>
										<td><%=exp.getStatus()%>
									</tr>
								</tbody>
							</table>
							<div class="form-group">
								<div class="col-sm-offset-6 col-sm-3">
									<input class="btn btn-primary form-control" name="claimAction"
										value="Approve" type="submit">
								</div>
								<div class="col-sm-3">
									<input class="btn btn-primary form-control" name="claimAction"
										value="Decline" type="submit">
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<br>
			

			<div class="row well">
				<div class="col-sm-offset2 col-sm-8 col-sm-offset-2">
					<h3 align="center">
						Details of
						<%=exp.getTrip().getProj().getProjectName()%>
						Project
					</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="table-responsive">
						<table class="table table-hover table-striped table-condensed">
							<thead>
								<tr>
									<th>Project Code</th>
									<th>Project Name</th>
									<th>Manager Name</th>
									<th>Budget</th>
									<th>Available Budget</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><%=exp.getTrip().getProj().getProjectId()%></td>
									<td><%=exp.getTrip().getProj().getProjectName()%></td>
									<td><%=exp.getTrip().getProj().getProjectManager().getFirstName() + " "
					+ exp.getTrip().getProj().getProjectManager().getLastName()%></td>
									<td><%=exp.getTrip().getProj().getBudget()%>
									<td><%=exp.getTrip().getProj().getCurrentBudget() %>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="Footer.jsp" %>