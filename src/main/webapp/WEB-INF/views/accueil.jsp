<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="layout/header.jsp" />

	      <div class="jumbotron" style="background-image:url(${pageContext.request.contextPath}/resources/img/spectacles/banner/${spectacleJumbotron.bannerPath});">
	        <h2 class="white">${spectacleJumbotron.nom}</h2>
	        <p class="white lead">${spectacleJumbotron.description}</p>
	        <p><a class="btn btn-lg btn-success" href="${pageContext.request.contextPath}/spectacles/${spectacleJumbotron.id}" role="button">Voir les billets &rarr;</a></p>
	      </div>

	      <div class="row">
	      	<div class="col-lg-12">
	      		<div class="page-header">
		          <h2>Des tonnes de spectacles!</h2>
		       </div>
		       <p class="lead">BillETS est une entreprise québécoise devenue le plus important diffuseur/producteur et promoteur indépendant au Canada. Produisant annuellement plus de 1 000 événements musicaux, familiaux, sportifs partout au Québec, dans les provinces de l’Atlantique et dans le nord-est des États-Unis</p>
		       <p><a href="${pageContext.request.contextPath}/spectacles" class="btn btn-warning btn-lg center-block" role="button">Consulter la liste des spectacles</a></p>
	      	</div>
	      </div>


	      <div class="row">
	        <div class="col-lg-12">
	        	<div class="page-header">
		          <h3>Prochain spectacles</h3>
		       </div>
		    </div>
		    <div class="col-lg-12">
	        	<div class="col-lg-4">
		          <div class="thumbnail" style="min-height : 450px;">
			      <img src="${pageContext.request.contextPath}/resources/img/spectacles/banner/${prochainSpectacle1.bannerPath}" alt="${prochainSpectacle1.nom}">
			      <div class="caption">
			        <h3>${prochainSpectacle1.artistes}</h3>
			        <p>${prochainSpectacle1.description}</p>
			        <p><a href='${pageContext.request.contextPath}/spectacles/${prochainSpectacle1.id}' class="btn btn-default" role="button">Voir les billets &rarr;</a></p>
			      </div>
			    </div>
		       </div>
		       <div class="col-lg-4">
		       	<div class="thumbnail" style="min-height : 450px;">
			      <img src="${pageContext.request.contextPath}/resources/img/spectacles/banner/${prochainSpectacle2.bannerPath}" alt="${prochainSpectacle2.nom}">
			      <div class="caption">
			        <h3>${prochainSpectacle2.artistes}</h3>
			        <p>${prochainSpectacle2.description}</p>
			        <p><a href='${pageContext.request.contextPath}/spectacles/${prochainSpectacle2.id}' class="btn btn-default" role="button">Voir les billets &rarr;</a></p>
			      </div>
			    </div>

		       </div>
		       <div class="col-lg-4">
		         <div class="thumbnail" style="min-height : 450px;">
			      <img src="${pageContext.request.contextPath}/resources/img/spectacles/banner/${prochainSpectacle3.bannerPath}" alt="${prochainSpectacle3.nom}">
			      <div class="caption">
			        <h3>${prochainSpectacle3.artistes}</h3>
			        <p>${prochainSpectacle3.description}</p>
			        <p><a href='${pageContext.request.contextPath}/spectacles/${prochainSpectacle3.id}' class="btn btn-default" role="button">Voir les billets &rarr;</a></p>
			      </div>
			    </div> 
		       </div>
		    </div>
		  </div>  

<jsp:include page="layout/footer.jsp" />