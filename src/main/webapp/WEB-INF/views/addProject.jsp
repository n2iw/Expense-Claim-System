<% String title = "Project detail"; %>
<%@include file="Header.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
			<form class="form-horizontal" action="/project"
				method="POST">
				<div class="well">
					<fieldset>
						<legend>Add Project</legend>
						<div class="form-group">
							<label class="control-label col-sm-2">Project Name: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Budget: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="budget">
							</div>
						</div>
						<div>
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

<%@include file="Footer.jsp" %>