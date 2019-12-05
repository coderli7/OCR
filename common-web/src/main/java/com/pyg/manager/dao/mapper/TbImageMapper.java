package com.pyg.manager.dao.mapper;

import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.dao.pojo.TbImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbImageMapper {
	int countByExample(TbImageExample example);

	int deleteByExample(TbImageExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TbImage record);

	int insertSelective(TbImage record);

	List<TbImage> selectByExample(TbImageExample example);

	TbImage selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TbImage record,
                                 @Param("example") TbImageExample example);

	int updateByExample(@Param("record") TbImage record,
                        @Param("example") TbImageExample example);

	int updateByPrimaryKeySelective(TbImage record);

	int updateByPrimaryKey(TbImage record);

	List<TbImage> findByCaseId(String caseId);

	int updateByPrimaryKeyWithBLOBs(TbImage record);

	List<TbImage> selectByExampleWithBLOBs(TbImageExample example);

	List<TbImage> findByDate(@Param("startDate") String startDate,
                             @Param("endDate") String endDate);

}