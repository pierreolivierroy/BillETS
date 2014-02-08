<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../layout/header.jsp" />

 <div class="page-header">
		          <h2>Détails de la représentation</h2>
		          <p>Voici les détails de la représentation</p>
		       </div>

		       <!-- content -->
				<h4 class="muted">Louis-Josée Houde - Les heures Verticales</h4>
				<div class="row">
					<div class="col-lg-8">
						<ul class="list-group">
							  <li class="list-group-item"><strong>Date &amp; heure</strong> : 20 janvier à 19h30</li>
							  <li class="list-group-item"><strong>Nombre de places disponibles</strong> : 569</li>
							  <li class="list-group-item"><strong>Numéro de représentation</strong> : 01</li>
							  <li class="list-group-item"><strong>Location</strong> : Montréal, Centre Bell</li>
							  <li class="list-group-item"><strong>Prix unitaire</strong> : 99$</li>
						</ul>
					</div>
					<div class="col-lg-4">
						<div class="panel panel-default">
						  <div class="panel-heading">
						    <h3 class="panel-title">Achat de billet(s)</h3>
						  </div>
						  <div class="panel-body">
						  	<p>Choisissez une quantité</p>
						  	<select class="form-control spacer-bottom">
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
				
		       	<a href="spectacles.html" class="spacer-bottom btn btn-default " role="button"><span class="glyphicon glyphicon-arrow-left"></span> Choisir une autre représentation</a>

 


<jsp:include page="../layout/footer.jsp" />      
	      