import React, {useState} from 'react';
import {VehicleService} from "../../services/VehicleService";
import styles from "./AddVehicle.module.css";
import FirstInput from "../../components/UI/inputs/firstInput/FirstInput";
import FirstSelect from "../../components/UI/selects/selectGender/FirstSelect";
import DataPickerNewPerson from "../../components/UI/datePickers/DataPickerNewPerson/DataPickerNewPerson";
import ArrayInput from "../../components/UI/inputs/arrayInputs/ArrayInput";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";
import {useNavigate} from "react-router-dom";
import NumberInput from "../../components/UI/inputs/numberInput/numberInput";

const AddVehicle = () => {
    let loc = useNavigate();

    function relocate(location: string): void {
        loc(location)
    }

    const [flag, setFlag] = useState<boolean>(false);

    const [number, setNumber] = useState<string>();
    const [model, setModel] = useState<string>();
    const [vehicleType, setVehicleType] = useState("Самолет")
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

    const vehicleArray = ["Самолет", "Автобус", "Автозаправщик"];

    async function clickButton() {
        console.log(passangers)
        if (number !== undefined &&
            model !== undefined &&
            vehicleType !== undefined &&
            crews !== undefined &&
            passangers !== undefined &&
            fuel !== undefined) {
            await VehicleService.createVehicle({
                crews: crews,
                model: model,
                number: number,
                passengers: passangers,
                fuelVolume: fuel
            }, vehicleType)
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
            <FirstInput placeholder={"Модель"} {...InputCss} onChange={setModel}/>
            <FirstInput placeholder={"Номер"} {...InputCss} onChange={setNumber}/>

            <FirstSelect placeholder={"Выберите вид техники"}
                         variables={vehicleArray} {...SelectCSS} selector={setVehicleType}/>

            <div style={{display: "flex", alignItems: "center", justifyContent: "space-between", marginTop: "30px"}}>
                <div style={{width: "100%"}}>
                    <p>Экипаж</p>
                    <NumberInput placeholder={'Экипаж'} value={crews} onChange={setCrews} disabled={false}/>
                </div>
                <div style={{width: "100%"}}>
                    <p>Пассажиры</p>
                    <NumberInput placeholder={'Пассажиры'} value={passangers} onChange={setPassangers}
                                 disabled={vehicleType === "Автозаправщик"}/>
                </div>
                <div style={{width: "100%"}}>
                    <p>Объем топлива</p>
                    <NumberInput placeholder={'Объем топлива'} value={fuel} onChange={setFuel}
                                 disabled={vehicleType !== "Автозаправщик"}/>
                </div>
            </div>
            {flag &&
                <p style={{color: 'red'}}>Заполните все поля</p>
            }
            <div style={{display: "flex", alignItems: "center", justifyContent: "space-between", marginTop: "30px"}}>
                <OutlinedButton onClick={clickButtonBack}>Отмена</OutlinedButton>
                <OutlinedButton onClick={clickButton}>Добавить технику</OutlinedButton>
            </div>

        </div>
    );
};

export default AddVehicle;