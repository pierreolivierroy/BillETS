<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String paiement_success = (String)request.getAttribute("success");
%>

<jsp:include page="../layout/header.jsp" />

<!-- page content -->
		
		<!-- successful confirmation modal -->
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
				
				<!-- javascript validation -->
				<script src="${pageContext.request.contextPath}/resources/js/parsley.min.js"></script>
				
				<form data-parsley-validate id="user_input_form" method="post" action="${pageContext.request.contextPath}/panier/pre_autorisation">
					<div class="col-lg-8">
						<div class="panel panel-default">
							<div class="panel-heading"><h4>Informations de paiement</h4></div>
							<div id="container_msd" class="panel-body">
							<%
								if(paiement_success.equals("fail")) {
									out.print("<div class=\"alert alert-danger\">Échec de préauthorisation du paiement, vérifiez vos informations de crédit!</div>");
								}
							%>
							
								
								  <div class="form-group">
								    <label  for="card_name">Prénom sur la carte</label>
								    <input data-parsley-type="alphanum"  class="form-control" name="card_firstname" required />
								    <label  for="card_name">Nom sur la carte</label>
								    <input data-parsley-type="alphanum"  class="form-control" name="card_lastname" required />
								  </div>
								  <div class="form-group">
								    <label  for="card_number">Numéro de la carte</label>
								    <input data-parsley-type="integer" data-parsley-minlength="16" data-parsley-maxlength="16" class="form-control" name="card_number" required />
								  </div>
								   <!-- Expiry-->
						          <div class="form-group">
						            <label  for="expiry_month">Date d'expiration de la carte</label>
						            <div >
						              <select name="expiry_month" id="expiry_month" required>
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
						              <select name="expiry_year" required>
						                <option value="2014">2014</option>
						                <option value="2015">2015</option>
						                <option value="2016">2016</option>
						                <option value="2017">2017</option>
						                <option value="2018">2018</option>
						                <option value="2019">2019</option>
						                <option value="2020">2020</option>
						                <option value="2021">2021</option>
						                <option value="2022">2022</option>
						                <option value="2023">2023</option>
						                <option value="2023">2024</option>
						              </select>
						            </div>
						          </div>
									<div class="form-group">
								    	<label  for="card_cvv">Code visuel de la carte</label>
								    	<input data-parsley-type="integer" data-parsley-minlength="3" data-parsley-type="integer" class="form-control" name="card_cvv" required />
								  	</div>
								

							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading"><h4>Informations de livraison</h4></div>
							<div class="panel-body">
								
									<div class="form-group">
								    	<label for="customer_name">Nom complet</label>
								    	<input type="text" class="form-control" name="customer_name" required >
								  	</div>
								  	
								  	<div class="form-group">
								    	<label for="address">Adresse</label>
								    	<input type="text" class="form-control" name="address" required>
								  	</div>
								  	
								  	<div class="form-group">
								    	<label for="city">Ville</label>
								    	<input type="text" class="form-control" name="city" required>
								  	</div>
								 	
								 	<div class="form-group">
								    	<label for="state">Province</label>
								    	<div>
								    	<select name="state" required>
							                <option value="AB">Alberta</option>
							                <option value="BC">Colombie-Britanique</option>
							                <option value="PE">Île-du-Prince-Édouard</option>
							                <option value="MB">Manitoba</option>
							                <option value="NB">Nouveau-Brunswick</option>
							                <option value="NS">Nouvelle-Écosse</option>
							                <option value="NU">Nunavut</option>
							                <option value="ON">Ontario</option>
							                <option value="QC">Québec</option>
							                <option value="SK">Saskatchewan</option>
							                <option value="NL">Terre-Neuve-et-Labrador</option>
							                <option value="NT">Territoires-du-Nord-Ouest</option>
							                <option value="YT">Yukon</option>
							              </select>
							            </div>
								  	</div>
								  	
								  	<div class="form-group">
								    	<label for="zip">Code postal</label>
								    	<input type="text" data-parsley-minlength="6" class="form-control" name="zip" required>
								  	</div>						  
							
							</div>
						</div>


					</div>
					<div class="col-lg-4">
						<div class="panel panel-default">
						  <div class="panel-body">
						  	<button  type="submit" class="btn btn-warning btn-block spacer-bottom">Soumettre votre achat</button>
						  	<p><strong>Résumé de l'achat</strong></p>
						  	<c:forEach items="${panier.lignesPanier}" var="ligne">
						  		<p>(${ligne.quantite}) ${ligne.titre}	<span class="pull-right">${ligne.getPrix()} $</span></p>
						  	</c:forEach>
						  	
						  	<hr>
						  	<p>Sous-total:	<span class="pull-right">${panier.getSous_total()} $</span></p>
							<p>TPS (5%):	<span class="pull-right">${panier.getTps()} $</span></p>
							<p>TVQ (9,975%):	<span class="pull-right">${panier.getTvq()} $</span></p>
						  	<hr>
						  	<p class="text-danger"><strong>Grand total:	<span class="pull-right">${panier.getTotal()} $</span></strong></p>
						  	
						    
						  </div>
						</div>
					</div>
					</form>
					
					
				</div>
		       	<a href="${pageContext.request.contextPath}/panier" class="spacer-bottom btn btn-default " role="button"><span class="glyphicon glyphicon-arrow-left"></span> Retour au panier</a>		       

	      			

	      	</div>

	      </div>
<!-- end of page content -->

<jsp:include page="../layout/footer.jsp" />

