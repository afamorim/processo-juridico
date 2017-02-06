import { GenericVO } from './GenericVO';
export class EmpresaVO extends GenericVO {
    public codEmpresa:string;
    public nomEmpresa:string;

    public get label ():string {
        return this.nomEmpresa;
    }

    public get value ():string{
        return this.codEmpresa;
    }

    public static convertList(arr:Array<any>):Array<EmpresaVO>{
        let items:Array<EmpresaVO> = new Array<EmpresaVO>();
        for(let item of arr){
            let temp:EmpresaVO = new EmpresaVO(item);
            items.push(temp);
        }
        return items;
    }
}