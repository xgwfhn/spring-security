<%@ page language="java" contentType="text/html; charset=UTF-8"  isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="http://127.0.0.1:8080/style/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="http://127.0.0.1:8080/style/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
     <security:csrfMetaTags/>
</head>
<body>

    <div class="container">

       <form class="form-signin" role="form" action="/user/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input  class="form-control" placeholder="Email address"  autofocus>
        <input type="password" class="form-control" placeholder="Password" required>
         <security:csrfInput/>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
       </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>