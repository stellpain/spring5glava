package ch1;

import ch2.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
 class JdbcSingerDao implements SingerDao, InitializingBean {
    private DataSource dataSource;
    private JdbcSingerDao jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource=dataSource;
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public void afterPropertiesSet() throws Exception {
        if (namedParameterJdbcTemplate ==null){
            throw new BeanCreationException("Null NamedParameterJdbcTemplate on SingerDao");
        }
    }

    @Override public String findNameById(Long id) {
        String sql = "SELECT first_name ||' '|| last_name " + "FROM singer WHERE id = :singerID";
        Map<String,Object> namedParameters = new HashMap<>();
        namedParameters.put("singerID",id);
        return namedParameterJdbcTemplate.queryForObject(sql,namedParameters,String.class);
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void insert(Singer singer){
        throw new NotImplementedException("insert");
    }

    private void queryForObject() {
    }

    public void setJdbcTemplate(JdbcSingerDao jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }
}
