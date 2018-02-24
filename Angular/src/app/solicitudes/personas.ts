import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { SolicitudesService } from './services/solicitudes.service';
import { ListItemSolicitudComponent } from './components/list-item-solicitud/list-item-solicitud.component';
import { ListSolicitudesComponent } from './components/list-solicitudes/list-solicitudes.component';
import { FormSolicitudComponent } from './components/form-solicitud/form-solicitud.component';

import { PersonasRoutingModule } from './personas-routing.module';
import { PersonasService} from './services/personas.service';
import { FormPersona } from './components/form-persona/form-persona.component';
import { ItemPersonaComponent } from './components/item-persona/item-persona.component';
import { ListaPersonasComponent } from './components/lista-personas/lista-personas.component';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    PersonasRoutingModule,
    FormPersona,
    FormsModule,
  ],
  declarations: [ListItemSolicitudComponent, ListSolicitudesComponent, FormSolicitudComponent,/* ListaLibrosComponent*/, FormPersona, ItemPersonaComponent, ListaPersonasComponent],
  providers: [SolicitudesService,PersonasService],
  exports: [ListItemSolicitudComponent, ListSolicitudesComponent, FormSolicitudComponent]
})
export class PersonasModule { }
