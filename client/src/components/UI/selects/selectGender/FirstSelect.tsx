import React, {FC} from 'react';
import Form from "react-bootstrap/Form";
import FloatingLabel from "react-bootstrap/FloatingLabel";

interface ISelect {
    placeholder: string;
    variables: string[];
    margin:string;
}

const FirstSelect: FC<ISelect> = ({placeholder, variables,margin}) => {
    return (
        <FloatingLabel
            controlId="floatingSelectGrid"
            label={placeholder}
            style={{margin}}
        >
            <Form.Select aria-label="Floating label select example" required={true}>
                {
                    variables.map((vars, index) => <option key={index} value={vars}>{vars}</option>)
                }
            </Form.Select>
        </FloatingLabel>
    );
};

export default FirstSelect;