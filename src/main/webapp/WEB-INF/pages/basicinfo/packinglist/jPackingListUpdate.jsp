<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
</head>
<body>
<form method="post">
	<input type="hidden" name="packing_list_id" value="${obj.packing_list_id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('Packlistupdate.action','_self');">确定</a></li>
<li id="back"><a href="list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		修改装箱单信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">卖方：</td>
	            <td class="tableContent"><textarea name="seller" style="height:120px;">${obj.seller}</textarea></td>
	            <td class="columnTitle_mustbe">买方：</td>
	            <td class="tableContent"><textarea name="buyer" style="height:120px;">${obj.buyer}</textarea></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">发票号：</td>
	            <td class="tableContent"><input type="text" name="invoice_no" value="${obj.invoice_no}"/></td>
	            <td class="columnTitle_mustbe">发票日期：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="invoice_date" value="<fmt:formatDate value="${obj.invoice_date}" pattern="yyyy-MM-dd"/>"
						   onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'})"/>
				</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">唛头：</td>
	            <td class="tableContent"><textarea name="marks" style="height:120px;">${obj.marks}</textarea></td>
	            <td class="columnTitle_mustbe">描述：</td>
	            <td class="tableContent"><textarea name="descriptions" style="height:120px;">${obj.descriptions}</textarea></td>
	        </tr>
		</table>
	</div>
</div>
 
<div class="textbox" id="centerTextbox">
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		报运信息
    </div> 
    </div>
    </div>
<div>

<div style="text-align:left;">
	${divData}
</div>
 
</form>
</body>
</html>

