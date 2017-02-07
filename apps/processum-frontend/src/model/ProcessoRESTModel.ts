import { ProcessoVO } from './../valueobject/ProcessoVO';
export class ProcessoRESTModel {
    public processos:Array<ProcessoVO>;
    public page:{size:number,totalElements:number,totalPages:5,number:0};
}