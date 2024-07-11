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
                <h3 class="box-title">Create a Category</h3>
              </div>
              <!-- form start -->
              <% if (session.getAttribute("loggedInUser") != null) { %>
              <f:form role="form" modelAttribute="cat" action="saveCategory" method="post">
                <div class="box-body">
		            <div class="form-group">
			            <label for="exampleInputEmail1"> Name</label>
			            <f:input path="catName" type="text" class="form-control" placeholder="Enter name" />
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