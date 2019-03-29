package com.vk.liyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vk.liyj.dynamicDataSource.TargetDataSource;
import com.vk.liyj.mapper.CommonMapper;
import com.vk.liyj.model.ConsultConfigArea;
import com.vk.liyj.model.ConsultContent;

@Service
@Profile("product")//指定使用生产环境的配置
public class CommonServiceImpl implements ICommonService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CommonMapper mapper;

    @Override
    public List<ConsultContent> queryContent(Map map) {
        String sql = "select * from consult_content a where a.state = 0 and a.type = 1 order by a.itemindex";
        return jdbcTemplate.query(sql, new RowMapper<ConsultContent>() {

            public ConsultContent mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                ConsultContent cc = new ConsultContent();
                cc.setContent(rs.getString("content"));
                cc.setId(rs.getInt("id"));
                cc.setItemIndex(rs.getInt("itemIndex"));
                cc.setState(rs.getInt("state"));
                cc.setType(rs.getString("type"));
                return cc;
            }
        });
    }

    @TargetDataSource(name = "ds1")
    public List<ConsultConfigArea> qryArea(Map param) {
        return mapper.qryArea(param);
    }

    @Transactional
    @TargetDataSource(name = "ds2")
    public int saveArea(ConsultConfigArea area) {
        int cout = mapper.saveArea(area);
        //        throw new RuntimeException();
        return cout;
    }

    public int saveAreaToBase(ConsultConfigArea area) {
        return mapper.saveArea(area);
    }

    public List<ConsultConfigArea> qryAreaFromBase(Map param) {
        return mapper.qryArea(param);
    }

}
