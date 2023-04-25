import React, {FC, useState} from 'react';
import styles from './Addperson.module.css'
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import {Form} from 'react-bootstrap';
import FirstSelect from "../../components/UI/selects/selectGender/FirstSelect";
import DataPickerNewPerson from "../../components/UI/datePickers/DataPickerNewPerson/DataPickerNewPerson";
import AdapterDateFns from "@mui/lab/AdapterDateFns";
import {DatePicker, LocalizationProvider} from "@mui/lab";
import {DateRange} from "@mui/lab/DateRangePicker";
import FirstInput from "../../components/UI/inputs/firstInput/FirstInput";
import {Button} from "@mui/material";


const AddPersonPage: FC = () => {

    const [selectedDate, setSlectedDate] = useState<Date | null>(null);

    const dateChange = (date: Date | DateRange<any>) => {
        console.log("HOJ")
    }

    const DataPickerCss={
        background:"white",
        margin:"20px 0px 0px 0px",
        width:"100%"
    }

    const InputCss={
        margin:"20px 0 0 0"
    }

    const SelectCSS={
        margin:"20px 0 0 0"
    }

    return (
        <div className={styles.con}>
            <FirstInput placeholder={"Имя"} {...InputCss}/>
            <FirstInput placeholder={"Фамилия"} {...InputCss}/>

            <FirstSelect placeholder={"Выберите пол"} variables={["Мужской","Женский"]} {...SelectCSS}/>

            <DataPickerNewPerson {...DataPickerCss}/>

            <FirstSelect placeholder={"Выберите профессию"} variables={["Пилот","Водитель","Диспетчер"]} {...SelectCSS}/>

            <Button variant="outlined">Добавить работягу</Button>
        </div>
    );
};

export default AddPersonPage;