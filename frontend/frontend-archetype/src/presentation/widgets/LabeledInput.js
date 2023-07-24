import React from 'react';
import './labeled-input.scss';

function LabeledInput({ label, placeholder }) {
  return (
    <div className="section">
      <span className="label">{label}</span>
      <input className="input" placeholder={placeholder} />
    </div>
  );
}

export default LabeledInput;
