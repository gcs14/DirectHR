import React from 'react'
import {Link, useNavigate} from 'react-router-dom'

export default function Navbar() {

    // const history = useNavigate();
    //
    // const handleLogout = () => {
    //     // Perform logout actions here (e.g., clear session, remove authentication token)
    //     // After logout, redirect to the login page
    //     history('/');
    // };

    return (
        <div id="navbar-container">
            <nav className="navbar navbar-expand-lg navbar-muted bg-primary">
                <div className="container-fluid">
                    <Link className="navbar-brand text-light" to="/">DirectHR</Link>
                    <button
                        className="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                    >
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <Link className="btn btn-outline-light" to="/addemployee">Add User</Link>
                    {/*<button type="button" className="btn btn-danger" onClick={handleLogout}>Logout</button>*/}
                </div>
            </nav>
        </div>
    )
}
