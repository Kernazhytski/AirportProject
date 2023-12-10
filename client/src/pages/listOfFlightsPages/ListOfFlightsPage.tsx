import React, {useMemo, useState} from 'react';
import styles from './ListOfFlightsPage.module.css'
import {FlightService} from "../../services/FlightService";
import Table from "react-bootstrap/Table";
import {useNavigate} from "react-router-dom";
import {useTranslation} from "react-i18next";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";

const ListOfFlightsPage = () => {

    let loc = useNavigate();

    const {t} = useTranslation();

    function relocate(location: string): void {
        loc(location)
    }

    async function clickButtonBack() {
        relocate('/')
    }

    const [flights, setFlights] = useState<any>();

    useMemo(async () => {
        const newFlights: any = await FlightService.getFlights();
        console.log(newFlights.data);
        setFlights(newFlights.data);
    }, []);

    return (
        <div className={styles.con}>
            <p>Полеты</p>
            <div style={{display: 'flex', maxHeight: '350px', overflowY: 'auto', margin: '10px', maxWidth: '450px'}}>
                {flights &&
                    <Table className={"table table-bordered table-light"} style={{width: "4  00px"}}>
                        <thead>
                        <tr>
                            <th>{t('flightNumber')}</th>
                            <th>{t('flightStatus')}</th>
                            <th>{t('fromTown')}</th>
                            <th>{t('toTown')}</th>
                            <th>{t('departureTime')}</th>
                            <th>{t('arrivalTime')}</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            flights.map((flight: any) =>
                                <tr>
                                    <td>{flight.flightNumber}</td>
                                    <td>{flight.flightStatus}</td>
                                    <td>{flight.fromTown}</td>
                                    <td>{flight.toTown}</td>
                                    <td>{flight.departureTime}</td>
                                    <td>{flight.arrivalTime}</td>
                                </tr>
                            )
                        }
                        </tbody>
                    </Table>}
            </div>
            <OutlinedButton onClick={clickButtonBack}>{t('back')}</OutlinedButton>
        </div>
    );
};

export default ListOfFlightsPage;