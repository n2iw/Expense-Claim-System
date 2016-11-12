<%@ page import="edu.ualbany.icis518.team6.Projects"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@ page import="edu.ualbany.icis518.team6.Trips"%>
<%
	String title = "Expenses for \"Travel to New York city\"";
%>
<%@include file="Header.jsp"%>

<%
	Projects project = (Projects) request.getAttribute("project");
	Trips trip = (Trips) request.getAttribute("trip");
%>
<link rel="stylesheet" href="/css/bootstrap.min.css">



<div class="container">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
			<div class="row">
				<h4 class="col-sm-offset-2 col-sm-8 col-sm-offset-2 center-block">
					Expenses for "<%=trip.getDescription()%>"
				</h4>
			</div>
			<div class="row">
				<form class="form-horizontal" action="#" method="post"
					enctype="multipart/form-data">
					<div class="well">
						<fieldset>
							<legend>Project Information</legend>
							<div class="form-group">
								<label class="control-label col-sm-2">Project Name: </label>
								<div class="col-sm-10">
									<input type="text" class="form-control" readonly
										value="<%=project.getProjectName()%>">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">Project Code: </label>
								<div class="col-sm-10">
									<input type="text" class="form-control" readonly
										value="<%=project.getProjectId()%>">
								</div>
							</div>
						</fieldset>
					</div>

					<div class="form-group">
						<div class="col-sm-6 col-sm-offset-6">
						 <!--<a href="/employee" class="btn btn-primaryX form-control" >Add Expense</a>-->
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" >Add expense</button>
							 <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">Modal title</h4>
										</div>
										<div class="modal-body"></div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary">Save
												changes</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>


					<%
						List<Expense> exps = (List<Expense>) request.getAttribute("expenses");
						for (Expense e : exps) {
					%>
					<div class="well">
						<fieldset>
							<legend><%=e.getType()%>
								Expenses
							</legend>
							<div class="form-group">
								<label class="control-label col-sm-2" for="food">Amount:
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="food" name="food"
										placeholder="$ Amount" value="<%=e.getAmount()%>">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">Upload Receipts: </label>
								<div class="col-sm-10">
									<input type="file" class="form-control" name="food_receipt"
										multiple>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2">Uploaded Receipt
									Files: </label>
								<div class="col-sm-10">
									<p><%=e.getReceipt()%></p>
									<a class="btn btn-default" href="receipts">Show uploaded
										Files</a>
								</div>
							</div>
						</fieldset>
					</div>
					<%
						}
					%>

					<div class="form-group">
						<div class="col-sm-offset-6 col-sm-3">
							<input class="btn btn-primary form-control" type="submit"
								value="Save">
						</div>
						<div class="col-sm-3">
							<a href="#" class="btn btn-danger form-control">Submit</a>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="/js/employee_form.js"></script>
<%@include file="Footer.jsp"%>
