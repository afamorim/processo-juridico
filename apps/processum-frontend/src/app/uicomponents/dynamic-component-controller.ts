import { UicomponentsController } from './uicomponents.controller';
import { ComponentFactoryResolver, ViewContainerRef, ComponentFactory, ApplicationRef } from '@angular/core';

export class DynamicComponentController<T> {

    public instance:T;
    
    constructor(private componentFactory:ComponentFactoryResolver, private uiComponentsController:UicomponentsController, private appRef:ApplicationRef, private componentType:any){
        this.create();
    }

    public create(pViewContainerRef?:ViewContainerRef):void{
        if(pViewContainerRef != null){
            this.uiComponentsController.setViewContainerRef(pViewContainerRef);
        }
        if(this.instance == null){
            let componentFactory:ComponentFactory<any> = this.componentFactory.resolveComponentFactory(this.componentType);
            let vcRef:ViewContainerRef = this.uiComponentsController.getRootViewContainerRef();
            try {
                this.instance = vcRef.createComponent(componentFactory).instance;
            } catch(e){
                console.warn(`Can't create component ${componentFactory.componentType.name}. You probably are trying to inject this component controller on your root component, but the application is not ready. You should pass the viewContainerRef manually on create() method in this case.`);
            }
        }
    }

}