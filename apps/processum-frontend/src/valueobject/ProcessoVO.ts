import { GenericVO } from './GenericVO';
export class ProcessoVO extends GenericVO{
    /*public codigo:number;
    public numero:string;
    public classe:string;
    public assunto:string;
    public outros_assuntos:string;
    public distribuicao:string;
    public controle:string;
    public juiz:string;
    public valor_acao:string;

    public status:string;
    public dataSolicitacaoPesquisa:string;*/

    //num processo, polo ativo, polo passivo - importados via scraping
    public idPocProcesso:string;
    public codEmpresa:string;
    public nomEmpresa:string;
    public codNatureza:string;
    public desNatureza:string;
    public codEspecificacaoNatureza:string;
    public desEspecificacaoNatureza:string;
    public codDetalheEspecificNatureza:string;
    public nomDetalheEspecificNatureza:string;
    public codPreObjetoEmpresa:string;
    public nomPreObjetoEmpresa:string;
    public dtcCitacao:string;
    public dtcProtocoloAforamento:string;
    public stsPassouCallCenter:string;
    public stsRelevante:string;
    public stsConsumerista:string;
    public stsPassouProcon:string;
    public nomTipoAcaoProcesso:string;
    public codDivisaoProcesso:string;
    public nomDivisao:string;
    public numProcesso:string;
    public dtcEnvioEscContratado:string;
    public codTipoAcaoProcesso:string;
    public codTipoAcao:string;
    public desTipoAcao:string;
    public sigEscritorioContratado:string;
    public nomEscritorioContratado:string;
    public sigEstado:string;
    public nomEstado:string;
    public sigMunicipio:string;
    public nomMunicipio:string;
    public codComarca:string;
    public nomComarca:string;
    public codJuizo:string;
    public nomJuizo:string;
    public sigAdvogado:string;
    public nomAdvogado:string;
    public sigCorresponsavel:string;
    public nomCorresponsavel:string;
    public nomPoloAtivo:string;
    public nomPoloPassivo:string;
    public nomTerceiroInteressado:string;

    public strDataInclusao:string;
    
    public stsValidadoUsuario:string;
}