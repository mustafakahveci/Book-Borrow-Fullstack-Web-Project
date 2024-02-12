import React, { useEffect, useState } from 'react'
import Book from '../Book/Book';
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

function Home() {

    const [error, setError] = useState(null)
    const [isLoaded, setIsLoaded] = useState(false)
    const [bookList, setBookList] = useState([])
    const classes = useStyles();

    useEffect(() => {
        fetch("/api/book")
            .then(res => res.json())
            .then(
                (result) => {
                    setIsLoaded(true)
                    setBookList(result)
                    //console.log(result)
                },
                (error) => {
                    console.log(error)
                    setIsLoaded(true)
                    setError(error)
                }
            )
    }, [])

    if (error) {
        return <div>Error !!</div>
    } else if (!isLoaded) {
        return <div>Loading...</div>
    } else {
        return (

            <div className={classes.container}>
                {bookList.map(book => (
                    <div>
                        <Book name={book.name} authorName={book.authorName} categoryId={book.categoryId}
                            bookId={book.id} imageUrl={book.imageUrl} language={book.language}
                            publisher={book.publisher} stock={book.stock} summary={book.summary} ></Book>
                    </div>
                ))}
            </div>
        );
    }
}

export default Home;