import React from 'react'
import { Link, useLocation } from 'react-router-dom';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { styled } from '@mui/system';

const StyledLink = styled(Link)({
  textDecoration: 'none',
  boxShadow: 'none',
  color: 'white',
});


const Navbar = () => {
  const { pathname } = useLocation();
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

    </div>
  )
}

export default Navbar