<% String title = "Add Project"; %>
<%@include file="Header.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
			<div class="row">
				<h3 class="col-sm-offset-4 col-sm-4 col-sm-offset-4">Welcome Mike</h3>
			</div>
			<div class="row">
			<div class="col-sm-12">
			<form class="form-horizontal" action="/manager/project/create"
				enctype="multipart/form-data">
				<div class="well">
					<fieldset>
						<legend>Add Project</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Name: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Code: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Budget: </label>
							<div class="col-sm-10">
								<input type="number" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Employes : </label>
							<div class="col-sm-10">
								<select multiple class="form-control">
								<option value="emp1">Employee1</option>
								<option value="emp2">Employee2</option>
								<option value="emp3">Employee3</option>
								<option value="emp4">Employee4</option>
								<option value="emp5">Employee5</option>
								</select>
							</div>
						</div>
					</fieldset>
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
	</div>
</div>

<%@include file="Footer.jsp" %>