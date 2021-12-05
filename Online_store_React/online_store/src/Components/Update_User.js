import axios from 'axios'
import { useState } from "react";
import { useEffect } from "react";
import { useParams } from 'react-router-dom';
import '../App.css';

function Update_User() {

  const [userName, setUserName] = useState();
  const [email, setEmail] = useState();
  const [phone, setPhone] = useState();
  const [password, setPassword] = useState();
  let { id } = useParams();
  const [users, setUsers] = useState();



  useEffect(() => {
    axios.all([
      axios.get(`http://localhost:8080/users/${id}`)
    ])
    .then(r => {
      setUsers(r[0].data);
       });
  
      }
  
  ,[]);

  return (
    <div>
    

        <h1 className="h1_h">Update User</h1>


        {  users === undefined ? '' :

        <form className="form_add_user">
        <div className="mb-3">
    <label htmlFor="exampleInputEmail1" className="form-label">User ID</label>
    <input type="number" className="form-control" id="exampleInputEmail1" placeholder={users.user_id} disabled  aria-describedby="emailHelp"  />
  </div>
        <div className="mb-3">
    <label htmlFor="exampleInputEmail1" className="form-label">User Name</label>
    {console.log(users)}
    <input type="text" className="form-control" id="exampleInputEmail1" placeholder={users.userName} aria-describedby="emailHelp" onChange={
        (e)=>{
            setUserName(e.target.value)
        }
    } />
  </div>

  <div className="mb-3">
    <label htmlFor="exampleInputEmail1" className="form-label">Email address</label>
    <input type="email" className="form-control" id="exampleInputEmail1" placeholder={users.email}  aria-describedby="emailHelp" onChange={
        (e)=>{
            setEmail(e.target.value)
        }} />
  </div>
  <div className="mb-3">
    <label htmlFor="exampleInputEmail1" className="form-label">Phone</label>
    <input type="number" className="form-control" id="exampleInputEmail1" placeholder={users.phone}  aria-describedby="emailHelp" onChange={
        (e)=>{
            setPhone(e.target.value)
        }} />
  </div>
  <div className="mb-3">
    <label htmlFor="exampleInputPassword1" className="form-label">Password</label>
    <input type="password" className="form-control" placeholder={users.password}  id="exampleInputPassword1" onChange={
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
    axios.put(`http://localhost:8080/users/${users.user_id}`, user)
        .then(response => {});
        window.location.href = "http://localhost:3000/users"; 
 }
    }>Update</button>
</form>

        }

  </div>

  )}
export default Update_User;
