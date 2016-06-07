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
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function iddd() {

		alert(document.getElementById("info").value);

	}
	$(document).ready(
			function() {
				$.ajax({
					type : 'POST',
					contentType : 'application/json',
					url : 'index.do',
					processData : false,
					dataType : 'json',
					success : function(data) {

						var tr = $("#cloneTr");
						$.each(data.result, function(index, item) {
							var item = item.map;
							var clonedTr = tr.clone();
							var _index = index;
							clonedTr.children("td").each(
									function(inner_index) {
										switch (inner_index) {
										case (0):
											$(this).html(_index + 1);
											break;
										case (1):
											$(this).html(item.name);
											break;
										case (2):
											$(this).html(item.user_type);
											break;
										case (3):
											$(this).html(item.create_time);
											break;
										case (4):
											$(this).html(item.state);
											break;
										case (5):
											$(this).html(item.last_login_time);
											break;
										case (6):
											$(this).html(item.remark);
											break;
										case (7):
											$(this).append(
													"<a href='edit.do?id="
															+ item.id
															+ "'>修改 　</a>" ).append(
																	"<a href='delete.do?id="
																	+ item.id
																	+ "'>删除</a>");
											break;
										}
									});
							clonedTr.insertAfter(tr);
						});
						$("#cloneTr").hide();
						$("#generatedTable").show();
					}
				});
			})
</script>
</head>

<body>
	<sf:form action="index.do" method="post">
		<div>
			<table id="generatedTable" class="table table-striped"
				style="display: none;">
				<thead>
					<tr>
						<th style='width: 5%;'>编号</th>
						<th style='width: 10%;'>姓名</th>
						<th style='width: 15%;'>账户类型</th>
						<th style='width: 15%;'>注册时段</th>
						<th style='width: 10%;'>状态</th>
						<th style='width: 15%;'>最后登录时间</th>
						<th style='width: 10%;'>备注</th>
						<th style='width: 20%;'>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr id="cloneTr">
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<table id="generatedTable1" class="table table-striped">
			<tbody>
				<tr>
					<td><a href='add.jsp'>添加</a></td>
				</tr>
			</tbody>
		</table>
	</sf:form>
</body>
</html>
