import { BaseProvider } from './../../providers/base-provider';
import { ApuracaoVO } from './../../valueobject/ApuracaoVO';
import { Component } from '@angular/core';
import { NavController, NavParams, ViewController } from 'ionic-angular';

/*
  Generated class for the ApuracaoDetalhe page.

  See http://ionicframework.com/docs/v2/components/#navigation for more info on
  Ionic pages and navigation.
*/
@Component({
  selector: 'page-apuracao-detalhe',
  templateUrl: 'apuracao-detalhe.html'
})
export class ApuracaoDetalhePage {
  
  private apuracao:ApuracaoVO = new ApuracaoVO();
  private detailApuracao:ApuracaoVO = new ApuracaoVO();

  constructor(public navCtrl: NavController, public viewCtrl: ViewController, public navParams: NavParams) {
    this.apuracao = navParams.get('apuracao') as ApuracaoVO;
    this.apuracao = (this.apuracao != null)?this.apuracao:new ApuracaoVO();

    this.detailApuracao = this.apuracao;
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ApuracaoDetalhePage');
  }

  private exportarPDF():void{
    window.open(BaseProvider.getPDFApuracaoURL()+this.apuracao.idPocOcorrencia);
  }

  private dismiss():void{
    this.viewCtrl.dismiss();
  }

}
