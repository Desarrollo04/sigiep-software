$("#sltCompania").append(function(e){
    let compania = $("#sltCompania").val();
    let token = $('input[name="_csrf"]').val();        
    
    if(compania.length > 0 || compania !== ""){
        $.ajax({
            type:"POST",
            url: "params",
            data: { Compania: compania,  _csrf: token },
            success:function(response){                
                $("#sltAnno").html(response).trigger("change");
            }
        });
    }        
});