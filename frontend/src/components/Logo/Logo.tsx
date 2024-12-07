import { Link } from 'react-router-dom';
import './Logo.scss';
import { Icon } from '../Icon';
import { IconType } from '../../types/IconType';

export const Logo = () => (
  <Link to="/" className="logo">
    <Icon iconType={IconType.logo} />
  </Link>
);
