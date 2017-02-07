import { element } from 'protractor';
export class Utils {
    public static getDefaultFormatDate(pDate:any):string{
        try{
            let date:Date = (pDate instanceof Date)?pDate:new Date(pDate);
            return this.getDefaultFormatOnlyDate(pDate)+' '+this.concatZero(date.getHours())+':'+this.concatZero(date.getMinutes())+':'+this.concatZero(date.getSeconds());
        } catch(e){
            return '';
        }
    }

    public static getDefaultFormatOnlyDate(pDate:any):string{
        try{
            let date:Date = (pDate instanceof Date)?pDate:new Date(pDate);
            return this.concatZero(date.getDate())+'/'+this.concatZero((date.getMonth()+1))+'/'+date.getFullYear();
        } catch(e){
            return '';
        }
    }

    public static concatZero(pNumber:number):string {
        return ((pNumber<10)?'0':'')+pNumber;
    }
}