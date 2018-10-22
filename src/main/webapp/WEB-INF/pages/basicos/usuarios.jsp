<%-- 
    Document   : usuarios
    Created on : 16-oct-2018, 7:35:35
    Author     : SERVIDOR
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3 class="text-center titulo mt-1">Usuarios</h3>
<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 contenedor bg-light">
    <form action="NuevoUsuario" method="post" name="frmUsuario">
        <table class="table table-condensed table-bordered table-light mt-1" id="table" style="width: 100%;">
            <thead>
                <tr>
                    <th>Usuario</th>
                    <th>Contraseña</th>
                    <th>Observaciones</th>
                    <th>Rol</th>
                    <th>Tercero</th>
                    <th>Estado</th>
                    <th style="width: 5%;"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="txtUsuario" id="txtUsuario" class="form-control" title="Ingrese nombre de usuario" placeholder="Usuario" minlength="5" required autocomplete="off" tabindex="1"/></td>
                    <td><input type="text" name="txtContrasena" id="txtContrasena" class="form-control" title="Ingrese contrasena de usuario" minlength="5" placeholder="Contraseña" required autocomplete="off" tabindex="2"/></td>
                    <td><input type="text" class="form-control" name="txtObservaciones" id="txtObservaciones" placeholder="Observaciones" minlength="10" autocomplete="off" tabindex="3" /></td>
                    <td>
                        <select class="select form-control" name="sltRol" id="sltRol" style="width: 100%;" required tabindex="4">                
                            <option value="">Rol</option>
                            <c:forEach items="${roles}" var="dato">
                                <option value="${dato.id_unico}">${dato.nombre}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select class="select form-control" name="sltTercero" id="sltTercero" style="width: 100%;" required tabindex="5">
                            <option value="">Tercero</option>
                            <c:forEach items="${terceros}" var="dato">
                                <option value="${dato.id_unico}">${dato.nomTer} ${dato.num}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select class="select form-control" name="sltEstado" id="sltEstado" style="width: 100%;" required tabindex="6">
                            <c:forEach items="${estados}" var="dato">
                                <option value="${dato.id_unico}">${dato.nombre}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="text-center"><button type="submit" title="Registrar" class="btn btn-sm btn-primary" tabindex="7" ><span class="fa fa-save"></span></button></td>            
                </tr>
                <c:forEach items="${usuarios}" var="dato">
                    <tr>
                        <td class="text-left">${dato.usuario}</td>                    
                        <td class="text-left">${dato.pass}</td>
                        <td class="text-left">${dato.observaciones}</td>
                        <td class="text-left">${dato.rol}</td>
                        <td class="text-left">${dato.nomTer}</td>
                        <td class="text-left">${dato.estado}</td>
                        <td class="text-center">
                            <a href="javascript:void(0)" title="Editar" class="ruta" data-id="${dato.id_unico}" data-toggle="modal" data-target="#mldUsuarios" data-backdrop="static" data-keyboard="false"><span class="fa fa-edit"></span></a>
                            <a onclick="eliminar(${dato.id_unico})" class="ruta" href="javascript:void(0)" title="Modificar"><span class="fa fa-trash"></span></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
</div>
<jsp:include page="modalUsuarios.jsp" />
<script>
    $(function(){
       $('#table').DataTable({
            "pageLength":5,
            "language": {
                "lengthMenu": "Mostrar _MENU_ registros",
                "zeroRecords": "No Existen Registros...",
                "info": "Página _PAGE_ de _PAGES_ ",
                "infoEmpty": "No existen datos",
                "infoFiltered": "(Filtrado de _MAX_ registros)",
                "sInfo":"Mostrando _START_ - _END_ de _TOTAL_ registros","sInfoEmpty":"Mostrando 0 - 0 de 0 registros",
                "sSearch":"Buscar",
                "paginate":{
                    "sPrevious": "Anterior",
                    "sNext": "Siguiente",
                    "sFirst": "Primero",
                    "sLast": "Ultimo"
                },
                "sEmptyTable": "No hay registros.",
                "columnDefs":[{
                    "targets":0,
                    "searchable":true,
                    "orderable": true,
                    "className": "dt-body-center"
                }]
            },
            "aLengthMenu":[1, 5, 10, 15, 25, 50, 100]
        }); 
    });  
    
    $(".select").select2({
        theme: 'bootstrap4',    
        allowClear: true,
        tags: true,
        language: "es"
    });
    
    $("button[type='submit']").click(function(e){  
        e.preventDefault();
        let usuario       = $("#txtUsuario").val();
        let contrasen     = $("#txtContrasena").val();
        let observaciones = $("#txtObservaciones").val();
        let rol           = $("#sltRol").val();
        let tercero       = $("#sltTercero").val();
        let estado        = $("#sltEstado").val();
        let token         = $('input[name="_csrf"]').val();
        
        var json = { 
            usuario : usuario, contrasen : contrasen, observaciones : observaciones,
            rol : rol, tercero : tercero, estado : estado, _csrf: token
        };
        
        $.ajax({
            url: "NuevoUsuario",
            type: "POST",
            data: json,
            success: function(data){                                
                if(data == "1"){
                    llamarCuerpo('Usuarios');
                    swal( "Información", "Información guardada correctamente!", "success");
                }else{
                    swal( "Información", "No se puede eliminar la información!", "danger");
                }                
            }
        });
    });
    
    function eliminar(id){
        swal({
            title: "Confirmación!",
            text: "Desea eliminar el registro seleccionado?",
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "Cancelar",
            confirmButtonClass: "btn-danger",
            cancelButtonClass: "btn-default",
            confirmButtonText: "Aceptar",
            closeOnConfirm: false
        }, 
        function(){
            $.ajax({
                url:"EliminarUsuario",
                data:{id: id},
                type:"POST",
                success: function (data) {   
                    if(data == 1){
                        llamarCuerpo('Usuarios');
                        swal( "Información!", "Información eliminada correctamente!", "success");
                    }else{
                        swal( "Información!", "No se puede eliminar la información!", "danger");
                    }                
                }
            });
        }
        );
    };
    
    $("#mldUsuarios").on('shown.bs.modal', function(e){
        let btn   = $(e.relatedTarget);
        let id    = btn.data("id");
        let modal = $(this);
        $.ajax({
            type: "POST",              
            url: "ObtenerUsuario/"+id,
            success: function(data){
                let res = JSON.parse(data);
                modal.find(".modal-body #txtId").val(res.id);
                modal.find(".modal-body #txtUsuarioE").val(res.usuario);
                modal.find(".modal-body #txtContrasenaE").val(res.contrasen);
                modal.find(".modal-body #txtObservacionesE").val(res.observaciones);
                modal.find(".modal-body #sltRolE").val(res.rol).trigger("change");
                modal.find(".modal-body #sltTerceroE").val(res.tercero).trigger("change");
                modal.find(".modal-body #sltEstadoE").val(res.estado).trigger("change");
            }
        });                
    });
    
    $("#btnEditar").click(function(){
        let id                 = $("#txtId").val();
        let usuario            = $("#txtUsuarioE").val();
        let contrasen          = $("#txtContrasenaE").val();
        let observaciones      = $("#txtObservacionesE").val();
        let rol                = $("#sltRolE").val();
        let tercero            = $("#sltTerceroE").val();
        let estado             = $("#sltEstadoE").val();
        let fecha              = new Date();        
        let fechaactualizacion = fecha.getFullYear()+"-"+(fecha.getMonth()+1)+"-"+fecha.getDate();
        
        let json = {
            id : id, usuario : usuario, contrasen : contrasen, observaciones : observaciones,
            rol : rol, tercero : tercero, estado : estado, fechaactualizacion: fechaactualizacion
        };               
        
        $.ajax({
            type: "POST",
            url: "EditarUsuario",
            data: json,
            success: function (data) {
                if(data == 1){
                    $("#mldUsuarios").modal('hide');                    
                    llamarCuerpo('Usuarios');
                    swal( "Información!", "Información modificada correctamente!", "success");
                }else{
                    swal( "Información!", "No se puede modificar la información!", "danger");
                }
            }
        });
    });
</script>