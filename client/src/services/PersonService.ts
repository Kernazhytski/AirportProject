import {IPersonNew} from "../entities/PersonEntity";
import {$api} from '../http/api'

export class PersonService {
    static async createPerson(person: IPersonNew, special: any, job: string) {
        console.log(person);
        console.log(special);
        console.log(job);
        switch (job) {
            case "Пилот":
                $api.post('/person/addPilot', {...person, pilotLycense: special})
                break;
            case "Водитель":
                $api.post('/person/addDriver', {...person, driverLycense: special})
                break;
            case "Стюардесса":
                $api.post('/person/addStewardess', {...person, languages: special})
                break;
        }
    }

    static async getPersons(job: string) {
        return $api.get('/person/list', {params: {job: job}}).then()
    }

    static async attachPerson(personId: number, personType: string, vehicleId: number, vehicleType: string) {
        console.log('obj', {
            personId: personId,
            personType: personType,
            vehicleId: vehicleId,
            vehicleType: vehicleType
        })

        return $api.post(`/vehicle/assignPerson?personId=${personId}&personType=${personType.toLowerCase()}&vehicleId=${vehicleId}&vehicleType=${vehicleType.toLowerCase()}`, {})
    }

    static async getAttachedPersons(vehicle: string) {
        return $api.get('/get/PersonsVehicle', {params: {type: vehicle}})
    }
}