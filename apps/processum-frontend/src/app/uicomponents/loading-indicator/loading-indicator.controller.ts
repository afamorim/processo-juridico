import { UicomponentsController } from './../uicomponents.controller';
import { DynamicComponentController } from './../dynamic-component-controller';
import { LoadingIndicatorComponent } from './loading-indicator.component';
import { Injectable, ComponentFactoryResolver, ViewContainerRef, ComponentFactory, ApplicationRef } from '@angular/core';

@Injectable()
export class LoadingIndicatorController extends DynamicComponentController<LoadingIndicatorComponent> {

    constructor(private pComponentFactory:ComponentFactoryResolver, private pUiComponentsController:UicomponentsController, private pAppRef:ApplicationRef){
        super(pComponentFactory, pUiComponentsController, pAppRef, LoadingIndicatorComponent);
    }

    public show():void{
        this.instance.show();
    }

    public hide():void{
        this.instance.hide();
    }

}