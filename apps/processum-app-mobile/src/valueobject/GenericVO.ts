export class GenericVO {

    constructor(source?:any) {
        if(source!=null){
            for (var propName in source) {
                this[propName] = source[propName];
            }
        }
    }

}