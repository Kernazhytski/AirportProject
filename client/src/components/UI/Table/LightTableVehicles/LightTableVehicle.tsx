import React, {FC, useEffect} from 'react';
import Table from 'react-bootstrap/Table';
import {useTranslation} from "react-i18next";

interface ITable {
    typeVehicle: string;
    data: any;
}

const LightTableVehicle: FC<ITable> = ({typeVehicle, data}) => {

    const {t} = useTranslation();

    useEffect(() => {
        if (data) {
            console.log(data);
            console.log(data["0"]);
        }
    }, [data])

    return (
        <div>
            {(typeVehicle === 'bus' && data) &&
                <Table className={"table table-bordered table-light"} style={{width: "4  00px"}}>
                    <thead>
                    <tr>
                        <th>{t('model')}</th>
                        <th>{t('number')}</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        data["0"].map((person: any) =>
                            <tr>
                                <td>{person.model}</td>
                                <td>{person.number}</td>
                            </tr>
                        )
                    }
                    </tbody>
                </Table>
            }
            {(typeVehicle === 'plane' && data) &&
                <Table className={"table table-bordered table-light"} style={{width: "4  00px"}}>
                    <thead>
                    <tr>
                        <th>{t('model')}</th>
                        <th>{t('number')}</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        data["0"].map((person: any) =>
                            <tr>
                                <td>{person.model}</td>
                                <td>{person.number}</td>
                            </tr>
                        )
                    }
                    </tbody>
                </Table>
            }
            {(typeVehicle === 'fettlingMachine' && data) &&
                <Table className={"table table-bordered table-light"} style={{width: "4  00px"}}>
                    <thead>
                    <tr>
                        <th>{t('model')}</th>
                        <th>{t('number')}</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        data["0"].map((person: any) =>
                            <tr>
                                <td>{person.model}</td>
                                <td>{person.number}</td>
                            </tr>
                        )
                    }
                    </tbody>
                </Table>
            }
        </div>
    );
};

export default LightTableVehicle;