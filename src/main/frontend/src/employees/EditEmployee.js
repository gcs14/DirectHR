import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function EditEmployee() {

    const navigate = useNavigate()
    const {id} = useParams();

    const [employee, setEmployee]= useState({
        name:"",
        username:"",
        email:"",
        phoneNumber:"",
        position:"",
        jobType:"",
        salary:"",
        hourly:"",
    });

    const {name, username, email, phoneNumber, position, jobType, salary, hourly}=employee;

    const onInputChange= (e)=>{
        setEmployee({...employee,[e.target.name]: e.target.value});
    };

    useEffect(() => {
        loadEmployee();
    }, []);

    const onSubmit=async(e)=>{
        e.preventDefault();
        // await axios.put(`https://www.direct-hr.com/employees/${id}`, employee);
        await axios.put(`http://localhost:8080/employees/${id}`, employee);
        navigate("/");
    };

    const loadEmployee = async () =>{
        // const result = await axios.get(`https://www.direct-hr.com/employees/${id}`);
        const result = await axios.get(`http://localhost:8080/employees/${id}`);
        setEmployee(result.data);
    };

  return (
    <div className="container">
        <div className="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center m-4">Edit Employee</h2>
                
                <form onSubmit={(e)=>onSubmit(e)}>
                    <div className="mb-3">
                        <label htmlFor="Name" className="form-label">Full Name</label>
                        <input 
                            type={"text"} 
                            className="form-control" 
                            placeholder="Enter full name" 
                            name="name"
                            value={name}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="Username" className="form-label">Username</label>
                        <input 
                            type={"text"} 
                            className="form-control" 
                            placeholder="Enter an username" 
                            name="username"
                            value={username}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="Email" className="form-label">Email</label>
                        <input 
                            type={"text"} 
                            className="form-control" 
                            placeholder="Enter a email address" 
                            name="email"
                            value={email}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="Phone Number" className="form-label">Phone Number</label>
                        <input 
                            type={"text"} 
                            className="form-control" 
                            placeholder="Enter a phone number" 
                            name="phoneNumber"
                            value={phoneNumber}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="Position" className="form-label">Position</label>
                        <input 
                            type={"text"} 
                            className="form-control" 
                            placeholder="Enter the employee's postion" 
                            name="position"
                            value={position}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="Job Type" className="form-label">Job Type</label>
                        <input 
                            type={"text"} 
                            className="form-control" 
                            placeholder="Is the employee 'full-time' or 'part-time'?" 
                            name="jobType"
                            value={jobType}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="Salary" className="form-label">Salary</label>
                        <input 
                            type={"text"} 
                            className="form-control" 
                            placeholder="If full-time, enter annual salary" 
                            name="salary"
                            value={salary}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="Hourly" className="form-label">Hourly</label>
                        <input 
                            type={"text"} 
                            className="form-control" 
                            placeholder="If part-time, enter hourly pay rate" 
                            name="hourly"
                            value={hourly}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <button type="submit" className="btn btn-primary">Submit</button>
                    <Link className="btn btn-outline-danger mx-2" to="/">Cancel</Link>
                </form>
            </div>
        </div>
    </div>
  );
}
