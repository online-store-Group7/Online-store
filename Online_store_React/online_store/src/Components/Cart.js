import { useEffect, useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import '../App.css';

function Cart() {


    const [cart, setCart] = useState([]);
    const navigate = useNavigate();


    useEffect(() => {
      axios
      .get("http://localhost:8080/cart")
      .then((response) => {
          console.log(response.data)
          setCart(response.data)
      })
      .catch((err) => {
      console.log(err);
      });
      }, []);

      const confirmOrder = (data) => {
        const d = new Date().toISOString().split('T')[0];
        axios
            .post("http://localhost:8080/orders", { 
                "orders": 
                    {
                        "date": d
                    },
                "product_id": data.products.product_id,
                "user_id":2
            })
            .then((response) => {
            console.log(response)
            })
            .catch((err) => {
            console.log(err);
            });
            navigate("/orders")
    }

    return (
        <>
        {  cart === undefined ? '' :
        <div className="parent">
            <h1 className = "cart-text">Order Summary<hr/></h1>
            <div className="summary_card">
                {cart.map((element, index) => {
                    return(
                        <div key={index}>
                    <div className="item-cart">
                    <img src = {element.products.image} height = "150" width = "110"/>
                        <h4>{element.products.title}</h4>
                        <h4 className="price-left">
                            {element.products.price}
                            <small>/SR</small>
                        </h4>
                    </div>
                    <div className="buttons-cart">
                   <button type="button" id="cartbtn" onClick={()=>confirmOrder(element)}>
                           Confirm order
                   </button>
                    </div>
                    </div>
                    )

                })}
               {/* <div className="buttons-cart">
                   <button type="button" id="cartbtn" onClick={()=>confirmOrder(element)}>
                           Confirm order
                   </button>
               </div> */}
            </div>
        </div>
        }
        </>
    )
}
export default Cart; 
