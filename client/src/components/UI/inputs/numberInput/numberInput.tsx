import React, {FC} from 'react';
import styles from './NumberInput.module.css'

interface IInputNumber {
    placeholder: string;
    value: number;
    disabled: boolean;

    onChange(e: number): void;
}

const NumberInput: FC<IInputNumber> = ({placeholder, value, onChange, disabled}) => {
    return (
        <input type={'number'} min={0} value={value.toString()} placeholder={placeholder} disabled={disabled}
               className={styles.input}
               onChange={(e) => onChange(parseInt(e.target.value))}/>
    );
};

export default NumberInput;