import classNames from 'classnames';
import './Menu.scss';
import { Link } from 'react-router-dom';
import { headerLinks } from '../../helpers/constants';
import React from 'react';

interface Props {
  isMenuOpen: boolean,
}

export const Menu: React.FC<Props> = ({ isMenuOpen }) => (
  <aside className={classNames('menu', { 'menu--active': isMenuOpen })}>
    <nav className={classNames('menu__nav', { 'menu__nav--active': isMenuOpen })}>
      <ul className="menu__list">
        {headerLinks.map(({ link, text }) => (
          <li key={text} className="menu__item">
            <Link to={link} className="menu__link">
              {text}
            </Link>
          </li>
        ))}
      </ul>
    </nav>
  </aside>
);
