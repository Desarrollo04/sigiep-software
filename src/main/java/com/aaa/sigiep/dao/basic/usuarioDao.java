package com.aaa.sigiep.dao.basic;

import java.util.List;
import com.aaa.sigiep.models.basic.usuario;
import com.aaa.sigiep.models.basic.login;

public interface usuarioDao {
    public usuario buscarUsuario(String usuario);  
    public List<String> obtenerRolesUsuario(String usuario);
    public usuario validarUsuario(login Login);
    public List<String> ListadoUsuario();
    public List<String> ListadoEstado();
    public List<String> ListadoTerceros();
    public List<String> ListadoRoles(String Compania);
    public Integer Registrar(usuario Usuario);
    public Integer Modificar(usuario Usuario);
    public Integer Eliminar(int id);
    public usuario obtenerUsuario(Integer id);
}
