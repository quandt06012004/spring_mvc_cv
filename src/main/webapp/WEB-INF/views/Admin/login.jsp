<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>

	<div class="container">
		<div class="box box-info">
	            <div class="box-header with-border">
	              <h3 class="box-title"><spring:message code="form_login" text="login Form"/></h3>
	            </div>
			<a class="btn btn-success" href="?lang=en_US"><spring:message code="en" text="English"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="btn btn-success" href="?lang=vi_VN"><spring:message code="vn" text="Vietnamese"/></a>
	            <!-- /.box-header -->
	            <!-- form start -->
	            <form class="form-horizontal" action="loginUsers" method="post">
	              <div class="box-body">
	                <div class="form-group">
	                  <label for="inputEmail3" id="inputEmail" class="col-sm-2 control-label"><spring:message code="email" text="Email"/></label>
	
	                  <div class="col-sm-10">
	                    <input type="email" name="email" class="form-control" id="inputEmail3" placeholder="Email">
	                  </div>
	                </div>
	                <div class="form-group">
	                  <label for="inputPassword3"  class="col-sm-2 control-label"><spring:message code="password" text="Password"/></label>
	
	                  <div class="col-sm-10">
	                    <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
	                  </div>
	                </div>
	                <div class="form-group">
	                  <div class="col-sm-offset-2 col-sm-10">
	                    <div class="checkbox">
	                      <label>
<%-- 	                      <a href="forgotUser?email=${ }" ><spring:message code="Forgot" text="Forgot password"/></a>  --%>
	                      </label>
	                    </div>
	                  </div>
	                </div>
	              </div>
	              <!-- /.box-body -->
	              <div class="box-footer">
	                <button type="submit" class="btn btn-default"><spring:message code="cancel" text="Cancel"/></button>
	                <button type="submit" class="btn btn-info pull-right"><spring:message code="sign_in" text="Sign in"/></button>
	              </div>
	              <!-- /.box-footer -->
	            </form>
	          </div>
          </div>
</body>
</html>