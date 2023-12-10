import React, {useMemo, useState} from 'react';
import styles from './AtatchVehicle.module.css'
import {PersonService} from "../../services/PersonService";
import {useTranslation} from "react-i18next";
import {VehicleService} from "../../services/VehicleService";
import TableAttachPerson from "../../components/UI/Table/TableAttachPerson/TableAttachPerson";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";
import {useNavigate} from "react-router-dom";
import TableAttachVehicle from "../../components/UI/Table/TableAttachVehicle/TableAttachVehicle";

const AttachPerson = () => {

    let loc = useNavigate();

    const {t} = useTranslation();

    function relocate(location: string): void {
        loc(location)
    }

    async function clickButtonBack() {
        relocate('/')
    }

    async function addToVeh() {
        console.log(person);
        console.log(vehicle);
        if (person >= dataPerson['0'].length || vehicle >= dataVehicle['0'].length) {
            console.log('lol')
            return;
        }
        const choosedPerson = dataPerson['0'][person];
        const choosedVehicle = dataVehicle['0'][vehicle];

        let choosedJob = '';
        if (job === 'pilot') {
            choosedJob = 'Pilot';
        } else if (job === 'stewardess') {
            choosedJob = 'Stewardess';
        } else if (job === 'driver') {
            choosedJob = 'Driver';
        }
        console.log(choosedPerson.id)
        console.log(choosedJob)
        console.log(choosedVehicle.id)
        console.log(choosedVehicle.type)
        await PersonService.attachPerson(choosedPerson.id, choosedJob, choosedVehicle.id, choosedVehicle.type)
    }

    const [job, setJob] = useState<string>("pilot");
    const [dataPerson, setDataPerson] = useState<any>();
    const [dataVehicle, setDataVehicle] = useState<any>();
    const [person, setPerson] = useState<number>(0);
    const [vehicle, setVehicle] = useState<number>(0);

    useMemo(async () => {
        const newPersons: any = await PersonService.getPersons(job);
        setDataPerson(newPersons.data);
        console.log(newPersons)
    }, [job]);

    useMemo(async () => {
        if (job === 'pilot' || job === 'stewardess') {
            const newPlanes: any = await VehicleService.getVehicle('plane');
            setDataVehicle(newPlanes.data);
        } else if (job === "driver") {
            const newBuses: any = await VehicleService.getVehicle('bus');
            const newFlet: any = await VehicleService.getVehicle('fettlingMachine');
            setDataVehicle([...newBuses.data, ...newFlet.data]);
        }
    }, [job]);

    return (
        <div className={styles.con}>
            <select className={styles.sel} onChange={(e) => setJob(e.target.value)}>
                <option value="pilot" selected>{t('getPilot')}</option>
                <option value="driver">{t('getDriver')}</option>
                <option value="stewardess">{t('getStewardess')}</option>
            </select>
            <div className={styles.tablesCon}>
                <div className={styles.oneTable}>
                    <p>{t('personTable')}</p>
                    <TableAttachPerson data={dataPerson}/>
                </div>
                <div className={styles.oneTable}>
                    <p>{t('vehicleTable')}</p>
                    <TableAttachVehicle data={dataVehicle}/>
                </div>
            </div>
            <div className={styles.tablesCon}>
                <div className={styles.oneTable}>
                    <p style={{margin: '0px'}}>{t('personTable')}</p>
                    <select className={styles.sel} onChange={(e) => setPerson(parseInt(e.target.value))}>
                        {dataPerson &&
                            dataPerson["0"].map((person: any, index: number) =>
                                <option value={index} selected>{person.firstName + " " + person.secondName}</option>
                            )
                        }
                    </select>
                </div>
                <div className={styles.oneTable}>
                    <p style={{margin: '0px'}}>{t('vehicleTable')}</p>
                    <select className={styles.sel} onChange={(e) => setVehicle(parseInt(e.target.value))}>
                        {dataVehicle &&
                            dataVehicle["0"].map((person: any, index: number) =>
                                <option value={index.toString()} selected>{person.model + " " + person.number}</option>
                            )
                        }
                    </select>
                </div>
            </div>
            <OutlinedButton onClick={addToVeh}>{t('addToVeh')}</OutlinedButton>
            <br/>
            <OutlinedButton onClick={clickButtonBack}>{t('back')}</OutlinedButton>
        </div>
    );
};

export default AttachPerson;
