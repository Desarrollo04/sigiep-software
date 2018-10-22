package com.aaa.sigiep.dao.impl.basic;

import java.util.List;
import javax.sql.DataSource;
import com.aaa.sigiep.dao.basic.paramDao;
import com.aaa.sigiep.models.basic.param;
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
public class paramDaoImp extends JdbcDaoSupport implements paramDao{
    
    @Autowired
    public paramDaoImp(DataSource dataSource){
        this.setDataSource(dataSource);
    }
    
    @Override
    public param obtenerParamActual(String param){
        String sql = "SELECT id_unico, anno "
                + "FROM Sigiep.gf_parametrizacion_anno "
                + "WHERE id_unico = " + param;
        List<param> xpar = this.getJdbcTemplate().query(sql, new ParamMapper());
        return xpar.size() > 0 ? xpar.get(0) : null;
    }
    
    class ParamMapper implements RowMapper<param>{
        @Override
        public param mapRow(ResultSet rs, int i) throws SQLException{
            param par = new param();
            par.setId_Unico(rs.getInt("id_unico"));
            par.setAnno(rs.getString("anno"));
            return par;            
        }
    }
}