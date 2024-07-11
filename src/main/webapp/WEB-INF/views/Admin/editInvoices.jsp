<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert product</title>
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
                <h3 class="box-title">insert invoices</h3>
              </div>
              <!-- form start -->
              <% if (session.getAttribute("loggedInUser") != null) { %>
              
              <f:form role="form" modelAttribute="in" action="updateInvoices" method="post">
                <div class="box-body">
                  <div class="form-group">
		            <label for="exampleInputEmail1">ID</label>
		            <f:input path="inId" type="text" class="form-control" placeholder="Enter ID" />
		            <f:errors cssClass= "error" path="inId"></f:errors>
		          </div>
	          	  <div class="form-group">
		            <label for="exampleInputEmail1">Customer</label>
		            <f:select path="cust.cusId" id= "cust.cusId">
		            	<f:option value="0">---------choose---------</f:option>
		            	<f:options items="${cus}" itemLabel="cusName" itemValue="cusId"/>
		            </f:select>
			      </div>
		          <div class="form-group">
		            <label for="exampleInputEmail1">total</label>
		            <f:input path="total" type="text" class="form-control" placeholder="Enter quantity" />
		            <f:errors cssClass= "error" path="total"></f:errors>
		          </div>
		          <div class="form-group">
		            <label for="exampleInputEmail1">Date</label>
		            <f:input path="inDate" type="date" class="form-control" placeholder="Enter creDate" />
		            <f:errors cssClass= "error" path="inDate"></f:errors>
		          </div>
                </div>
                <div class="box-footer">
                  <button type="submit" class="btn btn-primary">insert</button>
                </div>
              </f:form>
              <% } %>
            </div>
          </div>
    </section>

</body>
</html>