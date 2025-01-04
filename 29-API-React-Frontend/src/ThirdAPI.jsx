//Code 03

import useFetch from "./Services/useFetch";

const ThirdAPI = () => {

  const data = useFetch("http://localhost:8080/api/goodbye");

  const data2 = useFetch("http://localhost:8080/api/hello");

  return (
    <div>

      <p className="text-center text-red-600">API Calling Using Custom Hook</p>
      <p>Data 01</p>
      <p className="font-bold text-2xl">{data}</p>
      <p>Data 02</p>
      <p className="font-bold text-2xl">{data2}</p>
    </div>
  );
};

export default ThirdAPI;
