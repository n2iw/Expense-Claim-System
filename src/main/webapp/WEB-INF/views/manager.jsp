<% String title = "Project Details"; %>
<%@include file="Header.jsp" %>

<div class="container">
	<div class="row"><p></p></div>
		<div class="well">
			<h4>Project Details</h4>
		</div>

		<div class="table-responsive">
   			<table class="table table-hover table-striped table-condensed">
			<thead>
	  		<tr>
	    		<th>Projects</th> <th>Trips</th>
	  		</tr>
			</thead>
			<tbody>
	    	<tr>
	    		<td><a href="/manager/project">Expense Claim System</a></td><td>Travel to New York City</td>
	    	</tr>
	    	<tr>
	    		<td><a href="/manager/project">Food Management</a></td><td>Travel to Albany City</td>
	    	</tr>
		    <tr>
			    <td><a href="/manager/project">Event  Management</a></td><td>Travel to New Jersey</td>
	    	</tr>
			</tbody>
			</table>
		</div>
		<div>
			<a href="/manager/project/new" class="btn btn-primary active" role="button">Add Project</a>
		</div>
	</div>

<%@include file="Footer.jsp" %>