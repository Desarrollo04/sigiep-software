<%-- 
    Document   : home
    Created on : 12-oct-2018, 10:58:14
    Author     : SERVIDOR
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${menus}" var="dato">
    <div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 text-center">                                
        <a href="${dato.ruta}" class="link-gestion">
            <div class="card gestiones">            
                <div class="card-header">
                    <img class="card-img-top icono-gestiones" src="${dato.imagen}" />
                    <div class="card-title texto-getiones">${dato.nombre}</div>
                </div>            
            </div>       
        </a>
    </div>
</c:forEach>