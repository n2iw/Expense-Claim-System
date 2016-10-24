<% String title = "Expense Claims";%>
<%@include file="Header.jsp" %>

		<div class="container">
			<div class="row">
				<h1 class="col-sm-8 col-sm-offset-2"></h1>
			</div>
			<form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
				<div class="well">
					<fieldset>
						<legend>Claim Report</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Employee Name </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="Sushmita Shrestha">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Claim ID : </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="001">
							</div>
						</div>
												
						<div class="form-group">
							<label class="control-label col-sm-2">Trip Name : </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="New York city">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Project Code: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="123">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Expense Type</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="Food Expenses">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Claim Amount(USD)</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="134.56">
							</div>
						</div>		
						
						<div class="form-group">
							<label class="control-label col-sm-2">Approved Amount(USD)</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="134.56">
								
							</div>
						</div>	
						<div class="form-group">
							<label class="control-label col-sm-2">Due Amount(USD)</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="0.00">
								
							</div>
						</div>	
						
						
						
					</fieldset>
				</div>
			</form>
		</div>
  
<%@include file="Footer.jsp" %>