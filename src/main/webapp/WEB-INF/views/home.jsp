<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="layout/header.jsp" />

	      <div class="jumbotron">
	        <h2 class="white">Vakerai</h2>
	        <p class="white lead">Dans une forêt lointaine, au sommet d'un volcan, existe un monde extraordinaire. Un monde où quelque chose d'autre est possible.</p>
	        <p><a class="btn btn-lg btn-success" href="001.html" role="button">Voir les billets &rarr;</a></p>
	      </div>

	      <div class="row">
	      	<div class="col-lg-12">
	      		<div class="page-header">
		          <h2>Des tonnes de spectacles!</h2>
		       </div>
		       <p class="lead">BillETS est une entreprise québécoise devenue le plus important diffuseur/producteur et promoteur indépendant au Canada. Produisant annuellement plus de 1 000 événements musicaux, familiaux, sportifs partout au Québec, dans les provinces de l’Atlantique et dans le nord-est des États-Unis</p>
		       <p><a href="spectacles.html" class="btn btn-warning btn-lg center-block" role="button">Consulter la liste des spectacles</a></p>
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
		          <div class="thumbnail">
			      <img src="${pageContext.request.contextPath}/resources/img/placeholder.jpg" alt="...">
			      <div class="caption">
			        <h3>Sugar Sammy</h3>
			        <p>Sugar Sammy est le plus important humoriste québécois sur la scène internationale anglophone. Il a donné plus de 1 000 représentations dans 30 pays et fréquente toutes les grandes villes du monde.</p>
			        <p><a href='001.html' class="btn btn-default" role="button">Voir les billets &rarr;</a></p>
			      </div>
			    </div>
		       </div>
		       <div class="col-lg-4">
		       	<div class="thumbnail">
			      <img src="${pageContext.request.contextPath}/resources/img/placeholder.jpg" alt="...">
			      <div class="caption">
			        <h3>Sugar Sammy</h3>
			        <p>Sugar Sammy est le plus important humoriste québécois sur la scène internationale anglophone. Il a donné plus de 1 000 représentations dans 30 pays et fréquente toutes les grandes villes du monde.</p>
			        <p><a href='001.html' class="btn btn-default" role="button">Voir les billets &rarr;</a></p>
			      </div>
			    </div>

		       </div>
		       <div class="col-lg-4">
		         <div class="thumbnail">
			      <img src="${pageContext.request.contextPath}/resources/img/placeholder.jpg" alt="...">
			      <div class="caption">
			        <h3>Sugar Sammy</h3>
			        <p>Sugar Sammy est le plus important humoriste québécois sur la scène internationale anglophone. Il a donné plus de 1 000 représentations dans 30 pays et fréquente toutes les grandes villes du monde.</p>
			        <p><a href='001.html' class="btn btn-default" role="button">Voir les billets &rarr;</a></p>
			      </div>
			    </div> 
		       </div>
		    </div>
		  </div>  

<jsp:include page="layout/footer.jsp" />