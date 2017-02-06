import { AdvogadoVO } from './../../../valueobject/AdvogadoVO';
import { JuizoVO } from './../../../valueobject/JuizoVO';
import { ParteProcessoVO } from './../../../valueobject/ParteProcessoVO';
import { TipoAcaoVO } from './../../../valueobject/TipoAcaoVO';
import { ComarcaVO } from './../../../valueobject/ComarcaVO';
import { MunicipioVO } from './../../../valueobject/MunicipioVO';
import { EscritorioContratadoVO } from './../../../valueobject/EscritorioContratadoVO';
import { TipoAcaoProcesso } from './../../../valueobject/TipoAcaoProcesso';
import { PreObjetoEmpresaVO } from './../../../valueobject/PreObjetoEmpresaVO';
import { DetalheEspecificacaoNaturezaVO } from './../../../valueobject/DetalheEspecificacaoNaturezaVO';
import { DivisaoVO } from './../../../valueobject/DivisaoVO';
import { EmpresaVO } from './../../../valueobject/EmpresaVO';
import { ProcessoProviderService } from './../../../provider/processo-provider.service';
import { EstadoVO } from './../../../valueobject/EstadoVO';
import { ProcessoVO } from './../../../valueobject/ProcessoVO';
import { Dialog } from 'primeng/primeng';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-processo-cadastro',
  templateUrl: './processo-cadastro.component.html',
  styleUrls: ['./processo-cadastro.component.css'],
  providers: [ProcessoProviderService]
})
export class ProcessoCadastroComponent implements OnInit {

  private comboGenerico:Array<any> = new Array<any>();
  private autoCompleteGenerico:Array<any> = new Array<any>();
  private listboxGenerico:Array<any> = new Array<any>();

  private processo:ProcessoVO = new ProcessoVO();

  private estados:Array<EstadoVO> = new Array<EstadoVO>();
  private municipios:Array<MunicipioVO> = new Array<MunicipioVO>();
  private empresas:Array<EmpresaVO> = new Array<EmpresaVO>();
  private divisoes:Array<DivisaoVO> = new Array<DivisaoVO>();
  private advogados:Array<AdvogadoVO> = new Array<AdvogadoVO>();
  private espDetNatureza:Array<DetalheEspecificacaoNaturezaVO> = new Array<DetalheEspecificacaoNaturezaVO>();
  private preObjetosEmpresa:Array<PreObjetoEmpresaVO> = new Array<PreObjetoEmpresaVO>();
  private tiposAcaoProcesso:Array<TipoAcaoProcesso> = new Array<TipoAcaoProcesso>();
  private escritoriosContratados:Array<EscritorioContratadoVO> = new Array<EscritorioContratadoVO>();
  private comarcas:Array<ComarcaVO> = new Array<ComarcaVO>();
  private juizos:Array<JuizoVO> = new Array<JuizoVO>();
  private tiposAcao:Array<TipoAcaoVO> = new Array<TipoAcaoVO>();

  private partesPoloAtivo:Array<ParteProcessoVO> = new Array<ParteProcessoVO>();
  private partesPoloPassivo:Array<ParteProcessoVO> = new Array<ParteProcessoVO>();
  private partesTerceiroInteressado:Array<ParteProcessoVO> = new Array<ParteProcessoVO>();

  private formGroup:FormGroup;

  constructor(private route: ActivatedRoute, private processoProvider:ProcessoProviderService) {
    this.route.params.subscribe(params => {
        if(params['numero'] != ''){
          this.processo.numero = params['numero'];
        }
    });

    this.formGroup = new FormGroup({
      estado: new FormControl(),
      numeroProcesso: new FormControl(this.processo.numero),
      municipio: new FormControl(),
      preObjetoEmpresa: new FormControl(),
      espDetNatureza: new FormControl(),
      partesPoloAtivo: new FormControl(),
      partesPoloPassivo: new FormControl(),
      partesTerceiroInteressado: new FormControl(),
      comarca: new FormControl()
    });
  }

  ngOnInit() {
    this.comboGenerico.push({label:'.: Selecione :.', value:'1'});

    for(let i=1; i<=10; i++){
        this.listboxGenerico.push({label:'Nome da parte 0'+i, value:i});
      }

  }

  genericSearch(event) {
      this.autoCompleteGenerico = new Array<any>();
      for(let i=1; i<=10; i++){
        this.autoCompleteGenerico.push({label:((event!=null)?event.query:'')+' '+i, value:i});
      }
  }

  genericHandleDropdown() {
    this.genericSearch(event);
  }

  private searchEstados(event):void{
    this.processoProvider.findEstadosByNome(event.query).then((data:Array<EstadoVO>)=>{
      this.estados = data;
      console.log(this.estados);
    }).catch((e)=>{
      console.error(e);
    });
  }

  private searchEmpresas(event):void{
    this.processoProvider.findEmpresasByNome(event.query).then((data:Array<EmpresaVO>)=>{
      this.empresas = data;
      console.log(this.estados);
    }).catch((e)=>{
      console.error(e);
    });
  }

  private searchDivisoes(event):void{
    this.processoProvider.findDivisoesByNome(event.query).then((data:Array<DivisaoVO>)=>{
      this.divisoes = data;
      console.log(this.divisoes);
    }).catch((e)=>{
      console.error(e);
    });
  }

  private searchAdvogados(event):void{
    this.processoProvider.findAdvogadosByNome(event.query).then((data:Array<AdvogadoVO>)=>{
      this.advogados = data;
    }).catch((e)=>{
      console.error(e);
    });
  }

  private searchEspDetNatureza(event):void{
    this.processoProvider.findDetalheEspecificacaoNaturezaByNome(event.query).then((data:Array<DetalheEspecificacaoNaturezaVO>)=>{
      this.espDetNatureza = data;
    }).catch((e)=>{
      console.error(e);
    });
  }

  private searchPreObjetoEmpresa(event):void{
    this.processoProvider.findAllPreObjetoEmpresaByNome(event.query).then((data:Array<PreObjetoEmpresaVO>)=>{
      this.preObjetosEmpresa = data;
    }).catch((e)=>{
      console.error(e);
    });
  }

  private searchTiposAcaoProcesso(event):void{
    this.processoProvider.findAllTiposAcaoProcessoByNome(event.query).then((data:Array<TipoAcaoProcesso>)=>{
      this.tiposAcaoProcesso = data;
    }).catch((e)=>{
      console.error(e);
    });
  }

  private searchEscritoriosContratados(event):void{
    this.processoProvider.findEscritoriosContratadosByNome(event.query).then((data:Array<EscritorioContratadoVO>)=>{
      this.escritoriosContratados = data;
    }).catch((e)=>{
      console.error(e);
    });
  }

  private searchMunicipios(event):void{
    let tempEstado:EstadoVO = this.formGroup.value.estado as EstadoVO;
    if(tempEstado!=null && tempEstado.sigEstado != null && tempEstado.sigEstado != ''){
      this.processoProvider.findMunicipiosByFilter({sigEstado:tempEstado.sigEstado, nomMunicipio:event.query}).then((data:Array<MunicipioVO>)=>{
        this.municipios = data;
      }).catch((e)=>{
        console.error(e);
      });
    }
  }

  private searchComarcas(event):void{
    let tempEstado:EstadoVO = this.formGroup.value.estado as EstadoVO;
    let tempMunicipio:MunicipioVO = this.formGroup.value.municipio as MunicipioVO;
    if(tempEstado!=null && tempEstado.sigEstado != null && tempEstado.sigEstado != '' &&
        tempMunicipio!=null && tempMunicipio.sigMunicipio != null && tempMunicipio.sigMunicipio != ''){
      this.processoProvider.findComarcasByFilter({sigEstado:tempEstado.sigEstado, sigMunicipio:tempMunicipio.sigMunicipio, nomComarca:event.query}).then((data:Array<ComarcaVO>)=>{
        this.comarcas = data;
      }).catch((e)=>{
        console.error(e);
      });
    }
  }

  private searchJuizos(event):void{
    let tempComarca:ComarcaVO = this.formGroup.value.comarca as ComarcaVO;
    if(tempComarca!=null && tempComarca.codComarca != null){
      this.processoProvider.findJuizosByFilter({codComarca:tempComarca.codComarca, nomJuizo:event.query}).then((data:Array<JuizoVO>)=>{
        this.juizos = data;
      }).catch((e)=>{
        console.error(e);
      });
    }
  }

  private searchTiposAcao(event):void{
    let preObjetoEmpresa:PreObjetoEmpresaVO = this.formGroup.value.preObjetoEmpresa as PreObjetoEmpresaVO;
    let espDetNatureza:DetalheEspecificacaoNaturezaVO = this.formGroup.value.espDetNatureza as DetalheEspecificacaoNaturezaVO;

    if(preObjetoEmpresa != null && espDetNatureza != null && preObjetoEmpresa.codPreObjetoEmpresa != null && espDetNatureza.codEspecificacaoNatureza != null && espDetNatureza.codDetalheEspecificNatureza != null){
      this.processoProvider.findTiposAcaoByFilter({
        codPreObjetoEmpresa: preObjetoEmpresa.codPreObjetoEmpresa,
        codNatureza: '101',
        codEspecificacaoNatureza: espDetNatureza.codEspecificacaoNatureza,
        codDetalheEspecificNatureza: espDetNatureza.codDetalheEspecificNatureza,
        desTipoAcao: event.query
      }).then((data:Array<TipoAcaoVO>)=>{
        this.tiposAcao = data;
      }).catch((e)=>{
        console.error(e);
      });
    }
  }

  private onAddPartes(data:{tipoParte:any,partes:Array<ParteProcessoVO>}):void{
    switch(data.tipoParte.alias){
      case ParteProcessoVO.POLO_ATIVO.alias:
        this.partesPoloAtivo = this.partesPoloAtivo.concat(data.partes);
      break;
      case ParteProcessoVO.POLO_PASSIVO.alias:
        this.partesPoloPassivo = this.partesPoloPassivo.concat(data.partes);
      break;
      case ParteProcessoVO.TERCEIRO_INTERESSADO.alias:
        this.partesTerceiroInteressado = this.partesTerceiroInteressado.concat(data.partes);
      break;
    }
  }

  private removeFromListbox(controlName:string):void {
    let source:Array<any> = this[controlName];
    let values:Array<any> = this.formGroup.value[controlName];
    if(values!=null){
      let newSource:Array<any> = [].concat(source);
      for(let item of source){
        for(let value of values){
          if(item.value == value){
            newSource.splice(newSource.indexOf(item),1);
          }
        }
      }
      this[controlName] = newSource;
      this.formGroup.controls[controlName].reset();
    }
  }
}
