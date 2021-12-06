import axios from 'axios'
import { useEffect } from "react";
import { useState } from "react";
import '../App.css';

function Reviews() {

  const [reviews, setReviews] = useState();


    useEffect(() => {
        axios.all([
          axios.get('http://localhost:8080/reviews')
        ])
        .then(r => {
            setReviews(r[0].data);
          console.log(r[0].data);
           });
      
          }
      
      ,[]);

  return (

    <div>
    <h1 className="h1_h">Reviews</h1>
    <a href="/add_reviews"><button type="button" className="btn btn-secondary">Add New Reviews</button></a>

{  reviews === undefined ? '' :
          

reviews.map((element, index) => {
          return (
            <div key={index} className="div_Users"> 
            <p className="p2_Users"><b>User Name:</b> {element.user.userName}</p>
            <p className="p_Users"><b>Product Name:</b> {element.products.title}</p>
            <p className="p_Users"><b>Comment:</b> {element.comment}</p>
            <p className="p_Users"><b>date:</b> {element.date}</p>
            <p className="p_Users"><b>Rating:</b> {element.rating}</p>
            <input type="button" value="Delete" className="btn btn-danger" onClick={ () => {
    axios.delete(`http://localhost:8080/reviews/${element.comment_id}`).then(response => {
      console.log(response);
    });
    window.location.reload();
    }}  /> 
            </div>)
            }

  )}

  </div>

  )}
export default Reviews;
