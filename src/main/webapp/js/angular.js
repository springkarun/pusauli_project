var app = angular.module('app', []);


app.controller('shopRegisterController', function ($scope, $http, $location) {

    $scope.showAllCustomers = false;
    var url = $location.absUrl() + "api/categoryShopAll";
        var config = {
            headers : {
                'Content-Type' : 'application/json;charset=utf-8;'
            }
        }

        $http.get(url,config).then(function(response) {

            if (response.data.status === true) {
                $scope.arrlists =response.data.data;
                $scope.showAllCustomers = true;
            } else {
                $scope.getResultMessage = "get All Customers Data Error!";
            }

        }, function(response) {
            $scope.getResultMessage = response.data.mess;
        });


    $scope.checkselection = function () {

        if ($scope.cateSelect !== "" && $scope.cateSelect !== undefined) {
            $scope.getResultMessage = 'Selected Value: ' + $scope.cateSelect;


            var url = $location.absUrl() + "api/register_shop";

            var config = {
                headers: {
                    'Content-Type': multipart/form-data
                }
            }

            var data = {

                categoryId:$scope.cateSelect,
                shopId:"vd343",
                shopName: $scope.shopName,
                shopReg: $scope.shopReg,
                shopEmail: $scope.shopEmail,
                shopMobile: $scope.shopMobile,
                shopAddress: $scope.shopAddress,
                shopNearst: $scope.shopNearst,
                shopTime: $scope.shopTime,
                shopRating: $scope.shopRating,
                shopLatitude:"21.5555557",
                shopLongitude:"12.585888",
                ownerName: $scope.ownerName,
                ownerEmail: $scope.ownerEmail,
                ownerContact: $scope.ownerContact,
                colorCode: $scope.colorCode,
                reg_date:"12-02-2019"
			};

            $http.post(url, data, config).then(function (response) {
                $scope.getResultMessage = response.data.mess;
            }, function (response) {
                $scope.getResultMessage = response.data.mess;
            });
        }
        else
      $scope.getResultMessage = 'Please Select Category';
    }


/*
    $scope.arrlist = [{"userid": 1, "name": "Suresh"},
		              {"userid": 2, "name": "Rohini"},
		              {"userid": 3, "name": "Praveen"}];

    $scope.checkselection = function () {
        if ($scope.cateSelect !== "" && $scope.cateSelect !== undefined)
            $scope.msg = 'Selected Value: '+$scope.cateSelect;
        else
            $scope.msg = 'Please Select Category';
    }*/
});












/*(function () {
    'use strict';

    angular
        .module('app')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['RegistationService', '$location', '$rootScope', 'FlashService'];
    function RegisterController(RegistationService, $location, $rootScope, FlashService) {
        var vm = this;

        vm.register = register;

        function register() {
            vm.dataLoading = true;
            RegistationService.Create(vm.user)
                .then(function (response) {
                    if (response.success) {
                        FlashService.Success('Registration successful', true);
                        $location.path('/login');
                    } else {
                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });
        }
    }

})();*/




app.controller('loginController', function($scope, $http, $location) {
    $scope.submitForm = function(){
        var url = $location.absUrl() + "api/student_login";

        var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }
        var data = {

            rollNo: $scope.rollNo,
            passwords:$scope.passwords
        };

        $http.post(url, data, config).then(function (response) {

            if (response.data.status === true) {
                $scope.postResultMessage = response.data.mess;
                $location.path('home');
            }

        //    $scope.postResultMessage = "Sucessful!";
        }, function (response) {
            $scope.postResultMessage = response.data.mess
          //  $scope.postResultMessage = "Fail!";
        });

        $scope.rollNo = "";
        $scope.passwords = "";

    }
});

app.controller('postController', function($scope, $http, $location) {
	$scope.submitForm = function(){


		var url = $location.absUrl() + "api/student_registation";
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		
		var data = {

            rollNo: $scope.rollNo,
            passwords:$scope.passwords,
            name: $scope.name,
            email: $scope.email,
            mobile: $scope.mobile,
            course: $scope.course,
            age: $scope.age,
            gender: $scope.gender,
            addess: $scope.addess
        };

		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data.mess;
		}, function (response) {
			$scope.postResultMessage = "Fail!";
		});

		$scope.rollNo = "";
		$scope.passwords = "";
		$scope.name = "";
		$scope.email = "";
		$scope.mobile = "";
		$scope.course = "";
		$scope.age = "";
		$scope.gender = "";
		$scope.addess = "";

	}
});

app.controller('getAllShopController', function($scope, $http, $location) {
	
	$scope.showAllCustomers = false;

	$scope.getAllCustomers = function() {
		var url = $location.absUrl() + "api/showAllShop";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		};

       $http.get(url,config).then(function(response) {

			if (response.data.status === true) {
                $scope.getResultMessage = response.data.mess;
				$scope.allcustomers = response.data;
				$scope.showAllCustomers = true;

			} else {
				$scope.getResultMessage = "get All Customers Data Error!";
			}

		}, function(response) {
           $scope.getResultMessage = response.data.mess;
		});

	}
});


app.controller('getcustomerControllerrollNo', function($scope, $http, $location) {
	
	$scope.showCustomer = false;
	
	$scope.getCustomer = function() {
		var url = $location.absUrl() + "api/findByRollNo/"+ $scope.rollNo;
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {


            if (response.data.status === true) {
                $scope.getResultMessage = response.data.mess;
				$scope.allData = response.data;
                $scope.showCustomer = true;

            } else {
				$scope.getResultMessage = "rollNo Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});



app.controller('getcustomersbylastnameController', function($scope, $http, $location) {
	
	$scope.showCustomersByLastName = false;
	
	$scope.getCustomersByLastName = function() {
		var url = $location.absUrl() + "api/findByrRollNo";

		var config = {
			headers : {	'Content-Type' : 'application/x-www-form-urlencoded;' },
			params: { 'rollNo' : $scope.rollNo }
		}

		$http.get(url, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.allcustomersbylastname = response.data;
				$scope.showCustomersByLastName = true;

			} else {
				$scope.getResultMessage = "Customer Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});

