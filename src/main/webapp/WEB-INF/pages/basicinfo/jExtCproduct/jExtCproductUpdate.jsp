<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript">
    	//设置冗余的生产厂家名称
    	function setFactoryName(val){
    		var ele = document.getElementById("factoryName");
    		ele.value = val;
    	}
    </script>
</head>
<body>
<form method="post">
	<input type="hidden" name="ext_Cproduct_Id" value="${obj.ext_Cproduct_Id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('updateExt.action','_self');">确定</a></li>
<li id="back"><a href="/selectExt.action?contract_Product_Id=${contract_product_ids}">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		修改附件信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">厂家名称：</td>
	            <td class="tableContent">
	            	<select name="factory_Id" onchange="setFactoryName(this.options[this.selectedIndex].text);">
						<c:forEach items="${factory_cs}" var="f">
							<c:if test="${f.factory_id eq obj.factory_Id}">
								<option value="${f.factory_id}" selected="selected">${f.full_name}</option>
							</c:if>
							<c:if test="${f.factory_id != obj.factory_Id}">
								<option value="${f.factory_id}">${f.full_name}</option>
							</c:if>
						</c:forEach>
	            	</select>
	            </td>
	            <td class="columnTitle_mustbe">货号：</td>
	            <td class="tableContent"><input type="text" name="product_No" value="${obj.product_No}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">分类：</td>
	            <td class="tableContent">
	            	<select name="ctype">
						<c:forEach items="${sysCodeBS}" var="cl">
							<c:if test="${cl.sys_Code_Id eq obj.ctype}">
								<option value="${cl.sys_Code_Id}" selected="selected">${cl.name}</option>
							</c:if>
							<c:if test="${cl.sys_Code_Id != obj.ctype}">
								<option value="${cl.sys_Code_Id}">${cl.name}</option>
							</c:if>
						</c:forEach>
	            	</select>
	            </td>
	            <td class="columnTitle_mustbe">货物照片：</td>
	            <td class="tableContent"><input type="text" name="product_Image" value="${obj.product_Image}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">数量：</td>
	            <td class="tableContent"><input type="text" name="cnumber" value="${obj.cnumber}"/></td>
	            <td class="columnTitle_mustbe">包装单位：</td>
	            <td class="tableContent"><input type="text" name="packing_Unit" value="${obj.packing_Unit}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">单价：</td>
	            <td class="tableContent"><input type="text" name="price" value="${obj.price}"/></td>
	            <td class="columnTitle_mustbe">排序号：</td>
	            <td class="tableContent"><input type="text" name="order_No" value="${obj.order_No}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">货物描述：</td>
	            <td class="tableContent"><textarea name="product_Desc" style="height:120px;">${obj.product_Desc}</textarea></td>
	            <td class="columnTitle_mustbe">要求：</td>
	            <td class="tableContent"><textarea name="product_Request" style="height:120px;">${obj.product_Request}</textarea></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

