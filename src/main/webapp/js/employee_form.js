$(document).ready(function(){
    $("#hide").hide();
    $(".deleteconfirmation").click(function(){
    	var src = $(this).data('selector');
    	$("#deleteanchortag").attr("href",src);
    	$("#secondModal").modal('show');
    });
    $(".receiptforemployee").click(function(){
    	var src = $(this).data('selector');
    	$("#employeeformimage1").attr("src",src);
    	$("#secondmodalforimage1").modal('show');
         });
    $(".receiptforemployee1").click(function(){
    
    	var src = $(this).data('selector');
    	$("#employeeformimage2").attr("src",src);
    	$("#secondmodalforimage").modal('show');
         });
});