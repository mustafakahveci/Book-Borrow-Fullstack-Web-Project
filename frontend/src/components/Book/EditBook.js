import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import './BookAdd.css';

const EditBook = () => {
  const { bookId } = useParams();
  const [bookInfo, setBookInfo] = useState({});
  
  useEffect(() => {
    fetch("/api/book/" + bookId)
      .then(res => res.json())
      .then((result) => {
        setBookInfo(result);
        console.log(result);
      });
  }, [bookId]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setBookInfo({ ...bookInfo, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Gönderilen kitap bilgileri:', bookInfo);
    
    // Burada API'ye güncellenmiş kitap bilgilerini gönderme işlemi yapılabilir
    fetch(`/api/book/${bookId}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(bookInfo),
    })
    .then(response => response.json())
    .then(data => {
      console.log('Kitap başarıyla güncellendi:', data);
      // Başka bir işlem yapılabilir, örneğin kullanıcıyı bir başka sayfaya yönlendirebilirsiniz
    })
    .catch(error => {
      console.error('Hata oluştu:', error);
    });
  };

  return (
    <div className="book-form-container">
      <h2 className="form-title">Kitap Düzenle</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Kitap Adı:</label>
          <input type="text" name="name" value={bookInfo.name || ''} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Özet:</label>
          <textarea className="summary" name="summary" value={bookInfo.summary || ''} onChange={handleInputChange} rows={4} required />
        </div>
        <div className="form-group">
          <label>Yazar Adı:</label>
          <input type="text" name="authorName" value={bookInfo.authorName || ''} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Yayınevi:</label>
          <input type="text" name="publisher" value={bookInfo.publisher || ''} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Dil:</label>
          <input type="text" name="language" value={bookInfo.language || ''} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Resim URL:</label>
          <input type="text" name="imageUrl" value={bookInfo.imageUrl || ''} onChange={handleInputChange} />
        </div>
        <div className="form-group">
          <label>Stok:</label>
          <input type="number" name="stock" value={bookInfo.stock || 0} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Kategori ID:</label>
          <input type="number" name="categoryId" value={bookInfo.categoryId || 0} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <button type="submit" className="submit-button">Kaydet</button>
        </div>
      </form>
    </div>
  );
};

export default EditBook;
