<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">list category</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <!-- /.box-header -->
             <% if (session.getAttribute("loggedInUser") != null) { %>
            <div class="box-body">
              <div class="table-responsive">
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th>Category ID</th>
                    <th>Category Name</th>
                    <th>Delete</th>
                    <th>Update</th>
                  </tr>
                  </thead>
                  <tbody>
            		
	            			<c:forEach items="${cat }" var="c">
	                  			<tr>
				                    <td>${c.catId }</td>
				                    <td>${c.catName }</td>
				                    <td><a onclick="return confirm('bạn chắc chắn muốn xóa không')" href="deleteCategory?id=${c.catId}" class="label label-danger">Xóa</a></td>
				                    <td><a href="editCategory?id=${c.catId}" class="label label-success">Sửa</a></td>
	                  			</tr>
	                  		</c:forEach>
            		
           
                  </tbody>
                </table>
              </div>
              <!-- /.table-responsive -->
            </div>
             <% } %>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-left">Place New Order</a>
              <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-right">View All Orders</a>
            </div>
            <!-- /.box-footer -->
          </div>
</body>
</html>