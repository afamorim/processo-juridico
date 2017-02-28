import { GrowlController } from './growl/growl.controller';
import { UicomponentsController } from './uicomponents.controller';
import { LoadingIndicatorComponent } from './loading-indicator/loading-indicator.component';
import { LoadingIndicatorController } from './loading-indicator/loading-indicator.controller';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import * as Prime from 'primeng/primeng';

@NgModule({
  imports: [
    CommonModule,
    Prime.GrowlModule
  ],
  providers: [UicomponentsController, LoadingIndicatorController, GrowlController],
  entryComponents:[LoadingIndicatorComponent, Prime.Growl],
  declarations: [LoadingIndicatorComponent]
})
export class UicomponentsModule { }
