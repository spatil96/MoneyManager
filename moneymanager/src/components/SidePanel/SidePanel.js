import React from 'react';
import './SidePanel.css';
import defaultAvatar from '../../../src/logo.svg';
const SidePanel = ({ user }) => {
    console.log('User object:', user?.avatar_url);
    return (
    <div className="side-panel">
       <div className="user-profile">
        <img 
          src={user?.avatar_url} 
          alt="Profile" 
          className="profile-image"
          onError={(e) => {
            e.target.src = defaultAvatar;
          }}
          referrerPolicy="no-referrer" 
        />
        <h3>{user?.name || 'User'}</h3>
        <p>{user?.email || 'Define email'}</p>
      </div>
      <nav>
        <ul>
          <li>Dashboard</li>
          <li>Expenses</li>
          <li>Income</li>
          <li>Total</li>
        </ul>
      </nav>
    </div>
  );
};

export default SidePanel;