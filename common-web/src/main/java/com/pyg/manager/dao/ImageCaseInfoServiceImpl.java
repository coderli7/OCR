package com.pyg.manager.dao;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pyg.manager.commonutils.MyCommonUtils;
import com.pyg.manager.dao.mapper.TbImageCaseInfoMapper;
import com.pyg.manager.dao.mapper.TbImageMapper;
import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.dao.pojo.TbImageCaseInfo;
import com.pyg.manager.dao.pojo.TbImageCaseInfoExample;
import com.pyg.manager.dao.pojo.TbImageCaseInfoExample.Criteria;

import entity.PageResult;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */
@Service("imageCaseInfoService")
public class ImageCaseInfoServiceImpl implements ImageCaseInfoService {

	@Autowired
	private TbImageCaseInfoMapper imageCaseInfoMapper;

	@Autowired
	private TbImageMapper imageMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbImageCaseInfo> findAll() {
		return imageCaseInfoMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbImageCaseInfo> page = (Page<TbImageCaseInfo>) imageCaseInfoMapper
				.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbImageCaseInfo imageCaseInfo) {
		imageCaseInfoMapper.insert(imageCaseInfo);
	}

	/**
	 * 修改
	 */
	@Override
	public void update(TbImageCaseInfo imageCaseInfo) {
		imageCaseInfoMapper.updateByPrimaryKeyWithBLOBs(imageCaseInfo);
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public TbImageCaseInfo findOne(Long id) {
		return imageCaseInfoMapper.selectByPrimaryKey(id.intValue());
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			TbImageCaseInfo imageCaseInfo = imageCaseInfoMapper
					.selectByPrimaryKey(id.intValue());
			if (imageCaseInfo != null) {
				imageCaseInfo.setCasestatus("删除");
				imageCaseInfoMapper.updateByPrimaryKey(imageCaseInfo);
			}

		}
	}

	@Override
	public PageResult findPage(TbImageCaseInfo imageCaseInfo, int pageNum,
			int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbImageCaseInfoExample example = new TbImageCaseInfoExample();
		Criteria criteria = example.createCriteria();
		if (imageCaseInfo != null) {
			if (imageCaseInfo.getCaseid() != null
					&& imageCaseInfo.getCaseid().length() > 0) {
				criteria.andCaseidLike("%" + imageCaseInfo.getCaseid() + "%");
			}
			if (imageCaseInfo.getUsercode() != null
					&& imageCaseInfo.getUsercode().length() > 0) {
				criteria.andUsercodeLike(
						"%" + imageCaseInfo.getUsercode() + "%");
			}
			
			//新增模糊查询，info1用来模糊匹配名称
			String nameTmp = imageCaseInfo.getInfo1();
			if (!StringUtils.isBlank(nameTmp)) {
				criteria.andResultLike("%"+nameTmp+"%");
			}
		}
		
		criteria.andCasestatusNotLike("%" + "删除" + "%");
		example.setOrderByClause("id desc");
		Page<TbImageCaseInfo> page = (Page<TbImageCaseInfo>) imageCaseInfoMapper
				.selectByExampleWithBLOBs(example);
        //标注颜色
		List<TbImageCaseInfo> caseInfos = page.getResult();
		for (TbImageCaseInfo tbImageCaseInfo : caseInfos) {
			if ("未完成".equals(tbImageCaseInfo.getCasestatus())) {
				tbImageCaseInfo.setInfo2(MyCommonUtils.MyColor_Red);
			}else {
				//1.含有未识别出图片的标记黄色
				List<TbImage> images = imageMapper
						.findByCaseId(tbImageCaseInfo.getCaseid());
				for (TbImage tbImage : images) {
					if (tbImage.getImgresultmodelclass() == null
							|| tbImage.getImgresultmodelclass() == "") {
						tbImageCaseInfo.setInfo2(MyCommonUtils.MyColor_Yellow);
						tbImageCaseInfo.setTips("请注意包含未识别票据;");
						break;
					}
				}
				
				//2.含有特殊字符的,标记黄色
				String allResult = tbImageCaseInfo.getResult();
				if (!StringUtils.isBlank(allResult)&&allResult.contains("^")) {
					tbImageCaseInfo.setInfo2(MyCommonUtils.MyColor_Yellow);
					String tips = tbImageCaseInfo.getTips();
					tips=StringUtils.isBlank(tips)?"":tips;
					tips+="请注意包含模糊票据;";
					tbImageCaseInfo.setTips(tips);
				}
				
			}
		}
		return new PageResult(page.getTotal(), page.getResult());
	}

	public List<TbImageCaseInfo> findByCaseId(String caseId) {

		return imageCaseInfoMapper.findByCaseId(caseId);
	}

	@Override
	public List<TbImageCaseInfo> findByDate(String curUser, String startDate,
			String endDate,String caseStatus) {
		if ("admin".equals(curUser)) {
			curUser = "";
		}
		if (StringUtils.isBlank(caseStatus)) {
			caseStatus="完成";
		}
		
		return imageCaseInfoMapper.findByDate(startDate, endDate, curUser,
				caseStatus);
	}
}
