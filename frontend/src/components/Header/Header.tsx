import { Link } from 'react-router-dom';
import './Header.scss';
import { Icon } from '../Icon';
import { IconType } from '../../types/IconType';
import React, { useContext } from 'react';
import { ScreenSizeContext, ScreenType } from '../ScreenSizeProvider/ScreenSizeProvider';
import { headerLinks } from '../../helpers/constants';
import { Logo } from '../Logo';

interface Props {
  isMenuOpen: boolean,
  setIsMenuOpen: (arg: boolean) => void,
}

export const Header: React.FC<Props> = ({ isMenuOpen, setIsMenuOpen}) => {
  const screenSize = useContext(ScreenSizeContext);

  return (
    <header className="header">
      <Logo />

      {screenSize === ScreenType.isMobile && (
        <button
          type="button"
          className="header__menu-button"
          onClick={() => setIsMenuOpen(!isMenuOpen)}
        >
          <Icon iconType={IconType.menu} isActive={isMenuOpen} />
        </button>
      )}

      {screenSize !== ScreenType.isMobile && (
        <nav className="header__nav">
          <ul className="header__list">
            {headerLinks.map(({ link, text }) => (
              <li key={text} className="header__item">
                <Link to={link} className="header__link">
                  {text}
                </Link>
              </li>
            ))}
          </ul>
        </nav>
      )}
    </header>
  );
}
