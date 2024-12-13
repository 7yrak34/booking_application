import './HomePage.scss';
import { BookingForm } from '../../components/BookingForm';

export const HomePage = () => {
  return (
    <div className="home-page">
      <section className="home-page__top">
        <div className="home-page__container">
          <h1 className="home-page__title">
            Book
            <br />
            unique accommodation
            <br />
            quickly and easily
          </h1>

          <BookingForm />
        </div>
      </section>
    </div>
  );
}
