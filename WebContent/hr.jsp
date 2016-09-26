<% String title = "Claims"; %>
<%@include file="WEB-INF/Header.jsp" %>

<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

/* From login.jsp */
body {
	padding-top: 200px;
	padding-bottom: 40px;
	/*background-image: url('images/bg3.jpg');*/
}

.form-signin-heading {
	text-align: center;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 0px;
	margin: 0 auto 20px;
	background-color: #eed;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"], .form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
}

</style>


  <h1>Claims List:</h1>
  <table >
  <tr>
    <th>S.N.</th>
    <th>Project Code</th>
    <th>PM Name</th>
    <th>EMP Name</th>
    <th>Expense Amount(USD)</th>
     <th>Claim ID</th>
     
  </tr>
  <tr>
    <td>001</td>
    <td>0A1</td>
    <td>Neil Dave</td>
    <td>Sushmita Shrestha</td>
     <td>200</td>
     <td><a href="claim_id.jsp">PTC001</a></td>
    
  </tr>
  <tr>
    <td>002</td>
    <td>0B3</td>
    <td>Francisco Chang</td>
    <td>Samantha Rice</td>
     <td>675</td>
     <td><a href="claim_id.jsp">PTC002</a> </td>
  </tr>
  <tr>
    <td>003</td>
    <td>0C2</td>
    <td>Roland Mendel</td>
    <td>Chris Hughes</td>
     <td>700</td>
     <td><a href="claim_id.jsp">PTC003</a> </td>
  </tr>
 <tr>
    <td>004</td>
    <td>0B3</td>
    <td>Francis Chang</td>
    <td>Sam Clinton</td>
     <td>60</td>
     <td><a href="claim_id.jsp">PTC004</a></td>
  </tr>
  <tr>
    <td>005</td>
    <td>0C2</td>
    <td>Roland Chang</td>
    <td>Chris Fang</td>
     <td>80</td>
     <td><a href="claim_id.jsp">PTC005</a></td>
  </tr>
 
 </table>

<%@include file="WEB-INF/Footer.jsp" %>

