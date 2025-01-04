import { CollegeList } from "./Components/CollegeList";
import CollegeSelector from "./Components/CollegeSelector";
import CollegeImages from "./Components/CollegeImages";

function App() {


  return (
    <>
       <h1 className="text-center text-3xl text-blue-400">College HUNT</h1>
       <CollegeImages/>
       <CollegeSelector/>
       <CollegeList/>
    </>
  )
}

export default App;
