import { useEffect, useState } from "react";
import axios from "axios";
import "./order.css"

function Orders() {

    const [order, setOrder] = useState([]);

    useEffect(() => {
        axios
        .get("http://localhost:8080/orders")
        .then((response) => {
            setOrder(response.data)
        })
        .catch((err) => {
        console.log(err);
        });
        }, []);
    return (
      <>
        {order.map((element, index) => {
            return (
            <div key={index} className="order-container">
                <h1>Orders<hr/></h1>
                <div className="order-top">
                    <h5>User Name: <span className="order-text">{element.user.userName}</span></h5>
                    <h5>Order Date: <span className="order-text">{element.date}</span><hr/></h5>
            
                    <h5>Order Date: <span className="order-text">{element.date}</span></h5>
                </div>
                <div className="order-bottom">
                    <div className="left-side">
                        <img src = {element.products.image} height = "150" width = "110"/>
                    </div>
                    <div className="right-side">
                        <h5>Product: <span className="order-text">{element.products.title}</span></h5>
                        <h5>Total Price: <span className="order-text">{element.products.price}<small>/SR</small></span></h5>
                    </div>
                </div>
            </div>)
          })}
      </>
    );
  }

  export default Orders; 