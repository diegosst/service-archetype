import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import PriceView from './presentation/ui/PriceView';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <PriceView />
  </React.StrictMode>
);
