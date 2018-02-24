import { AppConfig } from "../app.config";

export class PersonasConfig{
    public static httpResource:any={
        personas:AppConfig.SERVER_ADDRESS+'/personas',
        persona:AppConfig.SERVER_ADDRESS+'/persona',
    }
}