<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../layout/header.jsp" />

<!-- page content -->
		<!-- confirmation modal -->
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel">Confirmation</h4>
		        <p>Veuillez confirmer l'exactitude des informations de paiement</p>
		      </div>
		      <div class="modal-body">
		        <h4>Addresse de livraison</h4>
		        <ul>
		        	<li>danny boyer</li>
					<li>549, rue Réjean</li>
					<li>Saint-Michel, Quebec J0L 2J0</li>
					<li>Canada</li>
					<li>Phone: 5147176383</li>
		        </ul>
		        <hr>
		        <h4>Informations de crédit</h4>
		        <ul><li>VISA se terminant par 4321</li></ul>

		        <hr>
		        <h4>Grand total:</h4>
		        <ul><li>CDN$ 91,96</li></ul>

				
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
		        <a href="${pageContext.request.contextPath}/panier/confirmation_achat" class="btn btn-success" role="button">Payer</a>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->

	      <div class="row">

	      	<div class="col-lg-12">

	        	<!-- breadcrumbs -->
	        	<ol class="breadcrumb">
				  <li><a href="${pageContext.request.contextPath}/">Accueil</a></li>
				  <li><a href="${pageContext.request.contextPath}/panier">Panier</a></li>
				  <li class="active">Paiement</li>
				</ol>
				
				<!-- page title -->
	        	<div class="page-header">
		          <h2>Revue de la commande</h2>
		       </div>

		       <!-- content -->
				<div class="row">
					<div class="col-lg-8">
						<div class="panel panel-default">
							<div class="panel-heading"><h4>Adresse de livraison</h4></div>
							<div class="panel-body">
								<form role="form">
									<div class="form-group">
								    <label for="address">Adresse</label>
								    <input type="email" class="form-control" id="address" >
								  </div>
								  <div class="form-group">
								    <label for="zip">Code postal/ZIP</label>
								    <input type="email" class="form-control" id="zip" >
								  </div>
								  <div class="form-group">
								    <label for="city">Ville</label>
								    <input type="password" class="form-control" id="city" >
								  </div>
								  <div class="form-group">
								    <label for="state">Province/États/Région</label>
								    <input type="password" class="form-control" id="state" >
								  </div>

								  <div class="form-group">
								    <label for="country">Pays</label>
								    <select id="country" class="form-control">
									  <option>Canada</option>
									  <option>États-Unis</option>
									</select>    
								  </div>
								  <div class="form-group">
								    <label for="phone">Numéro de téléphone</label>
								    <input type="password" class="form-control" id="phone" >
								  </div>
								  
								</form>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading"><h4>Informations de crédit</h4></div>
							<div class="panel-body">
								<form role="form">
								  <div class="form-group">
								    <label  for="card_name">Nom sur la carte</label>
								    <input type="email" class="form-control" id="card_name" >
								  </div>
								  <div class="form-group">
								    <label  for="card_number">Numéro de la carte</label>
								    <input type="password" class="form-control" id="card_number" >
								  </div>
								  <label  >Date d'expiration</label>
								</form>
								<form class="form-inline" role="form">
									<div class="form-group">
									    
										<select  class="form-control">
										  <option>1</option>
										  <option>2</option>
										  <option>3</option>
										  <option>4</option>
										  <option>5</option>
										  <option>6</option>
										  <option>7</option>
										  <option>8</option>
										  <option>9</option>
										  <option>10</option>
										  <option>11</option>
										  <option>12</option>
										</select>
										<select class="form-control">
										  <option>2014</option>
										  <option>2015</option>
										  <option>2016</option>
										  <option>2017</option>
										  <option>2018</option>
										</select>    
									  </div>
									</form>

							</div>
						</div>

					</div>
					<div class="col-lg-4">
						<div class="panel panel-default">
						  <div class="panel-body">
						  	<button data-toggle="modal" data-target="#myModal" type="button" class="btn btn-warning btn-block spacer-bottom">Soumettre votre achat</button>
						  	<p><strong>Résumé de l'achat</strong></p>
						  	<p>Items (2):	<span class="pull-right">CDN$ 85.66</span></p>
						  	<hr>
						  	<p>Sous-total:	<span class="pull-right">${panier.getSous_total()} $</span></p>
							<p>TPS (5%):	<span class="pull-right">${panier.getTps()} $</span></p>
							<p>TVQ (9,975%):	<span class="pull-right">${panier.getTvq()} $</span></p>
						  	<hr>
						  	<p class="text-danger"><strong>Grand total:	<span class="pull-right">${panier.getTotal()} $</span></strong></p>
						  	
						    
						  </div>
						</div>
					</div>
				</div>
		       	<a href="${pageContext.request.contextPath}/panier" class="spacer-bottom btn btn-default " role="button"><span class="glyphicon glyphicon-arrow-left"></span> Retour au panier</a>		       

	      			

	      	</div>

	      </div>
<!-- end of page content -->

<jsp:include page="../layout/footer.jsp" />

