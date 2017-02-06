export class GenericDialog {
    protected visible:boolean = false;

    protected show():void{
        this.visible = true;
    }

    protected hide():void{
        this.visible = false;
    }
}