import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Persona } from '../../model/persona';
import { PersonasService } from '../../services/persona-service';

@Component({
  selector: 'app-item-persona',
  templateUrl: './item-persona.component.html',
  styleUrls: ['./item-persona.component.css']
})
export class ItemPersonaComponent implements OnInit {

  @Input()
  persona : Persona;

  @Output()
  eliminado:EventEmitter<any>= new EventEmitter();

  @Output()
  clic:EventEmitter<any>=new EventEmitter();

  constructor(private personaService: PersonasService) { }

  ngOnInit() {
  }

  eliminarPersona(){
    if(confirm(`Desea eliminar el registro: ${this.persona.id}?`)){
      this.personaService.EliminarPersona(this.persona.id).subscribe(()=>this.eliminado.emit(this.persona.id));
    }
  }

  mostrar(){
    alert(`${this.persona.id}  " - " ${this.persona.nombre}`);
    this.clic.emit;
  }

}
