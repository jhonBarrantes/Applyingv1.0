import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormPersonaComponent } from './components/form-persona/form-persona.component';
import { ListPersonasComponent } from './components/list-personas/list-personas.component';
import { ItemPersonaComponent } from './components/item-persona/item-persona.component';
import { PersonasService } from './services/persona-service';
import { RouterModule } from '@angular/router';
import { PersonasRoutingModule } from './personas-routing.module';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    PersonasRoutingModule,
    FormsModule
  ],
  declarations: [FormPersonaComponent, ListPersonasComponent, ItemPersonaComponent],
  providers: [PersonasService],
  exports: [FormPersonaComponent, ListPersonasComponent, ItemPersonaComponent],
})
export class PersonasModule { }
