import React, {useEffect, useMemo, useState} from 'react';
import styles from './PersonListPage.module.css';
import LightTable from "../../components/UI/Table/LightTablePersons/LightTable";
import {PersonService} from "../../services/PersonService";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";
import {useNavigate} from "react-router-dom";
import {useTranslation} from "react-i18next";

const PersonListPage = () => {

    const {t} = useTranslation();

    const [job, setJob] = useState<string>("pilot");
    const [data, setData] = useState();

    let loc = useNavigate();

    function relocate(location: string): void {
        loc(location)
    }

    useMemo(async () => {
        const newPersons: any = await PersonService.getPersons(job);
        setData(newPersons.data);
        console.log('Get data from request', newPersons)
    }, [job]);

    async function clickButtonBack() {
        relocate('/')
    }

    return (
        <div className={styles.con}>
            <select className={styles.sel} onChange={(e) => setJob(e.target.value)}>
                <option value="pilot" selected>{t('getPilot')}</option>
                <option value="driver">{t('getDriver')}</option>
                <option value="stewardess">{t('getStewardess')}</option>
            </select>
            <LightTable typejob={job} data={data}/>
            <OutlinedButton onClick={clickButtonBack}>{t('back')}</OutlinedButton>
        </div>
    );
};

export default PersonListPage;