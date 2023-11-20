import React, {useMemo, useState} from 'react';
import {useNavigate} from "react-router-dom";
import styles from "../personListPage/PersonListPage.module.css";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";
import {VehicleService} from "../../services/VehicleService";
import LightTableVehicle from "../../components/UI/Table/LightTableVehicles/LightTableVehicle";

const VehicleListPage = () => {
    const [job, setJob] = useState<string>("bus");
    const [data, setData] = useState();

    let loc = useNavigate();

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
                <option value="bus" selected>Автобус</option>
                <option value="plane">Самолет</option>
                <option value="fettlingMachine">Автозаправщик</option>
            </select>
            <LightTableVehicle typeVehicle={job} data={data}/>
            <OutlinedButton onClick={clickButtonBack}>Назад</OutlinedButton>
        </div>
    );
};

export default VehicleListPage;