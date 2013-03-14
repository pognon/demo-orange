<!DOCTYPE html>
<%@include file="/taglibs.jsp" %>

<!--[if IEMobile 7 ]>    <html class="no-js iem7"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title><decorator:title /> | BCA Mobile App</title>
<meta name="description" content="">
<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">
<meta name="viewport" content="width=device-width">
<meta http-equiv="cleartype" content="on">


<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<c:url value='/img/touch/apple-touch-icon-144x144-precomposed.png'/>" />

<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<c:url value='/img/touch/apple-touch-icon-114x114-precomposed.png'/>" />
	
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<c:url value='/img/touch/apple-touch-icon-72x72-precomposed.png'/>" />
	
<link rel="apple-touch-icon-precomposed"
	href="<c:url value='/img/touch/apple-touch-icon-57x57-precomposed.png'/>" />
	
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


<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/css/bootstrap/bootstrap.min.css'/>" />

<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/css/bootstrap/bootstrap-responsive.min.css'/>" />
 
 
 <!-- 
 <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.1/css/bootstrap-combined.min.css" rel="stylesheet">
  -->
  
  	
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/css/bca.css'/>" />
	
		<!--  
        <link rel="stylesheet" href="<c:url value='/css/normalize.css'/>" />
        <link rel="stylesheet" href="<c:url value='/css/main.css'/>" />
        <script src="<c:url value='/js/vendor/modernizr-2.6.1.min.js'/>" /></script>
         -->
	
	
</head>

<body>

	<!-- =================== Navigation Bar ======================= -->


	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<!-- .btn-navbar is used as the toggle for collapsed navbar content -->
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse" > 
					<span>Menu</span>
					<!-- 
					<span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
					 -->
				</a> 
				
				<a class="brand" href=""><img alt=""
					src=<c:url value='/img/logo.png'/> /></a>
				<div class="nav-collapse">
					<!-- .nav, .navbar-search, .navbar-form, etc -->
					<ul class="nav">
						<li><a href="./missions" title="Home"><span>Missions</span></a></li>
						<li><a href="./missions" title="Home"><span>Missions</span></a></li>
						<li><a href="./missions" title="Home"><span>Missions</span></a></li>
						<li><a href="./missions" title="Home"><span>Missions</span></a></li>
						<li><a href="./missions" title="Home"><span>Missions</span></a></li>
					</ul>
					<p class="navbar-text pull-right">
						<a href="./login" htmlEscape="true" />Login</a>
					</p>
				</div>
			</div>
		</div>
	</div>


	<!-- Add your site or application content here -->

	<decorator:body />
	
	
	

	<!-- =================== Footer ======================= -->
	
	<footer class="footer">
		<div class="container">
			<p>
				Designed and built with all the love in the world <a
					href="http://twitter.com/twitter" target="_blank">@twitter</a> by <a
					href="http://twitter.com/mdo" target="_blank">@mdo</a> and <a
					href="http://twitter.com/fat" target="_blank">@fat</a>.
			</p>
		</div>
	</footer>
	 


	<!-- External Scripts -->
	
	<%--
	<script type="text/javascript" src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	
	<script src="<c:url value='http://ajax.cdnjs.com/ajax/libs/zepto/1.0rc1/zepto.min.js'/>" /></script>
	<script src="<c:url value='http://ajax.cdnjs.com/ajax/libs/jquery/1.8.2/jquery.min.js'/>" /></script> 
	<script src="http://ajax.cdnjs.com/ajax/libs/twitter-bootstrap/2.2.1/bootstrap.min.js"></script>
	 --%>
	 
	<!-- Internal Scripts -->
	<script type="text/javascript" src="<c:url value='/js/html5.js'/>" /></script>
	<script type="text/javascript" src="<c:url value='/js/vendor/zepto.min.js'/>" /></script>
	<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.8.2.js'/>" /></script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap/bootstrap.min.js'/>" /></script>
	<%--
	<script src="<c:url value='/js/bootstrap/bootstrap.js'/>" /></script>
	 --%>
	<script src="<c:url value='/js/helper.js'/>" /></script>
	<script src="<c:url value='/js/main.js'/>" /></script>
	  
	<!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
	<script>
            var _gaq=[["_setAccount","UA-XXXXX-X"],["_trackPageview"]];
            (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];g.async=1;
            g.src=("https:"==location.protocol?"//ssl":"//www")+".google-analytics.com/ga.js";
            s.parentNode.insertBefore(g,s)}(document,"script"));
    </script>
    
    <script>
    	function initPage() {
    	 	console.log("initPage...");
    	 	 //$("#menuCollapse").collapse();
    	}
    	
  		$(function () {
  			console.log("Document ready....");
    		initPage();
  		})
	</script>
    
</body>
</html>
