import { GenericVO } from './GenericVO';
export class ApuracaoVO extends GenericVO {
    public idPocOcorrencia:string;
    public stsPocOcorrencia:string;
    public dtcPocOcorrencia:string;
    public numProcesso:string;
    public numCpfCnpj:string;
    public numLinha:string;
    public dtcInicioPequisa:string;
    public dtcFimPesquisa:string;
    public nomCliente:string;
    public nomConta:string;
    public dtcCadastro:string;
    public nomTipoConta:string;
    public nomTipoAssinatura:string;
    public stsAssinatura:string;
    public desEnderecoCorrespondencia:string;
    public desEnderecoTributacao:string;
    public valSaldo:string;
    public nomFormaPagamento:string;

    public historico:Array<ApuracaoVO>;

    public get labelExibicao():string {
        return this.nomCliente||this.numLinha||this.numCpfCnpj;
    }

    public get id():string{
        return this.numCpfCnpj+'_'+this.numLinha+'_'+this.dtcInicioPequisa+'_'+this.dtcFimPesquisa;
    }

    public static convertList(arr:Array<any>):Array<ApuracaoVO>{
        let items:Array<ApuracaoVO> = new Array<ApuracaoVO>();
        for(let item of arr){
            let temp:ApuracaoVO = new ApuracaoVO(item);
            items.push(temp);
        }
        return items;
    }
}