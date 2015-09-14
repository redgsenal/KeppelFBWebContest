<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<sql:query var="rs" dataSource="jdbc/dbkeppelcontest">select fullname, usercomments from tblcomments</sql:query>
<%@include file="includes/header.jsp"%>
	<div class="page">
		<div class="content">
			<h2>Results</h2>
			<table>
				<c:forEach var="row" items="${rs.rows}">
					<tr>
						<td>${row.fullname}</td>
						<td>${row.usercomments}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
<%@include file="includes/fullfooter.jsp"%>