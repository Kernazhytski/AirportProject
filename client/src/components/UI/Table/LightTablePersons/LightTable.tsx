import React, {FC, useEffect} from 'react';
import Table from 'react-bootstrap/Table';

interface ITable {
    typejob: string;
    data: any;
}

const LightTable: FC<ITable> = ({typejob, data}) => {

    useEffect(() => {
        if (data) {
            console.log(data);
            console.log(data["0"]);
        }
    }, [data])

    return (
        <div>
            {(typejob === 'pilot' && data) &&
                <Table className={"table table-bordered table-light"} style={{width: "4  00px"}}>
                    <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Pilot Lycense</th>
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
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Driver Lycense</th>
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
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Languages</th>
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
                                <td>{person.languages.map((language: any) => <div>
                                    {language}
                                    <br/>
                                </div>)}</td>
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