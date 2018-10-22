<%-- 
    Document   : layout
    Created on : 12-oct-2018, 11:32:25
    Author     : SERVIDOR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>${titulo} - Principal</title>
        <jsp:include page="layout/link_header.jsp" />
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <jsp:include page="layout/header.jsp" />
                <jsp:include page="layout/sidebar.jsp" />                                                    
                <div class="col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-1" id="contenido" >                        
                    <jsp:include page="layout/main.jsp" />
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="container" id="cuerpo">                                                                       
                    </div>
                </div>                
            </div>
        </div>
        <jsp:include page="layout/footer.jsp" />        
    </body>
</html>