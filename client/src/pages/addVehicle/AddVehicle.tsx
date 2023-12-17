import React, {useState} from 'react';
import {VehicleService} from "../../services/VehicleService";
import styles from "./AddVehicle.module.css";
import FirstInput from "../../components/UI/inputs/firstInput/FirstInput";
import FirstSelect from "../../components/UI/selects/selectGender/FirstSelect";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";
import {useNavigate} from "react-router-dom";
import NumberInput from "../../components/UI/inputs/numberInput/numberInput";
import {useTranslation} from "react-i18next";

const AddVehicle = () => {
    let loc = useNavigate();

    const {t} = useTranslation();

    function relocate(location: string): void {
        loc(location)
    }

    const [flag, setFlag] = useState<boolean>(false);

    const [number, setNumber] = useState<string>();
    const [model, setModel] = useState<string>();
    const [vehicleType, setVehicleType] = useState(t('vehPlane'))
    const [crews, setCrews] = useState<number>(0);
    const [passangers, setPassangers] = useState<number>(0);
    const [fuel, setFuel] = useState<number>(0);

    const InputCss = {
        border: "1px solid black",
        margin: "20px 0 0 0",
    }

    const SelectCSS = {
        margin: "20px 0 0 0"
    }

    const LanguagesCSS = {
        margin: "20px 0 0 0"
    }

    const vehicleArray = [t('vehPlane'), t('vehBus'), t('vehFet')];

    const vehMap = new Map<string, string>([
        [t('vehPlane'), "Самолет"],
        [t('vehBus'), "Автобус"],
        [t('vehFet'), "Автозаправщик"],
    ])

    async function clickButton() {

        const v = vehMap.get(vehicleType);

        if (number !== undefined &&
            model !== undefined &&
            v !== undefined &&
            crews !== undefined &&
            passangers !== undefined &&
            fuel !== undefined) {
            await VehicleService.createVehicle({
                maxCrewSize: crews,
                model: model,
                number: number,
                passengers: passangers,
                fuelVolume: fuel
            }, v)
            setFlag(false);
            relocate('/');
        } else {
            setFlag(true);
        }
    }

    async function clickButtonBack() {
        setFlag(false);
        relocate('/')
    }

    return (
        <div className={styles.con}>
            <FirstInput placeholder={t('model')} {...InputCss} onChange={setModel}/>
            <FirstInput placeholder={t('number')} {...InputCss} onChange={setNumber}/>

            <FirstSelect placeholder={t('chooseType')}
                         variables={vehicleArray} {...SelectCSS} selector={setVehicleType}/>

            <div style={{display: "flex", alignItems: "center", justifyContent: "space-between", marginTop: "30px"}}>
                <div style={{width: "100%"}}>
                    <p>{t('crew')}</p>
                    <NumberInput placeholder={'Экипаж'} value={crews} onChange={setCrews} disabled={false}/>
                </div>
                <div style={{width: "100%"}}>
                    <p>{t('passenger')}</p>
                    <NumberInput placeholder={'Пассажиры'} value={passangers} onChange={setPassangers}
                                 disabled={vehicleType === t('vehFet')}/>
                </div>
                <div style={{width: "100%"}}>
                    <p>{t('fuel')}</p>
                    <NumberInput placeholder={'Объем топлива'} value={fuel} onChange={setFuel}
                                 disabled={vehicleType !== t('vehFet')}/>
                </div>
            </div>
            {flag &&
                <p style={{color: 'red'}}>{t('fillAll')}</p>
            }
            <div style={{display: "flex", alignItems: "center", justifyContent: "space-between", marginTop: "30px"}}>
                <OutlinedButton onClick={clickButtonBack}>{t('cancel')}</OutlinedButton>
                <OutlinedButton onClick={clickButton}>{t('addVeh')}</OutlinedButton>
            </div>

        </div>
    );
};

export default AddVehicle;