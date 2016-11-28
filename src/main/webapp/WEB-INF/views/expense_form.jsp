<%@ page import="edu.ualbany.icis518.team6.Projects"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="edu.ualbany.icis518.team6.Trips"%>

<%@include file="Header.jsp"%>

<% 
   Trips trip = (Trips)request.getAttribute("trip");
   Expense exp = (Expense)request.getAttribute("expense");
%>

<div class="container">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
			<div class="row">
			</div>
			<div class="row">
                <form class="form-horizontal" action="#" method="post">
                    <div class="well">
                        <fieldset>
                            <legend>Expenses for "<%= trip.getDescription() %>"</legend>
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
			<form class="form-horizontal" action="/employee/expense" method="post" enctype="multipart/form-data">
				<div class="well">
					<fieldset>
						<div class="form-group">
							<label class="control-label col-sm-2" for="type">Type:
							</label>
							<div class="col-sm-10">
								<select name="type" class="form-control" id="type" name="type">
								    <option value="<%= exp.getType() %>" selected><%= exp.getType() %></option>
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
								<input name ="amount" type="text" class="form-control" id="amount" value="<%= exp.getAmount() %>">
							</div>
						</div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Upload Receipt: </label>
                            <div class="col-sm-10">
                                <input type="file" class="form-control" name="receipt"
                                    value="<%= exp.getReceipt() %>">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-2 col-sm-offset-2">
                              <% if(exp.getReceipt() != null && !exp.getReceipt().isEmpty()) { %>
                                <a class="btn btn-default" href="/employee/expense/<%= exp.getExpenseId() %>/receipts">View Receipt</a>
                             <% } %>
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
