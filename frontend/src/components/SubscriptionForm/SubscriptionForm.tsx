import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import './SubscriptionForm.scss';
import { ICON_NAMES } from '../../icons';

export const SubscriptionForm = () => (
  <div className="subscription-form">
    <div className="subscription-form__content">
      <h3 className="subscription-form__title">Stay Updated</h3>

      <p className="subscription-form__text subscription-form__text--margin">
        Subscribe to our newsletter for the latest news,
        special offers, and discounts.
      </p>

      <div className="subscription-form__bottom">
        <div className="subscription-form__form">
          <div className="subscription-form__input-container">
            <FontAwesomeIcon icon={ICON_NAMES.envelope} className="subscription-form__icon" />

            <input type="email" placeholder="Type in your email" className="subscription-form__input" />
          </div>

          <button className="button subscription-form__button">
            Subscribe
          </button>
        </div>

        <p className="subscription-form__text">
          By clicking «Subscribe», you agree to our Terms of Service and Privacy Policy.
        </p>
      </div>
    </div>
  </div>
);
