import LabeledInput from '../widgets/LabeledInput';
import './price-view.scss';

function PriceView() {
  return (
    <div className="price-view">
      <header className="header">
        <h1 className="title">Price Management</h1>
        <div className="management-section">
          <LabeledInput label="Product" placeholder="Enter product code" />
          <LabeledInput label="Price" placeholder="Enter product value" />
        </div>
        <div className="buttons-section">
          <button className="button">Create price</button>
        </div>
      </header>
    </div>
  );
}

export default PriceView;
