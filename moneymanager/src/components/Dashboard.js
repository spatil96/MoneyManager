import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Dashboard = () => {
  const [user, setUser] = useState(null);
  useEffect(() => {
    axios.get('http://localhost:8080/user-info', {withCredentials: true})
      .then(response => {
        setUser(response.data);
      })
      .catch(error => {
        console.error('Error fetching user data:', error);
      });
  }, []);

  return (
    <div>
        <h1>Dashboard</h1>
        {user ? (<div>
            <h2>UserName: {user.name}</h2>
            <h2>UserEmail: {user.email}</h2>
            <h2>UserImage: {user.picture && <img src={user.picture} alt="UserImage" referrerPolicy='no-referrer' />}</h2>
            <h3>Expenses</h3>
            <h3>Income</h3>
            <h3>Balance</h3>
        </div>) : (<p>fetching...</p>)}
    </div>
  )
}

export default Dashboard;