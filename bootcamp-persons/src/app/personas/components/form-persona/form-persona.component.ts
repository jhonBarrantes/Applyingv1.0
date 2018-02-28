import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Persona } from '../../model/persona';
import { PersonasService } from '../../services/persona-service';

@Component({
  selector: 'app-form-persona',
  templateUrl: './form-persona.component.html',
  styleUrls: ['./form-persona.component.css']
})
export class FormPersonaComponent implements OnInit {

  persona:Persona;

  constructor(private personaService: PersonasService, private location:Location, private activateRoute: ActivatedRoute) { }

  ngOnInit() {
    const id:string = this.activateRoute.snapshot.paramMap.get('id');
    if(!id){
      alert('vacio');
      this.persona=new Persona();
    }else{
      alert("id: "+id);
      this.personaService.ObtenerPersona(parseInt(id)).subscribe(persona => this.persona = persona);
      console.log(this.persona);
    }
  }

  enviarPersona(persona:Persona){
    alert("nombre: " + this.persona.nombre)
    if(!this.persona.id){
      this.personaService.CrearPersona(persona).subscribe(() => this.location.back());
    }else{
      console.log("Persona:" + this.persona);
      this.personaService.ModificarPersona(persona).subscribe(()=> this.location.back());
    }
  }

  cancelar(){
    this.location.back();
  }

}
