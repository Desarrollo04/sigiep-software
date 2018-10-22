package com.aaa.sigiep.models.basic;

/**
 *
 * @author SERVIDOR
 */
public class login {
    public String txtNombre;
    public String txtContrasena;
    public int sltCompania;
    public int sltAnno;

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtContrasena() {
        return txtContrasena;
    }

    public void setTxtContrasena(String txtContrasena) {
        this.txtContrasena = txtContrasena;
    }

    public int getSltCompania() {
        return sltCompania;
    }

    public void setSltCompania(int sltCompania) {
        this.sltCompania = sltCompania;
    }

    public int getSltAnno() {
        return sltAnno;
    }

    public void setSltAnno(int sltAnno) {
        this.sltAnno = sltAnno;
    }

    public login(String txtNombre, String txtContrasena, int sltCompania, int sltAnno) {
        super();
        this.txtNombre = txtNombre;
        this.txtContrasena = txtContrasena;
        this.sltCompania = sltCompania;
        this.sltAnno = sltAnno;
    }

    public login() {
        super();
    }
    
    
}
