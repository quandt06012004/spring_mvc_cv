<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="session"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="${contextPath}/resources/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="${contextPath}/resources/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="${contextPath}/resources/dist/css/skins/skin-blue.min.css">
  
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
	  <!-- Main Header -->
	  <header class="main-header">
	
	    <!-- Logo -->
	    <a href="index2.html" class="logo">
	      <!-- mini logo for sidebar mini 50x50 pixels -->
	      <span class="logo-mini"><b>A</b>LT</span>
	      <!-- logo for regular state and mobile devices -->
	      <span class="logo-lg"><b>Admin</b>LTE</span>
	    </a>
	
	    <!-- Header Navbar -->
	    <nav class="navbar navbar-static-top" role="navigation">
	      <!-- Sidebar toggle button-->
	      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
	        <span class="sr-only">Toggle navigation</span>
	      </a>
	      <!-- Navbar Right Menu -->
	      <div class="navbar-custom-menu">
	        <ul class="nav navbar-nav">
	          <!-- Messages: style can be found in dropdown.less-->
	          <li class="dropdown messages-menu">
	            <!-- Menu toggle button -->
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	              <i class="fa fa-envelope-o"></i>
	              <span class="label label-success">4</span>
	            </a>
	            <ul class="dropdown-menu">
	              <li class="header">You have 4 messages</li>
	              <li>
	                <!-- inner menu: contains the messages -->
	                <ul class="menu">
	                  <li><!-- start message -->
	                    <a href="#">
	                      <div class="pull-left">
	                        <!-- User Image -->
	                        <img src="resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
	                      </div>
	                      <!-- Message title and timestamp -->
	                      <h4>
	                        Support Team
	                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
	                      </h4>
	                      <!-- The message -->
	                      <p>Why not buy a new awesome theme?</p>
	                    </a>
	                  </li>
	                  <!-- end message -->
	                </ul>
	                <!-- /.menu -->
	              </li>
	              <li class="footer"><a href="#">See All Messages</a></li>
	            </ul>
	          </li>
	          <!-- /.messages-menu -->
	
	          <!-- Notifications Menu -->
	          <li class="dropdown notifications-menu">
	            <!-- Menu toggle button -->
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	              <i class="fa fa-bell-o"></i>
	              <span class="label label-warning">10</span>
	            </a>
	            <ul class="dropdown-menu">
	              <li class="header">You have 10 notifications</li>
	              <li>
	                <!-- Inner Menu: contains the notifications -->
	                <ul class="menu">
	                  <li><!-- start notification -->
	                    <a href="#">
	                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
	                    </a>
	                  </li>
	                  <!-- end notification -->
	                </ul>
	              </li>
	              <li class="footer"><a href="#">View all</a></li>
	            </ul>
	          </li>
	          <!-- Tasks Menu -->
	          <li class="dropdown tasks-menu">
	            <!-- Menu Toggle Button -->
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	              <i class="fa fa-flag-o"></i>
	              <span class="label label-danger">9</span>
	            </a>
	            <ul class="dropdown-menu">
	              <li class="header">You have 9 tasks</li>
	              <li>
	                <!-- Inner menu: contains the tasks -->
	                <ul class="menu">
	                  <li><!-- Task item -->
	                    <a href="#">
	                      <!-- Task title and progress text -->
	                      <h3>
	                        Design some buttons
	                        <small class="pull-right">20%</small>
	                      </h3>
	                      <!-- The progress bar -->
	                      <div class="progress xs">
	                        <!-- Change the css width attribute to simulate progress -->
	                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
	                          <span class="sr-only">20% Complete</span>
	                        </div>
	                      </div>
	                    </a>
	                  </li>
	                  <!-- end task item -->
	                </ul>
	              </li>
	              <li class="footer">
	                <a href="#">View all tasks</a>
	              </li>
	            </ul>
	          </li>
	          <!-- User Account Menu -->
	          <li class="dropdown user user-menu">

	           <% if (session.getAttribute("loggedInUser") != null) { %>
<!-- 	            Menu Toggle Button -->
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
<!-- 	              The user image in the navbar -->
	              <img src="${contextPath}/${user.avatar}" class="user-image" alt="User Image">
<!-- 	              hidden-xs hides the username on small devices so only the image appears. -->
	              <span class="hidden-xs">${user.fullName}</span>
	            </a>
	            <ul class="dropdown-menu">
<!-- 	              The user image in the menu -->
	              <li class="user-header">
	                <img src="${contextPath}/${user.avatar}" class="img-circle" alt="User Image">
	                <p>
	                  Alexander Pierce - Web Developer
	                  <small>Member since Nov. 2012</small>
	                </p>
	              </li>
<!-- 	              Menu Body -->
	              <li class="user-body">
	                <div class="row">
	                  <div class="col-xs-4 text-center">
	                    <a href="#">Followers</a>
	                  </div>
	                  <div class="col-xs-4 text-center">
	                    <a href="#">Sales</a>
	                  </div>
	                  <div class="col-xs-4 text-center">
	                    <a href="#">Friends</a>
	                  </div>
	                </div>
	                /.row
	              </li>
<!-- 	              Menu Footer -->
	              <li class="user-footer">
	                <div class="pull-left">
	                  <a href="login" class="btn btn-default btn-flat">đăng nhập</a>
	                </div>
	                <div class="pull-right">
	                  <a href="logout" class="btn btn-default btn-flat">đăng xuất</a>
	                </div>
	              </li>
	            </ul>
	             <% } else { %>
	             <!-- 	          đăng ký -->
	          		<div class="row" style="margin-top: 10px">
	          			<a href="login" class="btn btn-primary">đăng nhập</a>
	          			<a href="insert" class="btn btn-success">đăng ký</a>
	          		</div>
	            <% } %>
	          </li>
	          <!-- Control Sidebar Toggle Button -->
	          <li>
	            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
	          </li>
	        </ul>
	      </div>
	    </nav>
	  </header>
	  <!-- Left side column. contains the logo and sidebar -->
	  <aside class="main-sidebar">
	
	    <!-- sidebar: style can be found in sidebar.less -->
	    <section class="sidebar">
	
	      <!-- Sidebar user panel (optional) -->
	      <div class="user-panel">
	        <div class="pull-left image">
	          <img src="resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
	        </div>
	        <div class="pull-left info">
	          <p>HỒ SỸ QUÂN ĐỀ 02</p>
	          <!-- Status -->
	          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
	        </div>
	      </div>
	
	      <!-- search form (Optional) -->
	      <form action="#" method="get" class="sidebar-form">
	        <div class="input-group">
	          <input type="text" name="q" class="form-control" placeholder="Search...">
	              <span class="input-group-btn">
	                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
	                </button>
	              </span>
	        </div>
	      </form>
	      <!-- /.search form -->
	
	      <!-- Sidebar Menu -->
	      <ul class="sidebar-menu">
	        <li class="header">HEADER</li>
	        <!-- Optionally, you can add icons to the links -->
	        <li class="active"><a href="#"><i class="fa fa-link"></i> <span>list</span></a></li>
	        <li><a href="#"><i class="fa fa-link"></i> <span>demo</span></a></li>
	        <li class="treeview">
	          <a href="#"><i class="fa fa-link"></i> <span>Categories</span> <i class="fa fa-angle-left pull-right"></i></a>
	          <ul class="treeview-menu">
	            <li><a href="showCategory">list categories</a></li>
	            <li><a href="insetCategories">insert categories</a></li>
	          </ul>
	        </li>
	         <li class="treeview">
	          <a href="#"><i class="fa fa-link"></i> <span>Product</span> <i class="fa fa-angle-left pull-right"></i></a>
	          <ul class="treeview-menu">
	            <li><a href="listProducts">list product</a></li>
	            <li><a href="initInsertProduct">insert product</a></li>
	          </ul>
	        </li>
	        <li class="treeview">
	          <a href="#"><i class="fa fa-link"></i> <span>Customers</span> <i class="fa fa-angle-left pull-right"></i></a>
	          <ul class="treeview-menu">
	            <li><a href="showcustomer">list Customers</a></li>
	            <li><a href="insetCustomer">insert Customers</a></li>
	          </ul>
	        </li>
	         <li class="treeview">
	          <a href="#"><i class="fa fa-link"></i> <span>Invoices</span> <i class="fa fa-angle-left pull-right"></i></a>
	          <ul class="treeview-menu">
	            <li><a href="listInvoices">list Invoices</a></li>
	            <li><a href="initInsertInvoices">insert Invoices</a></li>
	          </ul>
	        </li>
	      </ul>
	      <!-- /.sidebar-menu -->
	    </section>
	    <!-- /.sidebar -->
	  </aside>
	<!-- 	NỘI DUNG  -->
	  <div class="content-wrapper">
		<c:if test="${!empty page}">
			<jsp:include page="Admin/${page}.jsp"></jsp:include>
		</c:if> 	
	  </div>
	  <!-- /.content-wrapper -->
	
	  <!-- Main Footer -->
	  <footer class="main-footer">
	    <!-- To the right -->
	    <div class="pull-right hidden-xs">
	      Anything you want
	    </div>
	    <!-- Default to the left -->
	    <strong>Copyright &copy; 2015 <a href="#">Company</a>.</strong> All rights reserved.
	  </footer>
	
	  <!-- Control Sidebar -->
	  <aside class="control-sidebar control-sidebar-dark">
	    <!-- Create the tabs -->
	    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
	      <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
	      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
	    </ul>
	    <!-- Tab panes -->
	    <div class="tab-content">
	      <!-- Home tab content -->
	      <div class="tab-pane active" id="control-sidebar-home-tab">
	        <h3 class="control-sidebar-heading">Recent Activity</h3>
	        <ul class="control-sidebar-menu">
	          <li>
	            <a href="javascript::;">
	              <i class="menu-icon fa fa-birthday-cake bg-red"></i>
	
	              <div class="menu-info">
	                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
	
	                <p>Will be 23 on April 24th</p>
	              </div>
	            </a>
	          </li>
	        </ul>
	        <!-- /.control-sidebar-menu -->
	
	        <h3 class="control-sidebar-heading">Tasks Progress</h3>
	        <ul class="control-sidebar-menu">
	          <li>
	            <a href="javascript::;">
	              <h4 class="control-sidebar-subheading">
	                Custom Template Design
	                <span class="label label-danger pull-right">70%</span>
	              </h4>
	
	              <div class="progress progress-xxs">
	                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
	              </div>
	            </a>
	          </li>
	        </ul>
	      </div>
	      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
	      <div class="tab-pane" id="control-sidebar-settings-tab">
	        <form method="post">
	          <h3 class="control-sidebar-heading">General Settings</h3>
	          <div class="form-group">
	            <label class="control-sidebar-subheading">
	              Report panel usage
	              <input type="checkbox" class="pull-right" checked>
	            </label>
	
	            <p>
	              Some information about this general settings option
	            </p>
	          </div>
	          <!-- /.form-group -->
	        </form>
	      </div>
	      <!-- /.tab-pane -->
	    </div>
	  </aside>
	  <div class="control-sidebar-bg"></div>
	</div>
<!-- jQuery 2.2.0 -->
<script src="${contextPath}/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="${contextPath}/resources/dist/js/app.min.js"></script>
</body>
</html>