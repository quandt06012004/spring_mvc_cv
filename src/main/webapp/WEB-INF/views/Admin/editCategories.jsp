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
                <h3 class="box-title">Update Category</h3>
                <span style="color: red">${error}</span>
              </div>
              <!-- form start -->
              <f:form role="form" modelAttribute="cat" action="UpdateCategory" method="post">
                <div class="box-body">
		            <div class="form-group">
			            <label for="exampleInputEmail1"> ID</label>
			            <f:input path="catId" type="text" class="form-control" placeholder="Enter Id" />
		          	</div>
		          	  <div class="form-group">
			            <label for="exampleInputEmail1"> Name</label>
			            <f:input path="catName" type="text" class="form-control" placeholder="Enter name" />
		          	</div>
                </div>
                <!-- /.box-body -->

                <div class="box-footer">
                  <button type="submit" class="btn btn-primary">Update</button>
                </div>
              </f:form>
            </div>
          </div>
    </section>
</body>
</html>