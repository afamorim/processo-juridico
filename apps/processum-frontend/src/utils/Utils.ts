import { element } from 'protractor';
export class Utils {
    public static getDefaultFormatDate(pDate:any):string{
        let fmt:string = '';
        try{
            if(pDate != '' && pDate != null){
                let date:Date = (pDate instanceof Date)?pDate:new Date(pDate);
                fmt = this.getDefaultFormatOnlyDate(pDate)+' '+this.concatZero(date.getHours())+':'+this.concatZero(date.getMinutes())+':'+this.concatZero(date.getSeconds());
            }
        } catch(e){
            console.log(e);
        }
        return fmt;
    }

    public static getDefaultFormatOnlyDate(pDate:any):string{
        let fmt:string = '';
        try{
            if(pDate != '' && pDate != null){
                let date:Date = (pDate instanceof Date)?pDate:new Date(pDate);
                fmt = this.concatZero(date.getDate())+'/'+this.concatZero((date.getMonth()+1))+'/'+date.getFullYear();
            }
        } catch(e){
            console.log(e);
        }
        return fmt;
    }

    public static concatZero(pNumber:number):string {
        return ((pNumber<10)?'0':'')+pNumber;
    }

    public static formatPhone(phone:string):string {
        if(phone!=null && phone != ''){
            let regex:RegExp = /(\d{2})(\d{5})(\d{4})/;
            if(phone.length < 11){
                regex = /(\d{2})(\d{4})(\d{4})/;
            }
            return phone.replace(regex,'($1)$2-$3');
        } else {
            return '';
        }
    }

    public static formatCpfCnpj(cpfCnpj:string):string {
        if(cpfCnpj!=null && cpfCnpj != ''){
            if(cpfCnpj.length > 11){//cnpj
                return cpfCnpj.replace(/(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/,'$1.$2.$3/$4-$5');
            } else {
                return cpfCnpj.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/,'$1.$2.$3-$4');
            }
            
        } else {
            return '';
        }
    }
}