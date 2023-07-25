import React from 'react';
import { BrowserRouter, Routes, Route } from "react-router-dom";

import ArchetypeView from "./presentation/ui/ArchetypeView";

function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<ArchetypeView />} />
        </Routes>
    </BrowserRouter>
  );
}

export default App;
