import {IPersonNew} from "../entities/PersonEntity";
import {$api} from '../http/api'

export class PersonService{
    static async createPerson(person:IPersonNew,special:any,job:string){
        switch (job) {
            case "Пилот":
                $api.post('/person/addPilot',{...person,pilotLycense:special})
                break;
            case "Водитель":
                $api.post('/person/addDriver',{...person,driverLycense:special})
                break;
            case "Стюардесса":
                $api.post('/person/addStewardess',{...person,languages:special})
                break;
        }
    }
}