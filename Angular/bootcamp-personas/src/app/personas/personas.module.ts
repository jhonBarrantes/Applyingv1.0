import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormPersonaComponent } from './components/form-persona/form-persona.component';
import { ListPersonasComponent } from './components/list-personas/list-personas.component';
import { ItemPersonaComponent } from './components/item-persona/item-persona.component';
import { PersonasService } from './services/persona-service';
import { RouterModule } from '@angular/router';
import { PersonasRoutingModule } from './personas-routing.module';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppModule } from '../app.module';
//import { Solicitud } from '../solicitudes/model/solicitud';
//import { FormSolicitudComponent } from '../solicitudes/components/form-solicitud/form-solicitud.component';


@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    PersonasRoutingModule,
    FormsModule,
    NgbModule,
    
  ],
  declarations: [FormPersonaComponent, ListPersonasComponent, ItemPersonaComponent,/*SolicitudesModule*/],
//  bootstrap: [AppModule],
  providers: [PersonasService],
  exports: [FormPersonaComponent, ListPersonasComponent, ItemPersonaComponent],
})
export class PersonasModule { }
