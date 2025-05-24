import './App.css';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import EmployeeComponent from './components/EmployeeComponent';
import HeaderComponents from './components/HeaderComponents';
import FooterComponents from './components/FooterComponents';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <div className="app-layout">
        <HeaderComponents />
        
        <main className="main-content container">
          <Routes>
            <Route path='/' element={<ListEmployeeComponent />} />
            <Route path='/employees' element={<ListEmployeeComponent />} />
             
            <Route path="/add-employee" element={<EmployeeComponent />} />

            <Route path="/edit-employee/:id" element={<EmployeeComponent />} />
          </Routes>
        </main>
        
        <FooterComponents />
      </div>
    </BrowserRouter>
  );
} 

export default App;
