import useFetcher from "./Services/useFetcher";

const FourthAPI = () => {

  const { data: value, loading: loading1, error: error1 } = useFetcher("http://localhost:8080/api/goodbye");
  
  const { data: value2, loading: loading2, error: error2 } = useFetcher("http://localhost:8080/api/hello");

  return (

    <div>
      <p className="text-center text-red-600">API Calling Using Custom Hook Advanced Way</p>
      {loading1 && <p>Loading Data 01....</p>}
      {error1 && <p className="text-red-600">Error: {error1}</p>}
      {value && <p className="font-bold text-2xl">{value}</p>}

      {loading2 && <p>Loading Data 02...</p>}
      {error2 && <p className="text-red-600">Error: {error2}</p>}
      {value2 && <p className="font-bold text-2xl">{value2}</p>}
    </div>
    
  );
};

export default FourthAPI;

//This leads to the concept of Shimmer UI
