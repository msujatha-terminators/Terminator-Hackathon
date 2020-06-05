package com.hackathon.terminators.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hackathon.terminators.model.Feedback;
import com.hackathon.terminators.service.FeedbackService;
import com.hackathon.terminators.util.CustomErrorType;


@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	FeedbackService feedbackService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Feedbacks---------------------------------------------

	@RequestMapping(value = "/feedback/", method = RequestMethod.GET)
	public ResponseEntity<List<Feedback>> listAllFeedbacks() {
		List<Feedback> feedbacks = feedbackService.findAllFeedbacks();
		if (feedbacks.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Feedback>>(feedbacks, HttpStatus.OK);
	}

	// -------------------Retrieve Single Feedback------------------------------------------

	@RequestMapping(value = "/feedback/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getFeedback(@PathVariable("id") long id) {
		logger.info("Fetching Feedback with id {}", id);
		Feedback feedback = feedbackService.findById(id);
		if (feedback == null) {
			logger.error("Feedback with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Feedback with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
	}

	// -------------------Create a Feedback-------------------------------------------

	@RequestMapping(value = "/feedback/", method = RequestMethod.POST)
	public ResponseEntity<?> createFeedback(@RequestBody Feedback feedback, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Feedback : {}", feedback);

		if (feedbackService.isFeedbackExist(feedback)) {
			logger.error("Unable to create. A Feedback with name {} already exist", feedback.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A Feedback with name " + 
			feedback.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		feedbackService.saveFeedback(feedback);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/feedback/{id}").buildAndExpand(feedback.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Feedback ------------------------------------------------

	@RequestMapping(value = "/feedback/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateFeedback(@PathVariable("id") long id, @RequestBody Feedback feedback) {
		logger.info("Updating Feedback with id {}", id);

		Feedback currentFeedback = feedbackService.findById(id);

		if (currentFeedback == null) {
			logger.error("Unable to update. Feedback with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Feedback with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentFeedback.setName(feedback.getName());
		currentFeedback.setAge(feedback.getAge());
		currentFeedback.setSalary(feedback.getSalary());

		feedbackService.updateFeedback(currentFeedback);
		return new ResponseEntity<Feedback>(currentFeedback, HttpStatus.OK);
	}

	// ------------------- Delete a Feedback-----------------------------------------

	@RequestMapping(value = "/feedback/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteFeedback(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Feedback with id {}", id);

		Feedback feedback = feedbackService.findById(id);
		if (feedback == null) {
			logger.error("Unable to delete. Feedback with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Feedback with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		feedbackService.deleteFeedbackById(id);
		return new ResponseEntity<Feedback>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Feedbacks-----------------------------

	@RequestMapping(value = "/feedback/", method = RequestMethod.DELETE)
	public ResponseEntity<Feedback> deleteAllFeedbacks() {
		logger.info("Deleting All Feedbacks");

		feedbackService.deleteAllFeedbacks();
		return new ResponseEntity<Feedback>(HttpStatus.NO_CONTENT);
	}

}