import React, { useState } from 'react'
import { Link } from 'react-router-dom';
import './Login.css'

const Register = () => {

    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');
    const [name, setName] = useState('');
    const [username, setUsername] = useState('');
    const [surname, setSurname] = useState('');
    const [phone, setPhone] = useState('');
    const [gender, setGender] = useState('');
    const [birthdate, setBirthdate] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
    }

    return (
        <div className='loginAndRegister'>
            <div className='auth-form-container'>
                <h2>Register</h2>
                <form className='register-form' onSubmit={handleSubmit}>
                    <label for="username">Username</label>
                    <input value={username} onChange={(e) => setUsername(e.target.value)} type='username' placeholder='username' id='username' name='username'></input>
                    <label for="name">Name</label>
                    <input value={name} onChange={(e) => setName(e.target.value)} type='name' placeholder='name' id='name' name='name'></input>
                    <label for="surname">Surname</label>
                    <input value={surname} onChange={(e) => setSurname(e.target.value)} type='surname' placeholder='surname' id='surname' name='surname'></input>
                    <label for="email">Email</label>
                    <input value={email} onChange={(e) => setEmail(e.target.value)} type='email' placeholder='youremail@gmail.com' id='email' name='email'></input>
                    <label for="password">Password</label>
                    <input value={pass} onChange={(e) => setPass(e.target.value)} type='password' placeholder='********' id='password' name='password'></input>
                    <label For="phone">Phone</label>
                    <input value={phone} onChange={(e) => setPhone(e.target.value)} type='text' placeholder='123-456-7890' id='phone' name='phone'></input>
                    <label For="gender">Gender</label>
                    <select value={gender} onChange={(e) => setGender(e.target.value)} id="gender" name="gender">
                        <option value="">Select</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                    <label For="birthdate">Birthdate</label>
                    <input value={birthdate} onChange={(e) => setBirthdate(e.target.value)} type='date' id='birthdate' name='birthdate'></input>
                    <button type='submit'>Register</button>
                    <Link to={{ pathname: '/login' }}>Already have an account? Login here.</Link>
                </form>
            </div>
        </div>
    )
}

export default Register