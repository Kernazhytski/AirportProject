import React, {FC} from 'react';
import {Button} from "@mui/material";
import styles from './OutlinedButton.module.css'

interface Props {
    children: string;

    onClick(): void;
}

const OutlinedButton: FC<Props> = ({children, onClick}) => {
    return (
        <Button variant="outlined" style={{backgroundColor: "white", borderColor: "black", color: "black"}}
                onClick={onClick}>{children}</Button>
    );
};

export default OutlinedButton;