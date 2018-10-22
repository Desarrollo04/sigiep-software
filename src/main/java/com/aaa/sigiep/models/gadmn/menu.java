package com.aaa.sigiep.models.gadmn;

public class menu {
    public Integer Id_Unico;
    public String Nombre;
    public String Ruta;
    public Integer Predecesor;

    public menu() {
    }

    public menu(Integer Id_Unico, String Nombre, String Ruta, Integer Predecesor) {
        this.Id_Unico = Id_Unico;
        this.Nombre = Nombre;
        this.Ruta = Ruta;
        this.Predecesor = Predecesor;
    }

    public menu(String Nombre, String Ruta, Integer Predecesor) {
        this.Nombre = Nombre;
        this.Ruta = Ruta;
        this.Predecesor = Predecesor;
    }    
    
    public Integer getId_Unico() {
        return Id_Unico;
    }

    public void setId_Unico(Integer Id_Unico) {
        this.Id_Unico = Id_Unico;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String Ruta) {
        this.Ruta = Ruta;
    }

    public Integer getPredecesor() {
        return Predecesor;
    }

    public void setPredecesor(Integer Predecesor) {
        this.Predecesor = Predecesor;
    }    
}
