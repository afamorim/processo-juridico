import { UicomponentsModule } from './uicomponents/uicomponents.module';
import { AutenticacaoModule } from './autenticacao/autenticacao.module';
import { AppRoutingModule } from './app.routing-module';
import { ProcessoComponent } from './processo/processo.component';
import { Routes, RouterModule } from '@angular/router';
import { ProcessoModule } from './processo/processo.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    UicomponentsModule,
    
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    HttpModule,

    AutenticacaoModule,
    ProcessoModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
