app.controller("autoCompleteController",function($scope,$http){
		$scope.pesquisar = function(pesquisa){
			if ( pesquisa == "" ){
				//Retirar autocomplete
				$scope.show = false;
			}else{
				//Pesquisa AJAX
				$http.get('mercadoriaController',{"data" : pesquisa,"tipo_busca" : "categoria"}).
				sucess(function(data){
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