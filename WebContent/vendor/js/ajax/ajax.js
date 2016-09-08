$(function(){
	
	/***********************Exclusão**********************************/
	
	$('.excluir').click(function(){
		var id = $(".id_mercadoria").data("id");
		console.log(id);
		$.ajax({ 
			url : "mercadoriaController",
			data : {"id" : id,"tipo_busca" : "del"},
			type : "POST",
			beforeSend: function(){
			},
			success: function(data){	
				$(".dados-cadastro").hide();
			}
		});
	});
	
	/*********************CADASTRO****************************/
	$('#cadastrar_mercadoria').submit(function(event){
		event.preventDefault();
		var confirma = confirm("Você realmente deseja cadastrar essa mercadoria ?");
		
		if(confirma){
			var jtipo_mercadoria = $("input[name=tipo_mercadoria]").val();
			var jnome_mercadoria = $("input[name=nome_mercadoria]").val();
			var jquantidade = $("input[name=quantidade]").val();
			var jpreco = $("input[name=preco]").val();
			var jtipo_negocio = $("select[name=tipo_negocio]").val();
			var jdata = { 
					tipo_mercadoria : jtipo_mercadoria,
					nome_mercadoria : jnome_mercadoria,
					quantidade : jquantidade,
					preco : jpreco,
					tipo_negocio : jtipo_negocio,
					tipo_busca : "cadastro"
			};
			$.ajax({ 
				url : "mercadoriaController",
				data : jdata,
				type : "POST",
				beforeSend: function(){
					$('.gif_ajax').show();
				},
				success: function(data){
					console.log(data);
					setTimeout(function(){
						$('.gif_ajax').hide();
					},2000);
					$('.alert_custom').html("<strong>Voce cadastrou</strong> o seu pedido com sucesso! :)");
					$('.alert_custom').show();
					
					$('.dados-cadastro').show();
					carrega_json_cadastro(data);
					limpar_campos();
					
				}
			});
		}
	});
	
	/*********************************************************/
	/*$('#pesquisa').submit(function(event){
		
		event.preventDefault();
		var jtipo_mercadoria = $("select[name=tipo_mercadoria]").val();
		var jnome_mercadoria = $("input[name=nome_mercadoria]").val();
		var jtipo_negocio = $("select[name=tipo_negocio]").val();
		
		jdata = { 
					tipo_mercadoria : jtipo_mercadoria,
					nome_mercadoria : jnome_mercadoria,
					tipo_negocio : jtipo_negocio
				}
		$.ajax({ 
			url : "mercadoriaController",
			data : jdata,
			type : "GET",
			beforeSend: function(){
				$('.gif_ajax').show();
			},
			success: function(data){
				console.log(data);
				setTimeout(function(){
					$('.gif_ajax').hide();
				},1000);
				var concatena = "";
				for(var i = 0; i < data.length;i++){
					concatena += "<tr><td>"+data[i].iDMercadoria+"</td>"+
					"<td>"+data[i].nomeMercadoria+"</td>"+
					"<td>"+data[i].tipoMercadoria+"</td>"+
					"<td>"+data[i].quantidade+"</td>"+
					"<td> R$ "+data[i].preco+"</td>"+
					"<td>"+data[i].tipoNegocio+"</td></tr>";
				}
				$("#dados-grid").html(concatena);
				
			}
		});
		
		
	});*/
});

function limpar_campos(){
	$("input[name=tipo_mercadoria]").val("");
	$("input[name=nome_mercadoria]").val("");
	$("input[name=quantidade]").val("");
	$("input[name=preco]").val("");
}

function carrega_json_cadastro(json){
	console.log(json);
	$('.id_mercadoria').data("id",json.iDMercadoria);
	$('.nome_mercadoria').html(json.nomeMercadoria);
	$('.tipo_mercadoria').html(json.tipoMercadoria);
	$('.quantidade').html(json.quantidade);
	$('.preco').html(json.preco);
	$('.tipo_negocio').html(json.tipoNegocio);
}