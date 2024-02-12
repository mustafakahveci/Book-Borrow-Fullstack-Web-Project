import React, { useState } from 'react';
import './BookForm.css'; // CSS dosyasını dahil ediyoruz

function BookForm() {
  const [bookInfo, setBookInfo] = useState({
    name: '',
    summary: '',
    authorName: '',
    publisher: '',
    language: '',
    imageUrl: '',
    stock: 0,
    categoryId: 0
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setBookInfo({ ...bookInfo, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Gönderilen kitap bilgileri:', bookInfo);
    // API'ye gönderme işlemi burada gerçekleştirilebilir
  };

  return (
    <div className="book-form-container">
      <h2 className="form-title">Kitap Oluştur</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Kitap Adı:</label>
          <input type="text" name="name" value={bookInfo.name} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Özet:</label>
          <textarea className="summary" name="summary" value={bookInfo.summary} onChange={handleInputChange} rows={4} required />
        </div>
        <div className="form-group">
          <label>Yazar Adı:</label>
          <input type="text" name="authorName" value={bookInfo.authorName} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Yayınevi:</label>
          <input type="text" name="publisher" value={bookInfo.publisher} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Dil:</label>
          <input type="text" name="language" value={bookInfo.language} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Resim URL:</label>
          <input type="text" name="imageUrl" value={bookInfo.imageUrl} onChange={handleInputChange} />
        </div>
        <div className="form-group">
          <label>Stok:</label>
          <input type="number" name="stock" value={bookInfo.stock} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <label>Kategori ID:</label>
          <input type="number" name="categoryId" value={bookInfo.categoryId} onChange={handleInputChange} required />
        </div>
        <div className="form-group">
          <button type="submit" className="submit-button">Oluştur</button>
        </div>
      </form>
    </div>
  );
}

export default BookForm;
