import React from 'react';
import './HotelCard.scss';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { ICON_NAMES } from '../../icons';

interface Props {
  image: string,
  title: string,
  location: string,
  rating: number,
  reviewsQuantity: number,
  price: number,
}

export const HotelCard: React.FC<Props> = ({
  image,
  title,
  location,
  rating,
  reviewsQuantity,
  price,
}) => {
  return (
    <li className="hotel-card">
      <img src={image} alt="hotel room" className="hotel-card__image" />

      <div className="hotel-card__info">
        <h3 className="hotel-card__title">
          {title}
        </h3>

        <div className="hotel-card__location">
          <FontAwesomeIcon icon={ICON_NAMES.location} />

          {location}
        </div>

        <div className="hotel-card__ratings">
          <p className="hotel-card__rating">
            {rating}
          </p>

          <p className="hotel-card__reviews">
            {reviewsQuantity} reviews
          </p>
        </div>
      </div>

      <div className="hotel-card__price-box">
        <p className="hotel-card__price">
          {price}$
        </p>

        / a night
      </div>
    </li>
  );
};
