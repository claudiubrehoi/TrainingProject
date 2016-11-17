<%@ taglib prefix="html" uri="struts-html.tld" %>
<html>
<head>
	<title>Struts Test</title>
</head>
<body>
	<h2>Users</h2>
	<html:form action="users.do">
		<html:text property="id" />
		<html:text property="username" />
		<html:text property="name" />
		<html:submit />
	</html:form>
</body>
</html>
