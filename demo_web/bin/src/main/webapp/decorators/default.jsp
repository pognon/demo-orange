<!DOCTYPE html>
<%@ include file="/taglibs.jsp"%>

<!--[if IEMobile 7 ]>    <html class="no-js iem7"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <title><decorator:title /> | BCA Mobile App</title>
        <meta name="description" content="">
        <meta name="HandheldFriendly" content="True">
        <meta name="MobileOptimized" content="320">
        <meta name="viewport" content="width=device-width">
        <meta http-equiv="cleartype" content="on">

        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='/img/touch/apple-touch-icon-144x144-precomposed.png'/>" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value='/img/touch/apple-touch-icon-114x114-precomposed.png'/>" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value='/img/touch/apple-touch-icon-72x72-precomposed.png'/>" />
        <link rel="apple-touch-icon-precomposed" href="<c:url value='/img/touch/apple-touch-icon-57x57-precomposed.png'/>" />
        <link rel="shortcut icon" href="<c:url value='/img/touch/apple-touch-icon.png'/>" />

        <!-- For iOS web apps. Delete if not needed. https://github.com/h5bp/mobile-boilerplate/issues/94 -->
        <!--
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-title" content="">
        -->

        <!-- This script prevents links from opening in Mobile Safari. https://gist.github.com/1042026 -->
        <!--
        <script>(function(a,b,c){if(c in b&&b[c]){var d,e=a.location,f=/^(a|html)$/i;a.addEventListener("click",function(a){d=a.target;while(!f.test(d.nodeName))d=d.parentNode;"href"in d&&(d.href.indexOf("http")||~d.href.indexOf(e.host))&&(a.preventDefault(),e.href=d.href)},!1)}})(document,window.navigator,"standalone")</script>
        -->
        
         <!-- This is for twitter bootstrap includes -->
         
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/bootstrap/bootstrap.min.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/bootstrap/bootstrap-responsive.min.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/style.css'/>" />
        
		<!-- 
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/normalize.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/main.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='js/vendor/modernizr-2.6.1.min.js'/>" />
        -->
        
    </head>
    
    <body>

        <!-- Add your site or application content here -->
        
        <div id="header"></div>
        <div class="container-fluid">
		<%@ include file="/messages.jsp"%>
		<div class="row-fluid">
			<decorator:body />
		</div>
		</div>
		<div id="footer"> BCA Expertise - By Ippon Technologies</div>
		
		<!-- H5MBP Script includes -->
        <script src="<c:url value='/js/vendor/zepto.min.js'/>" /></script>
        <script src="<c:url value='/js/helper.js'/>" /></script>

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            var _gaq=[["_setAccount","UA-XXXXX-X"],["_trackPageview"]];
            (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];g.async=1;
            g.src=("https:"==location.protocol?"//ssl":"//www")+".google-analytics.com/ga.js";
            s.parentNode.insertBefore(g,s)}(document,"script"));
        </script>
    </body>
</html>