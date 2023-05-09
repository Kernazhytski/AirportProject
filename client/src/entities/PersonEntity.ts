import {IVehicleNew} from "./VehicleEntity";

export interface IPersonNew {
    firstName: string;
    secondName: string;
    age: number;
    profession:string;
    gender:string;

    vehicle?:IVehicleNew;
}



export interface IPilot extends IPersonNew{
    pylot_lycense?:string;
}

export interface IDriver extends IPersonNew{
    driver_lycense?:string;
}

export interface IStewardess extends IPersonNew{
    languages?:string[];
}
