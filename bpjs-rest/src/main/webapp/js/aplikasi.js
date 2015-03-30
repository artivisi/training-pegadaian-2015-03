var myApp = angular.module('aplikasiPaymentPoint', []);

myApp.controller('InquiryController', ['$scope', function ($scope) {
        $scope.greeting = 'Hola!';
        $scope.daftarJenisProduk = [
            {id : "01", nama : "BPJS Kesehatan"},
            {id : "02", nama : "BPJS Tenaga Kerja"}
        ];
    }]);