<%-- 
    Document   : main
    Created on : 12-oct-2018, 14:35:59
    Author     : SERVIDOR
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light main">
    <div class="container">        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarsExample07">
            <ul class="navbar-nav mr-auto">
                <c:forEach items="${xHijos}" var="dato">
                    <c:if test="${dato.ruta == null}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle link" onmousemove="obtenerHijos(${dato.id_unico})" href="javascript:void(0)" id="X${dato.id_unico}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${dato.nombre}</a>
                            <div class="dropdown-menu" aria-labelledby="X${dato.id_unico}" id="hijos${dato.id_unico}"></div>
                        </li>
                    </c:if>
                    <c:if test="${dato.ruta != null}">
                        <li class="nav-item">
                            <a class="nav-link link" href="${dato.ruta}">${dato.nombre}</a>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>            
        </div>
    </div>
</nav>