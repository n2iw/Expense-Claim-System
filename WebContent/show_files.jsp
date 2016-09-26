<% String title = "Receipts uploaded"; %>
<%@include file="WEB-INF/Header.jsp" %>

    <h1>Receipts uploaded</h1>
    <form action="#" method="post">
      <label>First receipt</label>
      <input type="hidden" value="file_id">
      <input type="submit" value="Delete">
      <br />
      <label>Second receipt</label>
      <input type="hidden" value="file_id">
      <input type="submit" value="Delete">
      <br />
      <label>Third receipt</label>
      <input type="hidden" value="file_id">
      <input type="submit" value="Delete">
    </form>
    <script src="js/jquery-3.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    
<%@include file="WEB-INF/Footer.jsp" %>