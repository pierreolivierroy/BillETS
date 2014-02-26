<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	      						<th>Spectacle</th>
	      						<th>Siège</th>
	      						<th>Prix</th>
	      					</tr>
	      				</thead>
	      				<tbody>


	      					<tr>
	      						<td style="text-align:center;"><button type="button"  class="close" aria-hidden="true">&times;</button></td>
	      						<td><span class="bold">Louis-José Houde - Les heures verticales</span><br />
	      							<small>
	      								Le vendredi 31 janvier 2013 à 21h<br />
	      								Salle Wilfrid-Pelletier - Place des Arts
	      							</small>
	      						</td>
	      						<td class="vert-align">B-35</td>
	      						<td class="prix vert-align">39,99 $</td>
	      					</tr>
	      					<tr>
								<td style="text-align:center;"><button type="button"  class="close" aria-hidden="true">&times;</button></td>
								<td><span class="bold">Louis-José Houde - Les heures verticales</span><br />
	      							<small>
	      								Le vendredi 31 janvier 2013 à 21h<br />
	      								Salle Wilfrid-Pelletier - Place des Arts
	      							</small>
	      						</td>
	      						<td class="vert-align">B-37</td>
	      						<td class="vert-align prix">39,99 $</td>
	      					</tr>
	      					<tr>
								<td style="text-align:center;"><button type="button"  class="close" aria-hidden="true">&times;</button></td>
								<td><span class="bold">Louis-José Houde - Les heures verticales</span><br />
	      							<small>
	      								Le vendredi 31 janvier 2013 à 21h<br />
	      								Salle Wilfrid-Pelletier - Place des Arts
	      							</small>
	      						</td>
	      						<td class="vert-align">B-39</td>
	      						<td class="vert-align prix">39,99 $</td>
	      					</tr>
	      				</tbody>
	      			</table>

	      			<hr />

	      			<table class="table-infos table">
	      				<tbody>
	      					<tr class="info">
	      						<td></td>
	      						<td></td>
	      						<td style="text-align:right;">Sous-total:</td>
	      						<td class="prix">79,98 $</td>
	      					</tr>
	      					<tr class="info">
	      						<td></td>
	      						<td></td>
	      						<td style="text-align:right;">TPS (5%):</td>
	      						<td class="prix">4,00 $</td>
	      					</tr>
	      					<tr class="info">
	      						<td></td>
	      						<td></td>
	      						<td style="text-align:right;">TVQ (9,975%):</td>
	      						<td class="prix">7,98 $</td>
	      					</tr>
	      					<tr class="info">
	      						<td></td>
	      						<td></td>
	      						<td style="text-align:right;">Grand total:</td>
	      						<td class="prix">91,96 $</td>
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

