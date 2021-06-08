angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:12211/market';

    $scope.init = function () {
        $http.get(contextPath + '/showProducts')
            .then(function (response) {
                $scope.products = response.data;
            });
    };

    $scope.init();
});