import { Injectable, ViewContainerRef, ApplicationRef } from '@angular/core';

@Injectable()
export class UicomponentsController {

    private viewContainerRef:ViewContainerRef;

    constructor(private appRef:ApplicationRef){ }

    public setViewContainerRef(pViewContainerRef:ViewContainerRef):void {
        this.viewContainerRef = pViewContainerRef;
    }

    public getRootViewContainerRef(): ViewContainerRef {
        if(this.viewContainerRef == null && this.appRef.components[0]!=null){
            const appInstance = this.appRef.components[0].instance;

            if (!appInstance.viewContainerRef) {
                const appName = this.appRef.componentTypes[0].name;
                throw new Error(`Missing 'viewContainerRef' declaration in ${appName} constructor`);
            }

            this.viewContainerRef = appInstance.viewContainerRef;
        }

        return this.viewContainerRef;
    }

    
}