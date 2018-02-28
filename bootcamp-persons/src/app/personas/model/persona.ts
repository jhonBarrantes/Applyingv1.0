import { Solicitud } from "../../solicitudes/model/solicitud";

export class Persona{
    id:number;
    nombre:string;
    apellidos:string;
    tipoDocumento:string;
    nroDocumento:string;
    listaSolicitudes: Solicitud[];
}