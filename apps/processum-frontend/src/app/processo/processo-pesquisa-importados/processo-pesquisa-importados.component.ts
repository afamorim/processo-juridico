import { ProcessoVO } from './../../../valueobject/ProcessoVO';
import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-processo-pesquisa-importados',
  templateUrl: './processo-pesquisa-importados.component.html',
  styleUrls: ['./processo-pesquisa-importados.component.css']
})
export class ProcessoPesquisaImportadosComponent implements OnInit {

  private comboGenerico:Array<any> = new Array<any>();
  private processos:Array<ProcessoVO> = new Array<ProcessoVO>();
  private processoSelected:ProcessoVO;

  constructor(private router:Router, private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.comboGenerico.push({label:'.: Selecione :.', value:'1'});

    for(let i=0; i<5; i++){
      let temp:ProcessoVO = new ProcessoVO();
      temp.codigo = i;
      temp.numero = '1002268-96.2016.8.26.0083'+i;
      temp.classe = 'Procedimento Comum';
      temp.assunto = 'ASSUNTOS ANTIGOS DO SAJ - DECLARATÓRIA';
      temp.outros_assuntos = 'Antecipação de Tutela / Tutela Específica,Indenização por Dano Moral,Pagamento Indevido,Telefonia';
      temp.distribuicao = '16/11/2016 às 22:02 - Livre';
      temp.controle = '16/11/2016 às 22:02 - Livre';
      temp.juiz = 'André Acayaba de Rezende';
      temp.valor_acao = 'R$ 21.656,84';
      temp.status = 'Importado';

      this.processos.push(temp);

    }

  }

  onRowSelect(event) {
    let processo:ProcessoVO = event.data as ProcessoVO;
    this.router.navigate(['/processo/cadastro',processo.numero]);
  }

}
