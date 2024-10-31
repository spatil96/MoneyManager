import React, { useEffect, useState } from 'react';
import axios from 'axios';
import SidePanel from '../SidePanel/SidePanel';
const Dashboard = () => {
  const [user, setUser] = useState(null);
  useEffect(() => {
    axios.get('http://localhost:8080/user-info', {withCredentials: true})
      .then(response => {
        setUser(response.data);
        console.log(user);
      })
      .catch(error => {
        console.error('Error fetching user data:', error);
      });
  }, []);

  return (
    <div className="dashboard-container">
      <SidePanel user={user} />
      
      <div className="main-content">
        <h1>Dashboard</h1>
        {user ? (
          <div>
            <h3>Expenses</h3>
            <h3>Income</h3>
            <h3>Balance</h3>
          </div>
        ) : (
          <p>fetching...</p>
        )}
      </div>
    </div>
  );
}

export default Dashboard;