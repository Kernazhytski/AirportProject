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

    static async attachPerson(){
        return $api.post('/vehicle/assignPerson',)
    }
}