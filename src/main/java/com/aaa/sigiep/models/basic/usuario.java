
package com.aaa.sigiep.models.basic;

public class usuario {
    
    public Integer id;
    public String usuario;
    public String contrasen;
    public String fechaactualizacion;
    public String observaciones;
    public Integer rol;
    public Integer tercero;
    public Integer estado;

    public usuario() {}
    
    public usuario(String usuario, String contrasen, Integer id, Integer tercero) {
        this.usuario = usuario;
        this.contrasen = contrasen;
        this.id = id;
        this.tercero = tercero;
    }    

    public usuario(Integer id, String usuario, String contrasen, String fechaactualizacion, String observaciones, Integer rol, Integer tercero, Integer estado) {
        this.id = id;
        this.usuario = usuario;
        this.contrasen = contrasen;
        this.fechaactualizacion = fechaactualizacion;
        this.observaciones = observaciones;
        this.rol = rol;
        this.tercero = tercero;
        this.estado = estado;
    }

    public usuario(String usuario, String contrasen, String fechaactualizacion, String observaciones, Integer rol, Integer tercero, Integer estado) {
        this.usuario = usuario;
        this.contrasen = contrasen;
        this.fechaactualizacion = fechaactualizacion;
        this.observaciones = observaciones;
        this.rol = rol;
        this.tercero = tercero;
        this.estado = estado;
    }       
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasen() {
        return contrasen;
    }

    public void setContrasen(String contrasen) {
        this.contrasen = contrasen;
    }

    public String getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(String fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public Integer getTercero() {
        return tercero;
    }

    public void setTercero(Integer tercero) {
        this.tercero = tercero;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }    
}
