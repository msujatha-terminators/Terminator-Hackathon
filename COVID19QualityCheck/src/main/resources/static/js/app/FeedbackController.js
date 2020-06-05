'use strict';

angular.module('crudApp').controller('FeedbackController',
    ['FeedbackService', '$scope',  function( FeedbackService, $scope) {

        var self = this;
        self.feedback = {};
        self.feedbacks=[];

        self.submit = submit;
        self.getAllFeedbacks = getAllFeedbacks;
        self.createFeedback = createFeedback;
        self.updateFeedback = updateFeedback;
        self.removeFeedback = removeFeedback;
        self.editFeedback = editFeedback;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.feedback.id === undefined || self.feedback.id === null) {
                console.log('Saving New Feedback', self.feedback);
                createFeedback(self.feedback);
            } else {
                updateFeedback(self.feedback, self.feedback.id);
                console.log('Feedback updated with id ', self.feedback.id);
            }
        }

        function createFeedback(feedback) {
            console.log('About to create feedback');
            FeedbackService.createFeedback(feedback)
                .then(
                    function (response) {
                        console.log('Feedback created successfully');
                        self.successMessage = 'Feedback created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.feedback={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Feedback');
                        self.errorMessage = 'Error while creating Feedback: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateFeedback(feedback, id){
            console.log('About to update feedback');
            FeedbackService.updateFeedback(feedback, id)
                .then(
                    function (response){
                        console.log('Feedback updated successfully');
                        self.successMessage='Feedback updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Feedback');
                        self.errorMessage='Error while updating Feedback '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeFeedback(id){
            console.log('About to remove Feedback with id '+id);
            FeedbackService.removeFeedback(id)
                .then(
                    function(){
                        console.log('Feedback '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing feedback '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllFeedbacks(){
            return FeedbackService.getAllFeedbacks();
        }

        function editFeedback(id) {
            self.successMessage='';
            self.errorMessage='';
            FeedbackService.getFeedback(id).then(
                function (feedback) {
                    self.feedback = feedback;
                },
                function (errResponse) {
                    console.error('Error while removing feedback ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.feedback={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);