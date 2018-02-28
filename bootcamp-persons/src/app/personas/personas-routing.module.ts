import { Routes, RouterModule } from "@angular/router";
import { NgModule } from "@angular/core";

import { FormPersonaComponent } from "./components/form-persona/form-persona.component";
import { ListPersonasComponent } from "./components/list-personas/list-personas.component";


const routes: Routes=[
 //   {path:'nombre de ruta a llamar',component:NombreComponente}
    {path:'personas',component:ListPersonasComponent},
    {path:'agregarPersona',component:FormPersonaComponent},
    {path:'editarPersona/:id',component:FormPersonaComponent}

];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class PersonasRoutingModule{

}