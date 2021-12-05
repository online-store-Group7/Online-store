import React, { useEffect, useState } from 'react';
import axios from 'axios';

function Favorite() {

    const [favorite, setFavorite] = useState();

    useEffect(() => {
        axios
        .get("http://localhost:8080/favorite")
        .then((response) => setFavorite(response.data.items))
        .catch((error) => console.log(error))
      },[])

    return (
        <>
        <div class="parent">
            <h1 id="heading">Favorite List</h1>
            <div class="summary_card">
                
            </div>
        </div>

        </>
    )
}

export default Favorite;