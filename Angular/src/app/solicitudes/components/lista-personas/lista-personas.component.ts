import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { Persona } from '../../model/persona';
import { Subscription } from 'rxjs/Subscription';
import { PersonasService } from '../../services/personas.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-lista-personas',
  templateUrl: './lista-personas.component.html',
  styleUrls: ['./lista-personas.component.css']
})
export class ListaPersonasComponent implements OnInit, OnDestroy {

  listaPersonas:Persona[];
  subscription : Subscription;

  @Input()
  editable:boolean;

  constructor(private personaService: PersonasService, private location:Location) { }

  ngOnInit() {
    alert("a");
    alert(this.personaService.showUrl);
    this.editable=true;
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
    this.subscription = this.personaService.listarPersonas().subscribe(listaPersonas => this.listaPersonas=this.listaPersonas)
  }
}
