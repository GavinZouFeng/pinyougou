// 定义服务层:
app.service('homeService',function($http){
    this.countOrders = function(){
        return $http.get("../index/countOrders.do?startTime="+$scope.currentTime+"&endTime="+$scope.weekTime);
    }
});