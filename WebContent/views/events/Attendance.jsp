<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:property value="eventName" /></title>
</head>
<body>

<h2>Current attendees</h2>

<s:iterator value="attendees">
  <form method='post' action='AttendanceRemove.action'>
    <input type='hidden' name='personId' value='<s:property value="id" />' />
    <input type='hidden' name='eventId'  value='<s:property value="[1].id" />' />
    <input type='submit' value='-' title='Remove' />
  </form>
	
  <s:property value="name" />
  <br>
</s:iterator>

<s:if test="attendees.isEmpty()">
  <em>There are no attendees</em><br/>
</s:if>

<h2>Add attendees</h2>

<s:iterator value="nonAttendees">
  <form method='post' action='AttendanceAdd.action'>
    <input type='hidden' name='personId' value='<s:property value="id" />' />
    <input type='hidden' name='eventId'  value='<s:property value="[1].id" />' />
    <input type='submit' value='+' title='Add' />
  </form>
	
  <s:property value="name" />
  <br>
</s:iterator>

<s:if test="nonAttendees.isEmpty()">
  <em>There is no one left to add</em><br/>
</s:if>

<s:a action="Listing">Close</s:a>

</body>
</html>