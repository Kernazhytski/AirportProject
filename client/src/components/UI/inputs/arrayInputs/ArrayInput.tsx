import React, {FC, useRef, useState} from 'react';
import styles from './ArrayInput.module.css';
import STCheckBox from "../../checkboxes/standartCheckBox/STCheckBox";

interface Props {
    array: string[];
    placeholder: string;
    margin: string;

    choosenLanguages: string[];

    setChoosenJobs(a: any): void;
}

interface Jobs {
    language: string;
    isChoosen: boolean;

}

const ArrayInput: FC<Props> = ({array, placeholder, margin, setChoosenJobs, choosenLanguages}) => {

        const [isActive, setActive] = useState<boolean>(false);

        const initialJobsState = array.map(language => ({
            language,
            isChoosen: choosenLanguages.includes(language) ? true : false,
        }));

        const [jobs, setJobs] = useState<Jobs[]>(initialJobsState);


        function handleClick() {
            console.log("click");

            console.log(choosenLanguages)
            setJobs(initialJobsState);
            setActive(true);
        }

        function handleBlur() {
            console.log("blur")
            setActive(false);
        }

        function setCheck(index: number) {
            const newJobs = [...jobs];
            newJobs[index].isChoosen = !newJobs[index].isChoosen;
            setJobs(newJobs);

            const fieldNames = jobs.filter((job) => job.isChoosen).map(job => (job.language));
            setChoosenJobs(fieldNames);
        }

        return (
            <div onClick={handleClick} onBlur={handleBlur} tabIndex={-1}>
                <div className={styles.con} style={{margin}}>
                    <p className={styles.placeholder}>{placeholder}</p>
                    <svg className={styles.arrow} width="16" height="8" viewBox="0 0 16 8" fill="none"
                         xmlns="http://www.w3.org/2000/svg">
                        <path d="M1 0.999999L7.21905 6.33061C7.66844 6.7158 8.33156 6.7158 8.78095 6.33061L15 1"
                              strokeWidth="1.5" strokeLinecap="round"/>
                    </svg>
                </div>
                {isActive &&
                    <div className={styles.vypad}>
                        {
                            jobs.map((lang: Jobs, index: number) =>
                                <>

                                    <STCheckBox width={"15px"} widthArrow={"13px"} click={() => setCheck(index)}/>
                                    <div>{lang.language}</div>
                                </>
                            )
                        }
                    </div>
                }
            </div>

        )
            ;
    }
;

export default ArrayInput;