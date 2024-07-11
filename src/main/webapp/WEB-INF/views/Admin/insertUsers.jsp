<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>đăng ký</title>
</head>
<style>

.error{color:red;}

</style>
<body>
	 <!-- Main content -->
    <section class="content">
        <!-- left column -->
        <h3 style = "color:red">${error}</h3>
        <div class="container">
          <!-- general form elements -->
            <div class="box box-primary">
              <div class="box-header with-border">
                <h3 class="box-title">đăng ký</h3>
              </div>
              <!-- form start -->
              <f:form role="form" modelAttribute="users" action="save" method="post" enctype="multipart/form-data">
                <div class="box-body">
		            <div class="form-group">
			            <label for="exampleInputEmail1">Full Name</label>
			            <f:input path="FullName" type="text" class="form-control" placeholder="Enter full name" />
			            <f:errors cssClass= "error" path="fullName"></f:errors>
		          	</div>
          			<div class="form-group">
		            <label for="exampleInputEmail1">Email address</label>
		            <f:input path="email" type="text" class="form-control" placeholder="Enter email" />
		            <f:errors cssClass= "error" path="email"></f:errors>
		          </div>
		          <div class="form-group">
		            <label for="exampleInputEmail1">Phone</label>
		            <f:input path="phone" type="text" class="form-control" placeholder="Enter phone" />
		            <f:errors cssClass= "error" path="phone"></f:errors>
		          </div>
                  
                  
                  
                  <div class="form-group">
		            <label for="exampleInputEmail1">Gender</label>
		            <br>
		            		Nam <f:radiobutton path="gender" class="form-check-input"  value="true" checked="true" />
		            		Nữ <f:radiobutton path="gender" class="form-check-input" value="false"/>
		          </div>
                  
                  <div class="form-group">
		            <label for="exampleInputFile">avatar</label>
		            <input type="file" name="images" id="exampleInputFile">
		            <p class="help-block">Example block-level help text here.</p>
		          </div>
		          
		          <div class="form-group">
		            <label for="exampleInputPassword1">Password</label>
		            <f:input path="passWord" type="text" class="form-control" placeholder="Enter password" />
		            <f:errors cssClass= "error" path="passWord"></f:errors>
		          </div>
                  
                  <div class="checkbox">
                    <label>
                      <input type="checkbox"> Check me out
                    </label>
                  </div>
                </div>
                <!-- /.box-body -->

                <div class="box-footer">
                  <button type="submit" class="btn btn-primary">đăng ký</button>
                </div>
              </f:form>
            </div>
          </div>
    </section>
</body>
</html>