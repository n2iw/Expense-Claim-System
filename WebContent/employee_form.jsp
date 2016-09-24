<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewpoint" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/styles.css">
		<title>Expenses for "New York city"</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<h1 class="col-sm-8 col-sm-offset-2">Expenses for "New York city"</h1>
			</div>
			<form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
				<div class="well">
					<fieldset>
						<legend>Project Infomation</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Project Code: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="123">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Job Code: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" readonly value="456">
							</div>
						</div>
					</fieldset>
				</div>

				<div class="well">
					<fieldset>
						<legend>Food Expenses</legend>
						<div class="form-group">
							<label class="control-label col-sm-2" for="food">Amount: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="food" name="food" placeholder="$ Amount">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2">Upload Receipts: </label>
							<div class="col-sm-10">
								<input type="file" class="form-control" name="food_receipt" multiple>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2">Uploaded Receipt Files: </label>
							<div class="col-sm-10">
								<a class="btn btn-default" href="show_files.jsp">Show uploaded Files</a>
							</div>
						</div>
					</fieldset>
				</div>

				<div class="well">
					<fieldset>
						<legend>Travel Expenses</legend>
						<div class="form-group">
							<label class="control-label col-sm-2" for="travel">Amount: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="travel" name="travel" placeholder="$ Amount">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2">Upload Receipts: </label>
							<div class="col-sm-10">
								<input type="file" class="form-control" name="travel_receipt" multiple>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2">Uploaded Receipt Files: </label>
							<div class="col-sm-10">
								<a	class="btn btn-default" href="show_files.jsp">Show uploaded Files</a>
							</div>
						</div>
					</fieldset>
				</div>

				<div class="well">
					<fieldset>
						<legend>Accommodation Expenses</legend>
						<div class="form-group">
							<label class="control-label col-sm-2" for="acc">Amount: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="acc" name="accomodation" placeholder="$ Amount">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2">Upload Receipts: </label>
							<div class="col-sm-10">
								<input type="file" class="form-control" name="acc_receipt" multiple>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2">Uploaded Receipt Files: </label>
							<div class="col-sm-10">
								<a	class="btn btn-default" href="show_files.jsp">Show uploaded Files</a>
							</div>
						</div>
					</fieldset>
				</div>

				<div class="well">
					<fieldset>
						<legend>Misc. Expenses</legend>
						<div class="form-group">
							<label class="control-label col-sm-2" for="misc">Amount: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="misc" name="misc" placeholder="$ Amount">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2">Upload Receipts: </label>
							<div class="col-sm-10">
								<input type="file" class="form-control" name="misc_receipt" multiple>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2">Uploaded Receipt Files: </label>
							<div class="col-sm-10">
								<a	class="btn btn-default" href="show_files.jsp">Show uploaded Files</a>
							</div>
						</div>
					</fieldset>
				</div>

					<div class="form-group">
						<div class="col-sm-6">
								<input class="btn btn-primary form-control" type="submit" value="Save">
						</div>
						<div class="col-sm-6">
								<a href="submit.jsp" class="btn btn-danger form-control">Submit</a>
						</div>
					</div>
			</form>
		</div>
		<script src="js/jquery-3.1.0.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/script.js"></script>
	</body>
</html>
