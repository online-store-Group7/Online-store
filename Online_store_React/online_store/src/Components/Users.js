import axios from 'axios'
import { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import '../App.css';
import Update_User from './Update_User';

function Users() {

  const [users, setUsers] = useState();
  const navigate = useNavigate();




    useEffect(() => {
        axios.all([
          axios.get('http://localhost:8080/users')
        ])
        .then(r => {
          setUsers(r[0].data);
          console.log(r[0].data)
           });
      
          }
      
      ,[]);

  return (
    <div>

        <h1 className="h1_h">Users</h1>
        <a href="/add_user"><button type="button" class="btn btn-secondary">Add New user</button></a>

{  users === undefined ? '' :
          

      users.map((element, index) => {
          return (
            <div key={index} className="div_Users"> 
            <p className="p2_Users"><b>User ID:</b> {element.user_id}</p>
            <p className="p_Users"><b>User Name:</b> {element.userName}</p>
            <p className="p_Users"><b>Phone:</b> {element.phone}</p>
            <p className="p_Users"><b>Password:</b> {element.password}</p>

            <input type="button" value="Update" class="btn btn-primary" onClick={ () => {
                      navigate(`/update_user/${element.user_id}`)

            }}  /> 


            <input type="button" value="Delete" class="btn btn-danger" onClick={ () => {
    axios.delete(`http://localhost:8080/users/${element.user_id}`).then(response => {
      console.log(response);
    });
    window.location.reload();
    }}  /> 


            </div>)
            }

  )}

  </div>

  )}
export default Users;
