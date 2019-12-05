 //控制层 
app.controller('usersController' ,function($scope,$controller   ,usersService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		usersService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		usersService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		usersService.findOne(id).success(
			function(response){
				$('#username').prop("disabled", true);
				$scope.entity= response;	
			}
		);				
	}
	
	$scope.newOne=function(){				
		$('#username').prop('disabled', false);			
	}
	
	
	$scope.operateType="";
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  	
		console.log($scope.entity.operateType);
		if($scope.entity.operateType=='1'){//如果有ID
			serviceObject=usersService.add( $scope.entity ); //增加 
		}else{
			serviceObject=usersService.update( $scope.entity  );//修改
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		usersService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		usersService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
});	
