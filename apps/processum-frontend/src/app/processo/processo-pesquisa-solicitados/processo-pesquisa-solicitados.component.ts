import { ProcessoProviderService } from './../../../provider/processo-provider.service';
import { ProcessoVO } from './../../../valueobject/ProcessoVO';
import { Dialog } from 'primeng/primeng';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-processo-pesquisa-solicitados',
  templateUrl: './processo-pesquisa-solicitados.component.html',
  styleUrls: ['./processo-pesquisa-solicitados.component.css'],
  providers: [ProcessoProviderService]
})
export class ProcessoPesquisaSolicitadosComponent implements OnInit {

  private processos:Array<ProcessoVO> = new Array<ProcessoVO>();
  private numeroProcesso:string = '';

  constructor(private processoProvider:ProcessoProviderService) { }

  ngOnInit() {
    /*for(let i=1; i<=5; i++){
      let temp:ProcessoVO = new ProcessoVO();
      //temp.dataSolicitacaoPesquisa = '0'+i+'/02/17 16:3'+i;
      //temp.numero = '1002268-96.2016.8.26.0083'+i;
      this.processos.push(temp);
    }*/

    this.findAll();
  }

  solicitarProcesso():void{
    this.processoProvider.solicitarProcesso(this.numeroProcesso).then((data)=>{
      alert('Solicitação efetuada com sucesso!');
      this.numeroProcesso = '';
    }).catch((e)=>{ console.error(e); this.numeroProcesso = ''; });
  }

  findAll():void{
    this.processoProvider.findProcessosSolicitados().then((data:Array<ProcessoVO>)=>{
      this.processos = data;
    }).catch((e)=>{ console.error(e);});
  }

  showDialog(dialog:Dialog):void{
    dialog.visible = true;
  }

  hideDialog(dialog:Dialog):void{
    dialog.visible = false;
  }

}
