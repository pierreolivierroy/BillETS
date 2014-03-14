<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp" />

<!-- page content -->

	      <div class="row">

	      	<div class="col-lg-12">

	        	<ol class="breadcrumb">
				  <li><a href="${pageContext.request.contextPath}">Accueil</a></li>
				  <li class="active">Panier</li>
				</ol>
				<div class="page-header">
	      			<h2>Votre panier</h2>
	      			<p>Voici les billets présents dans votre panier.</p>
      			</div>

	      			<table class="table-panier table table-striped">
	      				<thead>
	      					<tr>
	      						<th style="width:20px;"><span class="glyphicon glyphicon-trash"></span></th>
	      						<th>Quantité</th>
	      						<th>Spectacle</th>
	      						<th>Prix unitaire</th>
	      						<th>Prix</th>
	      					</tr>
	      				</thead>
	      				<tbody>
	      					<c:forEach items="${panier.lignesPanier}" var="ligne_panier">
	      				
	      					<tr>
	      						<td style="text-align:center;"><button type="button"  class="close" aria-hidden="true">&times;</button></td>
	      						<td class="text-center"><strong>${ligne_panier.quantite}</strong></td>
	      						<td><span class="bold">${ligne_panier.titre}</span><br />
	      							<small>${ligne_panier.description}</small>
	      						</td>
	      						<td class="vert-align">${ligne_panier.prixUnitaire} $</td>
	      						<td class="prix vert-align">${ligne_panier.prix} $</td>
	      					</tr>
	      					
	      					</c:forEach>
	      					
	      				</tbody>
	      			</table>

	      			<hr />

	      			<table class="table-infos table">
	      				<tbody>
	      					<tr class="info">
	      						<td></td>
	      						<td></td>
	      						<td style="text-align:right;">Sous-total:</td>
	      						<td class="prix">${panier.sous_total} $</td>
	      					</tr>
	      					<tr class="info">
	      						<td></td>
	      						<td></td>
	      						<td style="text-align:right;">TPS (5%):</td>
	      						<td class="prix">${panier.tps} $</td>
	      					</tr>
	      					<tr class="info">
	      						<td></td>
	      						<td></td>
	      						<td style="text-align:right;">TVQ (9,975%):</td>
	      						<td class="prix">${panier.tvq} $</td>
	      					</tr>
	      					<tr class="info">
	      						<td></td>
	      						<td></td>
	      						<td style="text-align:right;">Grand total:</td>
	      						<td class="prix">${panier.total} $</td>
	      					</tr>
	      				</tbody>
	      				</table>
	      				<hr />
						<p class="foot_buttons">
						  <a href="${pageContext.request.contextPath}" class="btn btn-default">Continuer à magasiner</a>
						  <a href="${pageContext.request.contextPath}/panier/paiement" class="btn btn-success">Procéder au paiement &rarr;</a>
						</p>

	      	</div>

	      </div>
<!-- end of page content -->

<jsp:include page="../layout/footer.jsp" />

