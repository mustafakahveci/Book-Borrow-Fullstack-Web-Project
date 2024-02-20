import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import './BookDetails.css'
import { Button } from '@mui/material'

function BookDetails() {
    const { bookId } = useParams()
    const [book, setBook] = useState(null)

    useEffect(() => {
        fetch("/api/book/" + bookId)
            .then(res => res.json())
            .then(
                (result) => {
                    setBook(result)
                    console.log(result)
                }
            )
    }, [bookId])

    const sendPostRequest = (requestData) => {
        fetch('/api/borrow', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(requestData),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                console.log('POST request succeeded with JSON response', data);
            })
            .catch(error => {
                console.error('Error sending POST request:', error);
            });
    };

    const handleClick = () => {
        const readerId = '1'; // Örnek userId
        const day = '0'; // Örnek day

        const requestData = {
            bookId: bookId,
            readerId: readerId,
            day: day
        };

        sendPostRequest(requestData);
    };

    return (
        <div className='book-details-container'>
            {book && (
                <div>
                    <div className='book-details-info'>
                        <div className='book-details-image'>
                            <img src={'/file-storage/download/' + book.imageId}>
                            </img>
                        </div>
                        <div className='book-details-text'>
                            <h1>{book.name}</h1>
                            <p><strong>Author:</strong> {book.authorName}</p>
                            <p><strong>Publisher:</strong> {book.publisher}</p>
                            <p><strong>Language:</strong> {book.language}</p>
                            <p><strong>Stock:</strong> {book.stock}</p>
                            <p><strong>Category:</strong> {book.categoryId}</p>
                        </div>
                    </div>
                    <div className='book-details-summary-container'>
                        <p><strong>Summary</strong> {book.summary}</p>
                    </div>
                </div>
            )}
            <div className='button-container'>
                <div style={{ display: 'flex', justifyContent: 'center', width: '50%', backgroundColor: '#90ee90', borderRadius: '30px' }}>
                    <Button className='button1' onClick={handleClick}>Ödünç al</Button>
                </div>
                <div className='space-container'></div>
                <div style={{ display: 'flex', justifyContent: 'center', width: '50%', backgroundColor: '#90ee90', borderRadius: '30px' }}>
                    <Button className='button2'>Daha sonra ödünç alacaklarım listesine ekle </Button>
                </div>
                <div className='space-container'></div>
                <div style={{ display: 'flex', justifyContent: 'center', width: '50%', backgroundColor: '#90ee90', borderRadius: '30px' }}>
                    <Link to={{ pathname: '/book/' + bookId + '/edit' }}>
                        <Button className='button2'>Düzenle </Button>
                    </Link>
                </div>
            </div>

        </div>
    )
}
export default BookDetails;