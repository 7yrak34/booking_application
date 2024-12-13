import './App.scss';
import { Outlet } from 'react-router-dom';
import { Header } from './components/Header';
import { Footer } from './components/Footer';
import { useContext, useState } from 'react';
import { Menu } from './components/Menu';
import { ScreenSizeContext, ScreenType } from './components/ScreenSizeProvider/ScreenSizeProvider';

export const App = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const screenSize = useContext(ScreenSizeContext);

  return (
    <div className="app">
      <Header isMenuOpen={isMenuOpen} setIsMenuOpen={setIsMenuOpen} />

      {screenSize === ScreenType.isMobile && (
        <Menu isMenuOpen={isMenuOpen} />
      )}

      <Outlet />

      <Footer />
    </div>
  );
}
