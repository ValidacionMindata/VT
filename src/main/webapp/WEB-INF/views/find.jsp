<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://example.com/functions" prefix="f" %>

<html lang="es">
<head>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-4 col-xs-offset-4">
				<div class="row">			
				<table class="table table-striped">
					<thead>
						<tr>
							<form class="form-inline" method="get">
								<th><input class="form-control" type="text" name="course" value="${param.course}" placeholder="Curso"/></th>
								<th>
									<div class="input-group">
										<input class="form-control" type="text" name="fromDate" value="${param.fromDate}" placeholder="Desde fecha (dd/MM/yyyy)"/>
										<span class="input-group-btn">
											<input class="btn btn-default" type="submit" value="Buscar"/>
										</span>
									</div>
								</th>
							</form>
						</tr>
						<tr>
							<th>Curso</th>
							<th>Fecha inicio</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${courses}" var="course">
							<tr>
								<td>${course.name}</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy" value="${course.date}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				
				<c:set var="currentUrl" value="/find${not empty requestScope['javax.servlet.forward.query_string']?'?':''}${requestScope['javax.servlet.forward.query_string']}"></c:set>
				<c:set var="urlWithoutPage" value="${f:replaceAll(currentUrl, '[&|?]page=[^&]+', '')}" />
				
				<c:set var="pages" value="${totalResults % pageSize==0 ? totalResults / pageSize : totalResults / pageSize + 1}" />
				
				<c:forEach begin="1" end="${pages}" varStatus="status">
				
					<spring:url value="${urlWithoutPage}" var="pagination">
						<spring:param name="page" value="${status.index}"></spring:param>
					</spring:url>
					
					<a class="btn btn-default" ${status.index == param.page ? "style=\"border-color:#727272\"" : ""} href="${pagination}" role="button"><c:out value="${status.index}"></c:out></a>
				</c:forEach>
				
				</div>
				<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js" />
			</div>
		</div>
	</div>
</body>
</html>