import {$api} from "../http/api";
import {IVehicleNew} from "../entities/VehicleEntity";

export class VehicleService{
    static async createVehicle(vehicle:IVehicleNew, vehicleType: string){
        console.log(vehicleType)
        switch (vehicleType) {
            case "Самолет":
                console.log('jnghfdr')
                await $api.post('/vehicle/addPlane',{...vehicle, type: 'Plane'})
                break;
            case "Автобус":
                await $api.post('/vehicle/addBus',{...vehicle, type: 'Bus'})
                break;
            case "Автозаправщик":
                await $api.post('/vehicle/addFettlingMachine',{...vehicle, type: 'FettilingMachine'})
                break;
        }
    }
}