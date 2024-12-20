import './App.scss';
import { Outlet } from 'react-router-dom';
import { Header } from './components/Header';
import { Footer } from './components/Footer';
import { useContext, useEffect, useState } from 'react';
import { Menu } from './components/Menu';
import { ScreenSizeContext, ScreenType } from './components/ScreenSizeProvider/ScreenSizeProvider';
import classNames from 'classnames';

export const App = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const screenSize = useContext(ScreenSizeContext);

  return (
    <div className={classNames('app', {
      'app--no-scroll': isMenuOpen,
    })}>
      <Header isMenuOpen={isMenuOpen} setIsMenuOpen={setIsMenuOpen} />

      {screenSize === ScreenType.isMobile && (
        <Menu isMenuOpen={isMenuOpen} />
      )}

      <main className="app__main">
        <Outlet />
      </main>

      <Footer />
    </div>
  );
}
