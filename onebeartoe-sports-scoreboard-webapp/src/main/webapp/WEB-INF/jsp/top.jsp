<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

	<head>
		
		<meta name="keywords" content="<%= keywords %>">
	
		<meta name="description" content="onebeartoe.org aims to provide articles and code examples">

<%--	
		<link rel="stylesheet" type="text/css" href="http://www.onebeartoe.com/css/andorid-apps/layout.css" />
		<link rel="stylesheet" type="text/css" href="http://www.onebeartoe.com/css/android-apps/style.css" />
--%>		
                <link rel="stylesheet" type="text/css" href="http://electronics.onebeartoe.org/css/layout.css" />
                <link rel="stylesheet" type="text/css" href="http://electronics.onebeartoe.org/css/style.css" />
<%--
	for(CssLinkTag cssLinkTag : cssLinkTags)
	{
		out.println(  cssLinkTag.toString() );
		out.println();
		
	}
--%>	
		
		<title><%= title %></title>
	
	</head>

	<body>

<% if ( showAd ) { %>

     <fieldset class="android">
		<legend class="android">Sponsor</legend>        
	    <helper:GoogleAdsenseCode />
	</fieldset>

<%} else {%>


<%} %>

<helper:GoogleAnalyticsCode />
