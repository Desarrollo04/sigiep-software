$("#barra").click(function(){
    $("#main").slideToggle(100, function (){
        if($("#main").is(':visible')){
            $("#flecha").removeClass('glyphicon-arrow-right').addClass('glyphicon-arrow-left');
            $("#contenido").removeClass('col-sm-12 col-md-12 col-lg-12').addClass('col-sm-10 col-md-10 col-lg-10');
        }else{        
            $("#flecha").removeClass('glyphicon-arrow-left').addClass('glyphicon-arrow-right');
            $("#contenido").removeClass('col-sm-10 col-md-10 col-lg-10').addClass('col-sm-12 col-md-12 col-lg-12');
        } 
    });    
});