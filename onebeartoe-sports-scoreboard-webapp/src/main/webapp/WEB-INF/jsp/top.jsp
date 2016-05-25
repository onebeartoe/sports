<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

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
