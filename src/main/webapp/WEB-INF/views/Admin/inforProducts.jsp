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
              <h3 class="box-title">list Product</h3>
              <br>
				<% if (session.getAttribute("loggedInUser") != null) { %>
				<form action="searchProductByName" method="GET">
					<b>Product Name: </b> <input type="text" name="proName"/> 
					<input type="submit" value="search" />
				</form>
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="table-responsive">
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>creDate</th>
                    <th>quantity</th>
                    <th>image</th>
                    <th>Delete</th>
                    <th>Update</th>
                  </tr>
                  </thead>
                  <tbody>
            		
	            			<c:forEach items="${pro }" var="p">
	                  			<tr>
				                    <td>${p.proId }</td>
				                     <td>${p.proName }</td>
				                     <td>${p.cat.catName }</td>
				                     <td>${p.price }</td>
				                     <td>${p.creDate }</td>
				                     <td>${p.quantity }</td>
				                     <td>
				                     	<img src="${pageContext.servletContext.contextPath}/${p.image }" alt="not img product" width="80" height=auto>
				                      </td>
				                    <td><a onclick="return confirm('bạn chắc chắn muốn xóa không')" href="deleteProduct?id=${p.proId}" class="label label-danger">Xóa</a></td>
				                    <td><a href="detailtProduct?id=${p.proId}" class="label label-success">Detailt</a></td>
	                  			</tr>
	                  		</c:forEach>
            		
           
                  </tbody>
                </table>
              				<nav aria-label="Page navigation example">
							  <ul class="pagination">
							    <li class="page-item">
							      <a class="page-link" href="#" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							        <span class="sr-only">Previous</span>
							      </a>
							    </li>
							    <c:if test="${not empty listPagesearch}">
									<c:forEach items="${listPagesearch }" var="page">
									    <li class="page-item"><a class="page-link" href="searchProductByName?proName=${param.proName}&page=${page }">${page }</a></li>
		             				</c:forEach>
								</c:if> 
							     <c:if test="${!empty listPage}">
									    <c:forEach items="${listPage }" var="page">
									    	<li class="page-item"><a class="page-link" href="listProducts?page=${page }">${page }</a></li>
		             					</c:forEach>
								</c:if> 

							    <li class="page-item">
							      <a class="page-link" href="#" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							        <span class="sr-only">Next</span>
							      </a>
							    </li>
							  </ul>
							</nav>
              </div>
              <!-- /.table-responsive -->
       <% } %>
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-left">Place New Order</a>
              <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-right">View All Orders</a>
            </div>
            <!-- /.box-footer -->
          </div>
</body>
</html>