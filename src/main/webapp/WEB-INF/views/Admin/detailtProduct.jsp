<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detailt product</title>
</head>
<body>
	<div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Chi tiết sản phẩm</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="box-footer">
          Mã sản phẩm
        </div>
        <div class="box-body">
          ${pro.proId }
        </div>
        <div class="box-footer">
         Tên sản phẩm
        </div>
        <div class="box-body">
          ${pro.proName }
        </div>
        <div class="box-footer">
          Giá sản phẩm
        </div>
        <div class="box-body">
          ${pro.price }
        </div>
        <div class="box-footer">
          Thuộc loại
        </div>
        <div class="box-body">
         ${pro.cat.catName }
        </div>
        <div class="box-footer">
          Số lượng sản phẩm
        </div>
        <div class="box-body">
          ${pro.quantity }
        </div>
        <div class="box-footer">
          Ngày sản xuất
        </div>
         <div class="box-body">
          ${pro.creDate }
        </div>
        <div class="box-footer">
          Mô tả
        </div>
        <div class="box-body">
          ${pro.describe }
        </div>
        <div class="box-footer">
          Hình ảnh sản phẩm
        </div>
        <div class="box-body">
          <img src="${pageContext.servletContext.contextPath}/${pro.image }" alt="not img product" width="300" height="auto">
        </div>
        <!-- /.box-footer-->
      </div>
       <div class="box-footer clearfix">
              <a href="updateProduct?id=${pro.proId}" class="btn btn-sm btn-info btn-flat pull-left">Update Product</a>
            </div>
</body>
</html>