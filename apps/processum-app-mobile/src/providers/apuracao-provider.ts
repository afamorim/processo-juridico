import { ApuracaoVO } from './../valueobject/ApuracaoVO';
import { Http, URLSearchParams, Headers, RequestOptions } from '@angular/http';
import { BaseProvider } from './base-provider';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';

/*
  Generated class for the ApuracaoProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular 2 DI.
*/
@Injectable()
export class ApuracaoProvider {

  constructor(public http: Http) {
    console.log('Hello ApuracaoProvider Provider');
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
    let apuracoes:Array<ApuracaoVO> = ApuracaoVO.convertList(pApuracoes); //converto a lista para o ApuracaoVO
    apuracoes.sort((a:ApuracaoVO,b:ApuracaoVO):number=>{ //ordeno a lista do registro mais novo pro mais velho
      return parseInt(b.idPocOcorrencia)-parseInt(a.idPocOcorrencia);
    });

    let newApuracoes:Array<ApuracaoVO> = new Array<ApuracaoVO>(); //crio a lista que vai receber os itens corretos e agrupados

    let i:number = apuracoes.length;
    while(i--){ //percorro a lista de trás para frente (dos mais novos p/ os mais antigos)
      let apuracao:ApuracaoVO = apuracoes[i]; //pego a apuracao

      if(apuracao!=null){ //verifico se a apuracao ja foi removida pelas ações abaixo
        apuracao.historico = new Array<ApuracaoVO>(); //crio a lista que vai receber os possiveis agrupamentos
        newApuracoes.push(apuracao); //coloco a apuracao na nova lista
        apuracoes.splice(i,1); //removo essa apuracao da lista que esta sendo percorrida (assim ela nao será mais checada na logica do agrupamento)

        let n:number = apuracoes.length;
        while(n--){ //percorro novamente as apuracoes que ainda restam na lista inicial
          let apuracaoHistorico:ApuracaoVO = apuracoes[n]; //pego a apuracao que será verificada com a a puracao "pai"
          if(apuracaoHistorico.id == apuracao.id){ //verifico se a apuracao tem os mesmos dados e devem ficar no historico (id é um getter que retorna uma chave composta)
            apuracao.historico.push(apuracaoHistorico); //coloco a apuracao "repetida" no historico da apuracao mais nova
            apuracoes.splice(n,1); //removo essa apuracao da lista inicial, assim ela nao será mais checada
          }
        }
      }
            
    }

    return newApuracoes;
  }

}
