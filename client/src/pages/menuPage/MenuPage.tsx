import React, {FC} from 'react';
import style from './MenuPage.module.css';
import LightButton from "../../components/UI/Buttons/LightButton/LightButton";
import "bootstrap/dist/css/bootstrap.min.css";
import LightTable from "../../components/UI/Table/LightTable/LightTable";
import {useNavigate} from "react-router-dom";

const MenuPage: FC = () => {

    let loc = useNavigate();

    function relocate (location:string):void {
        loc(location)
    }

    return (
        <div className={style.con}>
            <div className={style.con2}>
                <div className={style.butCon}>
                    <LightButton onClick={() => relocate("/addPerson")}>Добавить рабочего</LightButton>
                    <LightButton onClick={() => relocate("/addVehicle")}>Добавить технику</LightButton>
                    <LightButton>Список рабочих</LightButton>
                    <LightButton>Список техники</LightButton>
                </div>
            </div>
            <div className={style.tabCon}>
                <LightTable/>
            </div>
        </div>
    );
};

export default MenuPage;