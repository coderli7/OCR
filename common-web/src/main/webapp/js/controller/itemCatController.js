//控制层 
app.controller('itemCatController', function($scope, $controller,
		itemCatService, typeTemplateService) {

	$controller('baseController', {
		$scope : $scope
	});// 继承

	// 读取列表数据绑定到表单中
	$scope.findAll = function() {
		itemCatService.findAll().success(function(response) {
			$scope.list = response;
		});
	}

	// 分页
	$scope.findPage = function(page, rows) {
		itemCatService.findPage(page, rows).success(function(response) {
			$scope.list = response.rows;
			$scope.paginationConf.totalItems = response.total;// 更新总记录数
		});
	}

	// 查询实体
	$scope.findOne = function(id) {
		itemCatService.findOne(id).success(function(response) {
			$scope.entity = response;
			/*
			 * $scope.entity.typeId = JSON.parse("'id' :" + response.typeId +
			 * "+,'text' : ");
			 */
		});
	}

	// 保存
	$scope.save = function() {

		// $scope.entity.typeId=$scope.entity.typeId.id;
		// console.log($scope.entity.typeId.id);

		var serviceObject;// 服务层对象
		if ($scope.entity.id != null) {// 如果有ID
			serviceObject = itemCatService.update($scope.entity); // 修改
		} else {
			$scope.entity.parentId = $scope.parentId;
			serviceObject = itemCatService.add($scope.entity);// 增加
		}
		serviceObject.success(function(response) {
			if (response.success) {
				$scope.findByParentIdNo($scope.parentId);
			} else {
				alert(response.message);
			}
		});
	}

	// 批量删除
	$scope.dele = function() {
		// 获取选中的复选框
		itemCatService.dele($scope.selectIds).success(function(response) {
			if (response.success) {
				$scope.findByParentIdNo($scope.parentId);
			} else {
				alert(response.message);
			}
		});
	}

	$scope.searchEntity = {};// 定义搜索对象

	// 搜索
	$scope.search = function(page, rows) {
		itemCatService.search(page, rows, $scope.searchEntity).success(
				function(response) {
					$scope.list = response.rows;
					$scope.paginationConf.totalItems = response.total;// 更新总记录数
				});
	}

	// 面包屑菜单栏
	$scope.grade = 1;
	$scope.entity_1 = {};
	$scope.entity_2 = {};
	$scope.entity_3 = {};
	$scope.parentId = 0;

	$scope.setGrade = function(grade) {
		if (grade <= 3) {
			$scope.grade = grade;
		}
	}

	$scope.findByParentId = function(entity) {
		if ($scope.grade == 1) {
			$scope.entity_2 = null;
			$scope.entity_3 = null;
		} else if ($scope.grade == 2) {
			$scope.entity_2 = entity;
			$scope.entity_3 = null;
		} else if ($scope.grade == 3) {
			$scope.entity_3 = entity;
		}
		parentId = entity.id;
		$scope.findByParentIdNo(parentId);
		$scope.parentId = parentId;
	}

	$scope.findByParentIdNo = function(parentId) {
		itemCatService.findByParentId(parentId).success(function(response) {
			$scope.list = response;
			$scope.selectIds = [];
		});
		$scope.parentId = parentId;
	}

	$scope.typeTempList = {
		data : []
	};

	$scope.findSpecList = function() {
		typeTemplateService.selectOptionList().success(function(response) {
			$scope.typeTempList = {
				data : response
			}
		});
	}

});
