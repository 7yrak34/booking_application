import React from 'react';
import { IconType } from '../../types/IconType';
import { Icon } from '../Icon';
import './Counter.scss';

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
      <Icon iconType={IconType.plus} />
    </button>

    {count}

    <button
      className="counter__button"
      onClick={decreaseCount}
    >
      <Icon iconType={IconType.minus} />
    </button>
  </div>
);
