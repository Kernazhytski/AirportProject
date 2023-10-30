import {IPersonNew} from "../entities/PersonEntity";
import {$api} from "../http/api";
import {IVehicleNew} from "../entities/VehicleEntity";

export class VehicleService{
    static async createVehicle(vehicle:IVehicleNew, vehicleType: string){
        switch (vehicleType) {
            case "Самолёт":
                $api.post('/vehicle/addPlane',{...vehicle})
                break;
            case "Автобус":
                $api.post('/vehicle/addBus',{...vehicle})
                break;
            case "Автозаправщик":
                $api.post('/vehicle/addFettlingMachine',{...vehicle})
                break;
        }
    }
}