$(document).ready(function(){
    $(".receipt").click(function(){
    	var src = $(this).data('selector');
    	$("#hrpagesecondimage").attr("src",src);
    	$("#myModal").modal('show');
    });
    $(".receipt1").click(function(){
    	
    	var src = $(this).data('selector');
    	$("#hrpagefirstimage").attr("src",src);
    	$("#secondModal").modal('show');
    });
});