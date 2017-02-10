import { Utils } from './../utils/Utils';
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
        return Utils.formatPhone(this.numLinha)||Utils.formatCpfCnpj(this.numCpfCnpj)||this.nomCliente;
    }

    public get id():string{
        return this.numCpfCnpj+'_'+this.numLinha+'_'+((this.dtcInicioPequisa!=null)?this.dtcInicioPequisa.substr(0,10):this.dtcInicioPequisa)+'_'+((this.dtcFimPesquisa!=null)?this.dtcFimPesquisa.substr(0,10):this.dtcFimPesquisa);
    }

    public get numLinhaFormat():string {
        return Utils.formatPhone(this.numLinha);
    }

    public get numCpfCnpjFormat():string {
        return Utils.formatCpfCnpj(this.numCpfCnpj);
    }

    public get dtcPocOcorrenciaFormat():string{
        return Utils.getDefaultFormatDate(this.dtcPocOcorrencia);
    }

    public get dtcInicioPequisaFormat():string{
        return Utils.getDefaultFormatOnlyDate(this.dtcInicioPequisa);
    }

    public get dtcFimPesquisaFormat():string{
        return Utils.getDefaultFormatOnlyDate(this.dtcFimPesquisa);
    }

    public get dtcCadastroFormat():string{
        return Utils.getDefaultFormatOnlyDate(this.dtcCadastro);
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