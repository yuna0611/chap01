<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
    	Cookie cookie = new Cookie("id",request.getParameter("id"));
    	cookie.setMaxAge(60*60);
    	response.addCookie(cookie);
    %>
d