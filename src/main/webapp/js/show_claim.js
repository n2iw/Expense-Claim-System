$(document).ready(function(){
	$("#commentbox").hide();
    $("#receipt1").click(function(){
    	$("#secondModalShowClaim").modal('show');
    });
   $("#addcomment").click(function(){
	   $("#commentbox").show();
	   
   });
});