import './SignInPage.scss';
import { SignInInput } from '../../types/SignInInput';
import { useMemo, useState } from 'react';

export const SignInPage = () => {
  const [isRegistering, setIsRegistering] = useState(false);

  const inputs = useMemo(() => {
    const result: SignInInput[] = [
      { text: 'Email address:', type: 'email', },
      { text: 'Password:', type: 'password', },
    ];

    if (isRegistering) {
      result.push({ text: 'Confirm password:', type: 'password' });
    }

    return result;
  }, [isRegistering]);

  return (
    <div className="sign-in-page">
      <div className="sign-in-page__content">
        <h1 className="sign-in-page__title">
          {isRegistering ? 'Registration' : 'Login'}
        </h1>

        <div className="sign-in-page__inputs">
          {inputs.map(({ text, type }) => (
            <div className="sign-in-page__input-container">
              <label className="sign-in-page__label">
                {text}
              </label>

              <input type={type} className="sign-in-page__input" />
            </div>
          ))}
        </div>

        <button className="button sign-in-page__button">
          {isRegistering ? 'Sign up' : 'Login'}
        </button>

        <button
          className="button button--secondary sign-in-page__button"
          onClick={() => setIsRegistering(!isRegistering)}
        >
          {isRegistering ? 'Already have an account' : 'Create an account'}
        </button>

        <p className="sign-in-page__text">
          {isRegistering
            ? 'By registering for an account, you consent to our Terms and Conditions and Privacy Policy'
            : 'Accessing your personal account on the website requires your agreement to the privacy policy.'
          }
        </p>
      </div>
    </div>
  );
};
