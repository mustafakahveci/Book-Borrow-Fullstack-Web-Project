import React, { useState } from 'react'
import './Login.css'
import { Link } from 'react-router-dom';

const Login = () => {

    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
    }

    return (
        <div className='loginAndRegister'>
            <div className='auth-form-container'>
                <h2>Login</h2>
                <form className='login-form' onSubmit={handleSubmit}>
                    <label for="email">Email</label>
                    <input value={email} onChange={(e) => setEmail(e.target.value)} type='email' placeholder='youremail@gmail.com' id='email' name='email'></input>
                    <label for="password">Password</label>
                    <input value={pass} onChange={(e) => setPass(e.target.value)} type='password' placeholder='********' id='password' name='password'></input>
                    <button type='submit'>Login</button>
                    <Link className='link' to={{ pathname: '/register' }}>Don't have an account? Register here.</Link>
                </form>
            </div>
        </div>


    )
}

export default Login;