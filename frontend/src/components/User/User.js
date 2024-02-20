import React, { useState } from "react";
import { useParams } from "react-router-dom";
import './User.css';

function User() {
    const { userId } = useParams();
    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [phone, setPhone] = useState('');
    const [birthdate, setBirthdate] = useState('');

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        switch (name) {
            case 'name':
                setName(value);
                break;
            case 'surname':
                setSurname(value);
                break;
            case 'phone':
                setPhone(value);
                break;
            case 'birthdate':
                setBirthdate(value);
                break;
            default:
                break;
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();
    }

    return (
        <div className="user-form-container">
            <h2 className="form-title">Bilgilerimi düzenle</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Name:</label>
                    <input type="text" name="name" value={name} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                    <label>Surname:</label>
                    <input type="text" name="surname" value={surname} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                    <label>Phone:</label>
                    <input type="text" name="phone" value={phone} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                    <label>Birthdate:</label>
                    <input type="date" name="publisher" value={birthdate} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                    <label>Password:</label>
                    <input type="password" placeholder="********" name="publisher" value={birthdate} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                    <button type="submit" className="submit-button">Kaydet</button>
                </div>
            </form>
        </div>
    )
}

export default User;