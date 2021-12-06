// import React, { useEffect, useState } from 'react';
// import axios from 'axios';

// function Favorite() {

//     const [favorite, setFavorite] = useState([]);

//     useEffect(() => {
//         axios
//         .get("http://localhost:8080/favorite")
//         .then((response) => setFavorite(response.data))
//         .catch((error) => console.log(error))
//       },[])

//     return (
//         <>
//         <div class="root">
//             <h1 id="header">Favorite List</h1>
//             <div class="summary_favorite">
//             {favorite.map(e => {
//                     <div className="item-cart">
//                         <h4>{e.title}</h4>

//                         <h4 className="price-left">
//                             {e.price}
//                         </h4>
//                     </div>
//                 })}
//             </div>
//         </div>

//         </>
//     )
// }

// export default Favorite;