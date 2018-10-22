<%-- 
    Document   : sidebar
    Created on : 11-oct-2018, 16:07:57
    Author     : SERVIDOR
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="col-md-2 col-lg-2 col-xl-2 d-none d-md-block bg-light text-left sidebar col-2 left" id="main">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <c:forEach items="${menus}" var="dato">
                <li class="nav-item link">
                    <a class="nav-link" title="${dato.nombre}" href="${dato.ruta}">
                        <img src="<c:out value="${dato.imagen}" />" class="img-menu"><span class="texto-menu"><c:out value="${dato.nombre}" /></span>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>    
</nav>
