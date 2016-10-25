<%
	String title = "Add Trip";
%>
<%@include file="Header.jsp"%>

<div class="container">
	<div class="row">
		<h1 class="col-sm-8 col-sm-offset-2"></h1>
	</div>
		<form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
			<div class="well">
				<fieldset>
					<legend>Expense Claim System</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Project Name </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="Expense Claim System">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Project Code : </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="123">
							</div>
						</div>
				</fieldset>
			</div>
		</form>
		<br>
		<form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
			<div class="well">
				<fieldset>
					<legend>Trip Details</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Trip To </label>
							<div class="col-sm-10">
								<input type="text" class="form-control">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Employee ID </label>
							<div class="col-sm-10">
								<input type="text" class="form-control">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Hotel Name </label>
							<div class="col-sm-10">
								<input type="text" class="form-control">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Date </label>
							<div class="col-sm-10">
								<input type="text" class="form-control">
							</div>
						</div>
					</fieldset>
					
				</div>
				
				<div class="form-group">
					<div class="col-sm-6">
						<a class="btn btn-primary form-control" href="/manager/trip/create" role="button">Save</a>
					</div>
					<div class="col-sm-6">
						<a class="btn btn-primary form-control" href="/manager/trip/create" role="button">Submit</a>
					</div>
				</div>
			</form>
</div>

<%@include file="Footer.jsp"%>