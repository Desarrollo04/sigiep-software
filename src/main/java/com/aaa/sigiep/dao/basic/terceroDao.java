package com.aaa.sigiep.dao.basic;

import java.util.List;
import com.aaa.sigiep.models.basic.tercero;
import java.util.Map;

public interface terceroDao {           
    public List<String> Companias();    
    public List<Map<String, Object>> obtenerParams(String Compania);
    public tercero obtenerCompania(String Compania);
}