'use strict';

angular.module('crudApp').factory('FeedbackService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllFeedbacks: loadAllFeedbacks,
                getAllFeedbacks: getAllFeedbacks,
                getFeedback: getFeedback,
                createFeedback: createFeedback,
                updateFeedback: updateFeedback,
                removeFeedback: removeFeedback
            };

            return factory;

            function loadAllFeedbacks() {
                console.log('Fetching all feedbacks');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all feedbacks');
                            $localStorage.feedbacks = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading feedbacks');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllFeedbacks(){
                return $localStorage.feedbacks;
            }

            function getFeedback(id) {
                console.log('Fetching Feedback with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Feedback with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading feedback with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createFeedback(feedback) {
                console.log('Creating Feedback');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API, feedback)
                    .then(
                        function (response) {
                            loadAllFeedbacks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Feedback : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateFeedback(feedback, id) {
                console.log('Updating Feedback with id '+id);
                var deferred = $q.defer();
                $http.put(urls.USER_SERVICE_API + id, feedback)
                    .then(
                        function (response) {
                            loadAllFeedbacks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Feedback with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeFeedback(id) {
                console.log('Removing Feedback with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllFeedbacks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Feedback with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);