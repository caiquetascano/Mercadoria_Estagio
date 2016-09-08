$(function(){
	$('#angle-fa').click(function(){
		if ( $('.cl').is(":hidden") ){
			$('.cl').slideDown("slow");
			$('.angle-double').addClass('angle-double-reverse');
		}else{
			$('.angle-double').toggleClass('angle-double-reverse');
			$(".cl").hide();
		}
		
	});
	$('#preco').priceFormat({
		prefix: ''
	});
});