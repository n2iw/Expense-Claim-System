$(document).ready(function(){
	$("#triplist").hide();
	$("#employeelist").hide();
	$("#tripselect option").hide();
	$("#employeeselect option").hide();
	$("#projectselect").on('change',function(){
		var selectedproject = $("#projectselect").val();
		$("."+selectedproject).show();
		$("#triplist").show();
		
	});
	$("#tripselect").on('change',function(){
		var selectedtrip = $("#tripselect").val();
		$("." + selectedtrip).show();
		$("#triplist").show();
		$("#employeelist").show();
	});
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