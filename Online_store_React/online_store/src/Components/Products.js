import { useEffect, useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";
import "./products.css"

function Products(){

    const [products, setProducts] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        axios
        .get("http://localhost:8080/products")
        .then((response) => {
            setProducts(response.data)
        })
        .catch((err) => {
        console.log(err);
        });
        }, []);

        function addToFavorite(data){
            axios
            .post("http://localhost:8080/favorite", { 
                "favorite":{},
                "product_id": data.product_id,
                "user_id":2
            })
            .then((response) => {
            console.log(response)
            })
            .catch((err) => {
            console.log(err);
            });
            // navigate("/favorite")
        }

        function addToCart(data){
            axios
            .post("http://localhost:8080/cart", { 
                "cart":{},
                "user_id":2,
               "product_id": data.product_id
            })
            .then((response) => {
            console.log(response)
            })
            .catch((err) => {
            console.log(err);
            });
            // navigate("/cart")
        }
    return (
        <>
        <h1 className = "product-text">Products<hr/></h1>
        <div className = "card-container">
        {products.map((element) => {
            return (
                <div className = "card">
                    <div className = "card-top">
                        <img src = {element.image} height = "200px" width = "130px"/>
                    </div>
                    <div className = "card-bottom">
                        <h4>{element.title}</h4>
                        <h4 className = "price-text">{element.price} <small>/SR</small></h4>
                        <button className = "btn btn-secondary" onClick = {() => {addToFavorite(element)}}>Add to Favorite</button>
                        <button className = "btn btn-warning" onClick = {() => {addToCart(element)}}>Add to cart</button>
                    </div>
                </div>)
        })}
        </div>
        </>
    );
}

export default Products;