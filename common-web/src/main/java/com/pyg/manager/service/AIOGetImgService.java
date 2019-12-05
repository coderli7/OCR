package com.pyg.manager.service;

import java.util.List;

import com.pyg.manager.commonutils.MyBase64Utils;
import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.model.ImageACResponse;
import com.pyg.manager.model.WebApiRequest.ImageRequest;
import com.pyg.manager.model.WebApiResponse.BaseResponse;

public class AIOGetImgService extends BaseService {

	@Override
	public void Excute() {
		response = new BaseResponse();
		ImageRequest imageRequest = (ImageRequest) request;
		TbImage image = new TbImage();
		image.setCaseid(imageRequest.CaseId);
		image.setImgname(imageRequest.fileName);
		List<TbImage> images = imageService.findByModel(image);
		if (images != null && images.size() == 1) {
			TbImage tbImage = images.get(0);
			String imageToBase64ByLocal = MyBase64Utils
					.ImageToBase64ByLocal(tbImage.getImgpath());
			ImageACResponse imageACResponse = new ImageACResponse();
			imageACResponse.code = 0;
			imageACResponse.message = "OK";
			imageACResponse.data = imageToBase64ByLocal;
			response.Info = imageACResponse;
		}
	}

}
