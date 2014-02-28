<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp" />
				<!-- breadcrumbs -->
	        	<ol class="breadcrumb">
				  <li><a href="${pageContext.request.contextPath}">Accueil</a></li>
				  <li class="active">Spectacles</li>
				</ol>
    			<div class="page-header">
	      			<h2>Liste des spectacles</h2>
					<p>Voici une liste de tous les spectacles offerts par BillETS</p>
				</div>	
				
					<div class="form-group">
						<input name="spectacle_nom" type="text" class="form-control" placeholder="Rechercher">
					</div>


					<c:forEach items="${spectacles}" var="spectacle">     
					 	<div class="media">
						  <a class="pull-left" href="${pageContext.request.contextPath}/spectacles/${spectacle.value.id}">
						    <img class="media-object img-rounded" src="${pageContext.request.contextPath}/resources/img/spectacles/thumbnail/${spectacle.value.thumbnailPath}" alt="img_spectacle">
						  </a>
						  <div class="media-body">
						    <h4 class="media-heading"><a href="${pageContext.request.contextPath}/spectacles/${spectacle.value.id}">${spectacle.value.nom}</a></h4>
							<h5>${spectacle.value.artistes}</h5>
							<p>${spectacle.value.description}</p>
						  </div>
						</div>			
					</c:forEach>
					
					<ul class="pagination">
					  <li class="disabled"><a href="#">&laquo;</a></li>
					  <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					  <li class="inactive"><a href="#">2 <span class="sr-only">(current)</span></a></li>
					</ul>
	
<script type="text/javascript">var contextPath = '${pageContext.request.contextPath}';</script>
<script src="${pageContext.request.contextPath}/resources/js/spectacles.js" charset="utf-8"></script>

<jsp:include page="../layout/footer.jsp" />      
