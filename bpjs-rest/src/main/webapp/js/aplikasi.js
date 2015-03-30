var myApp = angular.module('aplikasiPaymentPoint', []);

myApp.controller('InquiryController', ['$scope','$http', function ($scope, $http) {
        $scope.greeting = 'Hola!';
        $scope.daftarJenisProduk = [
            {id : "01", nama : "BPJS Kesehatan"},
            {id : "02", nama : "BPJS Tenaga Kerja"}
        ];
        
        $scope.daftarTagihan = [];
        
        $scope.tombolCekDiklik = function(){
            alert("Inquiry untuk idpel "+$scope.idpel);
            $http.get('/inquiry/kesehatan/'+$scope.idpel)
                    .success(function(data, status, headers, config){
                        console.log("Status : "+status);
                        console.log("Data : ");
                        console.log(data);
                        $scope.daftarTagihan = data;
                    })
                    .error(function(data, status, headers, config){
                        console.log("Status : "+status);
                        console.log("Data : ");
                        console.log(data);
                    });
        }
    }]);