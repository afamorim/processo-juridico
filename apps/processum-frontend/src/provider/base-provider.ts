export class BaseProvider {
    public static HOST:string = 'http://10.129.228.166:7001/'
    public static PDF_APURACAO:string = 'processum/downloadPdfApuracao/';
    public static BASE_API:string = 'processum/api/';

    protected filterCollectionByProp<T>(propName:string,propValue:string,source:Array<T>,allIfEmpty?:boolean):Array<T>{
        let filtered:Array<T> = source.filter((o:T)=>{
            return o[propName].toUpperCase().indexOf(propValue.toUpperCase()) >= 0;
        });

        if(allIfEmpty && filtered.length == 0){
            filtered = source;
        }

        return filtered;
    }

    protected stringToDate(date:any):Date {
        if(date != null && typeof date === 'string'){
            return new Date(date);
        }
        return date;
    }

    public static getPDFApuracaoURL():string {
        return this.HOST+this.PDF_APURACAO;
    }

    public static getBaseAPI():string {
        return this.HOST+this.BASE_API;
    }
    
}