var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/COVID19QualityCheck',
    USER_SERVICE_API : 'http://localhost:8080/COVID19QualityCheck/api/feedback/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'FeedbackController',
                controllerAs:'ctrl',
                resolve: {
                    feedbacks: function ($q, FeedbackService) {
                        console.log('Load all feedbacks');
                        var deferred = $q.defer();
                        FeedbackService.loadAllFeedbacks().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

