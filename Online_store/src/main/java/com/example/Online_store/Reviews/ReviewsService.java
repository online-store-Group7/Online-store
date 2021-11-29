package com.example.Online_store.Reviews;
import com.example.Online_store.Products.Products;
import com.example.Online_store.Products.ProductsRepository;
import com.example.Online_store.Users.User;
import com.example.Online_store.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class ReviewsService {

    private final ReviewsRepository reviewsRepository;
    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;


    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository, UserRepository userRepository, ProductsRepository productsRepository) {
        this.reviewsRepository = reviewsRepository;
        this.userRepository = userRepository;
        this.productsRepository = productsRepository;
    }


    public List<Reviews> getReviews(){
        return reviewsRepository.findAll();
    }

    public Reviews getReview(String id){
        int Reviews_id = Integer.valueOf(id);
        return reviewsRepository.findById(Reviews_id).orElse(null);
    }


    public Reviews addReviews(Reviews reviews, int User_id, int Product_id){
        User user = userRepository.findById(User_id).orElse(null);
        Products Product = productsRepository.findById(Product_id).orElse(null);
        reviews.setUser(user);
        reviews.setProducts(Product);

        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        reviews.setDate(date.format(now));

        return reviewsRepository.save(reviews);
    }

    public void deleteReviews(String id){
        int review_id = Integer.valueOf(id);
        reviewsRepository.deleteById(review_id);

    }


    }


