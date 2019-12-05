package com.pyg.manager.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pyg.manager.dao.mapper.TbImageMapper;
import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.dao.pojo.TbImageExample;
import com.pyg.manager.dao.pojo.TbImageExample.Criteria;

import entity.PageResult;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */

@Service("imageService")
public class ImageServiceImpl implements ImageService {

	@Autowired
	private TbImageMapper imageMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbImage> findAll() {
		return imageMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbImage> page = (Page<TbImage>) imageMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbImage image) {
		imageMapper.insert(image);
	}

	/**
	 * 修改
	 */
	@Override
	public void update(TbImage image) {
		imageMapper.updateByPrimaryKeyWithBLOBs(image);
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public TbImage findOne(Long id) {
		return imageMapper.selectByPrimaryKey(new Long(id).intValue());
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			imageMapper.deleteByPrimaryKey(new Long(id).intValue());
		}
	}

	@Override
	public PageResult findPage(TbImage image, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TbImageExample example = new TbImageExample();
		Criteria criteria = example.createCriteria();

		if (image != null) {
			if (image.getCaseid() != null && image.getCaseid().length() > 0) {
				criteria.andCaseidEqualTo("%" + image.getCaseid() + "%");
			}
			if (image.getImgname() != null && image.getImgname().length() > 0) {
				criteria.andImgnameEqualTo("%" + image.getImgname() + "%");
			}
			if (image.getImgpath() != null && image.getImgpath().length() > 0) {
				criteria.andImgnameLike("%" + image.getImgpath() + "%");
			}
			if (image.getDelstatus() != null
					&& image.getDelstatus().length() > 0) {
				criteria.andDelstatusLike("%" + image.getDelstatus() + "%");
			}

		}

		Page<TbImage> page = (Page<TbImage>) imageMapper
				.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<TbImage> findByCaseId(String caseId) {
		List<TbImage> images = imageMapper.findByCaseId(caseId);
		return images;
	}

	public List<TbImage> findByModel(TbImage image) {

		TbImageExample example = new TbImageExample();
		Criteria criteria = example.createCriteria();

		if (image != null) {
			if (image.getCaseid() != null && image.getCaseid().length() > 0) {
				criteria.andCaseidEqualTo(image.getCaseid());
			}
			if (image.getImgname() != null && image.getImgname().length() > 0) {
				criteria.andImgnameEqualTo(image.getImgname());
			}
			if (image.getImgpath() != null && image.getImgpath().length() > 0) {
				criteria.andImgnameLike(image.getImgpath());
			}
			if (image.getDelstatus() != null
					&& image.getDelstatus().length() > 0) {
				criteria.andDelstatusLike(image.getDelstatus());
			}
		}

		return imageMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<TbImage> findByDate(String startDate, String endDate) {
		return imageMapper.findByDate(startDate, endDate);
	}
}
