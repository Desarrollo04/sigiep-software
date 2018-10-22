package com.aaa.sigiep.dao.impl.basic;

import java.util.List;
import javax.sql.DataSource;
import com.aaa.sigiep.dao.basic.terceroDao;
import com.aaa.sigiep.models.basic.tercero;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class terceroDaoImp extends JdbcDaoSupport implements terceroDao {
    
    @Autowired
    public terceroDaoImp(DataSource dataSource){
        this.setDataSource(dataSource);
    }
    
    @Override
    public List<String> Companias(){
        String sql = "SELECT gtr.id_unico, gtr.razonsocial, gtr.numeroidentificacion, gtr.digitoverficacion " +
                     "FROM Sigiep.gf_tercero AS gtr " +
                     "LEFT JOIN Sigiep.gf_perfil_tercero AS gpf ON gpf.tercero = gtr.id_unico " +
                     "WHERE gpf.perfil = 1";
        Object[] params = new Object[]{};
        List companias = this.getJdbcTemplate().queryForList(sql);
        return companias;
    }
    
    @Override
    public List<Map<String, Object>> obtenerParams(String Compania){        
        String sql = "SELECT id_unico, anno "
                + "FROM Sigiep.gf_parametrizacion_anno "
                + "WHERE compania = ? AND estadoanno = 1"
                + "ORDER BY anno DESC";
        Object[] params = new Object[]{Compania};
        List<Map<String, Object>> Aparams = this.getJdbcTemplate().queryForList(sql, params);        
        return Aparams;
    }
    
    @Override
    public tercero obtenerCompania(String Compania){
        String sql = "SELECT ter.id_unico, ter.razonsocial, ter.ruta_logo, "
                + "ter.tipoidentificacion, ter.numeroidentificacion, ter.digitoverficacion "
                + "FROM Sigiep.gf_tercero as ter "
                + "WHERE ter.id_unico = " + Compania;        
        List<tercero> ter = this.getJdbcTemplate().query(sql, new CompaniaMapper());
        return ter.size() > 0 ? ter.get(0) : null;
    }
    
    class TerceroMapper implements RowMapper<tercero>{
        @Override
        public tercero mapRow(ResultSet rs, int i) throws SQLException{
            tercero ter = new tercero();
            ter.setId_unico(rs.getInt("id_unico"));
            ter.setNombreUno(rs.getString("nombreuno"));
            ter.setNombreDos(rs.getString("nombredos"));
            ter.setApellidoUno(rs.getString("apellidouno"));
            ter.setApellidoDos(rs.getString("apellidodos"));
            ter.setRazonSocial(rs.getString("razonsocial"));
            ter.setNombreComercial(rs.getString("nombrecomercial"));
            ter.setNumeroIdentificacion(rs.getString("numeroidentificacion"));
            ter.setDigitoVerficacion(rs.getInt("digitoverificacion"));
            ter.setCompania(rs.getInt("compania"));
            ter.setTipoIdenficacion(rs.getInt("tipoidentificacion"));
            ter.setSucursal(rs.getInt("sucursal"));
            ter.setRepresentanteLegal(rs.getInt("representantelegal"));
            ter.setCiudadResidencia(rs.getInt("ciudadresiendencia"));
            ter.setCiudadIdenficacion(rs.getInt("ciudadidentificacion"));
            ter.setTipoRegimen(rs.getInt("tiporegimen"));
            ter.setContacto(rs.getInt("contacto"));
            ter.setZona(rs.getInt("zona"));
            ter.setCargo(rs.getInt("cargo"));
            ter.setTipoEmpresa(rs.getInt("tipoempresa"));
            ter.setTipoEntidad(rs.getInt("tipoentidad"));
            ter.setCodigoDane(rs.getString("codigodane"));
            ter.setRutaLogo(rs.getString("ruta_logo"));
            ter.setTargetaProfesional(rs.getString("targetaprofesional"));
            ter.setTipoCompania(rs.getInt("tipocompania"));
            ter.setFechaNacimiento(rs.getDate("fechanacimiento"));
            ter.setEmail(rs.getString("email"));
            ter.setMigradoCCB(rs.getString("migradoccb"));
            ter.setFirma(rs.getString("firma"));
            return ter;
        }
    }
    
    class CompaniaMapper implements RowMapper<tercero>{
        @Override
        public tercero mapRow(ResultSet rs, int i) throws SQLException{
            tercero ter = new tercero();
            ter.setId_unico(rs.getInt("id_unico"));            
            ter.setRazonSocial(rs.getString("razonsocial"));            
            ter.setNumeroIdentificacion(rs.getString("numeroidentificacion"));                        
            ter.setTipoIdenficacion(rs.getInt("tipoidentificacion"));                        
            ter.setRutaLogo(rs.getString("ruta_logo"));            
            return ter;
        }        
    }
}
