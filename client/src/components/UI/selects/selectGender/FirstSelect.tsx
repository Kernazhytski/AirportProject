import React, {ChangeEvent, FC} from 'react';
import Form from "react-bootstrap/Form";
import FloatingLabel from "react-bootstrap/FloatingLabel";
import {makeStyles} from "@mui/material";


interface ISelect {
    placeholder: string;
    variables: string[];
    margin:string;
    selector:(s:string)=>void;
    onChangeValue?(s:string):void;
}



const FirstSelect: FC<ISelect> = ({placeholder, variables,margin,selector, onChangeValue}) => {

    const handleSelectChange = (event: ChangeEvent<HTMLSelectElement>) => {
        selector(event.target.value);
        if (onChangeValue) {
            onChangeValue(event.target.value);
        }
    };

    return (
        <FloatingLabel
            controlId="floatingSelectGrid"
            label={placeholder}
            style={{margin}}
        >
            <Form.Select aria-label="Floating label select example" required={true} onChange={handleSelectChange}>
                {
                    variables.map((vars, index) => <option key={index} value={vars}>{vars}</option>)
                }
            </Form.Select>
        </FloatingLabel>
    );
};

export default FirstSelect;