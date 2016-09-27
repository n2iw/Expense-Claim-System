<% String title = "Travel List"; %>
<%@include file="WEB-INF/Header.jsp" %>

<div class="container">
<div class="row"><p></p></div>
<div class="well">
<h4>Travel List</h4>
</div>
<div class="table-responsive">
   <table class="table table-hover table-striped table-condensed">
	<thead>
	  <tr>
	    <th>Travel Name</th> <th>Status</th>
	  </tr>
	</thead>
	<tbody>
	    <tr>
	    <td><a href="employee_form.jsp">Travel to New York city</a></td><td>approved</td>
	    </tr>

	    <tr>
	    <td><a href="employee_form.jsp">Travel to New Jersey</a></td><td>saved</td>
	    </tr>

	    <tr>
	    <td><a href="employee_form.jsp">Travel to Rochester</a></td><td>submitted</td>
	    </tr>
	</tbody>
	</table>
	</div>
</div>
  <script src="js/jquery-3.1.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/script.js"></script>

<%@include file="WEB-INF/Footer.jsp" %>