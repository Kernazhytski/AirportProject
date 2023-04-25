import React, {FC} from 'react';
import Button from 'react-bootstrap/Button';
import styles from './LightButton.module.css'

interface Button {
    children: string;
    onClick?:()=>void;
}

const LightButton:FC<Button> = ({children,onClick}) => {
    return (
        <Button variant="light" className={styles.but} onClick={onClick}>{children}</Button>
    );
};

export default LightButton;