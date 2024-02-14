import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Book from './Book';
import { makeStyles } from '@mui/styles';

const useStyles = makeStyles((theme) => ({
  container: {
      display: "flex",
      flexWrap: "wrap",
      justifyContent: "flex-start",
      alignItems: "center",
      backgroundColor: '#f0f5ff',
      gap: "20px",
      padding: "20px"
  }
}));

const BooksCategory = () => {

  const { categoryId } = useParams();
  const [books, setBooks] = useState([]);
  const classes = useStyles();

  useEffect(() => {
    fetchBooksByCategory(categoryId);
  }, [categoryId]);

  const fetchBooksByCategory = async (categoryId) => {
    try {
      const response = await fetch(`/api/category/${categoryId}/books`);
      if (!response.ok) {
        throw new Error('Failed to fetch books');
      }
      const data = await response.json();
      setBooks(data);
    } catch (error) {
      console.error('Error fetching books by category:', error);
      setBooks([]);
    }
  };

  return (
    <div className={classes.container}>
                {books.map(book => (
                    <div>
                        <Book name={book.name} authorName={book.authorName} categoryId={book.categoryId}
                            bookId={book.id} imageId={book.imageId} language={book.language}
                            publisher={book.publisher} stock={book.stock} summary={book.summary} ></Book>
                    </div>
                ))}
            </div>
  )
}

export default BooksCategory