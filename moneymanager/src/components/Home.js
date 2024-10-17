import React from 'react';

const Home = () => {
  const googleLogin = () => {window.location.href = 'http://localhost:8080/0auth2/authorization/google'};
  const githubLogin = () => {window.location.href = 'http://localhost:8080/oauth2/authorization/github'};
    return (
    <div>
        <h2>Welcome to Money Manager</h2>
        <button onClick={googleLogin}>Login With Google</button>
        <button onClick={githubLogin}>Login With Github</button>
    </div>
  )
}

export default Home;