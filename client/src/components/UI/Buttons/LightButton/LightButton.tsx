import React, {FC} from 'react';
import Button from 'react-bootstrap/Button';
import styles from './LightButton.module.css'

interface Button {
    children: string;
}

const LightButton:FC<Button> = ({children}) => {
    return (
        <Button variant="light" className={styles.but}>{children}</Button>
    );
};

export default LightButton;