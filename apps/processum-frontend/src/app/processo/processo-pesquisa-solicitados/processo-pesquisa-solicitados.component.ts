import { ProcessoVO } from './../../../valueobject/ProcessoVO';
import { Dialog } from 'primeng/primeng';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-processo-pesquisa-solicitados',
  templateUrl: './processo-pesquisa-solicitados.component.html',
  styleUrls: ['./processo-pesquisa-solicitados.component.css']
})
export class ProcessoPesquisaSolicitadosComponent implements OnInit {

  private processos:Array<ProcessoVO> = new Array<ProcessoVO>();

  constructor() { }

  ngOnInit() {
    for(let i=1; i<=5; i++){
      let temp:ProcessoVO = new ProcessoVO();
      temp.dataSolicitacaoPesquisa = '0'+i+'/02/17 16:3'+i;
      temp.numero = '1002268-96.2016.8.26.0083'+i;
      this.processos.push(temp);
    }
  }

  showDialog(dialog:Dialog):void{
    dialog.visible = true;
  }

  hideDialog(dialog:Dialog):void{
    dialog.visible = false;
  }

}
