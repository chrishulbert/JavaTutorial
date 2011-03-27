<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All events</title>
</head>
<body>

<s:iterator value="events">
  <form action='Delete.action'>
    <input type='hidden' name=id value='<s:property value="id" />' />
    <input type='submit' value='-' title='Delete' />
  </form>
  <form action='Attendance.action'>
    <input type='hidden' name=id value='<s:property value="id" />' />
    <input type='submit' value='A' title='Attendance' />
  </form>
  <s:property value="name" />
  <br>
</s:iterator>
    
</body>
</html>