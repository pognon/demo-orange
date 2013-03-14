<!DOCTYPE html>
<%@ include file="/taglibs.jsp"%>
<html lang="en">
<head>
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Test</title>

<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>



<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/css/bootstrap/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/css/bootstrap/bootstrap-responsive.min.css'/>" />

</head>

<body>

	<!-- =================== Body container ======================= -->
	<div class="container-fluid">

      <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="input-block-level" placeholder="Email address">
        <input type="password" class="input-block-level" placeholder="Password">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
      </form>

	</div>



	<!-- =================== Scripts ======================= -->
	<!-- 
	<script src="<c:url value='/js/jquery/jquery-1.8.2.js'/>" /></script>
	<script src="<c:url value='/js/bootstrap/bootstrap.min.js'/>" /></script>
	<script src="<c:url value='/js/bootstrap/bootstrap.js'/>" /></script>
	 -->
</body>

</html>