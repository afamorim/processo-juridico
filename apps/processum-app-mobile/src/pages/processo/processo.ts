import { ApuracaoVO } from './../../valueobject/ApuracaoVO';
import { ApuracaoProvider } from './../../providers/apuracao-provider';
import { ApuracoesPage } from './../apuracoes/apuracoes';
import { Component } from '@angular/core';
import { NavController, NavParams, ModalController, Modal } from 'ionic-angular';


@Component({
  selector: 'page-processo',
  templateUrl: 'processo.html',
  providers:[ApuracaoProvider]
})
export class ProcessoPage {

  private apuracoes:Array<ApuracaoVO> = new Array<ApuracaoVO>();
  
  constructor(public navCtrl: NavController, public navParams: NavParams, public modalCtrl: ModalController, private apuracaoProvider:ApuracaoProvider) {}

  ionViewDidLoad() {
    console.log('ionViewDidLoad ProcessoPage');
    this.findAll();
  }

  private findAll():void{
    this.apuracaoProvider.findAllApuracoes().then((data:Array<ApuracaoVO>)=>{
      this.apuracoes = data;
    }).catch((e)=>{
      console.error(e);
    });
  }

  showOcorrencias():void{
    if(this.apuracoes.length > 0){
      let modal:Modal = this.modalCtrl.create(ApuracoesPage,{apuracoes:this.apuracoes});
      modal.onDidDismiss((data:Array<ApuracaoVO>)=>{
        if(data!=null){
          this.apuracoes = data;
        } else {
          this.findAll();
        }
        
      });
      modal.present();
    }
  }

}
