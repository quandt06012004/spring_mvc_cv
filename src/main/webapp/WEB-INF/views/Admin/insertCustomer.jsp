<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<section class="content">
        <!-- left column -->
        <div class="container">
          <!-- general form elements -->
            <div class="box box-primary">
              <div class="box-header with-border">
                <h3 class="box-title">Create a Customer</h3>
              </div>
              <!-- form start -->
              <% if (session.getAttribute("loggedInUser") != null) { %>
              <f:form role="form" modelAttribute="cus" action="saveCustomer" method="post">
                <div class="box-body">
		            <div class="form-group">
			            <label for="exampleInputEmail1">Customer Name</label>
			            <f:input path="cusName" type="text" class="form-control" placeholder="Enter name" />
		          	</div>
		          	<div class="form-group">
			            <label for="exampleInputEmail1">Email</label>
			            <f:input path="email" type="email" class="form-control" placeholder="Enter email" />
		          	</div>
		          	<div class="form-group">
			            <label for="exampleInputEmail1">Phone</label>
			            <f:input path="phone" type="text" class="form-control" placeholder="Enter phone" />
		          	</div>
		          	<div class="form-group">
			            <label for="exampleInputEmail1">AddressName</label>
			            <f:input path="address" type="text" class="form-control" placeholder="Enter address" />
		          	</div>
		          	
                </div>
                <!-- /.box-body -->

                <div class="box-footer">
                  <button type="submit" class="btn btn-primary">create</button>
                </div>
              </f:form>
              <% } %>
            </div>
          </div>
    </section>
</body>
</html>