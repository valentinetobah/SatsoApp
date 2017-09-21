/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('SatsoApp', []);

app.controller('ctrl', function ($scope, $http) {

    $scope.errorMessage = "";
    $scope.error = false;
    $scope.customerData = {};

    $scope.getProduct = function (productName) {

        $http.get("rest/satso/product/" + productName)
                .then(function (response) {
                    $scope.products = response.data;
                }, function () {
                    $scope.errorMessage = "Error retrieving Products. Please try again";
                });

    };

    $scope.setProduct = function (product) {

        $scope.productName = product.name;
        $scope.customerData.productID = product.id;
        $scope.products = "";
    };

    $scope.saveCustomer = function (customerData) {
        if (!$scope.customerData.title ||
                !$scope.customerData.name ||
                !$scope.customerData.surname ||
                !$scope.customerData.dateOfBirth ||
                !$scope.customerData.contactNumber ||
                !$scope.customerData.email ||
                !$scope.customerData.homeAddress ||
                !$scope.customerData.productID) {
            $scope.error = true;
            $scope.errorMessage = "\t\Please check form and make sure all inputs are correctly filled";
            $scope.customer = "";
        } else {
            $scope.errorMessage = "";
            $http.post("rest/satso/customer/", customerData)
                    .then(function (response) {
                        $scope.customer = response.data;
                        $scope.error = false;
                        clearForm();
                    }, function () {
                        $scope.errorMessage = "Error saving customer details. Please try again.";

                    });
        }
    };

    function clearForm() {
        $scope.customerData = {};
        $scope.productName = "";
    }

});