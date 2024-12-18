import advantageBuildings from '../images/advantage-buildings.svg';
import advantageLock from '../images/advantage-lock.svg';
import advantageHeart from '../images/advantage-heart.svg';
import { AdvantageType } from '../types/AdvantageType';

export const headerLinks = [
  { text: 'About us', link: '/about-us' },
  { text: 'Hotels', link: '/hotels' },
  { text: 'My profile', link: '/profile' },
];

export const footerLinks = [
  { text: '+1 234 5555-55-55', link: 'tel:+1 234 5555-55-55' },
  {
    text: '400 first ave. suite 700 Minneapolis, MN 55401',
    link: 'https://www.google.com/maps?q=400 first ave. suite 700 Minneapolis, MN 55401',
  },
];

export const advantages: AdvantageType[] = [
  {
    image: advantageBuildings,
    title: '10000 +',
    text: 'Accommodation Options Available',
  },
  {
    image: advantageLock,
    title: 'No markups',
    text: 'Or hidden fees',
  },
  {
    image: advantageHeart,
    title: 'Over 20,000',
    text: 'Happy Customers',
  },
];
