<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="gti525.paiement.InformationsPaiementTO" %>
<%@ page import="ets.gti525.tp2.InformationsLivraisonBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp" />
<%
InformationsPaiementTO info_paiement = (InformationsPaiementTO) request.getAttribute("info_paiement");
InformationsLivraisonBean info_livraison = (InformationsLivraisonBean) request.getAttribute("info_livraison");
%>

<!-- page content -->
		
	<div>
		<h4>Addresse de livraison</h4>
       	<ul>
	       	<li>${info_livraison.getNom()}</li>
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
       
	<div>
		<a href="${pageContext.request.contextPath}/panier" class="btn btn-success" role="button">Annuler</a>
    	<form method="post" action="${pageContext.request.contextPath}/panier/confirmation_achat">
    		<input type="hidden" value="${info_livraison}" name="info_livraison">  
    		<input type="hidden" value="${info_paiement}" name="info_paiement">				
    		<button  type="submit" class="btn btn-warning btn-block spacer-bottom">Payer</button>
		</form>
	</div>
	


<!-- end of page content -->
<script type="text/javascript">$('#myModal').modal('show');</script>
<jsp:include page="../layout/footer.jsp" />

