import React from 'react';
import './App.css';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import MenuPage from "./pages/menuPage/MenuPage";
import Shedule from "./components/Schedule/Shedule";
import AddPersonPage from "./pages/addPerson/AddPersonPage";


function App() {
    return (
        <Shedule>
            <Router>
                <Routes>
                    <Route path="/addPerson" element={<AddPersonPage/>}/>
                    <Route path="*" element={<MenuPage/>}/>
                </Routes>
            </Router>
        </Shedule>

    );
}

export default App;
