<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="struts-html.tld" %>
<%@ taglib prefix="logic" uri="struts-logic.tld" %>
<%@ taglib prefix="bean" uri="struts-bean.tld" %>
<html>
<body>

<h2>Users</h2>
  	<table>
		<tr>
			<td>Id</td>
			<td>Username</td>
			<td>Name</td>
			<td>Date</td>
			<td>Address</td>
			<td>Application</td>
		</tr>
	</table>
	<c:forEach items="${users}" var="user">
		
		<form action="updateUsr.do">
			<table>
				<tr>
					<td>
						<input type="hidden" name="id" value="${user.id}" />
						${user.id}
					</td>
					<td>
						<input type="text" name="username" value="${user.username}" />
					</td>
					<td>
						<input type="text" name="name" value="${user.name}" />
					</td>
					<td>
						<input type="date" name="date" value="${user.date}" />
					</td>
					<td>
						${user.address}
					</td>
					<td>
						${user.application.name}
					</td>
					<td>
						<input type="submit" value="Update" />
					</td>
				</tr>
			</table>
				
   		</form>
	</c:forEach>

<form method="POST" action="saveUsr.do">
	<input type="number" name="id" placeholder="id" />
	<input type="text" name="username" placeholder="username" />
	<input type="text" name="name" placeholder="name" />
	<input type="date" name="date" placeholder="birth_date" />
	<input type="submit" value="Save User" />
</form>

<!-- <ul><h3>Hibernate</h3>
  <li><a href="${pageContext.request.contextPath}/hibernate?action=list">User list</a></li>
  <li><a href="${pageContext.request.contextPath}/hibernate?action=insert">Insert user</a></li>
</ul>

<ul><h3>Struts</h3>
  <li><a href="${pageContext.request.contextPath}/userlist.do">User list</a></li>  
</ul>  -->

</body>
</html>
