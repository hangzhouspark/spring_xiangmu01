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
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('insertExt.action','_self');">确定</a></li>
<li id="back"><a href="/findConProAll.action?contract_Id=${contract_ids}">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		新增附件信息
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
		            	<option value="">--请选择--</option>
	            		<c:forEach items="${factory_cs}" var="f">
	            			<option value="${f.factory_id}">${f.full_name}</option>
	            		</c:forEach>
	            	</select>
	            </td>
	            <td class="columnTitle_mustbe">货号：</td>
	            <td class="tableContent"><input type="text" name="product_No"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">分类：</td>
	            <td class="tableContent">
	            	<select name="ctype">
		            	<option value="">--请选择--</option>
	            		<c:forEach items="${sysCodeBS}" var="cl">
	            			<option value="${cl.sys_Code_Id}">${cl.name}</option>
	            		</c:forEach>
	            	</select>
	            </td>
	            <td class="columnTitle_mustbe">货物照片：</td>
	            <td class="tableContent"><input type="text" name="product_Image"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">数量：</td>
	            <td class="tableContent"><input type="text" name="cnumber"/></td>
	            <td class="columnTitle_mustbe">包装单位：</td>
	            <td class="tableContent"><input type="text" name="packing_Unit"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">单价：</td>
	            <td class="tableContent"><input type="text" name="price"/></td>
	            <td class="columnTitle_mustbe">排序号：</td>
	            <td class="tableContent"><input type="text" name="order_No"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">货物描述：</td>
	            <td class="tableContent"><textarea name="product_Desc" style="height:120px;"></textarea></td>
	            <td class="columnTitle_mustbe">要求：</td>
	            <td class="tableContent"><textarea name="product_Request" style="height:120px;"></textarea></td>
	        </tr>
		</table>
	</div>
</div>
 
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    附件列表
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
		<td class="tableHeader">厂家名称</td>
		<td class="tableHeader">货号</td>
		<td class="tableHeader">数量</td>
		<td class="tableHeader">包装单位</td>
		<td class="tableHeader">单价</td>
		<td class="tableHeader">总金额</td>
		<td class="tableHeader">操作</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${extCproductCS}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="ext_Cproduct_Id" value="${o.ext_Cproduct_Id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.factory_Name}</td>
		<td>${o.product_No}</td>
		<td>${o.cnumber}</td>
		<td>${o.packing_Unit}</td>
		<td>${o.price}</td>
		<td>${o.amount}</td>
		<td>
			<a href="/selectExtByid.action?ext_Cproduct_Id=${o.ext_Cproduct_Id}">[修改]</a>
			<a href="/delExt.action?ext_Cproduct_Id=${o.ext_Cproduct_Id}">[删除]</a>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
</form>
</body>
</html>

