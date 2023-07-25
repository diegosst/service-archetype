import React, { useState } from 'react';
import { BaseEntity } from '../../domain/models/BaseEntity';
import { BaseEntityService } from '../../application/services/BaseEntityService';


import LabeledInput from '../widgets/LabeledInput';

import './archetype-view.scss';

function ArchetypeView() {

  return (
    <div className="archetype-view">
      <header className="header">
        <div className="management-section">
          <h1 className="title">Entity Management</h1>
          <LabeledInput label="Entity" placeholder="Enter entity code" />
          <div className="buttons-section">
            <button className="button">Create entity</button>
          </div>
        </div>
        <div className='entity-list'>
          <h1 className="title">Entities</h1>
        </div>
      </header>
    </div>
  );
}

export default ArchetypeView;
