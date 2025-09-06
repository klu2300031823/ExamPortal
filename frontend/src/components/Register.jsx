import React, { useState } from 'react';
import axios from 'axios';


export default function Register({ setShowRegister }) {
  const [form, setForm] = useState({
    email: '',
    username: '',
    password: '',
    confirmPassword: '',
    role: '',
  });

  // handle input change
  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  // handle form submit
  const handleSubmit = async (e) => {
    e.preventDefault();

    // validation
    if (!form.email || !form.username || !form.password || !form.confirmPassword || !form.role) {
      alert("All fields are required.");
      return;
    }

    if (form.password !== form.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }

    try {
      await axios.post("http://localhost:8085/users/signup", { 
    email: form.email,
    username: form.username,
    password: form.password,
    role: form.role.toLowerCase()
});

      alert(res.data); // backend returns string message
      setForm({
        email: '',
        username: '',
        password: '',
        confirmPassword: '',
        role: '',
      });

      setShowRegister(false); // hide register page
    } catch (err) {
      alert(err.response?.data || "Registration failed");
    }
  };

  return (
    <div className="signup-container">
      <div className="signup-left">
        <div className="signup-box">
          <form onSubmit={handleSubmit}>
            <label>Email</label>
            <input
              type="email"
              name="email"
              placeholder="Enter email"
              value={form.email}
              onChange={handleChange}
              required
            /><br/>

            <label>Username</label>
            <input
              type="text"
              name="username"
              placeholder="Enter Username"
              value={form.username}
              onChange={handleChange}
              required
            /><br/>

            <label>Role</label>
            <div className="role-selection">
              <label>
                <input
                  type="radio"
                  name="role"
                  value="user"
                  checked={form.role === 'user'}
                  onChange={handleChange}
                />
                <span>User</span>
              </label>
              <label>
                <input
                  type="radio"
                  name="role"
                  value="admin"
                  checked={form.role === 'admin'}
                  onChange={handleChange}
                />
                <span>Admin</span>
              </label>
            </div>

            <label>Password</label>
            <input
              type="password"
              name="password"
              placeholder="Enter Password"
              value={form.password}
              onChange={handleChange}
              required
            /><br/>

            <label>Confirm Password</label>
            <input
              type="password"
              name="confirmPassword"
              placeholder="Confirm Password"
              value={form.confirmPassword}
              onChange={handleChange}
              required
            /><br/>

            <button type="submit" className="signup-btn">Sign Up</button>

            <p
              onClick={() => setShowRegister(false)}
              style={{ cursor: "pointer", color: "blue", marginTop: "10px" }}
            >
              Back to Login
            </p>
          </form>
        </div>
      </div>

     
    </div>
  );
}
