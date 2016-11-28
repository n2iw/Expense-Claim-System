<% String title = "Receipts uploaded"; %>
<%@ page import="edu.ualbany.icis518.team6.Expense"%>
<%@include file="Header.jsp" %>
<% String receipt = (String)request.getAttribute("receipt"); 
   Expense exp = (Expense)request.getAttribute("expense");
%>
<div class="container">
  <div class="row">
    <h4 class="col-sm-12">Uploaded Receipt</h4>
  </div>
    <div class="row">
      <div class="col-sm-10">
        <img class="img-thumbnail" src="<%= receipt %>">
      </div>
      <div class="col-sm-2">
        <% if (exp.getStatus().equalsIgnoreCase("saved")
        		|| exp.getStatus().equalsIgnoreCase("declined")) { %>
			<a class="btn btn-danger" href="/employee/expense/<%= exp.getExpenseId() %>/delete_receipt">Delete</a>
        <% } %>
      </div>
    </div>
</div>

<%@include file="Footer.jsp" %>
