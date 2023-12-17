import React from 'react';
import styles from './App.module.css';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import MenuPage from "./pages/menuPage/MenuPage";
import Shedule from "./components/Schedule/Shedule";
import AddPersonPage from "./pages/addPerson/AddPersonPage";
import AddVehicle from "./pages/addVehicle/AddVehicle";
import PersonListPage from "./pages/personListPage/PersonListPage";
import VehicleListPage from "./pages/vehicleListPage/VehicleListPage";
import AttachPerson from "./pages/attavhPersonPage/AttachPerson";
import AttachVehicleToFlight from "./pages/attachVehicleToFlight/AttachVehicleToFlight";
import ListOfFlightsPage from "./pages/listOfFlightsPages/ListOfFlightsPage";
import AttachedPersonsPages from "./pages/veiwAttachedPersonsList/AttachedPersonsPages";


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
                        <Route path="/attachPerson" element={<AttachPerson/>}/>
                        <Route path="/attachVehicle" element={<AttachVehicleToFlight/>}/>
                        <Route path="/listOfFlights" element={<ListOfFlightsPage/>}/>
                        <Route path="/attachedList" element={<AttachedPersonsPages/>}/>
                        <Route path="*" element={<MenuPage/>}/>
                    </Routes>
                </Router>
            </Shedule>
        </div>
    );
}

export default App;
