import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { Persona } from '../../model/persona';
import { Subscription } from 'rxjs/Subscription';
import { PersonasService } from '../../services/persona-service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-list-personas',
  templateUrl: './list-personas.component.html',
  styleUrls: ['./list-personas.component.css']
})
export class ListPersonasComponent implements OnInit,OnDestroy {

  personas:Persona[];
  subscription:Subscription;

  @Input()
  persona:Persona;

  constructor(private personaService:PersonasService,private location:Location) {}

  ngOnInit() {
    this.actualizarLista();
  }

  ngOnDestroy(){
    if(this.subscription){
      this.subscription.unsubscribe;
    }
  }

  actualizarLista(){
    if(this.subscription){
      this.subscription.unsubscribe();
    }
    this.subscription = this.personaService.ListarPersonas().subscribe(personas=>this.personas=personas);
  }

  mostrarPersona(){
    alert(this.persona.nombre)
  }
}
