<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header col-12" id="header">
    <div class="row">
        <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2 text-center">
            <div class="col-12">
                <span id="texto-ano" class="text-left">${anno}</span>            
            </div>
            <div class="col-12">
                <a title="Inicio" href="Inicio" ><span class="fa fa-home link-cabeza"></span></a>
                <a href="javascript:void(0)" title="Salida segura" onclick="CerrarSesion()"><span class="fas fa-sign-out-alt link-cabeza"></span></a>
            </div>            
        </div>
        <div class="col-sm-8 col-md-8 col-lg-8 col-xl-8 text-center">
            <img src="./images/cabeza/Logo.svg" id="img-logo" />
        </div>
        <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2 text-center">
            <img src="${logo}" id="img-empresa" />
        </div>
    </div>    
</header>