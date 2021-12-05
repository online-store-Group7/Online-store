import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css';

function Cart() {

    const [cart, setCart] = useState([]);

    useEffect(() => {
        axios
        .get("http://localhost:8080/cart")
        .then((response) => setCart(response.data.items))
        .catch((error) => console.log(error))
        console.log(response);
      },[])

    
    const confermOrder = (e) => {
        axios
        .post("http://localhost:8080/orders")
        .then((response) => setCart(response.data.items))
        .catch((error) => console.log(error))
        console.log(response);
    }

    return (
        <>
        <div class="parent">
            <h1 id="heading">Order Summary</h1>
            <div class="summary_card">
                {cart.map(e => {
                    <div className="item-cart">
                        <h4>{e.title}</h4>

                        <h4 className="price-left">
                            {e.price}
                        </h4>
                    </div>
                })}

               <div className="buttons-cart">
                   <button type="button" id="cartbtn" onClick={()=>confermOrder()}>
                           Confirm order
                   </button>
               </div>
            </div>
        </div>
        
        </>
    )
}

export default Cart;