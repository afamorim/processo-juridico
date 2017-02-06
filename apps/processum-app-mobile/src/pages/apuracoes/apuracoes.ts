import { ApuracaoProvider } from './../../providers/apuracao-provider';
import { BaseProvider } from './../../providers/base-provider';
import { ApuracaoVO } from './../../valueobject/ApuracaoVO';
import { ApuracaoDetalhePage } from './../apuracao-detalhe/apuracao-detalhe';
import { ApuracaoCadastroPage } from './../apuracao-cadastro/apuracao-cadastro';
import { Component } from '@angular/core';
import { NavController, NavParams, ViewController, ModalController, Modal, ActionSheetController } from 'ionic-angular';

/*
  Generated class for the Apuracoes page.

  See http://ionicframework.com/docs/v2/components/#navigation for more info on
  Ionic pages and navigation.
*/
@Component({
  selector: 'page-apuracoes',
  templateUrl: 'apuracoes.html',
  providers: [ApuracaoProvider]
})
export class ApuracoesPage {

  private apuracoes:Array<ApuracaoVO>;
  
  constructor(public navCtrl: NavController, public viewCtrl: ViewController, public navParams: NavParams, public modalCtrl: ModalController, public actionSheetCtrl: ActionSheetController, private apuracaoProvider:ApuracaoProvider) {
    this.apuracoes = navParams.get('apuracoes') as Array<ApuracaoVO>;
    this.apuracoes = (this.apuracoes != null)?this.apuracoes:new Array<ApuracaoVO>();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ApuracoesPage');
  }

  private addApuracao():void{
    let modal:Modal = this.modalCtrl.create(ApuracaoCadastroPage);
    modal.onDidDismiss(()=>{
      this.findAll();
    });
    modal.present();
  }

  private detailApuracao(pApuracao:ApuracaoVO):void{
    let modal:Modal = this.modalCtrl.create(ApuracaoDetalhePage,{apuracao:pApuracao});
    modal.present();
  }

  private findAll():void{
    this.apuracaoProvider.findAllApuracoes().then((data:Array<ApuracaoVO>)=>{
      this.apuracoes = data;
    }).catch((e)=>{
      console.error(e);
    });
  }

  showActionSheetApuracao(apuracao:ApuracaoVO) {
    let actionSheet = this.actionSheetCtrl.create({
      title: 'Apuração '+apuracao.dtcPocOcorrencia,
      buttons: [
        {
          text: 'Apurar novamente',
          icon: 'search',
          handler: () => {
            this.efetuarApuracao(apuracao);
          }
        },
        {
          text: 'Ver detalhes',
          icon: 'more',
          handler: () => {
            this.detailApuracao(apuracao);
          }
        },
        {
          text: 'Exportar PDF',
          icon: 'document',
          handler: () => {
            this.exportarPDF(apuracao);
          }
        },{
          text: 'Cancelar',
          icon: 'close',
          role: 'cancel',
          handler: () => {
            console.log('Cancel clicked');
          }
        }
      ]
    });
    actionSheet.present();
  }

  private efetuarApuracao(apuracao:ApuracaoVO):void{
    console.log(apuracao);

    this.apuracaoProvider.saveApuracao(apuracao).then((data)=>{
      alert('Apuração efetuada com sucesso!');
      this.findAll();
    }).catch((e)=>{
      console.error(e);
    });
  }

  private exportarPDF(apuracao:ApuracaoVO):void{
    window.open(BaseProvider.getPDFApuracaoURL()+apuracao.idPocOcorrencia);
  }

  private dismiss():void{
    this.viewCtrl.dismiss(this.apuracoes);
  }

}
