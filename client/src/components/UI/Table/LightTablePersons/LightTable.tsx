import React, {FC, useEffect} from 'react';
import Table from 'react-bootstrap/Table';
import {useTranslation} from "react-i18next";
import styles from './LightTable.module.css'

interface ITable {
    typejob: string;
    data: any;
}

const LightTable: FC<ITable> = ({typejob, data}) => {

    const {t} = useTranslation();

    return (
        <div style={{display: 'flex', maxHeight: '350px', overflowY: 'auto', margin: '10px'}}>
            {(typejob === 'pilot' && data) &&
                <Table className={"table table-bordered table-light"} style={{width: "4  00px"}}>
                    <thead>
                    <tr>
                        <th>{t('name')}</th>
                        <th>{t('surname')}</th>
                        <th>{t('age')}</th>
                        <th>{t('gender')}</th>
                        <th>{t('flightLycense')}</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        data["0"].map((person: any) =>
                            <tr>
                                <td>{person.firstName}</td>
                                <td>{person.secondName}</td>
                                <td>{person.age}</td>
                                <td>{person.gender.gender}</td>
                                <td>{person.pilotLycense}</td>
                            </tr>
                        )
                    }
                    </tbody>
                </Table>
            }
            {(typejob === 'driver' && data) &&
                <Table className={"table table-bordered table-light"} style={{width: "4  00px"}}>
                    <thead>
                    <tr>
                        <th>{t('name')}</th>
                        <th>{t('surname')}</th>
                        <th>{t('age')}</th>
                        <th>{t('gender')}</th>
                        <th>{t('driveLycense')}</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        data["0"].map((person: any) =>
                            <tr>
                                <td>{person.firstName}</td>
                                <td>{person.secondName}</td>
                                <td>{person.age}</td>
                                <td>{person.gender.gender}</td>
                                <td>{person.driverLycense}</td>
                            </tr>
                        )
                    }
                    </tbody>
                </Table>
            }
            {(typejob === 'stewardess' && data) &&
                <Table className={"table table-bordered table-light"} style={{width: "4  00px"}}>
                    <thead>
                    <tr>
                        <th>{t('name')}</th>
                        <th>{t('surname')}</th>
                        <th>{t('age')}</th>
                        <th>{t('gender')}</th>
                        <th>{t('languages')}</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        data["0"].map((person: any) =>
                            <tr>
                                <td>{person.firstName}</td>
                                <td>{person.secondName}</td>
                                <td>{person.age}</td>
                                <td>{person.gender.gender}</td>
                                <td>{
                                    person.languages &&
                                    person?.languages.map((lan: any) => <div>{lan}<br/></div>)}</td>
                            </tr>
                        )
                    }
                    </tbody>
                </Table>
            }
        </div>
    );
};

export default LightTable;