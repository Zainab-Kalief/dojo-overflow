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
	<h1> <c:out value="${ question.question }"/> </h1>
	<p>Tags: 
		<c:forEach items="${ question.tags }" var="tag" >
					<span> <c:out value="${ tag.name }"/> </span>
		</c:forEach>
	</p>
	<table>
		<tr>
			<td>Answers</td>
		<tr>
		<c:forEach items="${ question.answers }" var="answer" >
			<tr>
			<td> <c:out value="${ answer.answer }"/> </td>
			</tr>
		</c:forEach>
	</table>
		<p>Add your answer</p>
		
		<form:form method="POST" action="/questions/${ question.id }" modelAttribute="newAnswer">
		
		
     <form:label path="answer">Answer:
     	<form:errors path="answer"/>
     	<form:textarea path="answer"/>
     </form:label><br>
 
    
      <input type="submit" name="" value="Answer it">
    </form:form>
	
</body>
</html>