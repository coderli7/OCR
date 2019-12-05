package com.pyg.manager.controller;
import com.pyg.manager.commonutils.MyCommonUtils;
import com.pyg.manager.dao.ImageCaseInfoService;
import com.pyg.manager.dao.ImageService;
import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.dao.pojo.TbImageCaseInfo;
import com.pyg.manager.model.BaseAcResponse;
import com.pyg.manager.model.WebApiRequest.BaseRequest;
import com.pyg.manager.model.WebApiResponse.BaseResponse;
import com.pyg.manager.model.pageinfo.CasePageInfo;
import com.pyg.manager.model.pageinfo.ImgPageInfo;
import com.pyg.manager.service.*;
import entity.PageResult;
import entity.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * controller
 * 
 * @author Administrator
 *
 */

@RestController
@RequestMapping("/imageCaseInfo")
public class ImageCaseInfoController {

	@Autowired
	private ImageService imageService;

	@Autowired
	private ImageCaseInfoService imageCaseInfoService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbImageCaseInfo> findAll() {
		return imageCaseInfoService.findAll();
	}

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		return imageCaseInfoService.findPage(page, rows);
	}

	/**
	 * 增加
	 * 
	 * @param imageCaseInfo
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbImageCaseInfo imageCaseInfo) {
		try {
			imageCaseInfoService.add(imageCaseInfo);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	/**
	 * 修改
	 * 
	 * @param imageCaseInfo
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbImageCaseInfo imageCaseInfo) {
		try {
			imageCaseInfoService.update(imageCaseInfo);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException
	 */
	@RequestMapping("/findOne")
	public CasePageInfo findOne(Long id) throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {
		BaseService service = new ImageCaseFindOneService();
		service.imageService=imageService;
		service.imageCaseInfoService=imageCaseInfoService;
		service.request=new BaseRequest();
		service.request.Info=id;
		service.Excute();
		CasePageInfo casePageInfo = (CasePageInfo) service.response.Info;
		return casePageInfo;
	}
	
	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long[] ids) {
		try {
			imageCaseInfoService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}

	/**
	 * 查询+分页
	 * 
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbImageCaseInfo imageCaseInfo,
			int page, int rows) {
		String curUser = MyCommonUtils.getCurUser();
		if (!"admin".equals(curUser)) {
			imageCaseInfo.setUsercode(curUser);
		}
		return imageCaseInfoService.findPage(imageCaseInfo, page, rows);
	}

	/**
	 * 通过报案号和图片名称定位信息
	 * 
	 * @param caseId
	 * @param imgName
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@RequestMapping("/searchByCaseIdAndImgName")
	public ImgPageInfo searchByCaseIdAndImgName(String caseId, String imgName)
			throws ClassNotFoundException, IllegalArgumentException,
			IllegalAccessException {
		ImgPageInfo imgPageInfo = new ImgPageInfo();
		BaseService service = new SearchByCaseIdAndImgNameService();
		TbImage srchImg = new TbImage();
		srchImg.setCaseid(caseId);
		srchImg.setImgname(imgName);
		service.request = new BaseRequest();
		service.request.Info = srchImg;
		service.imageCaseInfoService = imageCaseInfoService;
		service.imageService = imageService;
		service.Excute();
		if (service.response != null && service.response.Info != null) {
			imgPageInfo = (ImgPageInfo) service.response.Info;
		}
		return imgPageInfo;
	}

	/**
	 * 获取案件最新状态
	 * 
	 * @param caseId
	 * @return
	 */
	@RequestMapping("/findLastedStatusByCaseId")
	public String findLastedStatusByCaseId(String caseId) {
		BaseService service = new BHClientGetAIOStatusService();
		service.request = new BaseRequest();
		service.request.CaseId = caseId;
		service.Excute();
		String retTips = "";
		if (service.response.Info != null) {
			BaseAcResponse acResponse = (BaseAcResponse) service.response.Info;
			retTips = StringUtils.isEmpty(acResponse.data)
					? acResponse.message
					: MyCommonUtils.getCaseTips(acResponse.data);
		} else {
			retTips = "未获取到最新状态！";
		}
		return retTips;
	}

	@RequestMapping("/reSend")
	public String reSend(String caseId) {
		BaseService service = new BHClientUploadFileToAIOService();
		service.request = new BaseRequest();
		List<TbImageCaseInfo> imageCaseInfos = imageCaseInfoService
				.findByCaseId(caseId);
		if (imageCaseInfos != null && imageCaseInfos.size() >= 0) {
			List<TbImage> curCaseImages = imageService.findByCaseId(caseId);
			int size = curCaseImages.size();
			if (size > 0) {
				service.request.Info = curCaseImages;
				service.Excute();
			}
		}
		if (service.response != null) {
			BaseAcResponse acResponse = (BaseAcResponse) service.response.Info;
			return acResponse.message;
		} else {
			return "传送失败";
		}
	}

	/**
	 * 统计报表
	 * 
	 * @return
	 */
	@RequestMapping("/statistics")
	public BaseResponse Statistics(String startDate, String endDate) {
		GetStatisticsService service = new GetStatisticsService();
		service.imageCaseInfoService = imageCaseInfoService;
		service.imageService = imageService;
		service.request = new BaseRequest();
		service.setStartDate(startDate);
		service.setEndDate(endDate);
		String curUser = MyCommonUtils.getCurUser();
		service.setCurUser(curUser);
		service.Excute();
		return service.response;
	}

	/**
	 * 统计异常信息
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping("/statisticQuestions")
	public BaseResponse StatisticQuestions(String startDate, String endDate) {
		GetStatisticsService service = new GetStatisticsService();
		service.imageCaseInfoService = imageCaseInfoService;
		service.imageService = imageService;
		service.request = new BaseRequest();
		service.setStartDate(startDate);
		service.setEndDate(endDate);
		String curUser = MyCommonUtils.getCurUser();
		service.setCurUser(curUser);
		service.statisticQuestions();
		return service.response;
	}

	/**
	 * 统计字节数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping("/statisticBytes")
	public BaseResponse statisticBytes(String startDate, String endDate) {
		
		
		GetStatisticBytes service = new GetStatisticBytes();
		service.imageCaseInfoService = imageCaseInfoService;
		service.imageService = imageService;
		service.request = new BaseRequest();
		service.setStartDate(startDate);
		service.setEndDate(endDate);
		String curUser = MyCommonUtils.getCurUser();
		service.setCurUser(curUser);
		service.Excute();
		return service.response;
	}
	
	

	
	
}
