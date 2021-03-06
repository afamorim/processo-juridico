import { GrowlController } from './../../uicomponents/growl/growl.controller';
import { LoadingIndicatorController } from './../../uicomponents/loading-indicator/loading-indicator.controller';
import { LoadingIndicatorComponent } from './../../uicomponents/loading-indicator/loading-indicator.component';
import { ProcessoRESTModel } from './../../../model/ProcessoRESTModel';
import { ProcessoProviderService } from './../../../provider/processo-provider.service';
import { ProcessoVO } from './../../../valueobject/ProcessoVO';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, NavigationExtras, ActivatedRoute } from '@angular/router';

import {LazyLoadEvent} from 'primeng/primeng';

@Component({
  selector: 'app-processo-pesquisa-importados',
  templateUrl: './processo-pesquisa-importados.component.html',
  styleUrls: ['./processo-pesquisa-importados.component.css'],
  providers:[ProcessoProviderService]
})
export class ProcessoPesquisaImportadosComponent implements OnInit {

  private comboGenerico:Array<any> = new Array<any>();
  private processos:Array<ProcessoVO>;
  private processoSelected:ProcessoVO;

  private numRows:number = 0;
  private numTotal:number = 0;

  constructor(private router:Router, private activatedRoute:ActivatedRoute, private processoProvider:ProcessoProviderService, private loadingIndicator:LoadingIndicatorController, private growl:GrowlController) { }

  ngOnInit() {
    this.comboGenerico.push({label:'.: Selecione :.', value:'1'});
  }

  private lazyLoadProcessos(event:LazyLoadEvent):void{
    this.findProcessosByPage(event.first/event.rows);
  }

  private findProcessosByPage(page:number):void{
    this.loadingIndicator.show();
    this.processoProvider.findProcessosByPage(page).then((data:ProcessoRESTModel)=>{
      this.processos = data.processos;
      this.numRows = data.page.size;
      this.numTotal = data.page.totalElements;

      this.loadingIndicator.hide();
    }).catch((e)=>{
      console.error(e);
      this.growl.showError('Ocorreu um erro ao obter os processos!');
      this.loadingIndicator.hide();
    });
  }

  onRowSelect(event) {
    let processo:ProcessoVO = event.data as ProcessoVO;
    this.router.navigate(['/processo/cadastro',processo.idPocProcesso]);
  }

}
