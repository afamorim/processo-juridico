import { LoadingIndicatorController } from './uicomponents/loading-indicator/loading-indicator.controller';
import { Component, ViewContainerRef } from '@angular/core';

@Component({
  selector: 'app-root',
  template: '<router-outlet></router-outlet>',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  //we need viewContainerRef instance to create components dinamically
  constructor(public viewContainerRef:ViewContainerRef){}
}
