import React from 'react';
import './Advantage.scss';
import { AdvantageType } from '../../types/AdvantageType';

interface Props {
  advantage: AdvantageType,
}

export const Advantage: React.FC<Props> = ({ advantage: { image, title, text } }) => (
  <div className="advantage">
    <img src={image} alt="" className="advantage__image" />

    <div className="advantage__content">
      <h4 className="advantage__title">{title}</h4>
      <p className="advantage__text">{text}</p>
    </div>
  </div>
);
