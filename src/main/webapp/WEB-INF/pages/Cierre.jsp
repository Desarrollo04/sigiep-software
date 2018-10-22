<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Cierre de Sesión</title>
        <jsp:include page="layout/link_header.jsp" />
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <header class="header" id="header">
                    <div class="col-sm-12 col-md-12 col-lg-12 text-center">
                        <img src="./images/cabeza/Logo.svg" id="img-logo">
                    </div>
                </header>
                <div class="col-sm-9 col-md-7 col-lg-5 col-xl-5 mx-auto">
                    <div class="card card-signin my-5">
                        <h3 class="text-center mt-4 mb-2"><strong>Cierre de Sesión</strong></h3>
                        <c:if test="${param.error == 'true'}">
                            <div class="text-center text-danger mb-2 mt-3">                                
                                <h6>Tiempo de inabilidad excedido!!</h6>
                            </div>
                        </c:if>
                        <div class="col-12 text-center mt-2">
                            <h5>Cierre de Sessión exitoso</h5>
                        </div>
                        <div class="col-12 text-center mt-1 mb-4">
                            <h5><a href="login">Iniciar Sesión</a></h5>
                        </div>
                    </div>
                </div>
                <jsp:include page="layout/footer.jsp" />
            </div>
        </div>
    </body>
</html>
