<%@ page import="edu.ualbany.icis518.team6.Projects"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="edu.ualbany.icis518.team6.Trips"%>
<%
	String title = "Expenses for \"Travel to New York city\"";
%>
<%@include file="Header.jsp"%>

<% 
   Trips trip = (Trips)request.getAttribute("trip");
%>

<div class="container">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
			<div class="row">
				<h4 class="col-sm-offset-2 col-sm-8 col-sm-offset-2" align="center"></h4>
			</div>
			<div class="row">
		        <!-- Trip information -->
				<form class="form-horizontal" action="#" method="post">
					<div class="well">
						<fieldset>
							<legend>
								Trip Information
							</legend>
							<div class="form-group">
								<label class="control-label col-sm-2">Description</label>
								<div class="col-sm-10">
									<input readonly name="description" type="text"
										class="form-control" value="<%= trip.getDescription()%>">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">Start Date</label>
								<div class="col-sm-10">
									<input readonly name="startDate" type="text"
										class="form-control"
										value="<%= trip.DateToString(trip.getStartDate()) %>">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">End Date</label>
								<div class="col-sm-10">
									<input readonly name="endDate" type="text" class="form-control"
										value="<%= trip.DateToString(trip.getEndDate()) %>">
								</div>
							</div>
						</fieldset>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-9 col-sm-3">
							<a href="/employee/expense/new?tripId=<%= trip.getTripId() %>"
								class="btn btn-primary form-control">Add Expense</a>
						</div>
					</div>
				</form>

			</div>


			<!-- Editable expenses -->
			<div class="table-responsive">
			<table class="table table-striped">
				<caption>Current Expenses</caption>
				<thead><tr>
					<th>Type</th> <th>Amount</th> <th>Receipt</th> <th>Status</th> <th>Action</th> 
				</tr></thead>
				<tbody>
				<% 
				   Object temp = request.getAttribute("expenses");
				   if (temp instanceof List) { 
					   List<Expense> exps = (List<Expense>)temp;
					   for (Expense e: exps) {
				%>
				<tr class="<%= e.getStatus().equalsIgnoreCase("declined")? "danger" : "" %>">
					<td><%= e.getType() %></td>
					<td><%= e.getAmount() %></td>
					<td>
					  <% if(e.getReceipt() != null && !e.getReceipt().isEmpty()) { %>
						<a href="javascript:;" id="receiptforemployee">Receipt</a>
						<!--<a href="/employee/expense/<%= e.getExpenseId() %>/receipts">Receipt</a>-->
						<div class="modal fade" id="secondmodalforimage" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h4 class="modal-title" id="myModalLabel">Alert</h4>
												</div>
												<div class="modal-body" id="imagecontainer">
													<img alt="Receipt" src="<%= e.getReceipt() %>" style="width:500px;"></img>
												</div>
												<div class="modal-footer">
												
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Cancel</button>
											</div>
											</div>
										</div>
									</div>
					  <% } %>
					 </td>
					<td><%= e.getStatus() %></td>
					<td>
						<a href="/employee/expense/<%= e.getExpenseId() %>/edit"
							class="btn btn-primary btn-sm">Edit</a>
							<button type="button" class="btn btn-danger btn-sm" id="deleteconfirmation">Delete</button>
						<!-- <a href="/employee/expense/<%= e.getExpenseId() %>/delete"
							class="btn btn-danger btn-sm">Delete</a>-->
							<div class="modal fade" id="secondModal" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h4 class="modal-title" id="myModalLabel">Alert</h4>
												</div>
												<div class="modal-body" id="imagecontainer">
													<p>Are you sure that you want to delete this project?</p>
												</div>
												<div class="modal-footer">
												<a class="btn btn-danger" href="/employee/expense/<%= e.getExpenseId() %>/delete" role="button">Delete</a>
						
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Cancel</button>
											</div>
											</div>
										</div>
									</div>
						<% if (e.getStatus().equalsIgnoreCase("saved")){ %>
						<a href="/employee/expense/<%= e.getExpenseId() %>/submit"
							class="btn btn-success btn-sm">Submit</a>
						<% } %>
					</td>
				</tr>
				<% } %>
            <% } %>
			</tbody>
			</table>
			</div><!-- table-responsive -->
			
			
			<!-- Read only expenses -->
			<div class="table-responsive">
			<table class="table table-striped">
				<caption>History Expenses</caption>
				<thead><tr>
					<th>Type</th> <th>Amount</th> <th>Receipt</th> <th>Status</th>
				</tr></thead>
			<tbody>
			<% 
               Object readonlyExpenses = request.getAttribute("readonlyExpenses");
               if (readonlyExpenses instanceof List) { 
				   List<Expense> exps = (List<Expense>)readonlyExpenses;
				   for (Expense e: exps) {
            %>
				<tr class="<%= e.getStatus().equalsIgnoreCase("approved")? "success" : ""  %>">
					<td><%= e.getType() %></td>
					<td><%= e.getAmount() %></td>
					<td>
					  <% if(e.getReceipt() != null && !e.getReceipt().isEmpty()) { %>
					  <a href="javascript:;" id="receiptforemployee1">Receipt</a>
						<!--<a href="/employee/expense/<%= e.getExpenseId() %>/receipts">Receipt</a>-->
						<div class="modal fade" id="secondModalForImage1" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h4 class="modal-title" id="myModalLabel">Alert</h4>
												</div>
												<div class="modal-body" id="imagecontainer">
													<img alt="Receipt" src="<%=e.getReceipt()%>" style="width:500px;"></img>
												</div>
												<div class="modal-footer">
												
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Cancel</button>
											</div>
											</div>
										</div>
									</div>
					  <% } %>
					 </td>
					<td><%= e.getStatus() %></td>
				</tr>
				<% } %>
            <% } %>
			</tbody>
			</table>
			</div><!-- table-responsive -->
		</div>
	</div>
</div>
<script src="/js/employee_form.js"></script>
<%@include file="Footer.jsp"%>
