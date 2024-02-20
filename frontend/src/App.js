import './App.css';
import Navbar from './components/Navbar/Navbar';
import Home from './components/Home/Home';
import User from './components/User/User';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import BookDetails from './components/Book/BookDetails';
import BookAdd from './components/Book/BookAdd';
import EditBook from './components/Book/EditBook';
import BooksCategory from './components/Book/BooksCategory';
import Login from './components/Login/Login'
import Register from './components/Login/Register'
import Talepler from './components/Talep/Talepler';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Navbar></Navbar>
        <Routes>
          <Route exact path="/" element={<Home />}></Route>
          <Route exact path="/users/:userId" element={<User />}></Route>
          <Route exact path="/books/:bookId/details" element={<BookDetails />}></Route>
          <Route exact path="/login" element={<Login />}></Route>
          <Route exact path="/register" element={<Register />}></Route>
          <Route exact path="/talepler" element={<Talepler />}></Route>
          <Route exact path="/book/add" element={<BookAdd/>}></Route>
          <Route exact path="/book/:bookId/edit" element={<EditBook/>}></Route>
          <Route exact path='/category/:categoryId/books' element={<BooksCategory/>}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
