//服务层
app.service('addressService',function($http){
	    	
	this.findListByUserId=function () {
		return $http.get("../addressController/findListByUserId.do");
    }
    this.findOne=function (id) {
        return $http.get("../addressController/findOne.do?id="+id);
    }

    this.dele=function (id) {
        return $http.get("../addressController/dele.do?id="+id);
    }

    this.add=function (tb) {
        return $http.post("../addressController/add.do",tb);
    }

    this.update=function (tb) {
        return $http.post("../addressController/update.do",tb);
    }
    this.updateDufault=function (id, status) {
        return $http.get("../addressController/updateDufault.do?id="+id+"&status="+status);
    }


	
});
