<%@page import="com.br.model.Mercadoria"%>
<%@ include file="header.jsp"%>
<div ng-controller="pesquisaController">
<section class='container pesquisa-filtro'>
	<article class='row'>
		<header class='col-md-6 titulo-pesquisa'>
			<h1>Pesquise</h1>
			<h2>Sua Mercadoria</h2>
		</header>
		<div class='col-md-6 form-pesquisa'>
			<form id='pesquisa' method='GET' ng-submit="pesquisa(tipo_mercadoria,nome_mercadoria,tipo_negocio)">
				<div class='form-group'>
					<input class='form-control' type='text' name='nome_mercadoria' ng-model='nome_mercadoria'
						placeholder="Digite o nome da mercadoria" />
				</div>
				<div class='form-group'>
					<select name='tipo_mercadoria' class='form-control' ng-model='tipo_mercadoria'>
						<option value=''>Selecione Tipo</option>
						<c:forEach var="tipo_mercadoria" items="${tipoMercadorias}">
							<option value='${tipo_mercadoria}'>${tipo_mercadoria}</option>
						</c:forEach>
					</select>
				</div>
				<div class='form-group'>
					<select class='form-control' name='tipo_negocio' ng-model='tipo_negocio'>
						<option value=''>Selecione Negocio</option>
						<option value='comprar'>Comprar</option>
						<option value='vender'>Venda</option>
					</select>
				</div>
				<input type="submit"  class='btn btn-custom'>
			</form>
		</div>


	</article>
</section>
<section class='pesquisa-grid container'>		
	<table class="table table-reflow" data-sort="table">
	      <thead class='table-inverse'>
	        <tr>
	        	<th class="header" ng:click="changeSorting('iDMercadoria')")># <i ng-show="sort.column ===  'iDMercadoria'" ng-class="addClass('iDMercadoria')" aria-hidden="true"></i></th>
	          <th class="header"   ng:click="changeSorting('nomeMercadoria')">Nome <i ng-show="sort.column ===  'nomeMercadoria'"  ng-class="addClass('nomeMercadoria')" aria-hidden="true"></i></th>
	          <th class="header"   ng:click="changeSorting('tipoMercadoria')">Tipo <i ng-show="sort.column ===  'tipoMercadoria'"  ng-class="addClass('tipoMercadoria')" aria-hidden="true"></i></th>
	          <th class="header"   ng:click="changeSorting('quantidade')">Quantidade <i ng-show="sort.column ===  'quantidade'"  ng-class="addClass('quantidade')" aria-hidden="true"></i></th>
	          <th class="header"   ng:click="changeSorting('preco')">Preço <i ng-show="sort.column ===  'preco'"  ng-class="addClass('preco')" aria-hidden="true"></i></th>
	          <th class="header"   ng:click="changeSorting('tipoNegocio')">Negocio <i ng-show="sort.column ===  'tipoNegocio'"  ng-class="addClass('tipoNegocio')" aria-hidden="true"></i></th>
	        </tr>
	      </thead>
	      <tbody id='dados-grid'>
					<tr ng-repeat="mercadoria in mercadorias | orderBy: sort.column:reverse">
						<td>{{mercadoria.iDMercadoria}}</td>
						<td>{{mercadoria.nomeMercadoria}}</td>
						<td>{{mercadoria.tipoMercadoria}}</td>
						<td>{{mercadoria.quantidade}}</td>
						<td> R$ {{mercadoria.preco}}</td>
						<td>{{mercadoria.tipoNegocio}}</td>
					</tr>
	       </tbody>
    	</table>
		<div class='gif_ajax' ng-show="show">
			<div class=''>
				<img src='vendor/media/loading.gif'>
			</div>
		</div>

	</section>


</div>

<%@ include file="footer.jsp"%>