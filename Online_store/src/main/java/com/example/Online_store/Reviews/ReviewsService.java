package com.example.Online_store.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewsService {

    private final ReviewsRepository reviewsRepository;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }


    public List<Reviews> getReviews(){
        return reviewsRepository.findAll();
    }

    public Reviews getReview(String id){
        int Reviews_id = Integer.valueOf(id);
        return reviewsRepository.findById(Reviews_id).orElse(null);
    }

    public Reviews addReviews(Reviews Reviews){

        return reviewsRepository.save(Reviews);
    }

    public void deleteReviews(String id){
        int review_id = Integer.valueOf(id);
        reviewsRepository.deleteById(review_id);

    }


    }


