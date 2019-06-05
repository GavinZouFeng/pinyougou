//服务层
app.service('areasService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(id){
		return $http.get('../areas/findAll.do?id='+id);
	}

    //读取列表数据绑定到表单中
    this.findTownMap=function(){
        return $http.get('../areas/findTownMap.do');
    }



	//查询实体
	this.findOne=function(id){
		return $http.get('../areas/findOne.do?id='+id);
	}






	//增加 
	this.add=function(entity){
		return  $http.post('../areas/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../areas/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../areas/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../areas/search.do?page='+page+"&rows="+rows, searchEntity);
	}    	
});
