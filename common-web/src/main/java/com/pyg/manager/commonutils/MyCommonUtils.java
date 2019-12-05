package com.pyg.manager.commonutils;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.pyg.manager.model.AIOJsonModel.Accident_info;
import com.pyg.manager.model.AIOJsonModel.Case_info;
import com.pyg.manager.model.AIOJsonModel.Clinic_info;
import com.pyg.manager.model.AIOJsonModel.Clinic_record;
import com.pyg.manager.model.AIOJsonModel.Inpatient_info;
import com.pyg.manager.model.AIOJsonModel.Inpatient_record;
import com.pyg.manager.model.AIOJsonModel.JsonRootBean;
import com.pyg.manager.model.AIOJsonModel.Pay_info;
import com.pyg.manager.model.AIOJsonModel.ResultData;
import com.pyg.manager.model.pageinfo.ImgPageInfo;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

import net.coobird.thumbnailator.Thumbnails;

@SuppressWarnings({"rawtypes", "unused", "unchecked"})
public class MyCommonUtils {

	// 案件状态中文描述转换
	private static HashMap<String, String> caseStatusMap;

	// 红色
	public static String MyColor_Red = "#DD4B39";

	public static String MyColor_Yellow = "#FFEB9C";

	static {
		// 初始化
		caseStatusMap = new HashMap();
		caseStatusMap.put("0", "新到达");
		caseStatusMap.put("1", "下载中");
		caseStatusMap.put("2", "下载失败");
		caseStatusMap.put("3", "下载成功");
		caseStatusMap.put("5", "开始处理失败");
		caseStatusMap.put("6", "处理中");
		caseStatusMap.put("8", "已输出");
		caseStatusMap.put("9", "回传失败");
		caseStatusMap.put("10", "回传成功");
	}

	/**
	 * 获取加密MD5
	 * 
	 * @param value
	 * @return
	 */
	public static String getMD5Str(String value) {
		String md5Str = "";
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(value.getBytes());
			md5Str = new BigInteger(1, md.digest()).toString(16).toUpperCase();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return md5Str;

	}

	/**
	 * 获取当前用户
	 * 
	 * @return
	 */
	public static String getCurUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	/**
	 * 返回Model字段列表
	 * 
	 * @param model
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> List<String> getModelStr(T model)
			throws IllegalArgumentException, IllegalAccessException {

		List<String> curSb = new ArrayList<>();
		// StringBuilder curSb = new StringBuilder();
		try {
			Field[] fields = model.getClass().getDeclaredFields();
			for (Field field : fields) {
				String curFieldDes = "";
				Object curFieldVal = null;
				Class curFieldType = null;
				String curFieldName = "";
				MyAnnotation fildMark = field.getAnnotation(MyAnnotation.class);
				if (fildMark != null) {
					field.setAccessible(true);
					curFieldVal = field.get(model);
					curFieldDes = fildMark.name();
				}
				curFieldType = field.getType();
				curFieldName = field.getName();
				if (curFieldVal != null && !StringUtils.isEmpty(curFieldDes)) {

					if (curFieldType.toString().contains("java.lang.String")) {
						String curFieldValStr = curFieldVal.toString();
						if (!StringUtils.isBlank(curFieldValStr)
								&& !"0.00".equals(curFieldValStr)
								&& !"0.0".equals(curFieldValStr)
								&& !"0".equals(curFieldValStr)) {
							String curVal = String.format("%s(%s):%s",
									curFieldDes, curFieldName, curFieldValStr);
							curSb.add(curVal);
						}
					} else {
						// 此处需要区分含列表的情况
						if (curFieldType.toString()
								.contains("java.util.List")) {
							Iterable<Object> iterable = (Iterable<Object>) curFieldVal;
							for (Object object : iterable) {
								curSb.add(String.format(
										"****************%s(%s)****************",
										curFieldDes, curFieldName));
								curSb.addAll(getModelStr(object));
							}
						} else {
							// 继续遍历
							curSb.add(String.format(
									"****************%s(%s)****************",
									curFieldDes, curFieldName));
							curSb.addAll(getModelStr(curFieldVal));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curSb;
	}

	/**
	 * 获取案件状态-描述
	 * 
	 * @param key
	 * @return
	 */
	public static String getCaseTips(String key) {
		String val = caseStatusMap.get(key);
		return StringUtils.isEmpty(val) ? "未知状态" : val;
	}

	/**
	 * 生成缩略图
	 * 
	 * @param filePath
	 */
	public static void genThumbnail(String filePath) {
		try {
			File file = new File(filePath);
			if (file.exists() && file.isFile()) {
				String fileParentPath = file.getParent();
				String basePath = fileParentPath.replace('\\', '/');
				String fileName = file.getName();
				int fileSuffixNameIdx = fileName.lastIndexOf('.');
				if (fileSuffixNameIdx > 0) {
					String purFileName = fileName.substring(0,
							fileSuffixNameIdx);
					String suffixName = fileName.substring(fileSuffixNameIdx);
					String fromPath = String.format("%s/%s%s", basePath,
							purFileName, suffixName);
					String toPath = String.format("%s.small%s", fromPath,
							suffixName);
					Thumbnails.of(fromPath).scale(0.2f).outputQuality(0.5f)
							.toFile(toPath);
				}
			}
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.Error,
					String.format("执行函数genThumbnail发生异常:%s", e.getMessage()));
		}
	}

	/**
	 * 转换金额至bigDecimal
	 * @param strVal
	 */
	public static BigDecimal getBigDecimalVal(String strVal){
		BigDecimal bigDecimal=BigDecimal.ZERO;
		if (!StringUtils.isBlank(strVal)) {
			String tmpVal=strVal.trim();
			if (!tmpVal.contains("^")&&!"0.00".equals(tmpVal)&&!"0.0".equals(tmpVal)&&!"0".equals(tmpVal)) {
				try {
					bigDecimal=new BigDecimal(tmpVal);
				} catch (Exception e) {
					MyLogger.log(LoggerEnum.Error, String.format("执行函数getBigDecimalVal发生异常:%s", e.getMessage()));
				}
			}
		}
		return bigDecimal;
	}
}
