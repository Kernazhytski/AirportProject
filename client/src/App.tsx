import React from 'react';
import styles from './App.module.css';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import MenuPage from "./pages/menuPage/MenuPage";
import Shedule from "./components/Schedule/Shedule";
import AddPersonPage from "./pages/addPerson/AddPersonPage";
import AddVehicle from "./pages/addVehicle/AddVehicle";
import PersonListPage from "./pages/personListPage/PersonListPage";
import VehicleListPage from "./pages/vehicleListPage/VehicleListPage";


function App() {
    return (
        <div className={styles.back}>

            <Shedule>
                <Router>
                    <Routes>
                        <Route path="/addPerson" element={<AddPersonPage/>}/>
                        <Route path="/addVehicle" element={<AddVehicle/>}/>
                        <Route path="/personList" element={<PersonListPage/>}/>
                        <Route path="/vehicleList" element={<VehicleListPage/>}/>
                        <Route path="*" element={<MenuPage/>}/>
                    </Routes>
                </Router>
            </Shedule>
        </div>
    );
}

export default App;
