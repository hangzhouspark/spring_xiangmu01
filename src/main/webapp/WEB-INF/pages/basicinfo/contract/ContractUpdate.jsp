<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form action="/updateCon.action" method="post" id="updateForm">
	<input type="hidden" name="contract_Id" value="${obj.contract_Id}"/>

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
				<td class="columnTitle_mustbe">客户名称：</td>
				<td class="tableContent"><input type="text" name="custom_Name" value="${obj.custom_Name}"/></td>
				<td class="columnTitle_mustbe">收购方：</td>
				<td class="tableContent"><input type="text" name="offeror" value="${obj.offeror}"/></td>
			</tr>
			<tr>
				<td class="columnTitle_mustbe">合同号：</td>
				<td class="tableContent"><input type="text" name="contract_No" value="${obj.contract_No}"/></td>
				<td class="columnTitle_mustbe">打印板式：</td>

				<td class="tableContent">
					<c:if test="${obj.print_Style==1}">
						<input type="radio" name="print_Style" value="1" style="width: 10px" checked="checked"/>窄
						<input type="radio" name="print_Style" value="2" style="width: 10px"/>宽</td>
					</c:if>
				<c:if test="${obj.print_Style==2}">
					<input type="radio" name="print_Style" value="1" style="width: 10px"/>窄
					<input type="radio" name="print_Style" value="2" style="width: 10px" checked="checked"/>宽</td>
				</c:if>
			</tr>
			<tr>
				<td class="columnTitle_mustbe">签单日期：</td>
				<td class="tableContent"><input type="text" name="signing_Date" value="<fmt:formatDate value="${obj.signing_Date}" pattern="yyyy-MM-dd"/>"/></td>
				<td class="columnTitle_mustbe">重要程度：</td>
				<td class="tableContent">
					<c:if test="${obj.import_Num==3}">
						<input type="radio" name="import_Num" value="3" style="width: 10px" checked="checked"/>※※※
						<input type="radio" name="import_Num" value="2" style="width: 10px"/>※※
						<input type="radio" name="import_Num" value="1" style="width: 10px"/>※
					</c:if>
					<c:if test="${obj.import_Num==2}">
						<input type="radio" name="import_Num" value="3" style="width: 10px"/>※※※
						<input type="radio" name="import_Num" value="2" style="width: 10px" checked="checked"/>※※
						<input type="radio" name="import_Num" value="1" style="width: 10px"/>※
					</c:if>
					<c:if test="${obj.import_Num==1}">
						<input type="radio" name="import_Num" value="3" style="width: 10px"/>※※※
						<input type="radio" name="import_Num" value="2" style="width: 10px"/>※※
						<input type="radio" name="import_Num" value="1" style="width: 10px" checked="checked"/>※
					</c:if>

				</td>
			</tr>
			<tr>
				<td class="columnTitle_mustbe">交货期限：</td>
				<td class="tableContent"><input type="text" name="delivery_Period" value="<fmt:formatDate value="${obj.delivery_Period}" pattern="yyyy-MM-dd"/>"/></td>
				<td class="columnTitle_mustbe">船期：</td>
				<td class="tableContent"><input type="text" name="ship_Time" value="<fmt:formatDate value="${obj.ship_Time}" pattern="yyyy-MM-dd"/>"/></td>
			</tr>
			<tr>
				<td class="columnTitle_mustbe">总金额：</td>
				<td class="tableContent"><input type="text" name="total_Amount" value="${obj.total_Amount}"/></td>
				<td class="columnTitle_mustbe">验货员：</td>
				<td class="tableContent"><input type="text" name="inspector" value="${obj.inspector}"/></td>
			</tr>
			<tr>
				<td class="columnTitle_mustbe">制单人：</td>
				<td class="tableContent"><input type="text" name="input_By" value="${obj.input_By}"/></td>
				<td class="columnTitle_mustbe">审单人：</td>
				<td class="tableContent"><input type="text" name="check_By" value="${obj.check_By}"/></td>
			</tr>
			<tr>
				<td class="columnTitle_mustbe">要求：</td>
				<td class="tableContent"><textarea name="request" style="height:120px;">${obj.request}</textarea></td>
				<td class="columnTitle_mustbe">说明：</td>
				<td class="tableContent"><textarea name="remark" style="height:120px;">${obj.remark}</textarea></td>
			</tr>
		</table>
	</div>
</div>
</form>
</body>
</html>

