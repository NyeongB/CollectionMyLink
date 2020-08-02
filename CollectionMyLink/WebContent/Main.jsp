<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<style type="text/css">
	
	.tbwid_10{width:10%;}	/* Number */
	.tbwid_20{width:15%;}	/* Title */
	.tbwid_30{width:50%;}	/* Link(url) */
	.tbwid_40{width:15%;} 	/* Date */
	.tbwid_50{width:5%;} 	/* add */
	.tbwid_60{width:5%;} 	/* delete */

</style>

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<table class="table">
						<thead>
							<tr>
								<th class="tbwid_10">
									#
								</th>
								<th class="tbwid_20">
									Title
								</th>
								<th class="tbwid_30">
									Link
								</th>
								<th class="tbwid_40">
									Date
								</th>
								<th class="tbwid_50">
									Add
								</th>																
								<th class="tbwid_60">
									Del							
								</th>
							</tr>
						</thead>
						<tbody>
							<C:forEach var="dto" items="${list }">
							<tr>
								<td>
									${dto.link_num }
								</td>
								<td>
									${dto.link_title }
								</td>
								<td>
									<a href="${dto.link_url }">${dto.link_url }</a>
								</td>
								<td>
									${dto.link_date }
								</td>
								<td>
									<button type="button" class="btn btn-default">
									</button>
								</td>
								<td>
									<button type="button" class="btn btn-default">
									</button>
								</td>
							</tr>
							</C:forEach>
							
							
						</tbody>
					</table>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>