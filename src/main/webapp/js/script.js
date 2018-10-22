$("#barra").click(function(){
    $("#main").slideToggle(100, function (){
        if($("#main").is(':visible')){
            $("#flecha").removeClass('fa-arrow-right').addClass('fa-arrow-left');
            $("#contenido").removeClass('col-sm-12 col-md-12 col-lg-12 col-xl-12').addClass('col-sm-10 col-md-10 col-lg-10 col-xl-10');
        }else{        
            $("#flecha").removeClass('fa-arrow-left').addClass('fa-arrow-right');
            $("#contenido").removeClass('col-sm-10 col-md-10 col-lg-10').addClass('col-sm-12 col-md-12 col-lg-12');
        } 
    });    
});

$(".select").select2({
    theme: 'bootstrap4',    
    allowClear: true,
    tags: true,
    language: "es"
});

function obtenerHijos(id){
    let token = $('input[name="_csrf"]').val();
    $.ajax({
        type: "POST",
        url: "Dropdown",
        data: {padre : id, _csrf: token},
        success:function(response){
            $("#hijos"+id).html(response);
        }
    });
}

function llamarCuerpo(ruta){
    let token = $('input[name="_csrf"]').val();
    $.ajax({
        type: "GET",
        url: ruta,
        data: {_csrf: token},
        success: function(response){
            $("#cuerpo").html(response);
        }
    });
}

function CerrarSesion(){
    swal({
        title: "Confirmación!",
        text: "Desea salir de SIGIEP?",
        type: "info",        
        showCancelButton: true,
        cancelButtonText: "Cancelar",
        confirmButtonText: "Salir",
        closeOnConfirm: false,
        closeOnCancel: true,
        confirmButtonClass: 'btn-danger',
        cancelButtonClass: "btn-default"
    },
    function (isConfirm){
        if(isConfirm){
            window.location = "Logout";
        }
    }
    );
}