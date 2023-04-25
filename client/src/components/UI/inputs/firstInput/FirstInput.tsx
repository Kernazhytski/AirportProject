import React, {FC} from 'react';
import Form from "react-bootstrap/Form";
import FloatingLabel from "react-bootstrap/FloatingLabel";

interface IButton {
    placeholder:string;
    margin:string;
}

const FirstInput:FC<IButton> = ({placeholder,margin}) => {
    return (
        <FloatingLabel
            controlId="floatingInput"
            label={placeholder}
            className="mb-3"
            style={{margin}}
        >
            <Form.Control type="text" placeholder={placeholder}/>
        </FloatingLabel>
    );
};

export default FirstInput;