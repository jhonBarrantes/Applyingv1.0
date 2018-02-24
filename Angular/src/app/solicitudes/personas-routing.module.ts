import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListSolicitudesComponent } from './components/list-solicitudes/list-solicitudes.component';
import { FormSolicitudComponent } from './components/form-solicitud/form-solicitud.component';

import { ListaPersonasComponent } from './components/lista-personas/lista-personas.component';
import { FormPersona } from './components/form-persona/form-persona.component';

const routes: Routes = [
  { path: 'solicitudes', component: ListSolicitudesComponent },
  { path: 'nuevaSolicitud', component: FormSolicitudComponent},
  { path: 'editarSolicitud/:id', component: FormSolicitudComponent},


  {path: 'personas',component:ListaPersonasComponent},
  {path: 'agregarPersona', component:FormPersona},
  {path: 'editarPersona/:id', component:FormPersona},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class PersonasRoutingModule {


}
