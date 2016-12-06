<%@ page import="edu.ualbany.icis518.team6.Projects"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="edu.ualbany.icis518.team6.Trips"%>

<%@include file="Header.jsp"%>
<link rel="stylesheet" href="/css/expense_style.css">

<% 
   Trips trip = (Trips)request.getAttribute("trip");
   Expense exp = (Expense)request.getAttribute("expense");
   String error = (String)request.getAttribute("error");
   if (error == null) {
	   error = "";
   }
%>

<div class="container">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
			<div class="row">
			</div>
			<div class="row">
			    <!-- Trip information -->
                <form class="form-horizontal" action="#" method="post">
                    <div class="well">
                        <fieldset>
                            <legend>Trip Information</legend>
                            <div class="form-group">
                                <label class="control-label col-sm-2">Description</label>
                                <div class="col-sm-10">
                                    <input readonly name="description" type="text" class="form-control" value="<%= trip.getDescription()%>">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-2">Start Date</label>
                                <div class="col-sm-10">
                                    <input readonly name="startDate" type="text" class="form-control" value="<%= trip.DateToString(trip.getStartDate()) %>">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-2">End Date</label>
                                <div class="col-sm-10">
                                    <input readonly name="endDate" type="text" class="form-control" value="<%= trip.DateToString(trip.getEndDate()) %>">
                                </div>
                            </div>
                        </fieldset>

                    </div>
                </form>
				</div>
			<!-- Expense form -->
			<form class="form-horizontal" action="/employee/expense" method="post" enctype="multipart/form-data">
				<div class="well">
					<fieldset>
                    <!-- type -->
						<div class="form-group">
							<label class="control-label col-sm-2" for="type">Type:
							</label>
							<div class="col-sm-10">
								<select name="type" class="form-control" id="type" name="type">
									<option value="Food" <%= exp.getType().equalsIgnoreCase("Food") ? "selected" : "" %>>Food</option>
									<option value="Travel" <%= exp.getType().equalsIgnoreCase("Travel") ? "selected" : "" %>>Travel</option>
									<option value="Hotel" <%= exp.getType().equalsIgnoreCase("Hotel") ? "selected" : "" %>>Hotel</option>
									<option value="Misc" <%= exp.getType().equalsIgnoreCase("Misc") ? "selected" : "" %>>Misc</option>
								</select>
							</div>
						</div>

                    <!-- Amount -->
						<div class = "form-group" id="expense-error">
							<div class="col-sm-10 col-sm-offset-2"><%= error %></div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="amount">Amount:
							</label>
							<div class="col-sm-10">
								<input name ="amount" type="text" class="form-control" id="amount" value="<%= exp.getAmount() %>">
							</div>
						</div>

					<!-- Receipt -->
					 <% if(exp.getReceipt() != null && !exp.getReceipt().isEmpty()) { %>
                        <div class="form-group">
                            <div class="col-sm-2 col-sm-offset-2">
                                <a class="btn btn-sm btn-info" href="/employee/expense/<%= exp.getExpenseId() %>/receipts" target="_blank">Receipt</a>
                            </div>
                        </div>
					<% } %>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="receipt">Upload Receipt: </label>
                            <div class="col-sm-10">
                                <input type="file" class="form-control" name="receipt"
                                    value="<%= exp.getReceipt() %>">
                            </div>
                        </div>
					<!-- Notes -->
						<div class="form-group">
							<label class="control-label col-sm-2" for="notes">Note:
							</label>
							<div class="col-sm-10">
								<textarea name ="notes" rows="4" cols="50" class="form-control" id="notes"><%= exp.getEmp_notes() == null ? "" : exp.getEmp_notes() %></textarea>
							</div>
						</div>
					<!-- HR Comments -->
						<div class="form-group">
							<label class="control-label col-sm-2" for="comments">HR Comment:
							</label>
							<div class="col-sm-10">
								<textarea readonly name ="comments" rows="4" cols="50" class="form-control" id="notes"><%= exp.getHr_comment() == null ? "" : exp.getHr_comment() %></textarea>
							</div>
						</div>

					</fieldset>
					<input type="hidden" name="tripId" value="<%= exp.getTrip().getTripId() %>">
					<input type="hidden" name="expenseId" value="<%= exp.getExpenseId() %>">
				</div>

				<div class="form-group">
					<div class="col-sm-offset-9 col-sm-3">
						<input class="btn btn-primary form-control" type="submit"
							value="Save">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<%@include file="Footer.jsp"%>
