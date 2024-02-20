import React, { useState, useEffect} from 'react';
import './Talep.css'; 

const Talepler = () => {
    const [talepler, setTalepler] = useState([]);

    useEffect(() => {
        fetch('/api/borrow') // Backend'deki endpoint
          .then(response => response.json())
          .then(data => setTalepler(data))
          .catch(error => console.error('Talepler alınırken hata oluştu:', error));
      }, []);

    const handleOnayla = (index) => {
        const updatedTalepler = [...talepler];
        const talepToUpdate = updatedTalepler[index];
        
        // PUT isteği için gerekli bilgiler
        const requestOptions = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ 
                id: talepToUpdate.id, // Talep'in id'si
                officerId: 1 // Default officerId
            })
        };

        // Backend'e PUT isteği gönderme
        fetch(`/api/borrow/${talepToUpdate.id}`, requestOptions)
            .then(response => {
                if (!response.ok) {
                    throw new Error('HTTP Hatası ' + response.status);
                }
                // Başarı durumunda talebi güncelle
                setTalepler(updatedTalepler.filter((_, idx) => idx !== index));
            })
            .catch(error => console.error('Talep güncellenirken hata oluştu:', error));
    };

  return (
    <div className="talepler-container">
    {talepler.map((talep, index) => (
      <div key={index} className="talep-item">
        <div className="talep-info">
          <p>Okuyucu Adı: {talep.readerId}</p>
          <p>Görevli Memur ID: {talep.officerId}</p>
          <p>Kitap Adı: {talep.bookId}</p>
          <p>Süre: {talep.day} gün</p>
          <p>Durum: {talep.status ? "Onaylı" : "Talep oluşturulmuş"}</p>
        </div>
        <div className="talep-actions">
          <button onClick={() => handleOnayla(index)}>Onayla</button>
        </div>
      </div>
    ))}
  </div>
  );
};

export default Talepler;
