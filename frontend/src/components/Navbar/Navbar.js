import React, {useState,useEffect} from 'react'
import { Link, useLocation } from 'react-router-dom';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { styled } from '@mui/system';
import Drawer from '@mui/material/Drawer';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';

const StyledLink = styled(Link)({
  textDecoration: 'none',
  boxShadow: 'none',
  color: 'white',
});

const RedDrawerText = styled(ListItemText)({
  color: 'red',
});

const Navbar = () => {
  const { pathname } = useLocation();
  const [categories, setCategories] = useState([]);
  const [showCategories, setShowCategories] = useState(false);

  useEffect(() => {
    fetchCategories();
  }, []);

  const fetchCategories = async () => {
    try {
      // Backend'den kategorileri almak için bir API çağrısı yapılır
      const response = await fetch('/api/category');
      const data = await response.json();
      setCategories(data); // Kategoriler state'e atanır
    } catch (error) {
      console.error('Error fetching categories:', error);
    }
  };

  const toggleCategories = () => {
    setShowCategories(!showCategories); // Toggle the visibility of categories
  };

  if (pathname === "/login" || pathname === "/register") {
    return null;
  }
  let userId = 5;
  return (
    <div>

      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar>
            <IconButton
              size="large"
              edge="start"
              color="inherit"
              aria-label="menu"
              sx={{ mr: 2 }}
              onClick={toggleCategories}
            >
              <MenuIcon />
            </IconButton>
            <Typography variant="h6" component="div" sx={{ flexGrow: 1, textAlign: 'left' }}>
              <StyledLink to="/">Books</StyledLink>
            </Typography>
            <Typography variant="h6" component="div" sx={{ marginRight: '10px' }}>
              <StyledLink to={{ pathname: '/users/' + userId }}>User</StyledLink>
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
      <Drawer
        anchor="left"
        open={showCategories}
        onClose={toggleCategories}
      >
        <List>
          {categories.map(category => (
            <ListItem key={category.id} button>
              <StyledLink to={{ pathname: '/category/' + category.id + '/books'}}>
                <RedDrawerText primary={category.name} />
              </StyledLink>
            </ListItem>
          ))}
        </List>
      </Drawer>

    </div>
  )
}

export default Navbar