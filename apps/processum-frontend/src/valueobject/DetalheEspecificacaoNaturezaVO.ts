import { GenericVO } from './GenericVO';
export class DetalheEspecificacaoNaturezaVO extends GenericVO {
    public nomDetalheEspecificNatureza:string;
    public codEspecificacaoNatureza:string;
    public codDetalheEspecificNatureza:string;
    public desEspecificacaoNatureza:string;
    public codNatureza:string;

    public get label ():string {
        return this.desEspecificacaoNatureza+' - '+this.nomDetalheEspecificNatureza;
    }

    public static convertList(arr:Array<any>):Array<DetalheEspecificacaoNaturezaVO>{
        let items:Array<DetalheEspecificacaoNaturezaVO> = new Array<DetalheEspecificacaoNaturezaVO>();
        for(let item of arr){
            let temp:DetalheEspecificacaoNaturezaVO = new DetalheEspecificacaoNaturezaVO(item);
            items.push(temp);
        }
        return items;
    }
}