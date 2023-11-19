export interface IVehicle extends IVehicleNew{
    type:string;
}

export interface IVehicleNew {
    model:string;
    number:string;
    crews:number;
    passengers:number;
    fuelVolume: number;
}