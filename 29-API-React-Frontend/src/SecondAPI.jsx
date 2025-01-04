//Code 02

import React, { useState, useEffect } from "react";
import axios from "axios";

const SecondAPI = () => {
  
  const [value, setValue] = useState("Hello Akshit");

  useEffect(() => {

    async function fetchData() {
      try {
        const response = await axios.get("http://localhost:8080/api/goodbye");
        setValue(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    }

    fetchData();
    
  }, []); // Empty dependency array ensures this runs only on mount

  return (
    <div>
      <p className="text-center text-red-600">API Calling Using UseEffect Hook</p>
      <p className="font-bold text-2xl"> {value}</p>
    </div>
  );
};

export default SecondAPI;
