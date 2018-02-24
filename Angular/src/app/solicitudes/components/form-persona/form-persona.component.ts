import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import { ActivatedRoute } from '@angular/router';

import { PersonasService} from '../../services/personas.service';
import { Persona } from '../../model/persona';

@Component({
  selector: 'app-form-persona',
  templateUrl: './form-persona.component.html',
  styleUrls: ['./form-persona.component.css']
})
export class FormPersona implements OnInit {

  persona: Persona;
  texto:string;
  constructor(private personasService: PersonasService, private location:Location, private activateRoute: ActivatedRoute) { }

  ngOnInit() {
    const id:string =this.activateRoute.snapshot.paramMap.get('id');
    if(id==null){
      alert('Nueva Persona')
      this.persona= new Persona();
    }else{
      alert('editar Persoan');
      this.personasService.obtenerPersona(parseInt(id)).subscribe(persona=>this.persona=persona);
      alert("persona:" +this.persona.nombre);
    }
  }

  enviarPersona(persona:Persona){
    if(!persona.id){
      this.texto="Agregar persona";
      this.personasService.crearPersona(persona).subscribe(()=>this.location.back());
    }else{
      this.texto="Modificar persona";
      this.personasService.modificarPersona(persona).subscribe(()=>this.location.back());
    }

  }

  cancelar(){
    this.location.back();
  }

}
