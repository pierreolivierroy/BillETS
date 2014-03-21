<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="gti525.paiement.InformationsPaiementTO" %>
<%@ page import="ets.gti525.tp2.InformationsLivraisonBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp" />
<%
InformationsPaiementTO info_paiement = (InformationsPaiementTO) request.getAttribute("info_paiement");
InformationsLivraisonBean info_livraison = (InformationsLivraisonBean) request.getAttribute("info_livraison");
String card_number = String.valueOf(info_paiement.getCard_number());
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
        <h2>Confirmation de l'achat</h2>
     </div>

		
	<div class="row">
		<div class="col-lg-8">
		<div class="panel panel-default">
		<div class="panel-heading"><h4>Résumé de la transaction</h4></div>
		<div class="panel-body">
			<h5>Addresse de livraison</h5>
	       	<ul>
		       	<li>${info_livraison.getNom()}</li>
				<li>${info_livraison.getAdresse()}</li>
				<li>${info_livraison.getVille()}, ${info_livraison.getProvince()}, ${info_livraison.getCode_postal()}</li>
				<li>Canada</li>
	       	</ul>
	       <hr>
	       <h5>Informations de crédit</h5>
	       <ul><li>VISA se terminant par <% out.print(card_number.substring(card_number.length() - 4, card_number.length())); %></li></ul>
	
	       <hr>
	       <h5>Grand total:</h5>
	       <ul><li>CAD$ ${info_paiement.getAmount()}</li></ul>
		</div>
		</div>
		</div>
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-body">
				<div>
		    	<form method="post" action="${pageContext.request.contextPath}/panier/confirmation_achat">
		    	    	
		    		<input type="hidden" value="${info_paiement.getCard_number()}" name="card_number">
		    		<input type="hidden" value="${info_paiement.getFirst_name()}" name="card_firstname">
		    		<input type="hidden" value="${info_paiement.getLast_name()}" name="card_lastname">
		    		<input type="hidden" value="${info_paiement.getMonth()}" name="expiry_month">
		    		<input type="hidden" value="${info_paiement.getYear()}" name="expiry_year">
		    		<input type="hidden" value="${info_paiement.getSecurity_code()}" name="card_cvv">
		    		<input type="hidden" value="${info_livraison.getAdresse()}" name="address">
		    		<input type="hidden" value="${info_livraison.getCode_postal()}" name="zip">
		    		<input type="hidden" value="${info_livraison.getNom()}" name="customer_name">
		    		<input type="hidden" value="${info_livraison.getProvince()}" name="state">
					<input type="hidden" value="${info_livraison.getVille()}" name="city"> 		
						
		    		<button  type="submit" class="btn btn-warning btn-block spacer-bottom">Passer la commande</button>
				</form></div>
				<a href="${pageContext.request.contextPath}/panier" class="btn btn-default btn-block" role="button">Annuler</a>
			</div></div>
		</div>
	</div>
	
</div></div>
<!-- end of page content -->
<jsp:include page="../layout/footer.jsp" />

