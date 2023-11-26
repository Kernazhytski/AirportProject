import {$api} from "../http/api";
import {IVehicleNew} from "../entities/VehicleEntity";

export class VehicleService {
    static async createVehicle(vehicle: IVehicleNew, vehicleType: string) {
        console.log("veh", vehicle);
        console.log(vehicleType);
        switch (vehicleType) {
            case "Самолет":
                await $api.post('/vehicle/addPlane', {...vehicle, type: 'Plane'})
                break;
            case "Автобус":
                await $api.post('/vehicle/addBus', {...vehicle, type: 'Bus'})
                break;
            case "Автозаправщик":
                await $api.post('/vehicle/addFettlingMachine', {...vehicle, type: 'FettilingMachine'})
                break;
        }
    }

    static async getVehicle(type: string) {
        return $api.get('/vehicle/list', {params: {type: type}}).then()
    }
}