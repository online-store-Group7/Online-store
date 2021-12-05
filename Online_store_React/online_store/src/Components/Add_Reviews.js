import axios from 'axios'
import { useState } from "react";
import '../App.css';

function Add_Reviews() {

  const [userId, setUserId] = useState();
  const [productId, setProductId] = useState();
  const [comment, setComment] = useState();
  const [rating, setRating] = useState();




  return (

    <div>
        <h1 className="h1_h">Add New Reviews</h1>



        <form className="form_add_user">
        <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">User ID</label>
    <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" onChange={
        (e)=>{
            setUserId(e.target.value)
        }
    } />
  </div>

  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Product ID</label>
    <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" onChange={
        (e)=>{
            setProductId(e.target.value)
        }} />
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Comment</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" onChange={
        (e)=>{
            setComment(e.target.value)
        }} />
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Rating</label>
    <input type="number" class="form-control" id="exampleInputPassword1" onChange={
        (e)=>{
            setRating(e.target.value)
        }} />
  </div>

  <button type="button" class="btn btn-primary" onClick={
      ()=>{
        const reviews = {
     "a":{
        "comment": comment,
        "rating": rating
    },
    "product_id":productId,
    "user_id":userId
 };
    axios.post(`http://localhost:8080/reviews`, reviews)
        .then(response => {});
        window.location.href = "http://localhost:3000/reviews"; 
 }
    }>Submit</button>
</form>

  

  </div>

  )}
export default Add_Reviews;
