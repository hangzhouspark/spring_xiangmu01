<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="formSubmit('${ctx}/cargo/contract/toview.action','_self');this.blur();">查看</a></li>
<li id="print"><a href="#" onclick="formSubmit('${ctx}/cargo/contract/print.action','_self');this.blur();">打印</a></li>
<li id="new"><a href="#" onclick="formSubmit('insertexport.action','_self');this.blur();">报运</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    购销合同查询列表
  </div> 
  </div>
  </div>
  
<div>

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">客户名称</td>
		<td class="tableHeader">合同号</td>
		<td class="tableHeader">货物数/附件数</td>
		<td class="tableHeader">制单人</td>
		<td class="tableHeader">审单人</td>
		<td class="tableHeader">验货员</td>
		<td class="tableHeader">签单日期</td>
		<td class="tableHeader">交货期限</td>
		<td class="tableHeader">船期</td>
		<td class="tableHeader">总金额</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${contractList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="userList" value="${o.contract_Id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.custom_Name}</td>
		<td>${o.contract_No}</td>
		<td>${o.cpnum}/${o.extnum}</td>
		<td>${o.input_By}</td>
		<td>${o.check_By}</td>
		<td>${o.inspector}</td>
		<td><fmt:formatDate value="${o.signing_Date}" pattern="yyyy-MM-dd"/></td>
		<td><fmt:formatDate value="${o.delivery_Period}" pattern="yyyy-MM-dd"/></td>
		<td><fmt:formatDate value="${o.ship_Time}" pattern="yyyy-MM-dd"/></td>
		<td>${o.total_Amount}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</div>
</form>
</body>
</html>

