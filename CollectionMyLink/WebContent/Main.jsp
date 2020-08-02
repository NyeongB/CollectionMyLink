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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">


<style type="text/css">
	
	.tbwid_10{width:10%;}	/* Number */
	.tbwid_20{width:15%;}	/* Title */
	.tbwid_30{width:50%;}	/* Link(url) */
	.tbwid_40{width:15%;} 	/* Date */
	.tbwid_50{width:5%;} 	/* add */
	.tbwid_60{width:5%;} 	/* delete */

</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">

	$(document).ready(function()
	{
		$("#btn").click(function()
		{
			
			//alert("Test");
			$("#add").submit();
		});
	});

</script>

</head>
<body>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<form action="add.action" class="form-inline" id="add" method="post">
						
							<input type="text" class="form-control" id="input">
							<button type="button" class="btn" id="btn">입력</button>
						
					</form>
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