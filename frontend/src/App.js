import './App.css';
import Navbar from './components/Navbar/Navbar';
import Home from './components/Home/Home';
import User from './components/User/User';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import BookDetails from './components/Book/BookDetails';
import BookForm from './components/Book/BookForm';
import EditBookForm from './components/Book/EditBookForm';
import Login from './components/Login/Login'
import Register from './components/Login/Register'

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
          <Route exact path="/book/add" element={<BookForm/>}></Route>
          <Route exact path="/book/:bookId/edit" element={<EditBookForm/>}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
