<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

 <c:choose>
    <c:when test="${param.p >0 }">
        ${param.p } is positive
    </c:when>
    <c:when test="${param.p <0 }">
        ${param.p } is negetive
    </c:when>
    <c:otherwise>
       ${param.p } is Zero
    </c:otherwise>
 </c:choose>
    http://localhost:3030/JspApp20-JSTLCore/core3.jsp?p=0
 
