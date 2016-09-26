<% String title = "Expense Claim System"; %>
<%@include file="WEB-INF/Header.jsp" %>

<div class="jumbotron text-left">
  <h2 align="center">Welcome Manager_Name</h2>
</div>
  
<div class="container">
<div class="row">
<div class="col-sm-12">
<div class="table-responsive">
<table class="table">
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
</div>
</div>
</div>
  <div class="row">
    <div class="col-sm-4">  
    <h3>Projects</h3>
      <p>Expense Claim System</p>
      <p>Food Management</p>
      <p>Event  Management</p>
    <br>
    <a href="addProject.jsp" class="btn btn-primary active" role="button">Add Project</a>
   
      
    </div>
    <div class="col-sm-8">
      <h3>Trip in plan</h3>
      <p>Travel to New York City</p>
      <p>Travel to Albany City</p>
      <p>Travel to New Jersey</p>
    </div>
  </div>
</div>

<%@include file="WEB-INF/Footer.jsp" %>