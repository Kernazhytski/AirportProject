import React, {FC} from 'react';
import {DatePicker, LocalizationProvider} from '@mui/x-date-pickers';
import {AdapterDayjs} from '@mui/x-date-pickers/AdapterDayjs'
import styles from './DataPicker.module.css'
import {TextField} from "@mui/material";

interface Props {
    background?: string;
    margin?: string;
    width?: string;
}

const DataPickerNewPerson: FC<Props> = (Props: Props) => {
    return (
        <div style={{...Props, display: "inline-block", borderRadius:"5px"}} >
            <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DatePicker label={"Выберите дату рождения"}  className={styles.date} slotProps={{textField:{fullWidth:true}}}/>
        </LocalizationProvider>
</div>
)
    ;
};

export default DataPickerNewPerson;