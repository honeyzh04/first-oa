<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.Exception"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误页面</title>
    <!-- Base Styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->


</head>
<body>
<h1>出错了</h1>
${exception.message}



  <body class="body-404">

      <section class="error-wrapper">
          <i class="icon-404"></i>
          <div class="text-center">
              <h2 class="green-bg">page not found</h2>
          </div>
          <p>Something went wrong or that page doesn’t exist yet.</p>
          <a href="index.html" class="back-btn">Back to Home</a>
      </section>

  </body>
</body>
</html>