import { GenericVO } from './GenericVO';
export class ParteProcessoVO extends GenericVO {
    public static POLO_ATIVO:{label,alias}              = {label:'Polo Ativo', alias:'POLO_ATIVO'};
    public static POLO_PASSIVO:{label,alias}            = {label:'Polo Passivo', alias:'POLO_PASSIVO'};
    public static TERCEIRO_INTERESSADO:{label,alias}    = {label:'Vivo terceiro interessado', alias:'TERCEIRO_INTERESSADO'};

    public codParteProcesso:string;
    public nomParteProcesso:string;
    public numCpfCnpj:string;

    public get value():string {
        return this.codParteProcesso;
    }

    public static convertList(arr:Array<any>):Array<ParteProcessoVO>{
        let items:Array<ParteProcessoVO> = new Array<ParteProcessoVO>();
        for(let item of arr){
            let temp:ParteProcessoVO = new ParteProcessoVO(item);
            items.push(temp);
        }
        return items;
    }
}