import React, {useMemo, useState} from 'react';
import styles from './AttachVehicleToFlight.module.css'
import {VehicleService} from "../../services/VehicleService";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";
import {useNavigate} from "react-router-dom";
import {useTranslation} from "react-i18next";
import DataPickerNewPerson from "../../components/UI/datePickers/DataPickerNewPerson/DataPickerNewPerson";
import {FlightService} from "../../services/FlightService";

const AttachVehicleToFlight = () => {

        let loc = useNavigate();

        const {t} = useTranslation();

        function relocate(location: string): void {
            loc(location)
        }

        async function clickButtonBack() {
            relocate('/')
        }

        const [dataVehicle, setDataVehicle] = useState<any>();
        const [vehicle, setVehicle] = useState<number>(0);
        const [outTown, setOutTown] = useState<string>("Moscow");
        const [inTown, setInTown] = useState<string>("Moscow");
        const [outTime, setOutTime] = useState<any>(new Date('1990-01-01'));
        const [inTime, setInTime] = useState<any>(new Date('1990-01-01'));

        const DataPickerCss = {
            background: "white",
            margin: "0px 0px 20px 0px",
            width: "100%",
            label: t('chTime')
        }

        useMemo(async () => {
            const newPlanes: any = await VehicleService.getVehicle('plane');
            setDataVehicle(newPlanes.data);
        }, []);

        async function sendData() {
            await FlightService.createFlight({
                flightNumber: Math.random().toString(),
                arrivalTime: inTime,
                departureTime: outTime,
                planeId: dataVehicle['0'][vehicle].id,
                fromTown: outTown,
                toTown: inTown,
                flightStatus: ''
            });
        }

        return (
            <div className={styles.con}>
                <p className={styles.p}>{t('choosePTR')}</p>
                <select className={styles.sel} onChange={(e) => setVehicle(parseInt(e.target.value))}>
                    {dataVehicle &&
                        dataVehicle["0"].map((person: any, index: number) =>
                            <option value={index.toString()} selected>{person.model + " " + person.number}</option>
                        )
                    }
                </select>

                <p className={styles.p}>{t('chooseOC')}</p>
                <select className={styles.sel} onChange={(e) => setOutTown(e.target.value)}>

                    <option value="Moscow" selected>Moscow</option>
                    <option value="Minsk" selected>Minsk</option>
                    <option value="Paris" selected>Paris</option>
                    <option value="London" selected>London</option>
                    <option value="Kiev" selected>Kiev</option>

                </select>

                <p className={styles.p}>{t('chooseIC')}</p>
                <select className={styles.sel} onChange={(e) => setInTown(e.target.value)}>

                    <option value="Moscow" selected>Moscow</option>
                    <option value="Minsk" selected>Minsk</option>
                    <option value="Paris" selected>Paris</option>
                    <option value="London" selected>London</option>
                    <option value="Kiev" selected>Kiev</option>

                </select>

                <p className={styles.p}>{t('takeoffTime')}</p>
                <DataPickerNewPerson {...DataPickerCss} setAge={setOutTime}/>

                <p className={styles.p}>{t('landTime')}</p>
                <DataPickerNewPerson {...DataPickerCss} setAge={setInTime}/>
                <div className={styles.con2}>
                    <OutlinedButton onClick={clickButtonBack}>{t('back')}</OutlinedButton>
                    <OutlinedButton onClick={sendData}>{t('attachVehSend')}</OutlinedButton>
                </div>
            </div>
        );
    }
;

export default AttachVehicleToFlight;