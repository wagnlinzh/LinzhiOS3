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

    <!-- semantic CSS -->
    <link href="dist/css/semantic.min.css" rel="stylesheet">

    <!--DIY-->
    <link href="dist/css/theme.css" rel="stylesheet">




</head>
<body>
    <nav class="navbar navbar-inverse">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="indexJsp.action">Wanglinzhizhi OS</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">主 页</a></li>
              <li><a href="checkGradeJsp.action">成绩查询</a></li>
              <li><a href="chooseClassJsp.action">选课系统</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">更 多<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="account.html">用户信息</a></li>
                  <li><a href="contact.html">Contact</a></li>
                  <li><a href="about.html">About</a></li>
                  <li class="divider"></li>
                  <li class="dropdown-header">系统相关</li>
                  <li><a href="#">bug报告</a></li>
                  <li><a href="#">Email to us</a></li>
                  <li><a href="signout.action">Sign out</a></li>

                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
    </nav>
	   
    <div class="container theme-showcase" role="main">

       <!-- Main jumbotron for a primary marketing message or call to action -->
     	

        <!--  快速入口 -->
      <div class="page-header" id="index-page-header">
        快速入口
      </div>
      <!-- Carousel
      ================================================== -->
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
                <h1>主 页 展示</h1>
                <p>Note: 这是快捷入口，进入不同的页面 进行选择.
                  可以通过以下的按钮直接进入选课页面和成绩查询页面，也可以进入留言页面和联系我们页面</p>
                  <p>还可以进入bug报告页面并且可以@我们by Email，以及可以在那个页面找到我们的联系方式。我也知道我好啰嗦不过我现在只是想凑字数。</p>
                  <br><br><br><br><br><br><br>
              </div>
            </div>
          </div>

          <div class="item">
            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAGZmZgAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
              <div class="container">
                <div class="carousel-caption">
                  <h1>成绩查询模块</h1>
                  <p>通过点击下方的按钮，便可以进入成绩查询单元，愿你取得好成绩。</p>
                  <br><br><br><br><br><br><br>
                  <p><a class="btn btn-lg btn-primary" href="checkGradeJsp.action" role="button">成绩查询</a></p>
                </div>
            </div>
          </div>

          <div class="item">
            <img src="data:image/gif;base64,R0lGODlhAQABAIAAAFVVVQAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
            <div class="carousel-caption">
                <h1>选课模块</h1>
                <p>点击下方的按钮便可直接进入选课单元，祝您选到满意的课。</p>
                <br><br><br><br><br><br><br>
                <p><a class="btn btn-lg btn-primary" href="chooseClassJsp.action" role="button">选课模块</a></p>
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



<!-- 
      <div class="jumbotron">

        <p>这是个人主页，介绍的主要内容是，个人成绩以及选课页面的简略信息.和各种通知信息</p>
      </div> -->



      <!-- sometips and notes -->
      <div class="page-header" id="index-page-header">
        通知 消息
      </div>


  
        <!-- warning message -->
        <div class="ui warning icon message">
          <div class="content">
          <div class="header">Warning Message</div>
            <ul class="list">
              <li>下周五有高等数学期末测试</li>
              <li>11月23日 计算机网络和计算机组成原理期末考试，分别是上午8：00-10：00，下午14：00-16：00</li>
            </ul>
          </div>
        </div>


        <!-- info message -->
        <div class="ui info message">
          <div class="header">Info Message</div>
          <p>恭喜您，英语考试您考了66分，超过平均成绩-27分！</p>
        </div>

        <!-- negative message -->
        <div class="ui icon error message">
          <i class="attention circle icon"></i>
          <div class="content">
            <div class="header">Negative Message</div>
            <p>很遗憾通知您，您的数据结构考试挂了，补考时间另行通知，请您注意关注消息通知。</p>
          </div>
        </div>




        <div class="ui warning form segment">
          <div class="ui warning message">
            <div class="header">Warning Message</div>
            <ul class="list">
              <li>高等数学课程 您1月24日作业未交，记过一次</li>
              <li>计算机操作系统老师点名未到一次，被记名一次，这是本学期的第二次记名。</li>
            </ul>
          </div>
          <a href="checkGradeJsp.action"><div class="ui blue button">成绩查询</div></a>
        </div>


        <div class="ui error form segment">
          <div class="ui error message">
            <div class="header">Error Message</div>
            <p>您还有4门选修课尚未选择，系统将于11月27日0：00分关闭，请迅速完成选课。</p>
          </div>
          <a href="chooseClassJsp.action"><div class="ui blue button">选课系统</div></a>
        </div>

        <div class="ui info message">
          <div class="header">Info Message</div>
          <p>恭喜您，ACM获得全国第一名！</p>
        </div>
        <div class="ui info message">
          <div class="header">Info Message</div>
          <p>恭喜您，获得全国大学生数学竞赛国家一等奖！</p>
        </div>
        <div class="ui info message">
          <div class="header">Info Message</div>
          <p>你未来的女朋友第一次给你留言，在你给她留言了377次之后，距离你第一次给她留言仅仅过去了3年10个月，这说明你们的关系进一步拉近了。</p>
          <br>
          <p>她的留言内容是：</p>
          <p>请你不要再来骚扰我了。</P>
          <br>
          <P>（系统无法识别这条信息是positive还是negative，这里应该是negative，即应该出现红色的Error Message 而不是info message。。。。）</p>
        </div>



    



    </div>


    <footer class="footer">
      <div class="container">
        <p class="text-muted">copyright 2014-2015 wanglinzhizhi.</p>
        <p class="text-muted">${requestScope.email} ${requestScope.password}</p>
      </div>
    </footer>
	<!-- body html -->

    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="dist/js/jquery-2.1.3.js"></script>

    <script src="dist/js/bootstrap.min.js"></script>



    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="assets/js/ie10-viewport-bug-workaround.js"></script>

	
</body>
</html>
