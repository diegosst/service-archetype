import React from 'react';
import './labeled-input.scss';

type LabeledInputProps = {
  label: string;
  placeholder: string;
};

function LabeledInput({ label, placeholder } : LabeledInputProps) {
  return (
    <div className="section">
      <span className="label">{label}</span>
      <input className="input" placeholder={placeholder} />
    </div>
  );
}

export default LabeledInput;
