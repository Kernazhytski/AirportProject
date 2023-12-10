import {$api} from '../http/api'
import {Flight} from "../entities/Flight";

export class FlightService {
    static async createFlight(values: Flight) {
        $api.post('flights/addFlight', {...values})
    }

    static async getFlights(){
        return $api.get('flights/list')
    }
}