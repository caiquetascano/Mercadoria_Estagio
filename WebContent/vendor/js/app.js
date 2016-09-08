var app = angular.module("Mercadoria",[]);
app.controller("ControllerIndex",function($scope,$http){
	$scope.fecharBoxMedia = function(){
		$scope.media_show = false;
	}
	$scope.calculaMedia = function(tipo_produto,nome){
		$http.get('mercadoriaController?tipo='+tipo_produto+'&nome='+nome+'&tipo_busca=media_preco').
		success(function(data){
			$scope.media_show = true
			if(data != 0  ){
				$scope.media = tipo_produto + " - " +  nome  + " a média de preço desse produto é: R$" + data ;
			}else{
				$scope.media = "O produto: " + nome + " ainda não existe na nossa base.";
				
			}
		});
	};

	$scope.valorMercadoria = function(categoria){
		$scope.tipo_produto = categoria;
		//Retirar autocomplete
		$scope.show = false;
	};
	$scope.fecharCategorias = function(){
		$scope.show = false;
	}
	$scope.pesquisar = function(pesquisa){
	console.log(pesquisa);
		if ( pesquisa == "" ){
			//Retirar autocomplete
			$scope.show = false;
		}else{
			//Pesquisa AJAX
			$http.get('mercadoriaController?data='+pesquisa+"&tipo_busca=categoria").
			success(function(data){
				//console.log(data);
				//Coloca autocomplete
				$scope.show = true;

				//json model mercadoria
				$scope.categorias = data;
			})
			.
			error(function(data){
				//Erro mostrar log no console
				console.log("Ocorreu um erro na busca do autocompletar no banco de dados");
			});
		}
	};
});
app.controller("pesquisaController",function($scope,$http){
	$scope.pesquisa = function(tipo_mercadoria,nome_mercadoria,tipo_negocio){
		if( tipo_mercadoria == undefined){
			tipo_mercadoria = "";
		}
		if( nome_mercadoria == undefined){
			nome_mercadoria = "";
		}
		if( tipo_negocio == undefined ){
			tipo_negocio = "";
		}
		$http.get("mercadoriaController?tipo_mercadoria="+tipo_mercadoria+"&nome_mercadoria="+nome_mercadoria+"&tipo_negocio="+tipo_negocio).
	//	$scope.show = true;
		success(function(data){
	//		$scope.show = true;
			console.log(data);
			$scope.mercadorias = data;
		});
	};
    $scope.sort = {
            column: 'preco'
            
    };
    $scope.addClass = function(column){
    	typeCaret = $scope.reverse == true ? "up" : "down"
    	//console.log(typeCaret);
        return column == $scope.sort.column && 'fa fa-caret-' + typeCaret;
    }
    $scope.changeSorting = function(column) {
        var sort = $scope.sort;
       // console.log(column);
      //  console.log()
        if (sort.column == column) {
            $scope.reverse = !$scope.reverse;
            
        } else {
            sort.column = column;
            $scope.reverse = false;
        }
    };

});