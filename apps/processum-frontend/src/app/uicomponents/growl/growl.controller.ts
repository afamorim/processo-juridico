import { UicomponentsController } from './../uicomponents.controller';
import { DynamicComponentController } from './../dynamic-component-controller';
import { Growl, Message } from 'primeng/primeng';
import { Injectable, ComponentFactoryResolver, ViewContainerRef, ComponentFactory, ApplicationRef } from '@angular/core';

@Injectable()
export class GrowlController extends DynamicComponentController<Growl> {

    constructor(private pComponentFactory:ComponentFactoryResolver, private pUiComponentsController:UicomponentsController, private pAppRef:ApplicationRef){
        super(pComponentFactory, pUiComponentsController, pAppRef, Growl);

        this.clear();
    }

    public show(severity:string, detail:string, summary:string):void {
        this.instance.value.push({severity:severity, summary:summary, detail:detail});
    }

    public showSuccess(detail:string, summary?:string):void {
        summary = (summary!=null)?summary:'Informação';
        this.clear();
        this.instance.value.push({severity:'success', summary:summary, detail:detail});
    }

    public showInfo(detail:string, summary?:string):void {
        summary = (summary!=null)?summary:'Informação';
        this.clear();
        this.instance.value.push({severity:'info', summary:summary, detail:detail});
    }

    public showWarn(detail:string, summary?:string):void {
        summary = (summary!=null)?summary:'Aviso';
        this.clear();
        this.instance.value.push({severity:'warn', summary:summary, detail:detail});
    }

    public showError(detail:string, summary?:string):void {
        summary = (summary!=null)?summary:'Erro';
        this.clear();
        this.instance.value.push({severity:'error', summary:summary, detail:detail});
    }

    public clear():void {
        this.instance.value = [];
    }

}