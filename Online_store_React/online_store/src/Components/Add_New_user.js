import axios from 'axios'
import { useState } from "react";
import '../App.css';

function Add_User() {

  const [userName, setUserName] = useState();
  const [email, setEmail] = useState();
  const [phone, setPhone] = useState();
  const [password, setPassword] = useState();




  return (

    <div>
        <h1 className="h1_h">Add New User</h1>



        <form className="form_add_user">
        <div className="mb-3">
    <label for="exampleInputEmail1" className="form-label">User Name</label>
    <input type="text" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" onChange={
        (e)=>{
            setUserName(e.target.value)
        }
    } />
  </div>

  <div className="mb-3">
    <label for="exampleInputEmail1" className="form-label">Email address</label>
    <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" onChange={
        (e)=>{
            setEmail(e.target.value)
        }} />
  </div>
  <div className="mb-3">
    <label for="exampleInputEmail1" className="form-label">Phone</label>
    <input type="number" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" onChange={
        (e)=>{
            setPhone(e.target.value)
        }} />
  </div>
  <div className="mb-3">
    <label for="exampleInputPassword1" className="form-label">Password</label>
    <input type="password" className="form-control" id="exampleInputPassword1" onChange={
        (e)=>{
            setPassword(e.target.value)
        }} />
  </div>

  <button type="button" className="btn btn-primary" onClick={
      ()=>{
        const user = {
    "userName":userName,
    "email":email,
    "phone":phone,
    "password":password
}
;
    axios.post(`http://localhost:8080/users`, user)
        .then(response => {});
        window.location.href = "http://localhost:3000/users"; }
    }>Submit</button>
</form>

  

  </div>

  )}
export default Add_User;
