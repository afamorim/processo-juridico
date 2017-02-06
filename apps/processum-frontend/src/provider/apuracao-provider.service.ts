import { ApuracaoVO } from './../valueobject/ApuracaoVO';
import { Http, URLSearchParams, Headers, RequestOptions } from '@angular/http';
import { BaseProvider } from './base-provider';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class ApuracaoProviderService extends BaseProvider {

  constructor(private http:Http) {
    super();
  }

  public saveApuracao(apuracao:ApuracaoVO):Promise<Array<ApuracaoVO>>{

    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });

    apuracao.idPocOcorrencia = null;
    apuracao.historico = null;

    return this.http.post(BaseProvider.getBaseAPI()+'pococorrencia',JSON.stringify(apuracao), options).toPromise()
            .then(response => response.json()) 
            .catch((e)=>{ console.error(e); });
  }

  public findAllApuracoes():Promise<Array<ApuracaoVO>>{
    let params:URLSearchParams = new URLSearchParams();

    return this.http.get(BaseProvider.getBaseAPI()+'pococorrencia?size=999',{search:params}).toPromise()
            .then(response => this.parseApuracoes(response.json()._embedded.pocOcorrencia)) 
            .catch((e)=>{ console.error(e); });
  }

  private parseApuracoes(pApuracoes:Array<any>):Array<ApuracaoVO>{
    let apuracoes:Array<ApuracaoVO> = ApuracaoVO.convertList(pApuracoes);

    for(let apuracao of apuracoes){
      apuracao.historico = new Array<ApuracaoVO>();

      for(let apuracaoHistorico of apuracoes){
        if(apuracao.id == apuracaoHistorico.id && apuracao.idPocOcorrencia != apuracaoHistorico.idPocOcorrencia){
          apuracao.historico.push(apuracaoHistorico);
        }
      }

    }

    return apuracoes;
  }

}
