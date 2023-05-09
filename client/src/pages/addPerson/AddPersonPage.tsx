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
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";
import ArrayInput from "../../components/UI/inputs/arrayInputs/ArrayInput";


const AddPersonPage: FC = () => {

    const [name, setName] = useState<string | null>(null);
    const [surname, setSurname] = useState<string | null>(null);
    const [gender, setGender] = useState<string>("Мужской");
    const [job, setJob] = useState("Пилот")
    const [special, setSpecial] = useState<any>(null);

    const DataPickerCss = {
        background: "white",
        margin: "20px 0px 0px 0px",
        width: "100%"
    }

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

    const genderArray = ["Мужской", "Женский"]

    const jobArray = ["Пилот", "Водитель", "Стюардесса"];

    const languagesArray = ["Английский", "Испанский", "Русский"];

    function clickButton() {
        console.log(special)
    }


    return (
        <div className={styles.con}>
            <FirstInput placeholder={"Имя"} {...InputCss} onChange={setName}/>
            <FirstInput placeholder={"Фамилия"} {...InputCss} onChange={setSurname}/>

            <FirstSelect placeholder={"Выберите пол"} variables={genderArray} {...SelectCSS}
                         selector={setGender}/>

            <DataPickerNewPerson {...DataPickerCss}/>

            <FirstSelect placeholder={"Выберите профессию"}
                         variables={jobArray} {...SelectCSS} selector={setJob}/>

            {
                job === jobArray[0] ?
                    (<>
                        <FirstInput placeholder={"Полетная лицензия"} {...InputCss} onChange={setSpecial}/>
                    </>)
                    : job === jobArray[1] ? (<>
                            <FirstInput placeholder={"Водительские права"} {...InputCss} onChange={setSpecial}/>
                        </>)
                        : job === jobArray[2] ? (<>
                                <ArrayInput array={languagesArray} placeholder={"Выберете языки"} {...LanguagesCSS}
                                            setChoosenJobs={setSpecial}/>
                            </>)
                            : null
            }

            <div style={{display: "flex", alignItems: "center", justifyContent: "center", marginTop: "30px"}}>
                <OutlinedButton onClick={clickButton}>Добавить работягу</OutlinedButton>
            </div>

        </div>
    );
};

export default AddPersonPage;