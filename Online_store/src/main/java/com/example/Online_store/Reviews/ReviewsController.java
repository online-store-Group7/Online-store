package com.example.Online_store.Reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path= "reviews")
public class ReviewsController {

    private final ReviewsService reviewsService;


    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }



    @GetMapping
    public List<Reviews> getReviews(@RequestParam(required = false) String filter){
        return reviewsService.getReviews();
    }

    @PostMapping
    public void addReview(@RequestBody Reviews reviews){
         reviewsService.addReviews(reviews);
    }



    @GetMapping("/{id}")
    public Reviews getReview(@PathVariable String id){
        return reviewsService.getReview(id);
    }

    @DeleteMapping("/{id}")
    public void delReview(@PathVariable String id){
         reviewsService.deleteReviews(id);
    }


}
