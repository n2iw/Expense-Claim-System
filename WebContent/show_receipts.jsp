<% String title = "Receipts uploaded"; %>
<%@include file="WEB-INF/Header.jsp" %>

<div class="container">
  <div class="row">
    <h4 class="col-sm-12">Receipts uploaded</h4>
  </div>
  <form class="form-horizontal" action="#" method="post">
    <div class="form-group">
      <img class="col-sm-2" src="receipt.jpg">
      <label class="control-label col-sm-2">receipt.jgp</label>
      <div class="col-sm-2">
        <input class="form-control btn btn-danger" type="submit" value="Delete">
      </div>
    </div>
    <input type="hidden" value="file_id">
  </form>

  <form class="form-horizontal" action="#" method="post">
    <div class="form-group">
      <img class="col-sm-2" src="receipt2.jpg">
      <label class="control-label col-sm-2">receipt2.jpg</label>
      <div class="col-sm-2">
        <input class="form-control btn btn-danger" type="submit" value="Delete">
      </div>
    </div>
    <input type="hidden" value="file_id">
  </form>
  <script src="js/jquery-3.1.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/script.js"></script>
</div>

<%@include file="WEB-INF/Footer.jsp" %>
