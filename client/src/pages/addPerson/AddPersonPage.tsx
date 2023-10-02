import React, {FC, useState} from 'react';
import styles from './Addperson.module.css'
import FirstSelect from "../../components/UI/selects/selectGender/FirstSelect";
import DataPickerNewPerson from "../../components/UI/datePickers/DataPickerNewPerson/DataPickerNewPerson";
import FirstInput from "../../components/UI/inputs/firstInput/FirstInput";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";
import ArrayInput from "../../components/UI/inputs/arrayInputs/ArrayInput";
import {PersonService} from "../../services/PersonService";


const AddPersonPage: FC = () => {

    const [firstName, setName] = useState<string | null>(null);
    const [secondName, setSurname] = useState<string | null>(null);
    const [gender, setGender] = useState<string>("Мужской");
    const [job, setJob] = useState("Пилот")
    const [special, setSpecial] = useState<any>(null);
    const [age, setAge] = useState<any>(new Date('1990-01-01'));

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

    async function clickButton() {
        const date = new Date(age?.$d);
        console.log(date.getDate().toString() + "." + date.getMonth().toString() + "." + date.getFullYear().toString())
        await PersonService.createPerson({
            firstName,
            secondName,
            age: date.getDate().toString() + "." + date.getMonth().toString() + "." + date.getFullYear().toString(),
            gender
        }, special, job);
    }

    function ProfParam(s:string) {
        switch (s){
            case "Пилот":
                setSpecial(null);
                break;
            case "Водитель":
                setSpecial(null);
                break;
            case "Стюардесса":
                setSpecial([]);
                break;
        }
    }

    return (
        <div className={styles.con}>
            <FirstInput placeholder={"Имя"} {...InputCss} onChange={setName}/>
            <FirstInput placeholder={"Фамилия"} {...InputCss} onChange={setSurname}/>

            <FirstSelect placeholder={"Выберите пол"} variables={genderArray} {...SelectCSS}
                         selector={setGender} onChangeValue={ProfParam}/>

            <DataPickerNewPerson {...DataPickerCss} setAge={setAge}/>

            <FirstSelect placeholder={"Выберите профессию"}
                         variables={jobArray} {...SelectCSS} selector={setJob} onChangeValue={ProfParam}/>

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
                                            setChoosenJobs={setSpecial} choosenLanguages={special}/>
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