import './App.css';
import Home from './components/Home/Home';
import Dashboard from './components/Dashboard/Dashboard';
import Category from './components/Category/Category';
import Expsense from './components/Expenses/Expenses';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
function App() {
  return (

    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/dashboard" element={<Dashboard />} /> 
        <Route path='/categories'  component={Category}/>
        <Route path='/expenses'  component={Expsense}/>
      </Routes>
    </Router>

  );
}

export default App;
