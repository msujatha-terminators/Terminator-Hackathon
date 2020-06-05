package com.hackathon.terminators.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hackathon.terminators.model.Feedback;
import com.hackathon.terminators.repositories.FeedbackRepository;



@Service("feedbackService")
@Transactional
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackRepository feedbackRepository;

	public Feedback findById(Long id) {
		return feedbackRepository.findOne(id);
	}

	public Feedback findByOrgName(String name) {
		return feedbackRepository.findByOrgName(name);
	}

	public void saveFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
	}

	public void updateFeedback(Feedback feedback){
		saveFeedback(feedback);
	}

	public void deleteFeedbackById(Long id){
		feedbackRepository.delete(id);
	}

	public void deleteAllFeedbacks(){
		feedbackRepository.deleteAll();
	}

	public List<Feedback> findAllFeedbacks(){
		return feedbackRepository.findAll();
	}

	public boolean isFeedbackExist(Feedback feedback) {
		return findByOrgName(feedback.getName()) != null;
	}

}
