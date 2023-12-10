import React, {FC, useState} from 'react';
import styles from './Addperson.module.css'
import FirstSelect from "../../components/UI/selects/selectGender/FirstSelect";
import DataPickerNewPerson from "../../components/UI/datePickers/DataPickerNewPerson/DataPickerNewPerson";
import FirstInput from "../../components/UI/inputs/firstInput/FirstInput";
import OutlinedButton from "../../components/UI/Buttons/outlinedButton/OutlinedButton";
import ArrayInput from "../../components/UI/inputs/arrayInputs/ArrayInput";
import {PersonService} from "../../services/PersonService";
import {useNavigate} from "react-router-dom";
import {useTranslation} from 'react-i18next';


const AddPersonPage: FC = () => {

    const {t} = useTranslation();

    let loc = useNavigate();

    function relocate(location: string): void {
        loc(location)
    }

    const [flag, setFlag] = useState<boolean>(false);

    const [firstName, setName] = useState<string | null>(null);
    const [secondName, setSurname] = useState<string | null>(null);
    const [gender, setGender] = useState<string>(t('genderM'));
    const [job, setJob] = useState(t('jobPilot'))
    const [special, setSpecial] = useState<any>(null);
    const [age, setAge] = useState<any>(new Date('1990-01-01'));

    const DataPickerCss = {
        background: "white",
        margin: "20px 0px 0px 0px",
        width: "100%",
        label: t('chooseBirthday')
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

    const genderArray = [t('genderM'), t('genderF')];

    const jobArray = [t('jobPilot'), t('jobDriver'), t('jobStew')];

    const languagesArray = [t('lanEng'), t('lanEsp'), t('lanRus')];

    const genderMap = new Map<string, string>([
        [t('genderM'), 'Мужской'],
        [t('genderF'), 'Женский']
    ]);

    const jobMap = new Map<string, string>([
        [t('jobPilot'), 'Пилот'],
        [t('jobDriver'), 'Водитель'],
        [t('jobStew'), 'Стюардесса'],
    ]);

    const languageMap = new Map<string, string>([
        [t('lanEng'), 'Английский'],
        [t('lanEsp'), 'Испанский'],
        [t('lanRus'), 'Русский'],
    ]);

    async function clickButton() {
        const date = new Date(age?.$d);
        const gen = genderMap.get(gender);
        const jb = jobMap.get(job);
        let sp;

        if (jb === 'Стюардесса') {
            sp = languageMap.get(special);
        } else {
            sp = special;
        }

        if (firstName && secondName && gen && age && jb && sp) {
            await PersonService.createPerson({
                firstName,
                secondName,
                age: date.getDate().toString() + "." + date.getMonth().toString() + "." + date.getFullYear().toString(),
                gender: gen,
            }, sp, jb);
            setFlag(false);
            relocate('/')
        } else {
            setFlag(true);
        }
    }

    function ProfParam(s: string) {
        switch (s) {
            case t('jobPilot'):
                setSpecial(null);
                break;
            case t('jobDriver'):
                setSpecial(null);
                break;
            case t('jobStew'):
                setSpecial([]);
                break;
        }
    }

    async function clickButtonBack() {
        setFlag(false);
        relocate('/')
    }

    return (
        <div className={styles.con}>
            <FirstInput placeholder={t('name')} {...InputCss} onChange={setName}/>
            <FirstInput placeholder={t('surname')} {...InputCss} onChange={setSurname}/>

            <FirstSelect placeholder={t('chooseGender')} variables={genderArray} {...SelectCSS}
                         selector={setGender} onChangeValue={ProfParam}/>

            <DataPickerNewPerson {...DataPickerCss} setAge={setAge}/>

            <FirstSelect placeholder={t('chooseJob')}
                         variables={jobArray} {...SelectCSS} selector={setJob} onChangeValue={ProfParam}/>

            {
                job === jobArray[0] ?
                    (<>
                        <FirstInput placeholder={t('flightLycense')} {...InputCss} onChange={setSpecial}/>
                    </>)
                    : job === jobArray[1] ? (<>
                            <FirstInput placeholder={t('driveLycense')} {...InputCss} onChange={setSpecial}/>
                        </>)
                        : job === jobArray[2] ? (<>
                                <ArrayInput array={languagesArray} placeholder={t('chooseLanguages')} {...LanguagesCSS}
                                            setChoosenJobs={setSpecial} choosenLanguages={special}/>
                            </>)
                            : null
            }
            {flag &&
                <p style={{color: 'red'}}>{t('fillAll')}</p>
            }
            <div style={{display: "flex", alignItems: "center", justifyContent: "space-between", marginTop: "30px"}}>
                <OutlinedButton onClick={clickButtonBack}>{t('cancel')}</OutlinedButton>
                <OutlinedButton onClick={clickButton}>{t('addWorkerBut')}</OutlinedButton>
            </div>

        </div>
    );
};

export default AddPersonPage;