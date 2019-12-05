//服务层
app.service('usersService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../users/findAll.do');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../users/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../users/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../users/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../users/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../users/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../users/search.do?page='+page+"&rows="+rows, searchEntity);
	}    	
});
