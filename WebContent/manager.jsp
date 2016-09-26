<% String title = "Expense Claim System"; %>
<%@include file="WEB-INF/Header.jsp" %>

<div class="jumbotron text-left">
  <h2 align="center">Welcome Manager_Name</h2>
</div>
  
<div class="container">
<div class="row">
<div class="col-sm-12">
<div class="table-responsive">
<table class="table table-bordered">
<thead>
<tr>
<th>Project</th>
<th>Trips</th>
</tr>
</thead>
<tbody>
<tr><td>Expense Claim System</td><td>Travel to New York City</td></tr>
<tr><td>Food Management</td><td>Travel to Albany City</td></tr>
<tr><td>Event  Management</td><td>Travel to New Jersey</td></tr>
</tbody>
</table>
<a href="addProject.jsp" class="btn btn-primary active" role="button">Add Project</a>
</div>
</div>
</div>
  
</div>

<%@include file="WEB-INF/Footer.jsp" %>