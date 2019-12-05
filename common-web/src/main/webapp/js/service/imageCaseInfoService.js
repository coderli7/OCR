//服务层
app.service('imageCaseInfoService', function($http) {

	// 读取列表数据绑定到表单中
	this.findAll = function() {
		return $http.get('../imageCaseInfo/findAll.do');
	}
	// 分页
	this.findPage = function(page, rows) {
		return $http.get('../imageCaseInfo/findPage.do?page=' + page + '&rows='
				+ rows);
	}
	// 查询实体
	this.findOne = function(id) {
		return $http.get('../imageCaseInfo/findOne.do?id=' + id);
	}
	// 增加
	this.add = function(entity) {
		return $http.post('../imageCaseInfo/add.do', entity);
	}
	// 修改
	this.update = function(entity) {
		return $http.post('../imageCaseInfo/update.do', entity);
	}
	// 删除
	this.dele = function(ids) {
		return $http.get('../imageCaseInfo/delete.do?ids=' + ids);
	}
	// 搜索
	this.search = function(page, rows, searchEntity) {
		return $http.post('../imageCaseInfo/search.do?page=' + page + "&rows="
				+ rows, searchEntity);
	}

	// 通过报案号和图片名称搜索
	this.searchByCaseIdAndImgName = function(caseId, imgName) {
		return $http.get('../imageCaseInfo/searchByCaseIdAndImgName.do?caseId='
				+ caseId + "&imgName=" + imgName);
	}

	// 获取案件最新状态
	this.lastedStatus = function(caseId) {
		return $http.get('../imageCaseInfo/findLastedStatusByCaseId.do?caseId='
				+ caseId);
	}

	
	//reSend
	this.reSend = function(caseId) {
		return $http.get('../imageCaseInfo/reSend.do?caseId='
				+ caseId);
	}
});
