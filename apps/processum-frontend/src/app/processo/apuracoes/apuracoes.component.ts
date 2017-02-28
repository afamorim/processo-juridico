import { GrowlController } from './../../uicomponents/growl/growl.controller';
import { LoadingIndicatorController } from './../../uicomponents/loading-indicator/loading-indicator.controller';
import { BaseProvider } from './../../../provider/base-provider';
import { ApuracaoProviderService } from './../../../provider/apuracao-provider.service';
import { FormGroup, FormControl } from '@angular/forms';
import { ApuracaoVO } from './../../../valueobject/ApuracaoVO';
import { Component, OnInit, ViewChild } from '@angular/core';
import { SelectItem, Menu, Dialog } from 'primeng/primeng';

@Component({
  selector: 'app-apuracoes',
  templateUrl: './apuracoes.component.html',
  styleUrls: ['./apuracoes.component.css'],
  providers: [ApuracaoProviderService]
})
export class ApuracoesComponent implements OnInit {

  @ViewChild('dialogDetalheApuracao') dialogDetalheApuracao:Dialog;

  private listboxGenerico:Array<any> = new Array<any>();
  
  private cpfCnpj:Array<SelectItem> = new Array<SelectItem>();
  private fixaMovel:Array<SelectItem> = new Array<SelectItem>();

  private itemsSubmenuApuracoes:Array<any> = new Array<any>();

  private apuracoes:Array<ApuracaoVO> = new Array<ApuracaoVO>();
  private selectedApuracao:ApuracaoVO = new ApuracaoVO();
  private detailApuracao:ApuracaoVO = new ApuracaoVO();

  private formGroup:FormGroup;
  private formGroupInitValue:any;

  constructor(private apuracaoProvider:ApuracaoProviderService, private loadingIndicator:LoadingIndicatorController, private growl:GrowlController) {
    this.formGroup = new FormGroup({
      isCpfCnpj: new FormControl('cpf'),
      isFixaMovel: new FormControl('movel'),
      numCpfCnpj: new FormControl(),
      numLinha: new FormControl(),
      dtcInicioPequisa: new FormControl(),
      dtcFimPesquisa: new FormControl()
    });
    this.formGroupInitValue = Object.assign(this.formGroup.value);
  }

  ngOnInit() {
    for(let i=1; i<=10; i++){
      this.listboxGenerico.push({label:'Nome da parte 0'+i, value:i});
    }

    this.cpfCnpj.push({label:'CPF',value:'cpf'});
    this.cpfCnpj.push({label:'CNPJ',value:'cnpj'});

    this.fixaMovel.push({label:'Fixa',value:'fixa'});
    this.fixaMovel.push({label:'Móvel',value:'movel'});

    //apuracoes 
    /*for(let i=1; i<6; i++){
      let apuracao:ApuracaoVO = new ApuracaoVO();
      apuracao.nome_cliente = 'Fabricio Lefundes São Paulo de Araujo';
      apuracao.data_apuracao = '0'+i+'/02/2017 23:03';

      if(i==2){
        apuracao.historico = new Array<ApuracaoVO>();
          let apuracaoChild1:ApuracaoVO = new ApuracaoVO();
          apuracaoChild1.nome_cliente = 'Fabricio Lefundes São Paulo de Araujo 1';
          apuracaoChild1.data_apuracao = '12/01/2017 23:03';

          let apuracaoChild2:ApuracaoVO = new ApuracaoVO();
          apuracaoChild2.nome_cliente = 'Fabricio Lefundes São Paulo de Araujo 2';
          apuracaoChild2.data_apuracao = '25/12/2016 23:03';

        apuracao.historico.push(apuracaoChild1);
        apuracao.historico.push(apuracaoChild2);
      }

      this.apuracoes.push(apuracao);
    }*/

    this.findAll();

  }

  private findAll():void{
    this.loadingIndicator.show();
    this.apuracaoProvider.findAllApuracoes().then((data:Array<ApuracaoVO>)=>{
      this.apuracoes = data;
      
      this.loadingIndicator.hide();
    }).catch((e)=>{
      console.error(e);

      this.loadingIndicator.hide();
    });
  }

  private efetuarApuracao(data?:ApuracaoVO):void{
    let apuracao:ApuracaoVO = (data!=null)?data:new ApuracaoVO(this.formGroup.value);
    console.log(apuracao);

    this.loadingIndicator.show();

    this.apuracaoProvider.saveApuracao(apuracao).then((data)=>{
      this.growl.showSuccess('Apuração efetuada com sucesso!');

      this.loadingIndicator.hide();

      this.clearForm();
      this.findAll(); //TODO - pegar o data salvo
    }).catch((e)=>{
      console.error(e);

      this.loadingIndicator.hide();
    });
  }

  private clearForm():void{
    this.formGroup.reset();
      setTimeout(()=>{
        this.formGroup.setValue(this.formGroupInitValue);
      },0);
  }

  showDialog(dialog:Dialog):void{
    dialog.visible = true;
  }
  hideDialog(dialog:Dialog):void{
    dialog.visible = false;
  }

  private showSubmenuOcorrencias(event:any, menu:Menu, apuracao:ApuracaoVO):void{
    this.itemsSubmenuApuracoes = new Array<any>();
    this.itemsSubmenuApuracoes.push(
      {label: 'Apurar novamente', icon:'fa-search-plus', command:(event)=>{
        this.efetuarApuracao(apuracao);
      }},
      {label:'Ver detalhes', icon:'fa-ellipsis-h', command:(event)=>{
        this.selectedApuracao = apuracao;
        this.detailApuracao = this.selectedApuracao;
        this.showDialog(this.dialogDetalheApuracao);
      }},
      {label:'Exportar PDF', icon:'fa-file-pdf-o', command:(event)=>{
        this.exportarPDF(apuracao);
      }});

    menu.toggle(event);
  }

  private exportarPDF(apuracao:ApuracaoVO):void{
    window.location.href = BaseProvider.getPDFApuracaoURL()+apuracao.idPocOcorrencia;
  }

}
