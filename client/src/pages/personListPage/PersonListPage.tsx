import React, {useEffect, useMemo, useState} from 'react';
import styles from './PersonListPage.module.css';
import LightTable from "../../components/UI/Table/LightTablePersons/LightTable";
import {PersonService} from "../../services/PersonService";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";
import {useNavigate} from "react-router-dom";

const PersonListPage = () => {

    const [job, setJob] = useState<string>("pilot");
    const [data, setData] = useState();

    let loc = useNavigate();

    function relocate(location: string): void {
        loc(location)
    }

    useMemo(async () => {
        const newPersons: any = await PersonService.getPersons(job);
        setData(newPersons.data);
        console.log(newPersons)
    }, [job]);

    async function clickButtonBack() {
        relocate('/')
    }

    return (
        <div className={styles.con}>
            <select className={styles.sel} onChange={(e) => setJob(e.target.value)}>
                <option value="pilot" selected>Пилоты</option>
                <option value="driver">Водятлы</option>
                <option value="stewardess">Стюардессы</option>
            </select>
            <LightTable typejob={job} data={data}/>
            <OutlinedButton onClick={clickButtonBack}>Назад</OutlinedButton>
        </div>
    );
};

export default PersonListPage;