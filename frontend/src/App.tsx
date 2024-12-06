import './App.scss';
import { Outlet } from 'react-router-dom';
import { Header } from './components/Header';

export const App = () => {
  return (
    <div className="app">
      <Header />

      <Outlet />
    </div>
  );
}
