import React from 'react';
import './Home.css';
const Home = () => {
  const googleLogin = () => {window.location.href = 'http://localhost:8080/0auth2/authorization/google'};
  const githubLogin = () => {window.location.href = 'http://localhost:8080/oauth2/authorization/github'};
  
  return (
    <div className="container">
      <h2 className="title">Welcome to Money Manager</h2>
      <button className="button" onClick={googleLogin}>Login With Google</button>
      <button className="button" onClick={githubLogin}>Login With Github</button>
    </div>
  );
}


export default Home;