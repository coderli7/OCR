package com.pyg.manager.dao.mapper;

import com.pyg.manager.dao.pojo.Authorities;
import com.pyg.manager.dao.pojo.AuthoritiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthoritiesMapper {
    int countByExample(AuthoritiesExample example);

    int deleteByExample(AuthoritiesExample example);

    int insert(Authorities record);

    int insertSelective(Authorities record);

    List<Authorities> selectByExample(AuthoritiesExample example);

    int updateByExampleSelective(@Param("record") Authorities record, @Param("example") AuthoritiesExample example);

    int updateByExample(@Param("record") Authorities record, @Param("example") AuthoritiesExample example);
}