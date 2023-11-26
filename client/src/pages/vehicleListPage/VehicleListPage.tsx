import React, {useMemo, useState} from 'react';
import {useNavigate} from "react-router-dom";
import styles from "../personListPage/PersonListPage.module.css";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";
import {VehicleService} from "../../services/VehicleService";
import LightTableVehicle from "../../components/UI/Table/LightTableVehicles/LightTableVehicle";
import {useTranslation} from "react-i18next";

const VehicleListPage = () => {
    const [job, setJob] = useState<string>("bus");
    const [data, setData] = useState();

    let loc = useNavigate();

    const {t} = useTranslation();

    function relocate(location: string): void {
        loc(location)
    }

    useMemo(async () => {
        const newVehicle: any = await VehicleService.getVehicle(job);
        setData(newVehicle.data);
        console.log(newVehicle)
    }, [job]);

    async function clickButtonBack() {
        relocate('/')
    }

    return (
        <div className={styles.con}>
            <select className={styles.sel} onChange={(e) => setJob(e.target.value)}>
                <option value="bus" selected>{t('vehPlane')}</option>
                <option value="plane">{t('vehBus')}</option>
                <option value="fettlingMachine">{t('vehFet')}</option>
            </select>
            <LightTableVehicle typeVehicle={job} data={data}/>
            <OutlinedButton onClick={clickButtonBack}>{t('back')}</OutlinedButton>
        </div>
    );
};

export default VehicleListPage;