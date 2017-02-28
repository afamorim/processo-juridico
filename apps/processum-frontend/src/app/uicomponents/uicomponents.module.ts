import { UicomponentsController } from './uicomponents.controller';
import { LoadingIndicatorComponent } from './loading-indicator/loading-indicator.component';
import { LoadingIndicatorController } from './loading-indicator/loading-indicator.controller';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [
    CommonModule
  ],
  providers: [UicomponentsController, LoadingIndicatorController],
  entryComponents:[LoadingIndicatorComponent],
  declarations: [LoadingIndicatorComponent]
})
export class UicomponentsModule { }
