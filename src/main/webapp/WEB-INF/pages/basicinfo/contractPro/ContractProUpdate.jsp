<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form action="/UpdateConPro.action" method="post" id="updateForm">
	<input type="hidden" name="contract_Product_Id" value="${contractPro.contract_Product_Id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a onclick="document:updateForm.submit()">确定</a></li>
<li id="back"><a href="/findoryAlll.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		修改生产厂家信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
			<tr>
				<td class="columnTitle_mustbe">厂家名称：</td>
				<td class="tableContent">
					<select name="factory_Id">
						<c:forEach items="${factory_cs}" var=f"a">
							<c:if test="${fa.factory_id eq contractPro.factory_c.factory_id}">
								<option value="${fa.factory_id}" selected="selected">${fa.full_name}</option>
							</c:if>
							<c:if test="${fa.factory_id != contractPro.factory_c.factory_id}">
								<option value="${fa.factory_id}">${fa.full_name}</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
				<td class="columnTitle_mustbe">货号：</td>
				<td class="tableContent"><input type="text" name="product_No" value="${contractPro.product_No}"/></td>
			</tr>
			<tr>
				<td class="columnTitle_mustbe">货物照片：</td>
				<td class="tableContent"><input type="text" name="product_Image" value="${contractPro.product_Image}"/></td>
			</tr>
			<tr>
				<td class="columnTitle_mustbe">数量：</td>
				<td class="tableContent"><input type="text" name="cnumber" value="${contractPro.cnumber}"/></td>
				<td class="columnTitle_mustbe">包装单位：</td>
				<td class="tableContent"><input type="text" name="packing_Unit" value="${contractPro.packing_Unit}"/></td>
			</tr>
			<tr>
				<td class="columnTitle_mustbe">装率：</td>
				<td class="tableContent"><input type="text" name="loading_Rate" value="${contractPro.loading_Rate}"/></td>
				<td class="columnTitle_mustbe">箱数：</td>
				<td class="tableContent"><input type="text" name="box_Num" value="${contractPro.box_Num}"/></td>
			</tr>
			<tr>
				<td class="columnTitle_mustbe">单价：</td>
				<td class="tableContent"><input type="text" name="price" value="${contractPro.price}"/></td>
				<td class="columnTitle_mustbe">排序号：</td>
				<td class="tableContent"><input type="text" name="order_No" value="${contractPro.order_No}"/></td>
			</tr>
			<tr>
				<td class="columnTitle_mustbe">货物描述：</td>
				<td class="tableContent"><textarea name="product_Desc" style="height:120px;">${contractPro.product_Desc}</textarea></td>
			</tr>
		</table>
	</div>
</div>
</form>
</body>
</html>

