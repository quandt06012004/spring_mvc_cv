<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert product</title>
<script src="${pageContext.servletContext.contextPath}/resources/ckeditor/ckeditor.js"></script>
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
                <h3 class="box-title">Update product</h3>
              </div>
              <!-- form start -->
              <f:form role="form" modelAttribute="pro" action="editProduct" method="post" enctype="multipart/form-data">
                <div class="box-body">
                  <div class="form-group">
			            <label for="exampleInputEmail1">Product ID</label>
			            <f:input path="proId" type="text" class="form-control" placeholder="Enter Id product" />
			            <f:errors cssClass= "error" path="proId"></f:errors>
		          </div>
		          <div class="form-group">
			            <label for="exampleInputEmail1">Product Name</label>
			            <f:input path="proName" type="text" class="form-control" placeholder="Enter name product" />
			            <f:errors cssClass= "error" path="proName"></f:errors>
		          </div>
	          	  <div class="form-group">
		            <label for="exampleInputEmail1">categories</label>
		            <f:select path="cat.catId" >
		            	<f:option value="0">---------choose---------</f:option>
		            	<f:options items="${c}" itemLabel="catName" itemValue="catId" />
		            </f:select>
<%-- 		             <f:errors cssClass= "error" path="cat.catId"></f:errors> --%>
			      </div>
		          <div class="form-group">
		            <label for="exampleInputEmail1">price</label>
		            <f:input path="price" type="text" class="form-control" placeholder="Enter price" />
		            <f:errors cssClass= "error" path="price"></f:errors>
		          </div>
		          <div class="form-group">
		            <label for="exampleInputEmail1">quantity</label>
		            <f:input path="quantity" type="text" class="form-control" placeholder="Enter quantity" />
		            <f:errors cssClass= "error" path="quantity"></f:errors>
		          </div>
		          <div class="form-group">
		            <label for="exampleInputEmail1">Create Date</label>
		            <f:input path="creDate" type="date" class="form-control" placeholder="Enter creDate" />
		            <f:errors cssClass= "error" path="creDate"></f:errors>
		          </div>
                  
                  <div class="form-group">
		            <label for="exampleInputFile">Image</label>
		            <input type="file" name="img" id="exampleInputFile">
		            <p class="help-block">Example block-level help text here.</p>
		          </div>
		          <div class="form-group">
		            <label for="exampleInputEmail1">describe</label>
		            <f:textarea path="describe"/>
		            <f:errors cssClass= "error" path="describe"></f:errors>
		          </div>
		           
                </div>
                <div class="box-footer">
                  <button type="submit" class="btn btn-primary">Update</button>
                </div>
              </f:form>
            </div>
          </div>
    </section>
<script>
CKEDITOR.replace('describe')
</script>
</body>
</html>