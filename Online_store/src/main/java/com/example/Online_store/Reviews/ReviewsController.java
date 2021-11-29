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
    public void addReview(@RequestBody Form form){

        reviewsService.addReviews(form.getA(), form.getUser_id(), form.getProduct_id());
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

class Form{
    private Reviews a;
    private int user_id;
    private int product_id;


    public Reviews getA() {
        return a;
    }

    public int getUser_id() {
        return user_id;
    }
    public int getProduct_id() {
        return product_id;
    }


}