import React from 'react';
import './Counter.scss';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { ICON_NAMES } from '../../icons';

interface Props {
  count: number;
  increaseCount: () => void;
  decreaseCount: () => void;
}

export const Counter: React.FC<Props> = ({ count, increaseCount, decreaseCount }) => (
  <div className="counter">
    <button
      className="counter__button"
      onClick={increaseCount}
    >
      <FontAwesomeIcon icon={ICON_NAMES.plus} />
    </button>

    {count}

    <button
      className="counter__button"
      onClick={decreaseCount}
    >
      <FontAwesomeIcon icon={ICON_NAMES.minus} />
    </button>
  </div>
);
