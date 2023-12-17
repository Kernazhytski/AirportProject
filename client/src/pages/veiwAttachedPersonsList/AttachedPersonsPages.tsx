import styles from './AttachedPersonsPage.module.css'
import React, {useMemo, useState} from 'react';
import {useTranslation} from "react-i18next";
import {useNavigate} from "react-router-dom";
import Table from "react-bootstrap/Table";
import {PersonService} from "../../services/PersonService";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";

const AttachedPersonsPages = () => {

    const {t} = useTranslation();

    let loc = useNavigate();

    const [job, setJob] = useState<string>("plane");
    const [data, setData] = useState<any>();

    function relocate(location: string): void {
        loc(location)
    }

    async function clickButtonBack() {
        relocate('/')
    }

    useMemo(async () => {
        const newData = await PersonService.getAttachedPersons(job);
        if (job === "plane") {
            // @ts-ignore
            setData([...newData.data[1], ...newData.data[2]]);
        }
        if (job === "bus") {
            // @ts-ignore
            setData([...newData.data[0]]);
        }
        if (job === "fettilingMachine") {
            // @ts-ignore
            setData([...newData.data[0]]);
        }
        console.log([...newData.data[1], ...newData.data[2]])
    }, [job])

    return (
        <div className={styles.con}>
            <select className={styles.sel} onChange={(e) => setJob(e.target.value)}>
                <option value="plane" selected>{t('vehPlane')}</option>
                <option value="bus">{t('vehBus')}</option>
                <option value="fettilingMachine">{t('vehFet')}</option>
            </select>

            <p>Полеты</p>
            {<div style={{display: 'flex', maxHeight: '350px', overflowY: 'auto', margin: '10px', maxWidth: '750px'}}>
                {data?.length > 0 &&
                    <Table className={"table table-bordered table-light"} style={{width: "4  00px"}}>
                        <thead>
                        <tr>
                            <th>{t('name')}</th>
                            <th>{t('surname')}</th>
                            <th>{t('model')}</th>
                            <th>{t('number')}</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            data.map((flight: any) =>
                                <tr>
                                    <td>{flight.firstName}</td>
                                    <td>{flight.secondName}</td>
                                    <td>{flight?.vehicleResponseDTO?.model}</td>
                                    <td>{flight?.vehicleResponseDTO?.number}</td>
                                </tr>
                            )
                        }
                        </tbody>
                    </Table>}
            </div>}
            <OutlinedButton onClick={clickButtonBack}>{t('back')}</OutlinedButton>
        </div>


    );
};

export default AttachedPersonsPages;