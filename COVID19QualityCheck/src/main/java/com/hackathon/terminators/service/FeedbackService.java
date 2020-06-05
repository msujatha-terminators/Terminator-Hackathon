package com.hackathon.terminators.service;




import java.util.List;

import com.hackathon.terminators.model.Feedback;

public interface FeedbackService {
	
	Feedback findById(Long id);

	Feedback findByOrgName(String name);

	void saveFeedback(Feedback feedback);

	void updateFeedback(Feedback feedback);

	void deleteFeedbackById(Long id);

	void deleteAllFeedbacks();

	List<Feedback> findAllFeedbacks();

	boolean isFeedbackExist(Feedback feedback);
}