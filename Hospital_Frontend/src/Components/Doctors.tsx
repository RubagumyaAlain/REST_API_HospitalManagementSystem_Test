import React from "react"
import { useState } from "react"
import axios from "axios";

function Doctors() {
const [doctors, setDoctors] = useState([]);


  return (
    <div className="mt-10">
      <table className = "min-w-full p-20">
        <thead className="bg-gray-100">
          <tr>
            <th>Full Name</th>
            <th>specialization</th>
            <th>department</th>
            <th>available</th>
          </tr>
          </thead>
          <tbody className="bg-blue-200">
            <tr>
              <td>Rubagumya Alain</td>
              <td>First Responder</td>
              <td>EMS</td>
              <td>Available</td>
            </tr>
          </tbody>
      </table>
    </div>
  )
}

export default Doctors
  