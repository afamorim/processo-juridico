import { LoadingIndicatorController } from './../../uicomponents/loading-indicator/loading-indicator.controller';
import { element } from 'protractor';
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
import { Component, OnInit, ViewChild } from '@angular/core';
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

  constructor(private route: ActivatedRoute, private processoProvider:ProcessoProviderService, private loadingIndicator:LoadingIndicatorController) {

    this.formGroup = new FormGroup({
      empresa: new FormControl(),
      divisaoResponsavel: new FormControl(),
      objetoAcao: new FormControl(),
      escritorioContratado: new FormControl(),
      dataEnvioEscContratado: new FormControl(),
      dataCitacao: new FormControl(),
      dataProtocoloAforamento: new FormControl(),
      responsavel: new FormControl(),
      corresponsavel: new FormControl(),
      local: new FormControl(),
      passouCallCenter: new FormControl(),
      relevante: new FormControl(),
      consumerista: new FormControl(),
      passouProcon: new FormControl(),
      tipoAcao: new FormControl(),
      estado: new FormControl(),
      numProcesso: new FormControl(),
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

      this.route.params.subscribe(params => {
        if(params['numero'] != ''){
          this.processo.idPocProcesso = params['numero'];
          
          this.findById();
        }
    });

  }

  private saveProcesso():void{
    
    try {
      if(this.formGroup.value.empresa != null){
        this.processo.codEmpresa = this.formGroup.value.empresa.codEmpresa;
        this.processo.nomEmpresa = this.formGroup.value.empresa.nomEmpresa;
      }
      this.processo.codNatureza = '101';
      this.processo.desNatureza = 'Judicial';

      if(this.formGroup.value.espDetNatureza != null){
        this.processo.codEspecificacaoNatureza = this.formGroup.value.espDetNatureza.codEspecificacaoNatureza;
        this.processo.desEspecificacaoNatureza = this.formGroup.value.espDetNatureza.desEspecificacaoNatureza;
        this.processo.codDetalheEspecificNatureza = this.formGroup.value.espDetNatureza.codDetalheEspecificNatureza;
        this.processo.nomDetalheEspecificNatureza = this.formGroup.value.espDetNatureza.nomDetalheEspecificNatureza;
      }
      
      if(this.formGroup.value.preObjetoEmpresa != null){
        this.processo.codPreObjetoEmpresa = this.formGroup.value.preObjetoEmpresa.codPreObjetoEmpresa;
        this.processo.nomPreObjetoEmpresa = this.formGroup.value.preObjetoEmpresa.nomPreObjetoEmpresa;
      }

      this.processo.dtcCitacao = this.formGroup.value.dataCitacao;
      this.processo.dtcProtocoloAforamento = this.formGroup.value.dataProtocoloAforamento;

      this.processo.stsPassouCallCenter = (this.formGroup.value.passouCallCenter)?'1':'0';
      this.processo.stsRelevante = (this.formGroup.value.relevante)?'1':'0';
      this.processo.stsConsumerista = (this.formGroup.value.consumerista)?'1':'0';
      this.processo.stsPassouProcon = (this.formGroup.value.passouProcon)?'1':'0';

      if(this.formGroup.value.objetoAcao != null){
        this.processo.nomTipoAcaoProcesso = this.formGroup.value.objetoAcao.nomTipoAcaoProcesso;
      }

      if(this.formGroup.value.divisaoResponsavel != null){
        this.processo.codDivisaoProcesso = '6';//this.formGroup.value.divisaoResponsavel.sigDivisao;
        this.processo.nomDivisao = this.formGroup.value.divisaoResponsavel.nomDivisao;
      }

      this.processo.numProcesso = this.formGroup.value.numProcesso;

      this.processo.dtcEnvioEscContratado = this.formGroup.value.dataEnvioEscContratado;
      
      if(this.formGroup.value.objetoAcao != null){
        this.processo.codTipoAcaoProcesso = this.formGroup.value.objetoAcao.codTipoAcaoProcesso;
      }

      if(this.formGroup.value.tipoAcao != null){
        this.processo.codTipoAcao = this.formGroup.value.tipoAcao.codTipoAcao;
        this.processo.desTipoAcao = this.formGroup.value.tipoAcao.desTipoAcao;
      }

      if(this.formGroup.value.escritorioContratado != null){
        this.processo.sigEscritorioContratado = this.formGroup.value.escritorioContratado.sigEscritorioContratado;
        this.processo.nomEscritorioContratado = this.formGroup.value.escritorioContratado.nomEscritorioContratado;
      }

      if(this.formGroup.value.estado != null){
        this.processo.sigEstado = this.formGroup.value.estado.sigEstado;
        this.processo.nomEstado = this.formGroup.value.estado.nomEstado;
      }

      if(this.formGroup.value.municipio != null){
        this.processo.sigMunicipio = this.formGroup.value.municipio.sigMunicipio;
        this.processo.nomMunicipio = this.formGroup.value.municipio.nomMunicipio;
      }

      if(this.formGroup.value.comarca != null){
        this.processo.codComarca = this.formGroup.value.comarca.codComarca;
        this.processo.nomComarca = this.formGroup.value.comarca.nomComarca;
      }

      if(this.formGroup.value.local != null){
        this.processo.codJuizo = this.formGroup.value.local.codJuizo;
        this.processo.nomJuizo = this.formGroup.value.local.nomJuizo;
      }

      if(this.formGroup.value.responsavel != null){
        this.processo.sigAdvogado = this.formGroup.value.responsavel.sigAdvogado;
        this.processo.nomAdvogado = this.formGroup.value.responsavel.nomAdvogado;
      }

      if(this.formGroup.value.corresponsavel != null){
        this.processo.sigCorresponsavel = this.formGroup.value.corresponsavel.sigAdvogado;
        this.processo.nomCorresponsavel = this.formGroup.value.corresponsavel.nomAdvogado;
      }

      this.processo.nomPoloAtivo = this.partesPoloAtivo.map(function(o){ return o.nomParteProcesso; }).join(",");
      this.processo.nomPoloPassivo = this.partesPoloPassivo.map(function(o){ return o.nomParteProcesso; }).join(",");
      this.processo.nomTerceiroInteressado = this.partesTerceiroInteressado.map(function(o){ return o.nomParteProcesso; }).join(",");

      this.processo.stsValidadoUsuario = '1';
    } catch(e){
      console.error(e);
    }

    this.loadingIndicator.show();
    this.processoProvider.saveProcesso(this.processo).then((data:ProcessoVO)=>{
      alert('Processo salvo com sucesso!');
      this.loadingIndicator.hide();
      console.log(data);
    }).catch((e)=>{
      this.loadingIndicator.hide();
      console.error(e);
    });

  }

  private findById():void{
    if(this.processo.idPocProcesso != null){
      this.loadingIndicator.show();
      this.processoProvider.findProcessoById(this.processo.idPocProcesso).then((data:ProcessoVO)=>{
        data.idPocProcesso = this.processo.idPocProcesso;
        this.processo = data;

        this.fillFormGroup();
        this.loadingIndicator.hide();
      }).catch((e)=>{ console.log(e); this.loadingIndicator.hide(); });
    }
  }

  private fillFormGroup():void{

    /*for(let attrName in this.processo){
      if(this.processo[attrName] == null){
        this.processo[attrName] = " ";
      }
    }
    console.log(this.processo);*/

    if(this.processo.nomEmpresa!=null){
      this.formGroup.controls['empresa'].setValue({
        codEmpresa:this.processo.codEmpresa,
        nomEmpresa:this.processo.nomEmpresa
      });
    }

    if(this.processo.nomDetalheEspecificNatureza!=null){
      this.formGroup.controls['espDetNatureza'].setValue(new DetalheEspecificacaoNaturezaVO({
        codEspecificacaoNatureza:this.processo.codEspecificacaoNatureza,
        desEspecificacaoNatureza:this.processo.desEspecificacaoNatureza,
        codDetalheEspecificNatureza:this.processo.codDetalheEspecificNatureza,
        nomDetalheEspecificNatureza:this.processo.nomDetalheEspecificNatureza,
      }));
    }

    if(this.processo.nomPreObjetoEmpresa!=null){
      this.formGroup.controls['preObjetoEmpresa'].setValue({
        codPreObjetoEmpresa:this.processo.codPreObjetoEmpresa,
        nomPreObjetoEmpresa:this.processo.nomPreObjetoEmpresa
      });
    }
    
    this.formGroup.controls['dataCitacao'].setValue((this.processo.dtcCitacao!=null && this.processo.dtcCitacao != '')?new Date(this.processo.dtcCitacao):'');
    this.formGroup.controls['dataProtocoloAforamento'].setValue((this.processo.dtcProtocoloAforamento!=null && this.processo.dtcProtocoloAforamento != '')?new Date(this.processo.dtcProtocoloAforamento):'');
    this.formGroup.controls['passouCallCenter'].setValue(this.processo.stsPassouCallCenter == '1');
    this.formGroup.controls['relevante'].setValue(this.processo.stsRelevante == '1');
    this.formGroup.controls['consumerista'].setValue(this.processo.stsConsumerista == '1');
    this.formGroup.controls['passouProcon'].setValue(this.processo.stsPassouProcon == '1');
    
    if(this.processo.nomTipoAcaoProcesso!=null){
      this.formGroup.controls['objetoAcao'].setValue({
        nomTipoAcaoProcesso:this.processo.nomTipoAcaoProcesso,
        codTipoAcaoProcesso:this.processo.codTipoAcaoProcesso
      });
    }

    if(this.processo.nomDivisao!=null){
      this.formGroup.controls['divisaoResponsavel'].setValue({
        sigDivisao:this.processo.codDivisaoProcesso,
        nomDivisao:this.processo.nomDivisao
      });
    }

    this.formGroup.controls['numProcesso'].setValue(this.processo.numProcesso);

    this.formGroup.controls['dataEnvioEscContratado'].setValue((this.processo.dtcEnvioEscContratado!=null && this.processo.dtcEnvioEscContratado != '')?new Date(this.processo.dtcEnvioEscContratado):'');

    if(this.processo.desTipoAcao!=null){
      this.formGroup.controls['tipoAcao'].setValue({
        codTipoAcao:this.processo.codTipoAcao,
        desTipoAcao:this.processo.desTipoAcao
      });
    }

    if(this.processo.nomEscritorioContratado!=null){
      this.formGroup.controls['escritorioContratado'].setValue({
        sigEscritorioContratado:this.processo.sigEscritorioContratado,
        nomEscritorioContratado:this.processo.nomEscritorioContratado
      });
    }

    if(this.processo.nomEstado!=null){
      this.formGroup.controls['estado'].setValue({
        sigEstado:this.processo.sigEstado,
        nomEstado:this.processo.nomEstado
      });
    }

    if(this.processo.nomMunicipio!=null){
      this.formGroup.controls['municipio'].setValue({
        sigMunicipio:this.processo.sigMunicipio,
        nomMunicipio:this.processo.nomMunicipio
      });
    }

    if(this.processo.nomComarca!=null){
      this.formGroup.controls['comarca'].setValue({
        codComarca:this.processo.codComarca,
        nomComarca:this.processo.nomComarca
      });
    }

    if(this.processo.nomJuizo!=null){
      this.formGroup.controls['local'].setValue({
        codJuizo:this.processo.codJuizo,
        nomJuizo:this.processo.nomJuizo
      });
    }

    if(this.processo.nomAdvogado!=null){
      this.formGroup.controls['responsavel'].setValue({
        sigAdvogado:this.processo.sigAdvogado,
        nomAdvogado:this.processo.nomAdvogado
      });
    }

    if(this.processo.nomCorresponsavel!=null){
      this.formGroup.controls['corresponsavel'].setValue({
        sigAdvogado:this.processo.sigCorresponsavel,
        nomAdvogado:this.processo.nomCorresponsavel
      });
    }

    if(this.processo.nomPoloAtivo != null && this.processo.nomPoloAtivo != ''){
      let arrPoloAtivo:Array<ParteProcessoVO> = [];
      let poloAtivoSplit = this.processo.nomPoloAtivo.split(',');
      for(let item of poloAtivoSplit){
        arrPoloAtivo.push(new ParteProcessoVO({nomParteProcesso:item}));
      }
      this.onAddPartes({tipoParte:ParteProcessoVO.POLO_ATIVO,partes:arrPoloAtivo});
    }
    if(this.processo.nomPoloPassivo != null && this.processo.nomPoloPassivo != ''){
      let arrPoloPassivo:Array<ParteProcessoVO> = [];
      let poloPassivoSplit = this.processo.nomPoloPassivo.split(',');
      for(let item of poloPassivoSplit){
        arrPoloPassivo.push(new ParteProcessoVO({nomParteProcesso:item}));
      }
      this.onAddPartes({tipoParte:ParteProcessoVO.POLO_PASSIVO,partes:arrPoloPassivo});
    }
    if(this.processo.nomTerceiroInteressado != null && this.processo.nomTerceiroInteressado != ''){
      let arrTerceiroInteressado:Array<ParteProcessoVO> = [];
      let terceiroInteressadoSplit = this.processo.nomTerceiroInteressado.split(',');
      for(let item of terceiroInteressadoSplit){
        arrTerceiroInteressado.push(new ParteProcessoVO({nomParteProcesso:item}));
      }
      this.onAddPartes({tipoParte:ParteProcessoVO.TERCEIRO_INTERESSADO,partes:arrTerceiroInteressado});
    }

    //console.log(this.formGroup.value);

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
