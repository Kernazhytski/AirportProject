import {IVehicleNew} from "./VehicleEntity";

export interface IPersonNew {
    firstName: string;
    secondName: string;
    age: number;
    profession:string;
    gender:string;
}

export interface IPersonEdit extends IPersonNew{
    vehicle:IVehicleNew
}
