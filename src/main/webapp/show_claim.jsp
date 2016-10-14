<% String title = "Expense Claims";%>
<%@include file="WEB-INF/Header.jsp" %>

		<div class="container">
			<div class="row">
				<h1 class="col-sm-8 col-sm-offset-2"></h1>
			</div>
			<form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
				<div class="well">
					<fieldset>
						<legend>Expense Claim Details</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Employee Name </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="Sushmita Shrestha">
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
							<label class="control-label col-sm-2">Expenses Type</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="Food Expenses">
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Amount(USD)</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="134.56">
							</div>
						</div>		
					</fieldset>
				</div>
				 	<div class="form-group">
						<div class="col-sm-6">
								<input class="btn btn-danger form-control" type="submit" value="Disapprove">
						</div>
						<div class="col-sm-6">
								<input class="btn btn-success form-control" type="submit" value = "Approve">
						</div>
					</div>
			</form>
			
            </div>
            
            <div class="container">
               <fieldset>
						<legend>Receipt Attached Here</legend>           
                <img src="receipt.jpg" class="img-thumbnail" alt="Food Receipt" width="304" height="236">
                <img src="receipt2.jpg" class="img-thumbnail" alt="Food Receipt" width="304" height="236">
                
                </fieldset> 
									
		</div>

<%@include file="WEB-INF/Footer.jsp" %>