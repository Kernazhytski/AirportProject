export interface IVehicle extends IVehicleNew{
    type:string;
}

export interface IVehicleNew {
    model:string;
    number:string;
    maxCrewSize:number;
    passengers:number;
    fuelVolume: number;
}