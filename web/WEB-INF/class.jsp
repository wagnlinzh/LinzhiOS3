<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" autoFlush="true" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <!-- Standard Meta -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

	
	<title></title>
	<!-- Bootstrap core CSS -->
  <link href="dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- semantic CSS -->
  <link href="dist/css/semantic.min.css" rel="stylesheet">
  
  <!-- simplemodal CSS -->
  <link type='text/css' href='dist/css/basic.css' rel='stylesheet' />
  <link type='text/css' href='dist/css/box.css' rel='stylesheet' />

  <!--DIY-->
  <link href="dist/css/theme.css" rel="stylesheet">



</head>
<body>

  <div class="demo container">

	   
    <div class="container theme-showcase" role="main">

       <!-- Main jumbotron for a primary marketing message or call to action -->



      <div class="jumbotron" id="classes">
        <p>Now Time:<%=session.getAttribute("classTime")%> 。</p>
        <p><%= request.getParameter("classTime")%></p>
      </div>

      <!-- Form -->
      <div class="ui form segment">
        <label>请选择您所喜欢的课程</label>
          <div class="field">
            <div class="ui selection dropdown" tabindex="0">
              <div class="default text">Select</div>
              <i class="dropdown icon"></i>
              <input type="hidden" name="hidden-field">
              <div class="menu" tabindex="-1">
                <div data-value="1" class="item">高等数学</div>
                <div data-value="2" class="item">线性代数</div>
                <div data-value="3" class="item"> 概率论 </div>
                <div data-value="4" class="item">数据结构</div>
                <div data-value="5" class="item">计算机组成原理</div>
                <div data-value="6" class="item">计算机网络</div>
                <div data-value="7" class="item">操作系统</div>
                <div data-value="8" class="item">英 语</div>
                <div data-value="9" class="item">政 治</div>
              </div>
            </div>
            <div class="ui blue button">submit</div>

        </div>  
      </div>


      <!-- 课程已选择情况汇总表 -->
      <table class="ui celled striped table">
          <thead>
              <tr>
                <th class="disabled">课程名称</th>
                <th class="disabled">可容纳总人数（人）</th>
                <th class="disabled">已报名人数（人）</th>
              </tr>

          </thead>
          <tbody>
            <tr  class="warning">
              <td>
                <i class="tag icon"></i> 高等数学
                <i class="attention icon"></i>

              </td>
              <td>90</td>
              <td class="right aligned collapsing">90</td>
            </tr>
            <tr>
              <td>
                <i class="tag icon"></i> 线性代数
              </td>
            <td>30</td>
              <td class="right aligned">30</td>
            </tr>
            <tr class="positive">
              <td>
              <i class="tag icon"></i> 概率论
              <i class="smile icon"></i>
              </td>
            <td>20</td>
            <td class="right aligned">20</td>
            </tr>
            <tr>
              <td class="collapsing">
              <i class="tag icon"></i> 英语
              </td>
              <td>100</td>
              <td class="right aligned">100</td>
            </tr>
            <tr class="negative">
              <td>
              <i class="tag icon"></i> 政治
              <i class="frown icon"></i>
              </td>

              <td>100</td>
              <td class="right aligned">100</td>
            </tr>
            <tr>
              <td>
              <i class="tag icon"></i> 数据结构
              </td>
              <td>40</td>
              <td class="right aligned">40</td>
            </tr>
            
            <tr class="positive">
              <td>
              <i class="tag icon"></i> 操作系统
              <i class="smile icon"></i>
              </td>
              <td>30</td>
              <td class="right aligned">30</td>
            </tr>

            <tr>
              <td class="collapsing">
              <i class="tag icon"></i> 计算机组成原理
              </td>
              <td>40</td>
              <td class="right aligned">40</td>
            </tr>

            <tr class="positive">
              <td>
              <i class="tag icon"></i> 计算机网络
              <i class="smile icon"></i>
              </td>
              <td>20</td>
              <td class="right aligned">20</td>
            </tr>
          </tbody>
      </table>


    </div>
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

    <script src="dist/js/semantic.min.js"></script>




    <!-- SimpleModal and Basic JS files -->
    <script type='text/javascript' src='dist/js/jquery.simplemodal.js'></script>


    <script type="text/javascript">
          $(document).ready(function(){
              $('.ui.dropdown').dropdown();
              $('.ui.menu .dropdown').dropdown({
                on: 'hover'
              });
            });
    </script>

    <!-- 提交按钮 -->
    <script type="text/javascript">
      var $submitBtn=$(".ui.blue.button");
      $submitBtn.click(function(){
            var $className=$(".text").text();
            if ($className=="Select") {
                $.modal('<div><h1>SORRY！提交无效！</h1><p>请先选定课程之后 再提交</p></div>',{
                "overlayClose":true
              });
            }else{
                //将课程名的数据传到chooseClass.jsp页面
                <%
                    System.out.println(session.getAttribute("className"));
                %>

                $.modal('<div><h1>Good Luck! '+$className+'</h1><p></p><p>所选择的课程已提交!</p></div>',
                        {"overlayClose":true});


                // var url="chooseClass.jsp"
                //   window.open(encodeURI(url+"?$className="+$className));

            }
        });

      $submitBtn.click(function(){
        setTimeout(function(){
          $.modal.close()
        },2000);
      });

    </script>



    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="assets/js/ie10-viewport-bug-workaround.js"></script>

   
    
</body>
</html>
