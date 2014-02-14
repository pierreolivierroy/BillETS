<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<jsp:include page="../layout/header.jsp" />
				
    			<div class="page-header">
	      			<h2>Liste des spectacles</h2>
					<p>Voici une liste de tous les spectacles offerts par Billets</p>
				</div>	
				
					<div class="form-group">
						<input name="spectacle_nom" type="text" class="form-control" placeholder="Rechercher">
					</div>


			 		<div class="media">
					  <a class="pull-left" href="#">
					    <img class="media-object" src="${pageContext.request.contextPath}/resources/img/ljh.jpg" alt="img_spectacle">
					  </a>
					  <div class="media-body">
					    <h4 class="media-heading"><a href="001.html">Louis-Josée Houde</a></h4>
						<p>Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.</p>
					  </div>
					</div>
					
					<div class="media">
					  <a class="pull-left" href="#">
					    <img class="media-object" src="${pageContext.request.contextPath}/resources/img/sugar.png" alt="img_spectacle">
					  </a>
					  <div class="media-body">
					    <h4 class="media-heading"><a href="001.html">Louis-Josée Houde</a></h4>
						<p>Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.</p>
					  </div>
					</div>

					<div class="media">
					  <a class="pull-left" href="#">
					    <img class="media-object" src="${pageContext.request.contextPath}/resources/img/54589463.jpg" alt="img_spectacle">
					  </a>
					  <div class="media-body">
					    <h4 class="media-heading"><a href="001.html">Louis-Josée Houde</a></h4>
						<p>Les heures verticales. Pour l’humoriste, Les heures verticales, c’est le temps où l’être humain est debout, à partir du jour où il a appris à marcher, mais aussi dans les moments où il doit se tenir droit devant ou dans l’adversité.</p>
					  </div>
					</div>
	
<script type="text/javascript">var contextPath = '${pageContext.request.contextPath}';</script>
<script src="${pageContext.request.contextPath}/resources/js/spectacles.js"></script>

<jsp:include page="../layout/footer.jsp" />      
	      