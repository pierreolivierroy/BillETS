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
							<div class="panel-heading"><h4>Informations de paiement</h4></div>
							<div class="panel-body">
								<form>
								  <div class="form-group">
								    <label  for="card_name">Nom sur la carte</label>
								    <input type="text" class="form-control" id="card_name" >
								  </div>
								  <div class="form-group">
								    <label  for="card_number">Numéro de la carte</label>
								    <input type="password" class="form-control" id="card_number" >
								  </div>
								   <!-- Expiry-->
						          <div class="form-group">
						            <label  for="expiry_month">Date d'expiration de la carte</label>
						            <div >
						              <select name="expiry_month" id="expiry_month">
						                <option></option>
						                <option value="01">Jan (01)</option>
						                <option value="02">Feb (02)</option>
						                <option value="03">Mar (03)</option>
						                <option value="04">Apr (04)</option>
						                <option value="05">May (05)</option>
						                <option value="06">June (06)</option>
						                <option value="07">July (07)</option>
						                <option value="08">Aug (08)</option>
						                <option value="09">Sep (09)</option>
						                <option value="10">Oct (10)</option>
						                <option value="11">Nov (11)</option>
						                <option value="12">Dec (12)</option>
						              </select>
						              <select name="expiry_year">
						                <option value="14">2014</option>
						                <option value="15">2015</option>
						                <option value="16">2016</option>
						                <option value="17">2017</option>
						                <option value="18">2018</option>
						                <option value="19">2019</option>
						                <option value="20">2020</option>
						                <option value="21">2021</option>
						                <option value="22">2022</option>
						                <option value="23">2023</option>
						                <option value="23">2024</option>
						              </select>
						            </div>
						          </div>
									<div class="form-group">
								    	<label  for="card_cvv">Code visuel de la carte</label>
								    	<input type="text" class="form-control" id="card_cvv" >
								  	</div>
								</form>

							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading"><h4>Informations de livraison</h4></div>
							<div class="panel-body">
								<form role="form">
									<div class="form-group">
								    	<label for="customer_name">Nom complet</label>
								    	<input type="text" class="form-control" id="customer_name" >
								  	</div>
								  	
								  	<div class="form-group">
								    	<label for="address">Adresse</label>
								    	<input type="email" class="form-control" id="address" >
								  	</div>
								  	
								  	<div class="form-group">
								    	<label for="city">Ville</label>
								    	<input type="text" class="form-control" id="city" >
								  	</div>
								 	
								 	<div class="form-group">
								    	<label for="state">Province</label>
								    	<input type="text" class="form-control" id="state" >
								  	</div>
								  	
								  	<div class="form-group">
								    	<label for="zip">Code postal/ZIP</label>
								    	<input type="text" class="form-control" id="zip" >
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

