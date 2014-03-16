<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ets.gti525.tp2.Panier" %>
<%@ page session="true" %>

<%
String section = (String)request.getAttribute("section");
%>
    
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">

	    <title>BillETS - Achat de billets en ligne</title>

	    <!-- Bootstrap core CSS -->

	    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">


	    <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
	  	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

	    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	    <![endif]-->
	  <style>.pkt_added {text-decoration:none !important;}</style><style type="text/css"></style>
	</head>
	<body style="">
	
		<%
		
		// Obtenir le nombre de billets dans le panier
		Panier panier = (Panier)request.getSession().getAttribute("panier");
		int nbBillets = 0;
		
		if (panier != null)
		{
			nbBillets = panier.getLignesPanier().size();
		}
		%>

	    <div class="container">
	      <div class="header">
	        <ul class="nav nav-pills pull-right">
	           	<li <% if (section.equals("Accueil")) {out.print("class=\"active\"");}%>><a href="${pageContext.request.contextPath}/">Accueil</a></li>
	           	<li <% if (section.equals("Spectacles")) {out.print("class=\"active\"");}%>><a href="${pageContext.request.contextPath}/spectacles">Spectacles</a></li> 
	           	<li <% if (section.equals("Panier")) {out.print("class=\"active\"");}%>><a href="${pageContext.request.contextPath}/panier">Panier<span class="badge pull-right"><%= nbBillets %></span></a></li>
	        </ul>
	        <h1 class="text-muted">BillETS</h1>
	      </div>