import {IPersonNew} from "../entities/PersonEntity";
import {$api} from '../http/api'

export class PersonService{
    static async createPerson(person:IPersonNew){
        $api.post('/add',person)
    }
}