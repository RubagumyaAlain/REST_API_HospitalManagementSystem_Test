import axios from "axios";
import { useEffect, useState } from "react"

type Doctor = {
  fullName: string;
  specialization: string;
  department: string;
  available: boolean;
};

function Doctors() {
const [doctors, setDoctors] = useState<Doctor[]>([]);

useEffect(() => {
  const fetchDoc = async ()=>{
    try {
         const response = await axios.get<Doctor[]>("http://localhost:8080/api/doctors")
        
         setDoctors(response.data);
         
        }
     catch (error) {
     console.log(error)
    }
}
fetchDoc()
 },[]);


  return (
    <div className="mt-10">
      <table className = "min-w-full p-20 border = 1">
        <thead className="bg-gray-100">
          <tr>
            <th>Full Name</th>
            <th>specialization</th>
            <th>department</th>
            <th>available</th>
          </tr>
          </thead>
          <tbody className="bg-blue-200 text-center">
            {doctors.map((doctor,index)=>{
             return <tr key={index}>
                <td>{doctor.fullName}</td>
                <td>{doctor.specialization}</td>
                <td>{doctor.department}</td>
                <td>{doctor.available}</td>
              </tr>
            })}
          </tbody>
      </table>
    </div>
  )
}

export default Doctors
  
