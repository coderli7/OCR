package com.pyg.manager.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.pyg.manager.commonutils.MyCommonUtils;
import com.pyg.manager.commonutils.MyDateUtils;
import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.dao.pojo.TbImageCaseInfo;
import com.pyg.manager.model.AIOJsonModel.JsonRootBean;
import com.pyg.manager.model.AIOJsonModel.Question;
import com.pyg.manager.model.AIOJsonModel.Questions;
import com.pyg.manager.model.WebApiResponse.BaseResponse;

@SuppressWarnings("unused")
public class GetStatisticsService extends BaseService {

	private String curUser;
	private String startDate;
	private String endDate;

	public String getCurUser() {
		return curUser;
	}

	public void setCurUser(String curUser) {
		this.curUser = curUser;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void Excute() {
		response = new BaseResponse();
		try {

			// 1.案件总数：
			// 2.案件票据总计：
			// 3.案件平均票据数：
			// 4.票据识别成功总计：
			// 5.票据识别成功率：
			// 6.票据识别响应时长最小值：
			// 7.票据识别响应时长最大值：
			// 8.票据识别响应时长平均值：

			Long mixCaseReturnTime = 0L;
			Long maxCaseReturnTime = 0L;
			Long totalCaseReturnTime = 0L;
			Long avgCaseReturnTime = 0L;
			if ("".equals(startDate) || startDate == null) {
				startDate = MyDateUtils.getDateTimeNow("yyyy-MM-dd");
			}
			if ("".equals(endDate) || endDate == null) {
				endDate = MyDateUtils.getDateTimeNow("yyyy-MM-dd");
			}
			List<String> result = new ArrayList<>();
			result.add(String.format("===================  %s ~ %s ===================", startDate, endDate));
			List<TbImageCaseInfo> caseInfos = imageCaseInfoService
					.findByDate(curUser, startDate, endDate,"完成");
			int caseInfosCount = caseInfos.size();
			List<TbImage> images = new ArrayList<>();
			ArrayList<Long> allMinutes = new ArrayList<>();
			Long[] allMinutesArr = new Long[caseInfos.size()];
			for (TbImageCaseInfo imageCaseInfo : caseInfos) {
				// 返回当前案件时间
				Long second = MyDateUtils.getMinutes(
						imageCaseInfo.getCasedate(),
						imageCaseInfo.getResultdate());
				allMinutes.add(second);
				String caseId = imageCaseInfo.getCaseid();
				totalCaseReturnTime += second;
				images.addAll(imageService.findByCaseId(caseId));
			}
			if (allMinutesArr.length==0) {
				result.add("未查询到数据！");
				response.Info = result;
				return;
			}
			allMinutes.toArray(allMinutesArr);
			Arrays.sort(allMinutesArr);
			mixCaseReturnTime = allMinutesArr[0];
			maxCaseReturnTime = allMinutesArr[allMinutesArr.length - 1];
			avgCaseReturnTime = totalCaseReturnTime / allMinutesArr.length;
			String mixCaseReturnTimeStr = MyDateUtils
					.getTimeStr(mixCaseReturnTime);
			String maxCaseReturnTimeStr = MyDateUtils
					.getTimeStr(maxCaseReturnTime);
			String avgCaseReturnTimeStr = MyDateUtils
					.getTimeStr(avgCaseReturnTime);
			int imagesCount = images.size();
			DecimalFormat df = new DecimalFormat("0.00");
			List<String> successImg = new ArrayList<>();
			List<Integer> allImgOperateTime = new ArrayList<>();
			for (TbImage tbImage : images) {
				String imgresultmodelclass = tbImage.getImgresultmodelclass();
				if (imgresultmodelclass != null && imgresultmodelclass != "") {
					successImg.add(imgresultmodelclass);
				}
			}
			int successImgCount = successImg.size();
			// result.add("**********************");
			result.add(String.format("1.案件总数: %s", caseInfosCount));
			result.add(String.format("2.票据总计: %s", imagesCount));
			
			result.add(String.format("3.识别成功数: %s", successImgCount));
			result.add(
					String.format(
							"4.识别成功率: %s", df
									.format(((float) successImgCount
											/ imagesCount) * 100)
									.toString() + "%"));
			result.add(String.format("5.票据平均数: %s",
					df.format((float) imagesCount / caseInfosCount)));
			result.add(
					String.format("6.识别时长最小值: %s", mixCaseReturnTimeStr));
			result.add(
					String.format("7.识别时长最大值: %s", maxCaseReturnTimeStr));
			result.add(
					String.format("8.识别时长平均值: %s", avgCaseReturnTimeStr));
			response.Info = result;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询案件异常明细
	 */
	public void statisticQuestions(){
		response = new BaseResponse();
		try {
			if ("".equals(startDate) || startDate == null) {
				startDate = MyDateUtils.getDateTimeNow("yyyy-MM-dd");
			}
			if ("".equals(endDate) || endDate == null) {
				endDate = MyDateUtils.getDateTimeNow("yyyy-MM-dd");
			}
			List<String> allTips=new ArrayList<>();
			allTips.add(String.format("===================  %s ~ %s ===================", startDate, endDate));
			List<TbImageCaseInfo> caseInfos = imageCaseInfoService
					.findByDate(curUser, startDate, endDate,"完成");
			for (TbImageCaseInfo tbImageCaseInfo : caseInfos) {
				String curCaseResult = tbImageCaseInfo.getResult();
				if (curCaseResult!=null&&curCaseResult!="") {
					JsonRootBean rootBean = JSON.toJavaObject(JSON.parseObject(curCaseResult), JsonRootBean.class);
					if (rootBean.getResultData()!=null&&rootBean.getResultData().getQuestions()!=null) {
						Questions questions = rootBean.getResultData().getQuestions();
						List<Question> questionList = questions.getQuestion();
						if (questionList!=null&&questionList.size()>0) {
							String titleStr=String.format("**********案件号(%s|%s)异常信息**********",tbImageCaseInfo.getCaseid(),tbImageCaseInfo.getCasedate());
							allTips.add(titleStr);
							int curQuestionCount=0;
							for (Question question : questionList) {
								curQuestionCount++;
								String questionContent = question.getQuestionContent();
								String curQuestionContentStr=String.format("%s:%s",curQuestionCount, questionContent);
								allTips.add(curQuestionContentStr);
							}
						}						
					}
				}				
			}
			if (allTips.size()<=1) {
				allTips.add("未查询到异常信息！");
			}
			response.Info = allTips;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
