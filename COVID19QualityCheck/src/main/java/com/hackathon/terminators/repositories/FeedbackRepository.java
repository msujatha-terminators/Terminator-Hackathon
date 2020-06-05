package com.hackathon.terminators.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.terminators.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    Feedback findByOrgName(String name);

}
