<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">COVID 19 Feedback for Quality Check </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.feedback.id" />
	                
	                 <div class="row" style="float:left;">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="uname">Feedback BY</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.feedback.name" id="uname" class="feedbackname form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	                
	                <div class="row" style="float:left;">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="uname">Feedback For</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.feedback.OrgName" id="uname" class="feedbackname form-control input-sm" placeholder="Enter Organization name for feedback for" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="age">How would you rate the screening process done before entering the premises? </label>
	                        <div class="col-md-5">
	                            <input type="text" ng-model="ctrl.feedback.q1" id="q1" class="form-control input-sm" placeholder="Enter your rating." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="age">How well did the place maintain cleanliness and sanitization?</label>
	                        <div class="col-md-5">
	                            <input type="text" ng-model="ctrl.feedback.q2" id="q2" class="form-control input-sm" placeholder="Enter your rating." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="age">How cautious were the employees serving you and were they wearing masks and gloves? </label>
	                        <div class="col-md-5">
	                            <input type="text" ng-model="ctrl.feedback.q3" id="q3" class="form-control input-sm" placeholder="Enter your rating." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="age">How regularly were the tables/chairs or other objects of public use being sanitized or disinfected? How well did the place make sure that objects are not reused by another customer?</label>
	                        <div class="col-md-5">
	                            <input type="text" ng-model="ctrl.feedback.q4" id="q4" class="form-control input-sm" placeholder="Enter your rating." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="age">How would you rate the packaging while taking a parcel? Were enough number of sanitizers placed for public use?</label>
	                        <div class="col-md-5">
	                            <input type="text" ng-model="ctrl.feedback.q5" id="q5" class="form-control input-sm" placeholder="Enter your rating." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="age">How well were the social distancing norms being followed in the place?</label>
	                        <div class="col-md-5">
	                            <input type="text" ng-model="ctrl.feedback.q6" id="q6" class="form-control input-sm" placeholder="Enter your rating." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="age">How would you rate the attempts taken by the management in making the customers aware that they must follow the COVID-19 guidelines?</label>
	                        <div class="col-md-5">
	                            <input type="text" ng-model="ctrl.feedback.q7" id="q7" class="form-control input-sm" placeholder="Enter your rating." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="age"> How effective was the place in placing sign boards, handing guidelines, proper markings as to how far to sit from one another etc to ensure that the customers maintain their own safety as well?</label>
	                        <div class="col-md-5">
	                            <input type="text" ng-model="ctrl.feedback.q8" id="q8" class="form-control input-sm" placeholder="Enter your rating." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="age">How would you rate the management’s availability to address to your queries on social distancing guidelines?</label>
	                        <div class="col-md-5">
	                            <input type="text" ng-model="ctrl.feedback.q9" id="q9" class="form-control input-sm" placeholder="Enter your rating." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="age">How well did the management ensure that people do not crowd the area?    </label>
	                        <div class="col-md-5">
	                            <input type="text" ng-model="ctrl.feedback.q10" id="q10" class="form-control input-sm" placeholder="Enter your rating." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-12 control-lable" for="age">How comfortable and safe did you feel regarding the services?</label>
	                        <div class="col-md-5">
	                            <input type="text" ng-model="ctrl.feedback.q11" id="q11" class="form-control input-sm" placeholder="Enter your rating." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	


	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.feedback.id ? 'Submit' : 'Submit'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Feeback</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Feedbacks </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>Feedback BY</th>
		                <th>Feedback FOR</th>
		                <th>Rating</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllFeedbacks()">
		                <td>{{u.id}}</td>
		                <td>{{u.name}}</td>
		                <td>{{u.OrgName}}</td>
		                <td>5</td>
		                <td><button type="button" ng-click="ctrl.removeFeedback(u.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		             <tr>
		                <td>1</td>
		                <td>Sujatha</td>
		                <td>starBugs</td>
		                <td>10</td>
		                <td><button type="button" ng-click="ctrl.removeFeedback(u.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            <tr>
		                <td>2</td>
		                <td>Sujatha</td>
		                <td>Bank</td>
		                <td>8</td>
		                <td><button type="button" ng-click="ctrl.removeFeedback(u.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>