package com.aaa.sigiep.dao.gadmn;
import java.util.List;
import java.util.Map;

public interface menuDao {    
    public List<String> obtenerMenuRol(String Rol); 
    public List<String> obtenerHijosPrimeraCapa(String Rol, String Ruta);
    public List<Map<String, Object>> obtenerHijos(String Padre);
}
