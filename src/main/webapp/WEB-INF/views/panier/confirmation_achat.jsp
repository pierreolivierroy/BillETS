<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ets.gti525.tp2.Facture" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp" />
<%
Facture facture = (Facture)request.getAttribute("facture");
String card_number = String.valueOf(facture.getInfo_paiement().getCard_number());
%>

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
				  	<a href="#" class="list-group-item"><h4>Numéro de facture</h4>${facture.getNumeroFacture()}</a>
				  	<a href="#" class="list-group-item"><h4>Date</h4>${facture.getDate()}</a>
				  	<a href="#" class="list-group-item">
				  		<h4>Addresse de livraison</h4>
				        <ul>
				        	<li>${facture.getInfo_livraison().getNom()}</li>
							<li>${facture.getInfo_livraison().getAdresse()}</li>
							<li>${facture.getInfo_livraison().getVille()}, ${facture.getInfo_livraison().getProvince()}</li>
							<li>${facture.getInfo_livraison().getCode_postal()}</li>
				        </ul>
	        	  	</a>
					<a href="#" class="list-group-item">
				  		<h4>Informations de crédit</h4>
		        		<p>VISA se terminant par <% out.print(card_number.substring(card_number.length() - 4, card_number.length())); %></p>
				  	</a>
				  	<a href="#" class="list-group-item">
					  	<h4>Billets</h4>
					  	
					  	<c:forEach items="${facture.getLignesPanier()}" var="ligne">
					  		<p>(${ligne.getQuantite()}) ${ligne.getTitre()} : ${ligne.getDescription()}<span class="pull-right">${ligne.getPrix()} $</span></p>	
					  	</c:forEach>
				  	</a>
					<a href="#" class="list-group-item">
					  	<h4>Résumé de l'achat</h4>
					  	<p>Sous-total:	<span class="pull-right">${facture.getSous_total()} $</span></p>
						<p>TPS (5%):	<span class="pull-right">${facture.getTps()} $</span></p>
						<p>TVQ (9,975%):	<span class="pull-right">${facture.getTvq()} $</span></p>
					  	<hr>
					  	<p><strong>Grand total:	<span class="pull-right">${facture.getTotal()} $</span></strong></p>
				  	</a>
				  	
				</div>

		       	<a href="${pageContext.request.contextPath}" class="spacer-bottom btn btn-default " role="button"><span class="glyphicon glyphicon-arrow-left"></span> Retour à BILLETS</a>
	        </div>
	   
	      </div>
<!-- end of page content -->

<jsp:include page="../layout/footer.jsp" />

