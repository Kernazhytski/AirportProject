import React, {FC} from 'react';
import styles from './FirstInput.module.css'


interface IButton {
    placeholder: string;
    margin: string;

    onChange(e: string): void;
}


const FirstInput: FC<IButton> = ({placeholder, margin, onChange}) => {


    return (
        <input type={"text"} className={styles.input} style={{margin}} placeholder={placeholder}
               onChange={e => onChange(e.target.value)}/>
    );
};

export default FirstInput;
