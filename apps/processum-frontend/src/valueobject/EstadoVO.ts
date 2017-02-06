import { GenericVO } from './GenericVO';
export class EstadoVO extends GenericVO {
    public nomEstado:string;
    public sigEstado:string;

    public get label ():string {
        return this.nomEstado;
    }

    public get value ():string{
        return this.sigEstado;
    }

    public static convertList(arr:Array<any>):Array<EstadoVO>{
        let items:Array<EstadoVO> = new Array<EstadoVO>();
        for(let item of arr){
            let temp:EstadoVO = new EstadoVO(item);
            items.push(temp);
        }
        return items;
    }
}