package com.pyg.manager.dao.mapper;

import com.pyg.manager.dao.pojo.TbImageCaseInfo;
import com.pyg.manager.dao.pojo.TbImageCaseInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbImageCaseInfoMapper {
	int countByExample(TbImageCaseInfoExample example);

	int deleteByExample(TbImageCaseInfoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TbImageCaseInfo record);

	int insertSelective(TbImageCaseInfo record);

	List<TbImageCaseInfo> selectByExample(TbImageCaseInfoExample example);
	
	List<TbImageCaseInfo> selectByExampleWithBLOBs(TbImageCaseInfoExample example);

	TbImageCaseInfo selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TbImageCaseInfo record,
                                 @Param("example") TbImageCaseInfoExample example);

	int updateByExample(@Param("record") TbImageCaseInfo record,
                        @Param("example") TbImageCaseInfoExample example);

	int updateByPrimaryKeySelective(TbImageCaseInfo record);

	int updateByPrimaryKey(TbImageCaseInfo record);
	
	int updateByPrimaryKeyWithBLOBs(TbImageCaseInfo record);

	List<TbImageCaseInfo> findByCaseId(String caseId);

	List<TbImageCaseInfo> findByDate(@Param("startDate") String startDate,
                                     @Param("endDate") String endDate, @Param("userCode") String userCode, @Param("caseStatus") String caseStatus);//caseStatus

}