import { Injectable } from '@angular/core';
import { Persona } from '../model/persona';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { PersonasConfig } from '../personas.config';
import { ResultMessage } from '../../model/result-message';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

const httpOptions={
    headers:new HttpHeaders({'Content-type': 'application/json'})
};

@Injectable()
export class PersonasService{
    private resourceUrlPersonas:string;
    private resourceUrlPersona:string;

    constructor(private http:HttpClient){
        this.resourceUrlPersonas= PersonasConfig.httpResource.personas;
        this.resourceUrlPersona= PersonasConfig.httpResource.persona;
    }

    ListarPersonas():Observable<Persona[]>{
        return this.http.get<ResultMessage>(`${this.resourceUrlPersonas}`,httpOptions).map(
            response => response['data']);
    }

    ObtenerPersona(id:number): Observable<Persona>{
        return this.http.get<ResultMessage>(`${this.resourceUrlPersona}/${id}`,httpOptions).map(
            response => response['data']);
    }

    CrearPersona(persona:Persona):Observable<Persona>{
        alert("Servicio:"+ persona.nombre);
        console.log(persona.nombre);
        console.log(persona);
        return this.http.post<ResultMessage>(`${this.resourceUrlPersona}`,persona,httpOptions)
        .map(response=>{
            this.showMessage(response);
            return response['data'];});
    }


    ModificarPersona(persona:Persona):Observable<Persona>{
        return this.http.put<ResultMessage>(`${this.resourceUrlPersona}/${persona.id}`,httpOptions).map(
            response => response.data['data']);
    }

    EliminarPersona(id:number):Observable<Persona>{
        alert("eliminar: "+id)
        return this.http.delete<ResultMessage>(`${this.resourceUrlPersona}/${id}`,httpOptions).map(
            response=>response['data']);
    }    

    showMessage(response){
        alert(response.message);
    }

    MostrarLink(){
        alert(this.resourceUrlPersonas);
    }

}
