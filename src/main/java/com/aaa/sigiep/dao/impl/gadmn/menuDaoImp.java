package com.aaa.sigiep.dao.impl.gadmn;

import javax.sql.DataSource;
import com.aaa.sigiep.dao.gadmn.menuDao;
import com.aaa.sigiep.models.gadmn.menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Repository
public class menuDaoImp extends JdbcDaoSupport implements menuDao{    
    @Autowired
    public menuDaoImp(DataSource dataSource){
        this.setDataSource(dataSource);
    }
    
    @Override
    public List<String> obtenerMenuRol(String Rol){
        String sql = "SELECT gsm.id_unico, gsm.nombre, gsm.ruta, gsm.predecesor, gsm.imagen "
                + "FROM Sigiep.gs_privilegios_rol AS gpl "
                + "LEFT JOIN Sigiep.gs_menu AS gsm ON gpl.menu = gsm.id_unico " 
                + "WHERE gpl.rol =  " + Rol + " "
                + "AND gsm.predecesor IS NULL "
                + "ORDER BY gsm.nombre ASC ";        
        List menus  = this.getJdbcTemplate().queryForList(sql);        
        return menus;
    }
    
    @Override
    public List<String> obtenerHijosPrimeraCapa(String Rol, String Ruta){
        String sql = "SELECT gsm.id_unico, gsm.nombre, gsm.ruta, gsm.predecesor "
                + "FROM Sigiep.gs_privilegios_rol AS gpl "
                + "LEFT JOIN Sigiep.gs_menu AS gsm ON gpl.menu = gsm.id_unico "
                + "LEFT JOIN Sigiep.gs_menu AS gpr ON gsm.predecesor = gpr.id_unico "
                + "WHERE gpl.rol = " + Rol +" "
                + "AND gpr.ruta = '" + Ruta + "' "
                + "ORDER BY gsm.nombre ASC";
        List menus  = this.getJdbcTemplate().queryForList(sql);        
        return menus;
    }
    
    @Override
    public List<Map<String, Object>> obtenerHijos(String padre){
        String sql = "SELECT gsm.id_unico, gsm.nombre, gsm.ruta, gsm.predecesor "
                + "FROM Sigiep.gs_menu AS gsm "
                + "WHERE gsm.predecesor = " + padre + " "
                + "ORDER BY gsm.nombre ASC";        
        List<Map<String, Object>> params = this.getJdbcTemplate().queryForList(sql);
        return params;
    }
    
    class MenuMapper implements RowMapper<menu>{
        @Override
        public menu mapRow(ResultSet rs, int i) throws SQLException{
            menu main = new menu();
            main.setId_Unico(rs.getInt("id_unico"));
            main.setNombre(rs.getString("nombre"));
            main.setRuta(rs.getString("ruta"));
            main.setPredecesor(rs.getInt("predecesor"));
            return main;
        }
    }
}
