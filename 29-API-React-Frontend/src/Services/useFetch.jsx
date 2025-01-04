//Part of Code 03

import { useState, useEffect } from "react";
import axios from "axios";

const useFetch = (url) => {

  //useState is usually used to create a custom Hook.
  const [data, setData] = useState(null);

  useEffect(() => {

    //async Arrow Function
    const fetchData = async () => {
      try {
        const response = await axios.get(url);
        // console.log(response);
        setData(response.data);
      } catch (error) {
        console.log("Failed To Fetch Data" + error);
      } 
    };

    fetchData();
  }, [url]);

  return data;

};

export default useFetch;
