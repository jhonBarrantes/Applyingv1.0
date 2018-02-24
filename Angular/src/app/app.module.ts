import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { HomeComponent } from './components/home/home.component';
import { PersonasRoutingModule } from './solicitudes/personas-routing.module';

import { SolicitudesService } from './solicitudes/services/solicitudes.service';
import { PersonasService } from './solicitudes/services/personas.service';
import { ListSolicitudesComponent } from './solicitudes/components/list-solicitudes/list-solicitudes.component';
import { FormSolicitudComponent } from './solicitudes/components/form-solicitud/form-solicitud.component';
import { ListaPersonasComponent } from './solicitudes/components/lista-personas/lista-personas.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListSolicitudesComponent,
    FormSolicitudComponent,
  ],
  imports: [
    BrowserModule,
   // PersonasModule,
    AppRoutingModule,
    PersonasRoutingModule,
  ],
  providers: [SolicitudesService,PersonasService],
  bootstrap: [AppComponent,ListaPersonasComponent]
})
export class AppModule { }
