import React from "react";
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { Link } from 'react-router-dom';

function Book(props) {
    const { name, authorName, stock, bookId, imageId, publisher } = props
    
    return (
        <div className="bookContainer">
                <Card sx={{ maxWidth: 345 }}>
                <Link to={{pathname: '/books/' + bookId+'/details'}}>
                    <img style={{width:'200px'}} src={'/file-storage/download/'+imageId}>
                    </img>
                </Link>
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                            <h4>{name} </h4 >
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            <p>Author : {authorName}</p>
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            <p>id : {bookId}</p>
                            <p>Stock : {stock}</p>
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            <p>Publisher : {publisher}</p>
                        </Typography>
                    </CardContent>
                    <CardActions>
                        <div style={{ display: 'flex', justifyContent: 'center', width: '100%' }}>
                            <Button variant="contained">Borrow</Button>
                        </div>
                    </CardActions>
                </Card>
            
        </div>
    )

}

export default Book;