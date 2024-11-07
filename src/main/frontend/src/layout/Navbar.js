import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {

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
                </div>
            </nav>
        </div>
    )
}
