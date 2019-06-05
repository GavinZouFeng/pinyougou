app.controller('addressController',function($scope,addressService,citiesService,provincesService,areasService){
    /**
     * 查询
     * @param userId
     */

    $scope.findListByUserId=function () {
        addressService.findListByUserId().success(
            function (response) {
                $scope.entity=response;
               /* $scope.mobile=$scope.entity.mobile.substring(0,3)+"****"+$scope.entity.mobile.substring(7,11);*/
            }
        )
    }

    $scope.findOne=function (id) {
        addressService.findOne(id).success(
            function (response) {
                $scope.tbAddres=response;
            }
        )
    }




    /**
     * 删除
     */

    $scope.dele=function (id) {
            if(confirm("你确定删除吗？")){

            addressService.dele(id).success(
                function (response) {
                    if(response.success){
                        alert(response.message)
                    }else {
                        alert(response.message)
                    }
                    $scope.findListByUserId();
                }
            )
            }
    }

    $scope.tbAddres={
        'id':	'',
        'address':"",
        'alias':"",
        'cityId':"",
        'contact':"",
        'mobile':"",
         'notes':"",
         'provinceId':"",
        'townId':""
    }

  /*  $scope.update=function () {
        addressService.update($scope.tbAddres).success(
            function (response) {
                alert(response.message);
                $scope.findListByUserId();
            }
        )
    }

    //增加地址
    $scope.add=function () {
        var id=$scope.tbAddres.id;
        if(id!=null&&id!=""){
            addressService.update($scope.tbAddres)
        }
        addressService.add($scope.tbAddres).success(
            function (response) {
                if(response.success){
                    alert(response.message)
                }else {
                    alert(response.message)
                }
                $scope.findListByUserId();

            }
        )
    }*/

    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.tbAddres.id!=''){//如果有ID
            serviceObject=addressService.update( $scope.tbAddres ); //修改
        }else{
            serviceObject=addressService.add( $scope.tbAddres  );//增加
        }
        serviceObject.success(
            function(response){
                alert(response.message);
                $scope.findListByUserId();
            }
        );
    }

    //读取列表数据绑定到表单中 市
    $scope.findprovinceAllMap=function(){
        provincesService.findAllMap().success(
            function(response){
                $scope.provincesMap=response;
                $scope.provincesMap=JSON.parse($scope.provinceslist);
            }
        );
    }
    //读取列表数据绑定到表单中 市
    $scope.findprovinceAll=function(){
        provincesService.findAll().success(
            function(response){
                $scope.provinceslist=response;
                $scope.provinceslist=JSON.parse($scope.provinceslist);
            }
        );
    }




    //读取列表数据绑定到表单中 市
    $scope.findCityAll=function(){
        citiesService.findAll().success(
            function(response){
                $scope.cityMap=response;
            }
        );
    }

    //读取列表数据绑定到表单中 市
    $scope.findTownMap=function(){
        areasService.findTownMap().success(
            function(response){
                $scope.townMap=response;
            }
        );
    }



    //监听  读取列表数据绑定到表单中 城市
    $scope.$watch("tbAddres.provinceId",function(newValue,oldValue){
            citiesService.findByProid(newValue).success(
                function (response) {
                    $scope.citylist=response;
                }
            )
    })

    $scope.$watch("tbAddres.cityId",function(newValue,oldValue){
        areasService.findAll(newValue).success(
            function (response) {
                $scope.areaslist=response;

            }
        )
    })


    $scope.updateDufault=function (id,status) {
        addressService.updateDufault(id,status).success(
            function (response) {
                alert(response.message)
                $scope.findListByUserId();
            }
        )
    }

    $scope.aliasList=['家里','公司','父母家'];



})