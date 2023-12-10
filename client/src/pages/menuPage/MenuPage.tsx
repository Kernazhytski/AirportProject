import React, {FC} from 'react';
import style from './MenuPage.module.css';
import LightButton from "../../components/UI/Buttons/LightButton/LightButton";
import "bootstrap/dist/css/bootstrap.min.css";
import LightTable from "../../components/UI/Table/LightTablePersons/LightTable";
import {useNavigate} from "react-router-dom";
import {useTranslation} from "react-i18next";

const MenuPage: FC = () => {

    let loc = useNavigate();

    function relocate(location: string): void {
        loc(location)
    }

    const {t} = useTranslation();

    const {i18n} = useTranslation();

    const changeLanguage = (lng: string) => {
        i18n.changeLanguage(lng);
    };

    return (
        <div>
            <button onClick={() => changeLanguage('ru')}>ru</button>
            <button onClick={() => changeLanguage('en')}>en</button>
            <button onClick={() => changeLanguage('de')}>de</button>
            <div className={style.con}>
                <div className={style.butCon}>
                    <LightButton onClick={() => relocate("/addPerson")}>{t('addWorker')}</LightButton>
                    <LightButton onClick={() => relocate("/addVehicle")}>{t('addVeh')}</LightButton>
                    <LightButton onClick={() => relocate("/personList")}>{t('workerList')}</LightButton>
                    <LightButton onClick={() => relocate("/vehicleList")}>{t('vehList')}</LightButton>
                </div>
                <div className={style.butCon}>
                    <LightButton onClick={() => relocate("/attachPerson")}>{t('attachPerson')}</LightButton>
                    <LightButton onClick={() => relocate("/attachVehicle")}>{t('makeFlight')}</LightButton>
                    <LightButton onClick={() => relocate("/attachPerson")}>{t('viewPersonAttachments')}</LightButton>
                    <LightButton onClick={() => relocate("/listOfFlights")}>{t('listOfFlights')}</LightButton>
                </div>
            </div>
        </div>
    );
};

export default MenuPage;