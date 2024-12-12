import React from 'react';
import './SidePanel.css';
import defaultAvatar from '../../../src/logo.svg';
import {Nav,Navbar,NavItem,NavbarBrand, NavLink} from 'reactstrap';
import { FaUser, FaTachometerAlt, FaMoneyBill, FaChartBar } from 'react-icons/fa';

const SidePanel = ({ user }) => {
  console.log('User object:', user?.avatar_url);

  return (
    <div className="side-panel">
      {/* User Profile Section */}
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
        <h3 className="user-name">{user?.name || 'User'}</h3>
        <p className="user-email">{user?.email || 'Define email'}</p>
      </div>

      {/* Navigation Section */}
      <Navbar className="side-nav" vertical>
        <Nav navbar>
          <NavItem>
            <NavLink href="/dashboard">
              <FaTachometerAlt className="nav-icon" /> Dashboard {'Hello'} {user.name}
            </NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="/expenses">
              <FaMoneyBill className="nav-icon" /> Expenses:  {user?.expense || '0.0'}
            </NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="/income">
              <FaChartBar className="nav-icon" /> Income: {user?.income || '0.0'}
            </NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="/total">
              <FaMoneyBill className="nav-icon" /> Total: {user?.total || '0.0'}
            </NavLink>
          </NavItem>
        </Nav>
      </Navbar>
    </div>
  );
};

export default SidePanel;