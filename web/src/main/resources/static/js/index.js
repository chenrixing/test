// Define module
var app = angular.module("app", ['ui.router']);//定义app名称和加载所需的第三方库
// Define Controller
app.controller('t1Ctrl', function ($scope, $state) {
    $scope.goR2 = function () {
        $state.go("r2");
    }
});
// Define routers
app.config(function ($stateProvider) {
    $stateProvider.state('r1', {
        views: {
            'v1@': {
                url: '/r1v1',
                templateUrl: '../html/template/t1.html',
                controller: 't1Ctrl'
            },
            'v2@': {
                url: '/r1v2',
                templateUrl: '../html/template/t2.html'
            },
            'v3@': {
                url: '/r1v3',
                templateUrl: '../html/template/t3.html'
            }
        }
        // controller:

    }).state('r2', {
        views: {
            'v1@': {
                url: '/r2v1',
                templateUrl: '../html/template/t3.html'
            },
            'v2@': {
                url: '/r2v2',
                templateUrl: '../html/template/t1.html',
                controller: 't1Ctrl'
            },
            'v3@': {
                url: '/r2v3',
                templateUrl: '../html/template/t2.html'
            }
        }
    });
});
