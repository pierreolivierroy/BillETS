<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../layout/header.jsp" />

<!-- page content -->
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
		          <h1 class="text-success">Votre achat a été effectué avec succès!</h1>
		          <p>Veuillez conserver cette preuve d'achat</p>
		       </div>
		       <h2>Détails de la vente</h2>
		       
				<div class="list-group">
				  	<a href="#" class="list-group-item"><h4>Numéro de facture</h4>86862133773737774</a>
				  	<a href="#" class="list-group-item"><h4>Date</h4>2014/01/22</a>
				  	<a href="#" class="list-group-item">
				  		<h4>Addresse de livraison</h4>
				        <ul>
				        	<li>danny boyer</li>
							<li>549, rue Réjean</li>
							<li>Saint-Michel, Quebec J0L 2J0</li>
							<li>Canada</li>
							<li>Phone: 5147176383</li>
				        </ul>
	        	  	</a>
					<a href="#" class="list-group-item">
				  		<h4>Informations de crédit</h4>
		        		<p>VISA se terminant par 4321</p>
				  	</a>
				  	<a href="#" class="list-group-item">
					  	<h4>Billets</h4>
					  	<p>Louis-Josée Houde - Les heures Verticales - Siège C-37<span class="pull-right">CDN$ 39,99</span></p>
						<p>Louis-Josée Houde - Les heures Verticales - Siège C-38<span class="pull-right">CDN$ 39,99</span></p>
				  	</a>
					<a href="#" class="list-group-item">
					  	<h4>Résumé de l'achat</h4>
					  	<p>Sous-total:	<span class="pull-right">CDN$ 79,98</span></p>
						<p>TPS (5%):	<span class="pull-right">CDN$ 4,00</span></p>
						<p>TVQ (9,975%):	<span class="pull-right">CDN$ 7,98</span></p>
					  	<hr>
					  	<p><strong>Grand total:	<span class="pull-right">CDN$ 91,96</span></strong></p>
				  	</a>
				  	
				</div>

		       	<a href="${pageContext.request.contextPath}" class="spacer-bottom btn btn-default " role="button"><span class="glyphicon glyphicon-arrow-left"></span> Retour à BILLETS</a>
	        </div>
	   
	      </div>
<!-- end of page content -->

<jsp:include page="../layout/footer.jsp" />

