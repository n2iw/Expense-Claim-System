<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="edu.ualbany.icis518.team6.Employee" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/bootstrap.min.css">


<link rel="stylesheet" href="/css/header_style.css">
<title>${ title }</title>
</head>
<body>
<!-- <div class="container-fluid">
<div class="row">
<div class="col-sm-12">

<div id="header">
  <p id="header-title" class="text-center">Expense Claim System</p>
</div>
</div>
</div>
</div>-->
<div class="container">
<div class="row first" id="header">
    <div class="col-sm-2 first_row_column">
      <img class="img-responsive" src="/images/wtlogo.png" alt="Application Logo" />
    </div>
    <div class="col-sm-8 first_row_column">
      <h1 align="center" >Expense Claim System</h1>
    </div>
    <!-- <div class="col-sm-2 first_row_column"> 
      <div class="dropdown profile_column">
        <button class="btn dropdown-toggle" id="profile_button" type="button" data-toggle="dropdown">
          <span id = "lblData">User</span>
          <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
          <li><a href="/">Logout</a></li>
        </ul>
      </div>
    </div>-->  
  
</div>
<%Employee emp = (Employee)session.getAttribute("employee");
if(emp == null){} 
else{
	
	String role = emp.getRole();
%>
<div class="row">
<div class="col-sm-12" id="toolbar">
<%if ( role.equalsIgnoreCase("HR")){ %>
<nav class="navbar navbar-default">
  <a href="/hr" class="btn navbar-btn">HR Page</a>
  <a href="/employee" class="btn navbar-btn">My Expenses</a>
  <a href="/" class="btn navbar-btn">Logout</a>
</nav>
<% } else if("Manager".equalsIgnoreCase("manager")){%>
 <nav class="navbar navbar-default">
  <a href="/manager" class="btn navbar-btn">Manager Page</a>
  <a href="/employee" class="btn navbar-btn">My Expenses</a>
  <a href="/" class="btn navbar-btn">Logout</a>
</nav>
<%}
else{%>
<nav class="navbar navbar-default">
  <a href="/employee" class="btn navbar-btn">My Expenses</a>
  <a href="/" class="btn navbar-btn">Logout</a>
</nav>
<%}%>
</div>
</div>
<%} %>
</div>