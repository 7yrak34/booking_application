import './Footer.scss';
import { Logo } from '../Logo';
import { footerLinks } from '../../helpers/constants';

export const Footer = () => (
  <footer className="footer">
    <div className="footer__content">
      <div className="footer__top">
        <h2 className="footer__title">Need help?</h2>

        {footerLinks.map(({ link, text }) => (
          <a
            key={link}
            href={link}
            target="_blank"
            rel="noreferrer"
            className="footer__link"
          >
            {text}
          </a>
        ))}
      </div>

      <div className="footer__bottom">
        <Logo />

        <div className="footer__extra-info">
          <p className="footer__text">© 2009-2019</p>

          <p className="footer__text">
            The use of site materials without the author's consent is prohibited.
          </p>
        </div>
      </div>
    </div>
  </footer>
);
