import React, {FC} from 'react';
import {useTranslation} from "react-i18next";
import Table from "react-bootstrap/Table";

interface ITable {
    data: any;
}

const TableAttachPerson: FC<ITable> = ({data}) => {

    const {t} = useTranslation();

    return (

        <div style={{display: 'flex', maxHeight: '200px', overflowY: 'auto', margin: '10px'}}>
            {data &&
                <Table className={"table table-bordered table-light"} style={{width: "4  00px"}}>
                    <thead>
                    <tr>
                        <th>{t('name')}</th>
                        <th>{t('surname')}</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        data["0"].map((person: any) =>
                            <tr>
                                <td>{person.firstName}</td>
                                <td>{person.secondName}</td>
                            </tr>
                        )
                    }
                    </tbody>
                </Table>
            }
        </div>
    );
};

export default TableAttachPerson;