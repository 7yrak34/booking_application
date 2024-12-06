import { createRoot } from 'react-dom/client';
import { Root } from './Root';
import { ScreenSizeProvider } from './components/ScreenSizeProvider/ScreenSizeProvider';

createRoot(document.getElementById('root') as HTMLElement)
  .render(
    <ScreenSizeProvider>
      <Root />
    </ScreenSizeProvider>
);
