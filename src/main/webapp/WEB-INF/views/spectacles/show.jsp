<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../layout/header.jsp" />

			<div class="page-header">
				<h2>${spectacle.nom}</h2>
				<p>${spectacle.description}</p>
			</div>

			<img class="img-rounded img-responsive" src="${pageContext.request.contextPath}/resources/img/${spectacle.imagePath}">
  			
	      		<h3>Représentations</h3>
	      		<table class="table table-striped table-hover">
	      			<thead>
	      				<tr>
	      					<th>Date</th>
	      					<th>Lieu</th>
	      					<th></th>
	      				</tr>
	      			</thead>
	      			<tbody>
						<c:forEach items="${spectacle.representations}" var="representation">     
	      					<tr>
		      					<td class="vert-align">${representation.date}</td>
		      					<td class="vert-align">${representation.lieu}</td>
		      					<td class="vert-align"><a href="/spectacles/${spectacle.id}/representations/${representation.id}" class="btn btn-primary pull-right">Voir &rarr;</a></td>
		      				</tr>
						</c:forEach>
					</tbody>
	      		</table>
	      		<a href="${pageContext.request.contextPath}/spectacles" class="spacer-bottom btn btn-default " role="button"><span class="glyphicon glyphicon-arrow-left"></span> Choisir un autre spectacle</a>
<jsp:include page="../layout/footer.jsp" />      
	      