<%@ include file="/taglibs.jsp"%>

<html lang="en">
<head>
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<c:url value="/img/favicon.ico"/>" />
<title><decorator:title /> | BCA Web Application</title>
	<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>


<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/bootstrap/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/bootstrap/bootstrap-responsive.min.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/style.css'/>" />

	<decorator:head />
</head>
<body>

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="brand" href="<c:url value='/'/>">BCA Mobile Application</a>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<%@ include file="/messages.jsp"%>
		<div class="row-fluid">
			<decorator:body />
		</div>
	</div>

	<div id="footer">BCA Mobile App</div>
</body>
</html>


