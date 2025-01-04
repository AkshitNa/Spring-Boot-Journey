//Header and Footer
import Header from './Components/Layout/Header';
import Footer from './Components/Layout/Footer';

//Employee
import EmployeeForm from './Components/Employee/EmployeeForm';
import ListEmployee from './Components/Employee/ListEmployee';

//Department
import DepartmentForm from './Components/Department/DepartmentForm';
import ListDepartment from './Components/Department/ListDepartment';

//For Routing
import {BrowserRouter, Routes, Route} from 'react-router-dom';

function App() {

  return (
    <>
      <BrowserRouter>
        <Header />
          <Routes>

            {/* http://localhost:3000 */}
              <Route path='/' element = { <ListEmployee />} />
              {/*  http://localhost:3000/employees */}
              <Route path='/employees' element = { <ListEmployee /> }/>
              {/* http://localhost:3000/add-employee */}
              <Route path='/add-employee' element = { <EmployeeForm />}/>

              {/* http://localhost:3000/edit-employee/1 */}
              <Route path='/edit-employee/:id' element = { <EmployeeForm /> }/>

               {/* http://localhost:3000/departments */}
               <Route path='/departments' element = { <ListDepartment />} />

              {/* http://localhost:3000/add-department */}
              <Route path='/add-department' element = { <DepartmentForm /> } />

              <Route path='/edit-department/:id' element = { <DepartmentForm />} />
              
          </Routes>
        <Footer />
      </BrowserRouter>
    </>
  )
}

export default App;
