import { BrowserRouter, Link, Route, Routes } from 'react-router-dom'
import Doctors from './Components/Doctors.tsx'
import Patients from './Components/Patients.tsx'

function App() {
 
return(
  <>
      <div>
        <BrowserRouter>
          <nav className='flex justify-between items-center gap-8 font-bold text-white bg-blue-500 p-2'>
            <h1>Nyarugenge Hospital</h1>
            <div className='flex items-center gap-8'>
                <Link to='/doctors' className='hover:text-blue-100 text-white-600'> Doctors</Link>
                <Link to='/patients' className='hover:text-blue-100 text-white-600'> Patients</Link>
            </div>
          <div className='ml-auto border border-black rounded-sm p-2 hover:border-white '>
            <button> Logout</button>
          </div>
        </nav>

        <div className='flex justify-center text-bold font-bold'>
          <h1>Hospital Management System</h1>
        </div>

        <Routes>
          <Route path='/patients' element={<Patients />} />
          <Route path='/doctors' element={<Doctors />} />
        </Routes>
        </BrowserRouter>
      </div>
      
  </>
  
)
 
}

export default App
