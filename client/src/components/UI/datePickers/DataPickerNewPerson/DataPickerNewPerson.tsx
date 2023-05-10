import React, {FC} from 'react';
import {DatePicker, LocalizationProvider} from '@mui/x-date-pickers';
import {AdapterDayjs} from '@mui/x-date-pickers/AdapterDayjs'
import styles from './DataPicker.module.css'
import {TextField} from "@mui/material";

interface Props {
    background?: string;
    margin?: string;
    width?: string;

    setAge(age: Date|null): void;
}

const DataPickerNewPerson: FC<Props> = (Props: Props) => {

    const handleChange = (date:Date | null) => {
        Props.setAge(date);
    }

    return (
        <div style={{...Props, display: "inline-block", borderRadius: "5px"}}>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DatePicker label={"Выберите дату рождения"} className={styles.date}
                            slotProps={{textField: {fullWidth: true}}} onChange={handleChange} />
            </LocalizationProvider>
        </div>
    )
        ;
};

export default DataPickerNewPerson;