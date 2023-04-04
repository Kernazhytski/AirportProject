import React, {FC} from 'react';
import style from './MenuPage.module.css'
import LightButton from "../../components/UI/Buttons/LightButton/LightButton";
import "bootstrap/dist/css/bootstrap.min.css";
import LightTable from "../../components/UI/Table/LightTable/LightTable";

const MenuPage: FC = () => {
    return (
        <div className={style.con}>
            <div className={style.con2}>
                <div className={style.butCon}>
                    <LightButton>Добавить рабочего</LightButton>
                    <LightButton>Добавить технику</LightButton>
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