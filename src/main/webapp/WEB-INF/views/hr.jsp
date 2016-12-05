<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="java.util.List"%>

<%
	String title = "Claim List";
%>
<%@include file="Header.jsp"%>
<link rel="stylesheet" href="/css/hr_style.css">
<div class="container">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
			<div class="row well">
				<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
					<h3 align="center">Expense Claim List</h3>
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
								<%
									for (Expense exp : (List<Expense>) request.getAttribute("expList")) {
								%>
								<tr>
									<td><a href="hr/claim?id=${id}<%= exp.getExpenseId() %>"><%=exp.getExpenseId()%></td>
									<td><%=exp.getEmpl().getEmployeeId()%></td>
									<td><%=exp.getAmount()%>
									<td><%=exp.getType()%>
									<td><%=exp.getStatus()%>
									<td><a href="javascript:;" id="receipt1">Receipt</a></td>
									<div class="modal fade" id="secondModal" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h4 class="modal-title" id="myModalLabel">Receipt</h4>
												</div>
												<div class="modal-body" id="imagecontainer">
													<img src="<%=exp.getReceipt() %>>" />
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</div>
											</div>
										</div>
									</div>
								</tr>
								<%
									}
								%>
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
								<%
									for (Expense exp : (List<Expense>) request.getAttribute("historyExpList")) {
								%>
								<tr>
									<td><a href="hr/claim?id=${id}<%= exp.getExpenseId() %>"><%=exp.getExpenseId()%></td>
									<td><%=exp.getEmpl().getEmployeeId()%></td>
									<td><%=exp.getAmount()%>
									<td><%=exp.getType()%>
									<td><%=exp.getStatus()%>
									<td><a href="javascript:;" id="receipt">Receipt</a></td>
									<!-- Modal -->
									<div class="modal fade" id="myModal" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h4 class="modal-title" id="myModalLabel">Receipt</h4>
												</div>
												<div class="modal-body" id="imagecontainer">
													<img src="<%=exp.getReceipt()%>" />
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</div>
											</div>
										</div>
									</div>

								</tr>
								<% } %>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		<div class="row">
		<div class="col-sm-12">
		                <form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
                    <div class="well">
                        <fieldset>
                            <legend>Advanced Reservations</legend>
                            <div class="form-group">
							<label class="control-label col-sm-2" for="type">Employee :
							</label>
							<div class="col-sm-10">
								<select name="employee_name" class="form-control" id="type" name="type">
								    <option value="" selected>--Select Employee--</option>
									<option value="a">a</option>
									<option value="b">b</option>
									<option value="c">c</option>
									<option value="d">d</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="type">Project :
							</label>
							<div class="col-sm-10">
								<select name="project_name" class="form-control" id="type" name="type">
								    <option value="" selected>--Select Project--</option>
									<option value="a">a</option>
									<option value="b">b</option>
									<option value="c">c</option>
									<option value="d">d</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="type">Trip :
							</label>
							<div class="col-sm-10">
								<select name="trip_name" class="form-control" id="type" name="type">
								    <option value="" selected>--Select Trip--</option>
									<option value="a">a</option>
									<option value="b">b</option>
									<option value="c">c</option>
									<option value="d">d</option>
								</select>
							</div>
						</div>
						<div class="form-group">
                                <label class="control-label col-sm-2">Description: </label>
                                <div class="col-sm-10">
                                    <input name="description" type="text" class="form-control" value="">
                                </div>
                            </div>
                            <div class="form-group">
                            <label class="control-label col-sm-2">Upload Receipt: </label>
                            <div class="col-sm-10">
                                <input type="file" class="form-control" name="receipt"
                                    value="">
                            </div>
                        </div>
                                                    </fieldset>
                        <div class="form-group">
					<div class="col-sm-offset-9 col-sm-3">
						<input class="btn btn-primary form-control" type="submit"
							value="Submit">
					</div>
				</div>

                    </div>
                </form>
		</div>
		</div>
		</div>
	</div>
</div>
<script src="/js/hr.js"></script>
<%@include file="Footer.jsp"%>