$(document).ready(function(){
    $(".expenseformreceipt").click(function(){
    	var src = $(this).data('selector');
    	$("#employeeformpagefirstimage").attr("src",src);
    	$("#expenseformmodal").modal('show');
    });
});