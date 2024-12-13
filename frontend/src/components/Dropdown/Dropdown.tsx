import React, { useEffect, useRef, useState } from 'react';
import './Dropdown.scss';
import classNames from 'classnames';
import { Icon } from '../Icon';
import { IconType } from '../../types/IconType';

interface Props {
  title: string;
  icon: IconType;
  isOpen: boolean;
  setIsOpen: (arg: boolean) => void;
  children: React.ReactNode;
}

export const Dropdown: React.FC<Props> = ({
  title,
  icon,
  isOpen,
  children,
  setIsOpen: setIsDropdownOpen,
}) => {
  const dropdown = useRef<HTMLDivElement | null>(null);

  useEffect(() => {
    const handleOutsideClickForLocation = (e: MouseEvent) => {
      if (dropdown.current && !dropdown.current.contains(e.target as Node)) {
        setIsDropdownOpen(false);
      }
    };

    document.addEventListener('click', (e) => handleOutsideClickForLocation(e));

    return () => {
      document.removeEventListener('click', handleOutsideClickForLocation);
    };
  }, []);

  return (
    <div
      ref={dropdown}
      className="dropdown"
    >
      <button
        className={classNames('dropdown__button', {
          'dropdown__button--active': isOpen,
        })}
        onClick={() => {
          setIsDropdownOpen(!isOpen);
        }}
      >
        <Icon iconType={icon} />

        {title}
      </button>

      {isOpen && children}
    </div>
  );
};
