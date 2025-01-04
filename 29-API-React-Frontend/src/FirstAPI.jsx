//Code 01

import axios from "axios";
import React, { useState } from "react";

const FirstAPI = () => {
  
  const [value, setValue] = useState("Hello Akshit");

  const handleHelloAPI = () => {

    async function fetchData() {
      try {
        const response = await axios.get("http://localhost:8080/api/hello");
        //setValue(response.data);
        console.log(response);
        setValue(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    }

   
  fetchData(); //fully hoisted

  };

  return (
    <div>
      <p className="text-center text-red-600">API Calling Using Button No UseEffect Hook</p>
      <button
        onClick={handleHelloAPI}
        className="border-2 border-black bg-green-500 mb-3"
      >
        Click ME
      </button>
      <p className="font-bold text-2xl"> {value}</p>
    </div>
  );
};

export default FirstAPI;
