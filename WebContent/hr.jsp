<% String title = "Claim List"; %>
<%@include file="WEB-INF/Header.jsp" %>


<div class="container">
            			
			<div class="row">
				<h1 class="col-sm-8 col-sm-offset-2"></h1>
			</div>
			<form class="form-horizontal">
				<div class="well well-sm">
					<fieldset>
						<Legend>Claim List</Legend>
					</fieldset>
				</div>
             </form>			
			<div class ="table-responsive">
					
			   <table class="table table-hover ">
			  
						
                <thead>
                <tr class = active>
                     <th>S.N.</th>
                     <th>Project Code</th>
                     <th>PM Name</th>
                     <th>EMP Name</th>
   					 <th>Expense Amount(USD)</th>
   					 <th>Claim ID</th>
     
 				</tr>
 				</thead>
 				<tbody>
 				<tr>
                     <td>001</td>
                     <td>0A1</td>
                     <td>Neil Dave</td>
                     <td>Sushmita Shrestha</td>
   					 <td>200</td>
   					 <td><a href="claim_id.jsp">PTC001</a></td>
     			</tr>
 				<tr class = active>
                     <td>002</td>
                     <td>0B3</td>
                     <td>Francisco Chang</td>
                     <td>Samantha Rice</td>
   					 <td>675</td>
   					 <td><a href="claim_id.jsp">PTC001</a></td>
     
 				</tr>
 				<tr>
                     <td>003</td>
                     <td>0C2</td>
                     <td>Roland Mendel</td>
                     <td>Chris Hughes</td>
   					 <td>700</td>
   					 <td><a href="claim_id.jsp">PTC001</a></td>
     
 				</tr>
 				
 				<tr class =active>
                     <td>004</td>
                     <td>0C2</td>
                     <td>Roland Mendel</td>
                     <td>Chris Hughes</td>
   					 <td>700</td>
   					 <td><a href="claim_id.jsp">PTC001</a></td>
     
 				</tr>
 				<tr>
                     <td>004</td>
                     <td>0B3</td>
                     <td>Francis Chang</td>
                     <td>Sam Clinton</td>
   					 <td>60</td>
   					 <td><a href="claim_id.jsp">PTC001</a></td>
     
 				</tr>
 				<tr class = active>
                     <td>005</td>
                     <td>0C2</td>
                     <td>Roland Chang</td>
                     <td>Chris Fang</td>
   					 <td>80</td>
   					 <td><a href="claim_id.jsp">PTC001</a></td>
     
 				</tr>
 				</tbody>
 				
		   </table>
		   </div>
		  
</div>


<%@include file="WEB-INF/Footer.jsp" %>