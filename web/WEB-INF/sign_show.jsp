<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title></title>
 <!-- Bootstrap core CSS -->
 <link href="dist/css/bootstrap.min.css" rel="stylesheet">
 <!-- Bootstrap theme -->
 <link href="dist/css/bootstrap-theme.min.css" rel="stylesheet">
 <!--DIY-->
 <link href="dist/css/theme.css" rel="stylesheet">

</head>
<body>
  <nav class="navbar navbar-inverse">
   <div class="container">
     <div class="navbar-header">
       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse" aria-expanded="false" aria-controls="navbar">
         <span class="sr-only">Toggle navigation</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
       </button>
       <a class="navbar-brand" href="#">Wanglinzhizhi OS</a>
     </div>
     <div id="navbar" class="navbar-collapse collapse">
       <form class="navbar-form navbar-right" action="signin">
         <div class="form-group">
           <input type="text" placeholder="Email" class="form-control">
         </div>
         <div class="form-group">
           <input type="password" placeholder="Password" class="form-control">
         </div>
         <button type="submit" class="btn btn-success">Sign in</button>
       </form>
     </div><!--/.navbar-collapse -->
   </div>
  </nav>
  <!-- main body -->
  <div class="container theme-showcase" role="main">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide">
            <div class="container">
              <div class="carousel-caption">
                <h1>主 页 展 示</h1>
                <p>Note: 这是快捷入口，进入不同的页面 进行选择.
                  可以通过以下的按钮直接进入选课页面和成绩查询页面，也可以进入留言页面和联系我们页面</p>
                  <p>还可以进入bug报告页面并且可以@我们by Email，以及可以在那个页面找到我们的联系方式。我也知道我好罗素不过我现在只是想凑字数。</p>
                  <p><a class="btn btn-lg btn-primary" href="signin.jsp" role="button">Sign up Now</a></p>
                </div>
              </div>
          </div>

          <div class="item">
            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAGZmZgAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
            <div class="container">
              <div class="carousel-caption">
                <h1>成绩查询模块</h1>
                <p>通过点击下方的按钮，便可以进入成绩查询单元，愿你取得好成绩。</p>
                <br><br><br><br>
                <p><a class="btn btn-lg btn-primary" href="checkGrade.jsp" role="button">成绩查询</a></p>
              </div>
            </div>
          </div>

          <div class="item">
            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAFVVVQAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
            <div class="carousel-caption">
              <h1>选课模块</h1>
              <p>点击下方的按钮便可直接进入选课单元，祝您选到满意的课。</p>
              <br><br><br><br>
              <p><a class="btn btn-lg btn-primary" href="chooseClass.jsp" role="button">选课模块</a></p>
            </div>
          </div>
      </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
    </div><!-- /.carousel -->

  </div>
  
  <!-- footer -->
  <footer class="footer">
    <div class="container">
      <p class="text-muted">copyright 2014-2015 wanglinzhizhi.</p>
    </div>
  </footer>



  	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="dist/js/jquery-2.1.3.js"></script>

    <script src="dist/js/bootstrap.min.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="assets/js/ie10-viewport-bug-workaround.js"></script>

  </body>
  </html>