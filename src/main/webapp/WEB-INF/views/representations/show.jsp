<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../layout/header.jsp" />
	
	      <div class="row">
	        <div class="col-lg-12">
	        	<!-- breadcrumbs -->
	        	<ol class="breadcrumb">
				  <li><a href="${pageContext.request.contextPath}/">Accueil</a></li>
				  <li><a href="${pageContext.request.contextPath}/spectacles">Spectacles</a></li>
				  <li><a href="${pageContext.request.contextPath}/spectacles/${spectacle.id}">${spectacle.nom}</a></li>
				  <li class="active">${representation.date}</li>
				</ol>

				<!-- page title -->
	        	<div class="page-header">
		          <h2>Détails de la représentation</h2>
		          <p>Voici les détails de la représentation</p>
		       </div>

		       <!-- content -->
				<h4 class="muted">${spectacle.artistes} - ${spectacle.nom}</h4>
				<div class="row">
					<div class="col-lg-8">
						<ul class="list-group">
							  <li class="list-group-item"><strong>Date &amp; heure</strong> : ${representation.date}</li>
							  <li class="list-group-item"><strong>Nombre de places disponibles</strong> : ${representation.obtenirNombreBilletsDisponibles()}</li>
							  <li class="list-group-item"><strong>Numéro de représentation</strong> : ${representation.id}</li>
							  <li class="list-group-item"><strong>Identifiant du spectacle</strong> : ${representation.idSpectacle}</li>
							  <li class="list-group-item"><strong>Location</strong> : ${representation.salle.nom}</li>
							  <li class="list-group-item"><strong>Prix unitaire</strong> : ${representation.prix} $</li>
						</ul>
					</div>
					<div class="col-lg-4">
						<div class="panel panel-default">
						  <div class="panel-heading">
						    <h3 class="panel-title">Achat de billet(s)</h3>
						  </div>
						  <div class="panel-body">
						  	<p>Choisissez une quantité</p>
						  	<select id="num_tickets_list" class="form-control spacer-bottom">
							  <option>1</option>
							  <option>2</option>
							  <option>3</option>
							  <option>4</option>
							  <option>5</option>
							  <option>6</option>
							</select>
						    <button data-toggle="modal" data-target="#myModal" type="button" class="btn btn-success btn-block"><span class="glyphicon glyphicon glyphicon-shopping-cart"></span> Ajouter au panier</button>
						  </div>
						</div>
					</div>
				</div>
		       	<a href="${pageContext.request.contextPath}/spectacles/${spectacle.id}" class="spacer-bottom btn btn-default " role="button"><span class="glyphicon glyphicon-arrow-left"></span> Choisir une autre représentation</a>
	        </div>
	        <!-- confirmation modal -->
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel">Confirmation</h4>
		        <p>Veuillez confirmer votre choix de billets</p>
		      </div>
		      <div class="modal-body">
		        <p>Quantité de billets : <span id="num_tickets">1</span></script></p>
		        <p>Représentation du 20 janvier à 19h30</p>
		        <p>Montréal, Centre Bell</p>
		      </div>
		      <form id="form_panier" method="POST" action="${pageContext.request.contextPath}/panier" style="display:none;">
		      	<input name="quantite" id="quantite" type="hidden" value="" />
		      	<input name="representation_id" type="hidden" value="${representation.id}" />
		      	<input name="spectacle_id" type="hidden" value="${spectacle.id}" />
		      </form>
		      <div class="modal-footer">
		        <p><button type="button" class="btn btn-danger btn-block" data-dismiss="modal">Annuler</button></p>
		        <a href="#" id="submit_button" class="spacer-bottom btn btn-success btn-block" role="button">Ajouter les billets au panier</a>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
	        
	   
	      </div>

<script>var quantite = ${representation.obtenirNombreBilletsDisponibles()};</script>
<script src="${pageContext.request.contextPath}/resources/js/nb_billets_validation.js" charset="utf-8"></script>
<!-- this script changes the value of num_tickets -->
<script>
$(document).ready(function() {
	$('#num_tickets_list').change(function() {
		$('#num_tickets').text($('#num_tickets_list option:selected').text());
		$('#quantite').val($('#num_tickets_list option:selected').text());
	});
	$('#quantite').val($('#num_tickets_list option:selected').text());
	$('#submit_button').click(function(event) {
		event.preventDefault();
		$( "#form_panier" ).submit();
	});
});
</script>

<jsp:include page="../layout/footer.jsp" />

