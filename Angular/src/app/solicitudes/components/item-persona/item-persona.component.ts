import { Component, OnInit,Input,Output, EventEmitter } from '@angular/core';
import { Persona } from '../../model/persona';
import { PersonasService } from '../../services/personas.service';

@Component({
  selector: 'app-item-persona',
  templateUrl: './item-persona.component.html',
  styleUrls: ['./item-persona.component.css']
})
export class ItemPersonaComponent implements OnInit {

  @Input()
  persona:Persona;

  @Input()
  editable:boolean;

  @Output()
  eliminado:EventEmitter<any>=new EventEmitter();

  constructor(private personaService:PersonasService) { }

  ngOnInit() {
  }

  eliminarPersona(){
    if(confirm(`Desea eliminar al usuario: ${this.persona.id} `)){
      this.personaService.eliminarPersona(this.persona.id).subscribe(()=>this.eliminado.emit(this.persona.id));
    }
  }
}
