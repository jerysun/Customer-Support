<%--@elvariable id="tickets" type="java.util.List<com.jsun.site.Ticket>"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="jsun" uri="http://www.jsun.com/jsp/tld/jsun" %>
<spring:message code="title.ticketList" var="listTitle" />
<template:basic htmlTitle="${listTitle}" bodyTitle="${listTitle}">
    <c:choose>
        <c:when test="${fn:length(tickets) == 0}">
            <i><spring:message code="message.ticketList.none" /></i>
        </c:when>
        <c:otherwise>
            <c:forEach items="${tickets}" var="ticket">
                <spring:message code="message.ticketList.ticket" />&nbsp;${ticket.id}:
                <a href="<c:url value="/ticket/view/${ticket.id}" />">
                <c:out value="${jsun:abbreviateString(ticket.subject, 60)}"/>
                </a><br />
                <c:out value="${ticket.customerName}" />&nbsp;
                <spring:message code="message.ticketList.created" />&nbsp;
                <jsun:formatDate value="${ticket.dateCreated}" type="both"
                                 timeStyle="short" dateStyle="medium" /><br />
                <br />
            </c:forEach>
        </c:otherwise>
    </c:choose>
</template:basic>
