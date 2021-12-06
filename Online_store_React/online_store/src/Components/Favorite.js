import React, { useEffect, useState } from 'react';
import axios from 'axios';

function Favorite() {

    const [favorite, setFavorite] = useState([]);


      useEffect(() => {
        axios.all([
          axios.get('http://localhost:8080/favorite')
        ])
        .then(r => {
            setFavorite(r[0].data);
           });
      
          }
      
      ,[]);

    return (
        <>
        <div className="root">
            <h1 className="h1_h">Favorite List</h1>
            <div className="summary_favorite">
    
            {  favorite === undefined ? '' :
            favorite.map((e,index) => {
                return (
                    <div key={index} className="div_Users">
                        <h4 className="h1_h">{e.products.title}</h4>
                        <hr/>
                        <h4 className="h1_h">
                            {e.products.description}
                        </h4>
                    </div>
            )})}
            </div>
            
        </div>

        </>
    )
}

export default Favorite;