import { ApuracaoDetalhePage } from './../pages/apuracao-detalhe/apuracao-detalhe';
import { ApuracaoCadastroPage } from './../pages/apuracao-cadastro/apuracao-cadastro';
import { ApuracoesPage } from './../pages/apuracoes/apuracoes';
import { ProcessoPage } from './../pages/processo/processo';
import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    ProcessoPage,
    ApuracoesPage,
    ApuracaoCadastroPage,
    ApuracaoDetalhePage
  ],
  imports: [
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    ProcessoPage,
    ApuracoesPage,
    ApuracaoCadastroPage,
    ApuracaoDetalhePage
  ],
  providers: [{provide: ErrorHandler, useClass: IonicErrorHandler}]
})
export class AppModule {}
