import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { SolicitudesModule } from './solicitudes/solicitudes.module';
import { AppRoutingModule } from './/app-routing.module';
import { HomeComponent } from './components/home/home.component';
import { PersonasModule } from './personas/personas.module';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
  //  ModuleComponent
  ],
  imports: [
    BrowserModule,
    SolicitudesModule,
    PersonasModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
