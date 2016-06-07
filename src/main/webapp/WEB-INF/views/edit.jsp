<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js">
	
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap.min.js">
	
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/moment.js">
	
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/daterangepicker.js">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#createTime').daterangepicker({
			timePicker : true,
			timePickerIncrement : 30,
			format : "yyy-MM-dd"
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".js-example-basic-single").select2();
	});
</script>
<style>
.form-control.select2 {
	width: 16%;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$(".js-example-basic-single").select2();
	});
</script>

<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/daterangepicker.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
	<sf:form action="editSubmit.do" method="post" modelAttribute="user">
		<table id="generatedTable" class="table table-striped">
			<sf:input type="hidden" path="id"></sf:input>
			<tr>
				<th style='width: 10%;'>姓名</th>
				<td><sf:input path="name" /></td>
			</tr>
			<tr>
				<th style='width: 15%;'>账户类型</th>
				<td><select id="userType" name="userType"
					class="form-control select2">
						<option>student</option>
						<option>teacher</option>
				</select></td>
			</tr>
			<tr>
				<th style='width: 15%;'>注册时段</th>
				<td><sf:input id="createTime" path="createTime" readonly="true" /></td>
			</tr>
			<tr>
				<th style='width: 10%;'>状态</th>
				<td>
				<c:choose>
                     <c:when test="${state=='online'}">
                     <input type="radio" name="state" value="online"  checked />online
                      <input type="radio" name="state" value="leave"  />leave
                     </c:when>
                     <c:otherwise>
                      <input type="radio" name="state" value="online"   />online
                      <input type="radio" name="state" value="leave" checked />leave
                     </c:otherwise>
                     </c:choose>
				
				</td>
			
			</tr>
			<tr>
				<th style='width: 15%;'>最后登录时间</th>
				<td><sf:input path="lastLoginTime"
						/></td>
			</tr>
			<tr>
				<th style='width: 10%;'>备注</th>
				<td><sf:input path="remark" /></td>
			</tr>
			<tr>
				<th style='width: 20%;'>操作</th>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>
