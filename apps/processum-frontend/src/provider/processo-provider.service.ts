import { ProcessoRESTModel } from './../model/ProcessoRESTModel';
import { ProcessoVO } from './../valueobject/ProcessoVO';
import { AdvogadoVO } from './../valueobject/AdvogadoVO';
import { JuizoVO } from './../valueobject/JuizoVO';
import { ParteProcessoVO } from './../valueobject/ParteProcessoVO';
import { TipoAcaoVO } from './../valueobject/TipoAcaoVO';
import { ComarcaVO } from './../valueobject/ComarcaVO';
import { MunicipioVO } from './../valueobject/MunicipioVO';
import { EscritorioContratadoVO } from './../valueobject/EscritorioContratadoVO';
import { TipoAcaoProcesso } from './../valueobject/TipoAcaoProcesso';
import { PreObjetoEmpresaVO } from './../valueobject/PreObjetoEmpresaVO';
import { DetalheEspecificacaoNaturezaVO } from './../valueobject/DetalheEspecificacaoNaturezaVO';
import { DivisaoVO } from './../valueobject/DivisaoVO';
import { EmpresaVO } from './../valueobject/EmpresaVO';
import { GenericVO } from './../valueobject/GenericVO';
import { EstadoVO } from './../valueobject/EstadoVO';
import { Http, URLSearchParams, Headers, RequestOptions } from '@angular/http';
import { BaseProvider } from './base-provider';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class ProcessoProviderService extends BaseProvider {

  private allEstados:Array<EstadoVO> = new Array<EstadoVO>();
  private allDivisoes:Array<DivisaoVO> = new Array<DivisaoVO>();
  private allPreObjetoEmpresa:Array<PreObjetoEmpresaVO> = new Array<PreObjetoEmpresaVO>();
  private allTiposAcaoProcesso:Array<TipoAcaoProcesso> = new Array<TipoAcaoProcesso>();

  constructor(private http:Http) {
    super();
  }

  public solicitarProcesso(numeroProcesso:string):Promise<ProcessoVO>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('numeroProcesso', numeroProcesso);

    return this.http.get(BaseProvider.getBaseAPI()+'scraping/salvarNumeroProcesso',{search:params}).toPromise()
            .then(response => response.json()) 
            .catch((e)=>{ console.error(e); });
  }

  public findProcessosSolicitados():Promise<Array<ProcessoVO>>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('codigoStatus', '1');

    return this.http.get(BaseProvider.getBaseAPI()+'scraping/buscaProcessos',{search:params}).toPromise()
            .then(response => response.json()) 
            .catch((e)=>{ console.error(e); });
  }

  public saveProcesso(processo:ProcessoVO):Promise<ProcessoVO>{

    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });

    delete processo['_links'];

    if(processo.nomTerceiroInteressado == null || processo.nomTerceiroInteressado == ''){
      delete processo.nomTerceiroInteressado;
    }

    if(processo.nomPoloAtivo == null || processo.nomPoloAtivo == ''){
      delete processo.nomPoloAtivo;
    }

    if(processo.nomPoloPassivo == null || processo.nomPoloPassivo == ''){
      delete processo.nomPoloPassivo;
    }
    
    console.log(JSON.stringify(processo));

    return this.http.post(BaseProvider.getBaseAPI()+'pocprocesso',JSON.stringify(processo), options).toPromise()
            .then(response => response.json()) 
            .catch((e)=>{ console.error(e); });
  }

  public findProcessoById(idPocProcesso:string):Promise<ProcessoVO>{

    return this.http.get(BaseProvider.getBaseAPI()+'pocprocesso/'+idPocProcesso).toPromise()
            .then(response => new ProcessoVO(response.json())) 
            .catch((e)=>{ console.error(e); });

  }

  public findProcessosByPage(page:number):Promise<ProcessoRESTModel>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('page', page.toString());

    return new Promise((resolve,reject)=>{

      this.http.get(BaseProvider.getBaseAPI()+'pocprocesso', {search:params}).toPromise()
        .then((response) => {
          let model:ProcessoRESTModel = new ProcessoRESTModel();
          model.processos = response.json()._embedded.pocProcesso;
          model.page = response.json().page;
          
          resolve(model);
        }) 
        .catch((e)=>{ reject(e); });

    });
    
  }

  public findAllTiposAcaoProcesso():Promise<Array<TipoAcaoProcesso>>{
    return this.http.get(BaseProvider.getBaseAPI()+'tipoacaoprocesso/search/findByOrderByNomTipoAcaoProcesso').toPromise()
            .then(response => response.json()._embedded.tipoAcaoProcesso) 
            .catch((e)=>{ console.error(e); });
  }

  public findAllTiposAcaoProcessoByNome(nome:string):Promise<Array<TipoAcaoProcesso>>{
    return new Promise((resolve,reject)=>{
      if(this.allTiposAcaoProcesso.length > 0){
        resolve(this.filterCollectionByProp<TipoAcaoProcesso>('nomTipoAcaoProcesso',nome,this.allTiposAcaoProcesso,true));
      } else {
        this.findAllTiposAcaoProcesso().then((data:Array<TipoAcaoProcesso>)=>{
          this.allTiposAcaoProcesso = data;
          resolve(this.filterCollectionByProp<TipoAcaoProcesso>('nomTipoAcaoProcesso',nome,this.allTiposAcaoProcesso,true));
        }).catch((e)=>{
          reject(e);
        });
      }
    });
  }

  public findAllPreObjetoEmpresa():Promise<Array<PreObjetoEmpresaVO>>{
    return this.http.get(BaseProvider.getBaseAPI()+'preobjetoempresa/search/findByOrderByNomPreObjetoEmpresa').toPromise()
            .then(response => response.json()._embedded.preObjetoEmpresa) 
            .catch((e)=>{ console.error(e); });
  }

  public findAllPreObjetoEmpresaByNome(nome:string):Promise<Array<PreObjetoEmpresaVO>>{
    return new Promise((resolve,reject)=>{
      if(this.allPreObjetoEmpresa.length > 0){
        resolve(this.filterCollectionByProp<PreObjetoEmpresaVO>('nomPreObjetoEmpresa',nome,this.allPreObjetoEmpresa,true));
      } else {
        this.findAllPreObjetoEmpresa().then((data:Array<PreObjetoEmpresaVO>)=>{
          this.allPreObjetoEmpresa = data;
          resolve(this.filterCollectionByProp<PreObjetoEmpresaVO>('nomPreObjetoEmpresa',nome,this.allPreObjetoEmpresa,true));
        }).catch((e)=>{
          reject(e);
        });
      }
    });
  }

  public findAllDivisoes():Promise<Array<DivisaoVO>>{
    return this.http.get(BaseProvider.getBaseAPI()+'divisaoprocesso/search/findByNomDivisaoContainingIgnoreCaseOrderByNomDivisao?nomDivisao').toPromise()
            .then(response => response.json()._embedded.divisaoProcesso) 
            .catch((e)=>{ console.error(e); });
  }

  public findDivisoesByNome(nome:string):Promise<Array<DivisaoVO>>{
    return new Promise((resolve,reject)=>{
      if(this.allDivisoes.length > 0){
        resolve(this.filterCollectionByProp<DivisaoVO>('nomDivisao',nome,this.allDivisoes,true));
      } else {
        this.findAllDivisoes().then((data:Array<DivisaoVO>)=>{
          this.allDivisoes = data;
          resolve(this.filterCollectionByProp<DivisaoVO>('nomDivisao',nome,this.allDivisoes,true));
        }).catch((e)=>{
          reject(e);
        });
      }
    });
  }

  public findAllEstados():Promise<Array<EstadoVO>>{
    return this.http.get(BaseProvider.getBaseAPI()+'estado/search/findByOrderBySigEstado').toPromise()
            .then(response => response.json()._embedded.estado) 
            .catch((e)=>{ console.error(e); });
  }

  public findEstadosByNome(nome:string):Promise<Array<EstadoVO>>{
    return new Promise((resolve,reject)=>{
      if(this.allEstados.length > 0){
        resolve(this.filterCollectionByProp<EstadoVO>('nomEstado',nome,this.allEstados,true));
      } else {
        this.findAllEstados().then((data:Array<EstadoVO>)=>{
          this.allEstados = data;
          resolve(this.filterCollectionByProp<EstadoVO>('nomEstado',nome,this.allEstados,true));
        }).catch((e)=>{
          reject(e);
        });
      }
    });
  }

  public findEmpresasByNome(nome:string):Promise<Array<EmpresaVO>>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('nomEmpresa', nome.toUpperCase());

    return this.http.get(BaseProvider.getBaseAPI()+'empresa/search/findByNomEmpresaContainingIgnoreCaseOrderByNomEmpresa',{search:params}).toPromise()
            .then(response => response.json()._embedded.empresa) 
            .catch((e)=>{ console.error(e); });
  }

  public findDetalheEspecificacaoNaturezaByNome(nome:string):Promise<Array<DetalheEspecificacaoNaturezaVO>>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('codNatureza', '101');
    params.set('nomDetalheEspecificNatureza', nome.toUpperCase());

    return this.http.get(BaseProvider.getBaseAPI()+'detalheespecificnatureza/search/findByFilterOrderByDesEspecificacaoNatureza',{search:params}).toPromise()
            .then(response => DetalheEspecificacaoNaturezaVO.convertList(response.json()._embedded.detalheEspecificNatureza)) 
            .catch((e)=>{ console.error(e); });
  }

  public findEscritoriosContratadosByNome(nome:string):Promise<Array<EscritorioContratadoVO>>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('nomEscritorioContratado', nome.toUpperCase());

    return this.http.get(BaseProvider.getBaseAPI()+'escritoriocontratado/search/findByNomEscritorioContratadoContainingIgnoreCaseOrderByNomEscritorioContratado',{search:params}).toPromise()
            .then(response => response.json()._embedded.escritorioContratado) 
            .catch((e)=>{ console.error(e); });
  }

  public findMunicipiosByFilter({sigEstado,nomMunicipio}):Promise<Array<MunicipioVO>>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('sigEstado', sigEstado.toUpperCase());
    params.set('nomMunicipio', nomMunicipio.toUpperCase());

    return this.http.get(BaseProvider.getBaseAPI()+'municipio/search/findBySigEstadoAndNomMunicipioOrderByNomMunicipio',{search:params}).toPromise()
            .then(response => response.json()._embedded.municipio) 
            .catch((e)=>{ console.error(e); });
  }

  public findComarcasByFilter({sigEstado,sigMunicipio,nomComarca}):Promise<Array<ComarcaVO>>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('sigEstado', sigEstado.toUpperCase());
    params.set('sigMunicipio', sigMunicipio.toUpperCase());
    params.set('nomComarca', nomComarca.toUpperCase());

    return this.http.get(BaseProvider.getBaseAPI()+'comarca/search/findBySigEstadoAndSigMunicipioAndNomComarcaOrderByNomComarca',{search:params}).toPromise()
            .then(response => response.json()._embedded.comarca) 
            .catch((e)=>{ console.error(e); });
  }

  public findTiposAcaoByFilter({codPreObjetoEmpresa,codNatureza,codEspecificacaoNatureza,codDetalheEspecificNatureza,desTipoAcao}):Promise<Array<TipoAcaoVO>>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('codPreObjetoEmpresa', codPreObjetoEmpresa.toUpperCase());
    params.set('codNatureza', codNatureza.toUpperCase());
    params.set('codEspecificacaoNatureza', codEspecificacaoNatureza.toUpperCase());
    params.set('codDetalheEspecificNatureza', codDetalheEspecificNatureza.toUpperCase());
    params.set('desTipoAcao', desTipoAcao.toUpperCase());

    return this.http.get(BaseProvider.getBaseAPI()+'tipoacao/search/findByFilterOrderByDesTipoAcao',{search:params}).toPromise()
            .then(response => response.json()._embedded.tipoAcao) 
            .catch((e)=>{ console.error(e); });
  }

  public findPartesProcessoByNome(nome:string):Promise<Array<ParteProcessoVO>>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('nomParteProcesso', nome.toUpperCase());

    return this.http.get(BaseProvider.getBaseAPI()+'parteprocesso/search/findByNomParteProcessoContainingIgnoreCaseOrderByNomParteProcesso',{search:params}).toPromise()
            .then(response => response.json()._embedded.parteProcesso) 
            .catch((e)=>{ console.error(e); });
  }

  public findJuizosByFilter({codComarca,nomJuizo}):Promise<Array<JuizoVO>>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('codComarca', codComarca);
    params.set('nomJuizo', nomJuizo.toUpperCase());

    return this.http.get(BaseProvider.getBaseAPI()+'juizo/search/findByCodComarcaAndNomJuizoOrderByNomJuizo',{search:params}).toPromise()
            .then(response => response.json()._embedded.juizo) 
            .catch((e)=>{ console.error(e); });
  }

  public findAdvogadosByNome(nome:string):Promise<Array<AdvogadoVO>>{
    let params:URLSearchParams = new URLSearchParams();
    params.set('nomAdvogado', nome.toUpperCase());

    return this.http.get(BaseProvider.getBaseAPI()+'advogado/search/findByNomAdvogadoOrderByNomAdvogado',{search:params}).toPromise()
            .then(response => response.json()._embedded.advogado) 
            .catch((e)=>{ console.error(e); });
  }

}
