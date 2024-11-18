import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom'

export default function Home() {

    const [employees, setEmployees]=useState([])
    // eslint-disable-next-line
    const {id} = useParams()

    const loadEmployees=async()=>{
        // const result=await axios.get('https://direct-hr.com/employees')
        const result=await axios.get('http://localhost:8080/employees')
        setEmployees(result.data);
    };

    const deleteEmployee = async (id) =>{
      // await axios.delete(`https://direct-hr.com/employee/${id}`)
        await axios.delete(`http://localhost:8080/employees/${id}`)
      loadEmployees();
    };

    useEffect(()=>{
      loadEmployees();
  },[])

  let formatPhoneNumber = (str) => {
    let cleaned = ('' + str).replace(/\D/g, '');
    let match = cleaned.match(/^(\d{3})(\d{3})(\d{4})$/);
  
    if (match) {
      return '(' + match[1] + ') ' + match[2] + '-' + match[3]
    }
    return null
  };

  return (
    <div className='container'>
        <div className='py-5'>
        {/*<table className="table border shadow">*/}
        <table className="table table-hover border shadow">
          <thead>
            <tr>
              <th scope="col" className="id">Id</th>
              <th scope="col" className="name">Name</th>
              <th scope="col" className="userName">Username</th>
              <th scope="col" className="email">Email</th>
              <th scope="col" className="phoneNumber">Phone Number</th>
              <th scope="col" className="action">Action</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((employee)=>(
                <tr>
                    <th className="employee_id">{employee.id}</th>
                    <td className="employee_name">{employee.name}</td>
                    <td className="employee_userName">{employee.username}</td>
                    <td className="employee_email">{employee.email}</td>
                    <td className="employee_phoneNumber">{formatPhoneNumber(employee.phoneNumber)}</td>
                    <td className="employee_actions">
                        <Link className='btn btn-primary mx-2' to={`/viewemployee/${employee.id}`}>View</Link>
                        <Link className='btn btn-outline-primary mx-2' to={`/editemployee/${employee.id}`}>Edit</Link>
                        <button className="btn btn-danger mx-2"
                        onClick={()=> deleteEmployee(employee.id)}>Delete</button>
                    </td>
                </tr>
            ))
            }
          </tbody>
        </table>
        </div>
    </div>
  )
}
