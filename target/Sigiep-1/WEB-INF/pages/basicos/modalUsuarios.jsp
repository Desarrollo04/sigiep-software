<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="mldUsuarios" tabindex="-1" role="dialog" aria-labelledby="titleUsuarios" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="titleUsuarios">Editar Usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <input type="hidden" id="txtId" />
                    <div class="row form-group">
                        <label class="col-form-label col-4 col-xs-4 col-sm-4 col-lg-4 col-xl-4 text-right">Usuario:</label>
                        <div class="col-8  col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xl-8">
                            <input type="text" name="txtUsuarioE" id="txtUsuarioE" placeholder="Usuario" class="form-control" value="" autocomplete="off" tabindex="1" />
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="col-form-label col-4 col-xs-4 col-sm-4 col-lg-4 col-xl-4 text-right">Contraseña:</label>
                        <div class="col-8 col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xl-8">
                            <input type="text" name="txtContrasenaE" id="txtContrasenaE" placeholder="Contraseña" class="form-control" value="" autocomplete="off" tabindex="1" />
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="col-form-label col-4 col-xs-4 col-sm-4 col-lg-4 col-xl-4 text-right">Observaciones:</label>
                        <div class="col-8 col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xl-8">
                            <textarea class="form-control" id="txtObservacionesE" name="txtObservacionesE" placeholder="Observaciones"></textarea>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="col-form-label col-4 col-xs-4 col-sm-4 col-lg-4 col-xl-4 text-right">Rol:</label>
                        <div class="col-8 col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xl-8">                            
                            <select name="sltRolE" id="sltRolE" placeholder="Rol" class="form-control select">
                                <option value="">Rol</option>
                                <c:forEach items="${roles}" var="dato">
                                    <option value="${dato.id_unico}">${dato.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="col-form-label col-4 col-xs-4 col-sm-4 col-lg-4 col-xl-4 text-right">Tercero:</label>
                        <div class="col-8 col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xl-8">                            
                            <select name="sltTerceroE" id="sltTerceroE" placeholder="Tercero" class="form-control select">
                                <option value="">Tercero</option>
                                <c:forEach items="${terceros}" var="dato">
                                    <option value="${dato.id_unico}">${dato.nomTer} ${dato.num}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="col-form-label col-4 col-xs-4 col-sm-4 col-lg-4 col-xl-4 text-right">Estado:</label>
                        <div class="col-8 col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xl-8">                            
                            <select name="sltEstadoE" id="sltEstadoE" placeholder="Estado" class="form-control select">
                                <option value="">Estado</option>
                                <c:forEach items="${estados}" var="dato">
                                    <option value="${dato.id_unico}">${dato.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                <button type="button" id="btnEditar"  class="btn btn-primary">Guardar Cambios</button>
            </div>
        </div>
    </div>
</div>