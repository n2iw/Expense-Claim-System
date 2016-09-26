<% String title = "Expense Claim System"; %>
<%@include file="WEB-INF/Header.jsp" %>

<div class="jumbotron text-left">
  <h2>Welcome Manager_Name</h2>
</div>

<div class="well">
          <fieldset>
          <div class="col-md-8 col-md-offset-2">
            <legend>Add Project</legend>
            <br>
            <div class="form-group">
                <label class="control-label col-sm-3">Project Name: </label>
                <div class="col-sm-6">
                  <input type="text" class="form-control">
                </div>
            </div> 
            <br><br>
            <div class="form-group">
              <label class="control-label col-sm-3">Project Code: </label>
              <div class="col-sm-6">
                <input type="text" class="form-control">
              </div>
            </div>
          </div>
          <br><br>
          <div class="col-sm-4 col-md-offset-7">
          	<form 
              <div class="form-group">  
                  <br>
                  <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </div>
          </fieldset>
        </div>

<%@include file="WEB-INF/Footer.jsp" %>