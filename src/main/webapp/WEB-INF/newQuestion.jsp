<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
<h1>What's your question?</h1>
	<form:form method="POST" action="/questions/new" modelAttribute="newQuestion">
		<form:hidden path="id"/>
		
     <form:label path="question">Name
     	<form:errors path="question"/>
     	<form:textarea path="question"/>
     </form:label><br>
     
     
     
     Tags: <input type="text" name="tagList"><br>
    
      <input type="submit" name="" value="Submit">
    </form:form>
</body>
</html>