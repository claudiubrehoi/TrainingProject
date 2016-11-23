<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="struts-html.tld" %>
<%@ taglib prefix="logic" uri="struts-logic.tld" %>
<%@ taglib prefix="bean" uri="struts-bean.tld" %>
<%@ taglib prefix="custom" uri="custom.tld" %>
<html>
<body>
<div><custom:usersTable/></div>
<h2>Users</h2>

  	<table>
		<tr>
			<td>Id</td>
			<td>Username</td>
			<td>Name</td>
			<td>Date</td>
			<td>Address</td>
			<td>Street</td>
			<td>City</td>
			<td>Country</td>
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
						<custom:selectAddress selectedId="${user.address.id}" selectedStreetId="${user.address.street.id}"/>
					</td>
					<td>
						<custom:selectStreet selectedId="${user.address.street.id}" selectedCityId="${user.address.street.city.id}"/>
					</td>
					<td>
						<custom:selectCity selectedId="${user.address.street.city.id}" selectedCountryId="${user.address.street.city.country.id}"/>
					</td>
					<td>
						<custom:selectCountry selectedId="${user.address.street.city.country.id}"/>
					</td>
					<td>
						<custom:selectApplication selectedId="${user.application.id}"/>
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
	<custom:selectStreet selectedCityId="-1"/>
</form>

<!-- <ul><h3>Hibernate</h3>
  <li><a href="${pageContext.request.contextPath}/hibernate?action=list">User list</a></li>
  <li><a href="${pageContext.request.contextPath}/hibernate?action=insert">Insert user</a></li>
</ul>

<ul><h3>Struts</h3>
  <li><a href="${pageContext.request.contextPath}/userlist.do">User list</a></li>  
</ul>  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/customIndex.js"></script>
</body>
</html>
