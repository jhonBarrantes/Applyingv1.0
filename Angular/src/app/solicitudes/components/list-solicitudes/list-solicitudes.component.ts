import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { Location } from '@angular/common';


import { Solicitud } from '../../model/solicitud';
import { SolicitudesService } from '../../services/solicitudes.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'ap-list-solicitudes',
  templateUrl: './list-solicitudes.component.html',
  styleUrls: ['./list-solicitudes.component.css']
})
export class ListSolicitudesComponent implements OnInit, OnDestroy {

  
  solicitudes: Solicitud[];

  subscription: Subscription;

  @Input()
  solicitud: Solicitud;

  @Input()
  editable: boolean;

  constructor(private solicitudService: SolicitudesService, private location: Location) { }

  ngOnInit() {
    this.editable = true;
    this.actualiarSolicitudes();
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  actualiarSolicitudes() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
    this.subscription = this.solicitudService.getAll().subscribe(solicitudes => this.solicitudes = solicitudes);
  }

  alertaSolicitud(){
    alert('Solicitud.id');
  }


}
