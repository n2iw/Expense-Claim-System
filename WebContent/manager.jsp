<% String title = "Expense Claim System"; %>
<%@include file="WEB-INF/Header.jsp" %>

<div class="jumbotron text-left">
  <h2>Welcome Manager_Name</h2>
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-4">  
    <button type="button" class="btn btn-primary" onclick="window.location='./AddProject.html'">Add Project</button>
  </div>
  <br><br>
  <div class="row">
    <div class="col-sm-4">
      <h3>Projects</h3>
      <p>Write project name here</p>
    </div>
    <div class="col-sm-8">
      <h3>Trip in plan</h3>
      <p>Write trip with hyperlink. Linking to next page</p>
    </div>
  </div>
</div>

<%@include file="WEB-INF/Footer.jsp" %>