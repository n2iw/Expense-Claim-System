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
				<form class="form-horizontal" action="#" method="post">
					<div class="well">
						<fieldset>
							<legend>
								Expenses for "<%= trip.getDescription() %>"
							</legend>
							<div class="form-group">
								<label class="control-label col-sm-2">Description</label>
								<div class="col-sm-10">
									<input readonly name="description" type="text"
										class="form-control" value="<%= trip.getDescription()%>">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">Date </label>
								<div class="col-sm-10">
									<input readonly name="startDate" type="text"
										class="form-control"
										value="<%= trip.DateToString(trip.getStartDate()) %>">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">Date </label>
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



			<% 
               Object temp = request.getAttribute("expenses");
               if (temp instanceof List) { 
				   List<Expense> exps = (List<Expense>)temp;
				   for (Expense e: exps) {
            %>

			<form class="form-horizontal" action="/employee/expense"
				method="post">
				<div class="well">
					<fieldset>
					   <div class="form-group">
                            <label class="control-label col-sm-2" for="status">Amount:
                            </label>
                            <div class="col-sm-10">
                               <% if (e.getdeleted()) { %>
									<input readonly name="status" type="text" class="form-control"
										id="status" value="Deleted">
                               <% } else { %>
                                <input readonly name="status" type="text" class="form-control"
                                    id="status" value="<%= e.getStatus() %>">
								<% } %>
                            </div>
                        </div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="type">Type: </label>
							<div class="col-sm-10">
								<select name="type" class="form-control" id="type" name="type">
								    <option value="<%= e.getType() %>" selected><%= e.getType() %></option>
									<option value="Food">Food</option>
									<option value="Travel">Travel</option>
									<option value="Hotel">Hotel</option>
									<option value="Misc">Misc</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="amount">Amount:
							</label>
							<div class="col-sm-10">
								<input name="amount" type="text" class="form-control"
									id="amount" value="<%= e.getAmount() %>">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2">Upload Receipt: </label>
							<div class="col-sm-10">
								<input type="file" class="form-control" name="receipt"
									value="<%= e.getReceipt() %>">
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-6">
							  <% if(e.getReceipt() != null && !e.getReceipt().isEmpty()) { %>
								<a class="" href="/employee/expense/<%= e.getExpenseId() %>/receipts">View Receipt</a>
							 <% } %>
							</div>
						</div>
						<div class="form-group">
						   <% if (e.getStatus().equalsIgnoreCase("saved")
								   && !e.getdeleted()) { %>
								<div class="col-sm-offset-6 col-sm-2">
									<input class="btn btn-primary form-control" type="submit" value="Save">
								</div>
								<div class="col-sm-2">
									<a href="/employee/expense/<%= e.getExpenseId() %>/delete"
										class="btn btn-danger form-control">Delete</a>
								</div>
								<div class="col-sm-2">
									<a href="/employee/expense/<%= e.getExpenseId() %>/submit"
										class="btn btn-danger form-control">Submit</a>
								</div>
						   <% } %>
						</div>
					</fieldset>
					<input type="hidden" name="tripId" value="<%= e.getTrip().getTripId() %>">
					<input type="hidden" name="expenseId" value="<%= e.getExpenseId() %>">
				</div>

			</form>

			<% } %>
			<% } %>


		</div>
	</div>
</div>
<
<script src="/js/employee_form.js"></script>
<%@include file="Footer.jsp"%>
