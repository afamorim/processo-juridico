import { ApuracaoProvider } from './../../providers/apuracao-provider';
import { ApuracaoVO } from './../../valueobject/ApuracaoVO';
import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { NavController, NavParams, ViewController } from 'ionic-angular';

/*
  Generated class for the ApuracaoCadastro page.

  See http://ionicframework.com/docs/v2/components/#navigation for more info on
  Ionic pages and navigation.
*/
@Component({
  selector: 'page-apuracao-cadastro',
  templateUrl: 'apuracao-cadastro.html',
  providers: [ApuracaoProvider]
})
export class ApuracaoCadastroPage {

  private formGroup:FormGroup;

  constructor(public navCtrl: NavController, public viewCtrl: ViewController, public navParams: NavParams, private apuracaoProvider:ApuracaoProvider) {
    this.formGroup = new FormGroup({
      isCpfCnpj: new FormControl('cpf'),
      numCpfCnpj: new FormControl(),
      numLinha: new FormControl(),
      dtcInicioPequisa: new FormControl(),
      dtcFimPesquisa: new FormControl()
    });

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ApuracaoCadastroPage');
  }

  private efetuarApuracao():void{
    let apuracao:ApuracaoVO = this.formGroup.value as ApuracaoVO;
    console.log(apuracao);

    this.apuracaoProvider.saveApuracao(apuracao).then((data)=>{
      alert('Apuração efetuada com sucesso!');
      this.dismiss();
    }).catch((e)=>{
      console.error(e);
    });
  }

  private dismiss():void{
    this.viewCtrl.dismiss();
  }

}
