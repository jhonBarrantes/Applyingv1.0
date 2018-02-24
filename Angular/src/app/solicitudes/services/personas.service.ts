import { Injectable } from '@angular/core';
import { Persona } from '../model/persona';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { PersonasConfig } from '../personas.config';
import { ResultMessage } from '../../model/result-message';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
};

@Injectable()
export class PersonasService {

  private resourceUrlPersonas: string;
  private resourceUrlPersona: string;

  constructor( private http: HttpClient ) {
  
    this.resourceUrlPersonas = PersonasConfig.httpResource.personas;
    this.resourceUrlPersona= PersonasConfig.httpResource.persona;
    alert(this.resourceUrlPersona);
}

  listarPersonas(): Observable<Persona[]>{
    return this.http.get<ResultMessage>(`${this.resourceUrlPersonas}`,httpOptions).map(response => response['data']);
  }

  obtenerPersona(id:number): Observable<Persona>{
    return this.http.get<ResultMessage>(`${this.resourceUrlPersona}`,httpOptions).map(response => response['data']);
  }

  crearPersona(persona:Persona): Observable<Persona>{
    return this.http.post<ResultMessage>(`${this.resourceUrlPersona}`,persona,httpOptions)
    .map(response=>{
      this.showMessage(response);
      return response['data'];
    })
  }

  showUrl(){
    alert(this.resourceUrlPersonas);
  }

  modificarPersona(persona:Persona):Observable<Persona>{
      return this.http.put<ResultMessage>(`${this.resourceUrlPersona}/${persona.id}`,persona,httpOptions)
      .map(response=>{
          this.showMessage(response);
          return response['data'];
      })
  }

  eliminarPersona(id:number):Observable<Persona>{
      return this.http.delete<ResultMessage>(`${this.resourceUrlPersona}/${id}`,httpOptions)
      .map(response=>{
          this.showMessage(response);
          return response['data'];
      })
  }

  private showMessage(response) {
    alert(response.message);
  }
}
