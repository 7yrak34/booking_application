import './App.scss';
import { Outlet } from 'react-router-dom';
import { Header } from './components/Header';
import { Footer } from './components/Footer';
import { useState } from 'react';
import { Menu } from './components/Menu';

export const App = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  return (
    <div className="app">
      <Header isMenuOpen={isMenuOpen} setIsMenuOpen={setIsMenuOpen} />

      <Menu isMenuOpen={isMenuOpen} />

      <Outlet />

      <Footer />
    </div>
  );
}
