package com.aaa.sigiep.dao.impl.basic;

import java.util.List;
import javax.sql.DataSource;
import com.aaa.sigiep.dao.basic.usuarioDao;
import com.aaa.sigiep.models.basic.usuario;
import com.aaa.sigiep.models.basic.login;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Repository
public class usuarioDaoImp extends JdbcDaoSupport implements usuarioDao{
    @Autowired
    public usuarioDaoImp(DataSource dataSource){
        this.setDataSource(dataSource);
    }
    
    @Override
    public usuario buscarUsuario(String nombre){        
        String sql = "SELECT gus.usuario, gus.contrasen, gus.tercero, gus.rol, gus.id_unico "
                + "FROM  Sigiep.gs_usuario AS gus "
                + "WHERE gus.estado  = 1 "
                + "AND   gus.usuario = '"+nombre+"'";
        List<usuario> user = this.getJdbcTemplate().query(sql, new LoginMapper());        
        return user.size() > 0 ? user.get(0) : null;        
    }
    
    @Override
    public usuario validarUsuario(login Login){
        String sql = "SELECT gus.usuario, gus.contrasen, gus.tercero, gus.rol, gus.id_unico "
                + "FROM  Sigiep.gs_usuario AS gus "
                + "WHERE gus.estado  = 1 "
                + "AND   gus.usuario = '"+Login.getTxtNombre()+"' "
                + "AND   gus.contrasen = '" + Login.getTxtContrasena()+ "' ";
        List<usuario> uss = this.getJdbcTemplate().query(sql, new LoginMapper());
        return uss.size() > 0 ? uss.get(0) : null;
    }   
    
    @Override
    public List<String> obtenerRolesUsuario(String nombre){
        String sql = "SELECT grl.nombre "
                + "FROM Sigiep.gs_usuario AS gsu "
                + "LEFT JOIN Sigiep.gs_rol AS grl ON gsu.rol = grl.id_unico "
                + "WHERE gsu.usuario = ?";        
        Object[] params = new Object[]{nombre};
        List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);        
        return roles;
    }
    
    @Override
    public List<String> ListadoUsuario(){
        String sql = "SELECT gsu.id_unico, gsu.usuario, HASHBYTES('SHA1', gsu.contrasen) as pass, gsu.observaciones, "
                + "grl.nombre as rol, geu.nombre as estado, "
                + "IIF(gtr.nombreuno + gtr.nombredos + gtr.apellidouno + gtr.apellidodos IS NULL, "
                + "gtr.razonsocial, gtr.nombreuno + gtr.nombredos + gtr.apellidouno + gtr.apellidodos) AS nomTer "
                + "FROM Sigiep.gs_usuario AS gsu "
                + "LEFT JOIN Sigiep.gs_rol AS grl ON gsu.rol = grl.id_unico "
                + "LEFT JOIN Sigiep.gs_estado_usuario AS geu ON gsu.estado = geu.id_unico "
                + "LEFT JOIN Sigiep.gf_tercero AS gtr ON gsu.tercero = gtr.id_unico ";
        List users = this.getJdbcTemplate().queryForList(sql);
        return users;
    }
    
    @Override
    public List<String> ListadoEstado(){
        String sql = "SELECT id_unico, nombre FROM Sigiep.gs_estado_usuario";
        List estados = this.getJdbcTemplate().queryForList(sql);
        return estados;
    }
    
    @Override
    public List<String> ListadoTerceros(){
        String sql = "SELECT gtr.id_unico, "
                + "IIF(gtr.nombreuno + gtr.nombredos + gtr.apellidouno + gtr.apellidodos IS NULL, "
                + "gtr.razonsocial, gtr.nombreuno + gtr.nombredos + gtr.apellidouno + gtr.apellidodos) AS nomTer, "
                + "gti.sigla + ' ' + gtr.numeroidentificacion as num "
                + "FROM Sigiep.gf_tercero AS gtr "
                + "LEFT JOIN Sigiep.gf_tipo_identificacion AS gti ON gtr.tipoidentificacion = gti.id_unico ";
        List terceros = this.getJdbcTemplate().queryForList(sql);
        return terceros;
    }
    
    @Override
    public List<String> ListadoRoles(String Compania){
        String sql = "SELECT id_unico, nombre FROM Sigiep.gs_rol WHERE compania = " + Compania;
        List roles = this.getJdbcTemplate().queryForList(sql);
        return roles;
    }
    
    @Override
    public Integer Registrar(usuario Usuario){
        String sql = "INSERT INTO Sigiep.gs_usuario (usuario, contrasen, observaciones, "
                + "rol, tercero, estado) VALUES('" + Usuario.getUsuario() + "', '" + Usuario.getContrasen() + "', "
                + "'" + Usuario.getObservaciones() + "', " + Usuario.getRol() + ", "
                + " " + Usuario.getTercero() + ", " + Usuario.getEstado() + ")";
        return this.getJdbcTemplate().update(sql);
    }
    
    @Override
    public Integer Modificar(usuario Usuario){
        String sql = "UPDATE Sigiep.gs_usuario SET "
                + "usuario = '" + Usuario.getUsuario() + "', "
                + "contrasen = '" + Usuario.getContrasen() + "', "
                + "fechaactualizacion = '" + Usuario.getFechaactualizacion() + "', "
                + "observaciones = '" + Usuario.getObservaciones() + "', "
                + "rol = " + Usuario.getRol() + ", "
                + "tercero = " + Usuario.getTercero() + ", "
                + "estado = " + Usuario.getEstado() + " "
                + "WHERE id_unico = " + Usuario.getId();
        return this.getJdbcTemplate().update(sql);
    }
    
    @Override
    public Integer Eliminar(int id){
        String sql = "DELETE FROM Sigiep.gs_usuario WHERE id_unico = " + id;
        return this.getJdbcTemplate().update(sql);
    }
    
    @Override
    public usuario obtenerUsuario(Integer id){
        String sql = "SELECT id_unico, usuario, contrasen, tercero, rol, estado, "
                + "observaciones "
                + "FROM Sigiep.gs_usuario "
                + "WHERE id_unico = " + id;
        List<usuario> usr = this.getJdbcTemplate().query(sql, new UsuarioMapper());
        return usr.size() > 0 ? usr.get(0) : null;
    }
    
    class LoginMapper implements RowMapper<usuario>{
        @Override
        public usuario mapRow(ResultSet rs, int i) throws SQLException{
            usuario user = new usuario();
            user.setId(rs.getInt("id_unico"));
            user.setUsuario(rs.getString("usuario"));
            user.setContrasen(rs.getString("contrasen"));
            user.setTercero(rs.getInt("tercero"));
            user.setRol(rs.getInt("rol"));                        
            return user;
        }
    }
    
    class UsuarioMapper implements RowMapper<usuario>{
        @Override
        public usuario mapRow(ResultSet rs, int i) throws SQLException{
            usuario user = new usuario();
            user.setId(rs.getInt("id_unico"));
            user.setUsuario(rs.getString("usuario"));
            user.setContrasen(rs.getString("contrasen"));
            user.setTercero(rs.getInt("tercero"));
            user.setRol(rs.getInt("rol"));  
            user.setEstado(rs.getInt("estado"));
            user.setObservaciones(rs.getString("observaciones"));
            return user;
        }
    }
}
