<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V19</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath }/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<!-- <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css"> -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css/">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
				<form class="login100-form validate-form" name="form1" method="post" action="loginPOST.do">
					<span class="login100-form-title p-b-33">
						Account Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid Id is required">
						<input class="input100" type="text" name="userId" placeholder="Id">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="userPw" placeholder="Password">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="container-login100-form-btn m-t-20">
						<button class="login100-form-btn">
							Sign in
						</button>
					</div>

					<div class="text-center p-t-45 p-b-4">
						<span class="txt1">
							Forgot
						</span>

						<a href="#" class="txt2 hov1">
							Username / Password?
						</a>
					</div>

					<div class="text-center">
						<span class="txt1">
							Create an account?
						</span>

						<a href="write.do" class="txt2 hov1">
							Sign up
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
<!--===============================================================================================-->
	<!-- <script src="vendor/jquery/jquery-3.2.1.min.js"></script> -->
	<script src="<c:url value="/resources/vendor/jquery/jquery.3.2.1.min.js" />"></script>
<!--===============================================================================================-->
	<!-- <script src="vendor/animsition/js/animsition.min.js"></script> -->
	<script src="<c:url value="/resources/vendor/animsition/js/animsition.min.js" />"></script>
<!--===============================================================================================-->
	<!-- <script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>-->
	<script src="<c:url value="/resources/vendor/bootstrap/js/popper.js" />"></script>
	<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script src="<c:url value="/resources/vendor/select2/select2.min.js" />"></script>
<!--===============================================================================================-->
<!-- 	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script> -->
	<script src="<c:url value="/resources/vendor/daterangepicker/moment.min.js" />"></script>
	<script src="<c:url value="/resources/vendor/daterangepicker/daterangepicker.js" />"></script>
<!--===============================================================================================-->
	<!-- <script src="vendor/countdowntime/countdowntime.js"></script> -->
	<script src="<c:url value="/resources/vendor/countdowntime/countdowntime.js" />"></script>
<!--===============================================================================================-->
	<!-- <script src="js/main.js"></script> -->
	<scirpt src="<c:url value="/resources/js/main.js"/>"></scirpt>

</body>
</html>