import { InputTextModule } from 'primeng/primeng';
import { ProcessoProviderService } from './../../../../provider/processo-provider.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ParteProcessoVO } from './../../../../valueobject/ParteProcessoVO';
import { GenericDialog } from './../GenericDialog';
import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';

@Component({
  selector: 'dialog-partes',
  templateUrl: './dialog-partes.component.html',
  styleUrls: ['./dialog-partes.component.css'],
  providers: [ProcessoProviderService]
})
export class DialogPartesComponent extends GenericDialog implements OnInit {

  @Output() add:EventEmitter<any> = new EventEmitter<any>();

  private tipoParte:any = {};
  private formGroup:FormGroup;
  private partes:Array<ParteProcessoVO> = new Array<ParteProcessoVO>();
  private partesSelected:Array<ParteProcessoVO> = new Array<ParteProcessoVO>();

  constructor(private processoProvider:ProcessoProviderService) {
    super();

    this.formGroup = new FormGroup({
      nomParteProcesso: new FormControl('',Validators.required)
    });
  }

  ngOnInit() {

  }

  protected show(pAliasTipoParte?:string):void{
    this.setTipoParte(pAliasTipoParte);

    this.formGroup.reset();
    this.partes = new Array<ParteProcessoVO>();
    this.partesSelected = new Array<ParteProcessoVO>();

    super.show();
  }

  private search():void{
    this.processoProvider.findPartesProcessoByNome(this.formGroup.value.nomParteProcesso).then((data:Array<ParteProcessoVO>)=>{
      this.partes = ParteProcessoVO.convertList(data);
      this.partesSelected = new Array<ParteProcessoVO>();
    }).catch((e)=>{
      console.error(e);
    });
  }

  private addPartes():void {
    this.add.emit({tipoParte:this.tipoParte,partes:this.partesSelected});
    this.hide();
  }

  private setTipoParte(aliasTipoParte:string){

    switch(aliasTipoParte){
      case ParteProcessoVO.POLO_ATIVO.alias:
        this.tipoParte = ParteProcessoVO.POLO_ATIVO;
      break;
      case ParteProcessoVO.POLO_PASSIVO.alias:
        this.tipoParte = ParteProcessoVO.POLO_PASSIVO;
      break;
      case ParteProcessoVO.TERCEIRO_INTERESSADO.alias:
        this.tipoParte = ParteProcessoVO.TERCEIRO_INTERESSADO;
      break;
    }
  }

}
