<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
	
</style>
</head>
<body>
	<h1>Question Dashboard</h1>
	
	<table>
		<tr>
			<td>Question</td>
			<td>Tag</td>
		<tr>
		<c:forEach items="${ questions }" var="question" >
			<tr>
			<td> <a href="/questions/${ question.id }"><c:out value="${ question.question }"/></a> </td>
			<td>
				<c:forEach items="${ question.tags }" var="tag" >
					<span> <c:out value="${ tag.name }"/> </span>
				</c:forEach>
			  </td>
			</tr>
		</c:forEach>
	</table>
		<a href="/questions/new">New Question</a>
	
</body>
</html>