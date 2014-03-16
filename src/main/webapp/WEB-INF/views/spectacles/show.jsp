<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp" />
			<!-- breadcrumbs -->
	        	<ol class="breadcrumb">
				  <li><a href="${pageContext.request.contextPath}/">Accueil</a></li>
				  <li><a href="${pageContext.request.contextPath}/spectacles">Spectacles</a></li>
				  <li class="active">${spectacle.nom}</li>
				</ol>
			<div class="page-header">
				<h2>${spectacle.nom}</h2>
				<h3>${spectacle.artistes}</h3>
				<p>${spectacle.description}</p>
			</div>

			<img class="img-rounded img-responsive" src="${pageContext.request.contextPath}/resources/img/spectacles/banner/${spectacle.bannerPath}">
  			
	      		<h3>Représentations</h3>
	      		<table class="table table-striped table-hover">
	      			<thead>
	      				<tr>
	      					<th>Date</th>
	      					<th>Lieu</th>
	      					<th>Prix</th>
	      					<th></th>
	      				</tr>
	      			</thead>
	      			<tbody>
						<c:forEach items="${spectacle.representations}" var="representation">     
	      					<tr>
		      					<td class="vert-align">${representation.value.date}</td>
		      					<td class="vert-align">${representation.value.salle.nom}<br /><small>${representation.value.salle.adresse}</small></td>
		      					<td class="vert-align">${representation.value.prix} $</td>
		      					<td class="vert-align"><a href="${pageContext.request.contextPath}/spectacles/${spectacle.id}/representations/${representation.value.id}" class="btn btn-primary pull-right">Voir &rarr;</a></td>
		      				</tr>
						</c:forEach>
					</tbody>
	      		</table>
	      		<a href="${pageContext.request.contextPath}/spectacles" class="spacer-bottom btn btn-default " role="button"><span class="glyphicon glyphicon-arrow-left"></span> Choisir un autre spectacle</a>
<jsp:include page="../layout/footer.jsp" />      
	      