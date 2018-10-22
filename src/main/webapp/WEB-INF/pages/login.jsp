<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Inicio de Sesión</title>
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
                        <h3 class="text-center mt-4 mb-2"><strong>Inicio de Sesión</strong></h3>
                        <c:if test="${param.error == 'true'}">
                            <div class="text-center text-danger mb-2">
                                <h5>Inicio de Sesión Fallido!!!</h5>
                                <h6>Motivo : Usuario y/ó Contraseña erroneas!!</h6>
                            </div>
                        </c:if>                    
                        <form name='f' action="ingresar" method='POST' class="form-signin" modelAttribute="login">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <div class="form-group row">
                                <label for="txtNombre" class="col-form-label col-sm-3 col-md-3 col-lg-3 col-xl-3 text-right font-weight-bold">Usuario:</label>
                                <div class="col-sm-8 col-md-7 col-lg-7">
                                    <input type='text' name='txtNombre' id="txtNombre" class="form-control" required autocomplete="off" placeholder="Usuario" minlength="5" title="Ingrese usuario registrado">
                                </div>
                                <form:errors path="txtNombre" class="text-danger" />
                            </div>
                            <div class="form-group row">
                                <label for="txtContrasena" class="col-form-label col-sm-3 col-md-3 col-lg-3 col-xl-3 text-right font-weight-bold">Contraseña:</label>
                                <div class="col-sm-8 col-md-7 col-lg-7">
                                    <input type='password' name='txtContrasena' class="form-control" required autocomplete="off" placeholder="Contraseña" minlength="5" title="Ingrese contraseña">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="sltCompania" class="col-form-label col-sm-3 col-md-3 col-lg-3 col-xl-3 text-right font-weight-bold">Compañia:</label>
                                <div class="col-sm-8 col-md-7 col-lg-7">
                                    <select class="form-control select" id="sltCompania" name="sltCompania" placeholder="Compañia" required="">                                    
                                        <c:forEach items="${companias}" var="dato">
                                            <option value="<c:out value="${dato.id_unico}"/>">
                                                <c:set var="razonsocial" value="${dato.razonsocial} NIT ${dato.numeroidentificacion} - ${dato.digitoverficacion}" />
                                                <c:out value="${razonsocial}" />
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="sltAnno" class="col-form-label col-sm-3 col-md-3 col-lg-3 col-xl-3 text-right font-weight-bold">Año:</label>
                                <div class="col-sm-8 col-md-7 col-lg-7">
                                    <select class="form-control select" id="sltAnno" name="sltAnno" placeholder="Año" required="">                                    
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row mt-2 mb-5">
                                <label for="btn" class="col-form-label col-sm-3 col-md-3 col-lg-3 col-xl-3"></label>
                                <div class="col-sm-7 col-md-7 col-lg-7 text-left">
                                    <button type="submit" class="btn btn-lg btn-primary btn-block text-uppercase">INGRESAR <span class="fas fa-sign-in-alt"></span></button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <jsp:include page="layout/footer.jsp" />
                <script src="./js/script_login.js"></script>
            </div>
        </div>
    </body>
</html>