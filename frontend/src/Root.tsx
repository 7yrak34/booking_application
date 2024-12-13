import { Route, HashRouter as Router, Routes} from 'react-router-dom';
import { App } from './App';

export const Root = () => (
  <Router>
    <Routes>
      <Route path="/" element={<App />}>
        <Route index element={<h1>Home Page</h1>} />
      </Route>
    </Routes>
  </Router>
);