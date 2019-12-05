app.controller('searchController', function($scope, $location, $controller,
		searchService) {

	// 继承
	$controller('baseController', {
		$scope : $scope
	});

	$scope.tips = "";

	// 查询余额
	$scope.BHClientAIOGetAccountBalance = function() {
		searchService.BHClientAIOGetAccountBalance().success(
				function(response) {
					$scope.tips = "余额:" + response.Info.data;
				});
	}

	// 获取使用明细
	$scope.BHClientAIOGetAccountBalanceDetail = function() {
		searchService.BHClientAIOGetAccountBalanceDetail().success(
				function(response) {
					$scope.tips = response.ErrMsg;
				});
	}

	// 加班请求
	$scope.BHClientAIOOvertimeNotice = function() {
		searchService.BHClientAIOOvertimeNotice().success(function(response) {
			$scope.tips = response.info;
		});
	}

	// 获取统计信息
	$scope.statistics = function(startDate, endDate) {
		if (startDate == undefined) {
			startDate = '';
		}
		if (endDate == undefined) {
			endDate = '';
		}
		searchService.statistics(startDate, endDate).success(
				function(response) {
					$scope.tips = response;
				});
	}
	
	// 
	$scope.statisticQuestions = function(startDate, endDate) {
		if (startDate == undefined) {
			startDate = '';
		}
		if (endDate == undefined) {
			endDate = '';
		}
		searchService.statisticQuestions(startDate, endDate).success(
				function(response) {
					$scope.tips = response;
				});
	}
	
	
	$scope.statisticBytes = function(startDate, endDate) {
		if (startDate == undefined) {
			startDate = '';
		}
		if (endDate == undefined) {
			endDate = '';
		}
		searchService.statisticBytes(startDate, endDate).success(
				function(response) {
					$scope.tips = response;
				});
	}
	
	
	
	
	

})