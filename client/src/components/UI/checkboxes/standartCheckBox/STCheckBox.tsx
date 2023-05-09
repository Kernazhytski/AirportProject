import React, {FC, useState} from 'react';
import styles from './Checkbox.module.css'
import CheckIcon from '@mui/icons-material/Check';

interface Props{
    width:string;
    widthArrow:string;
    click():void;
}




const StCheckBox:FC<Props> = ({width,widthArrow,click}) => {

    const [checked,setChecked] = useState<boolean>(false);

    function handleClick() {
        if(checked){
            setChecked(false);
        }else{
            setChecked(true);
        }
    }



    return (
        <div className={styles.con} onClick={()=>{click();handleClick()}}>
            <div className={styles.box} style={{width,height:width}}>
                {
                    checked&&<CheckIcon style={{width:widthArrow}}/>
                }
            </div>
        </div>
    );
};

export default StCheckBox;