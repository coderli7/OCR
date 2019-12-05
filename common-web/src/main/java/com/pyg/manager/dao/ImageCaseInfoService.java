package com.pyg.manager.dao;
import java.util.List;


import com.pyg.manager.dao.pojo.TbImageCaseInfo;

import entity.PageResult;
/**
 * 服务层接口
 * 
 * @author Administrator
 *
 */
public interface ImageCaseInfoService {

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	public List<TbImageCaseInfo> findAll();

	/**
	 * 返回分页列表
	 * 
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);

	/**
	 * 增加
	 */
	public void add(TbImageCaseInfo imageCaseInfo);

	/**
	 * 修改
	 */
	public void update(TbImageCaseInfo imageCaseInfo);

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	public TbImageCaseInfo findOne(Long id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * 
	 * @param pageNum
	 *            当前页 码
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */
	public PageResult findPage(TbImageCaseInfo imageCaseInfo, int pageNum,
                               int pageSize);

	public List<TbImageCaseInfo> findByCaseId(String caseId);

	/**
	 * 日期区间查询
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<TbImageCaseInfo> findByDate(String curUser, String startDate, String endDate, String caseStatus);
}
