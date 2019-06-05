//服务层
app.service('citiesService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../cities/findAll.do');		
	}

    //读取列表数据绑定到表单中
    this.findAllMap=function(){
        return $http.get('../cities/findAllMap.do');
    }
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../cities/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../cities/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../cities/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../cities/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../cities/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../cities/search.do?page='+page+"&rows="+rows, searchEntity);
	}
	//查城市
	this.findByProid=function (proId) {
		return $http.get("../cities/findOne.do?proId="+proId);
    }
});
