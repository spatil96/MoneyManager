import React, { useEffect, useState } from 'react';
import axios from 'axios';
import SidePanel from '../SidePanel/SidePanel';
const Dashboard = () => {
  const [user, setUser] = useState(null);
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8083/user-info', { withCredentials: true }); // API Gateway URL
        setUser(response.data);
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    };
    fetchData();
  }, []);
  return (
    <div className="dashboard-container">
      <SidePanel user={user} />
      
      <div className="main-content">
        <h1>Dashboard</h1>
        {user ? (
          <div>
            <h3>Expenses : {user.expense}</h3>
            <h3>Income : {user.income}</h3>
            <h3>Balance: {user.total}</h3>
          </div>
        ) : (
          <p>fetching...</p>
        )}
      </div>
    </div>
  );
}

export default Dashboard;