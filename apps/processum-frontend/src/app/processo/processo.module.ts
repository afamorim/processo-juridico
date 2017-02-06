import { ButtonModule, InputTextModule } from 'primeng/primeng';
import { ProcessoCadastroComponent } from './processo-cadastro/processo-cadastro.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProcessoRoutingModule } from './processo-routing.module';
import { ProcessoComponent } from './processo.component';
import { DialogPartesComponent } from './dialogs/dialog-partes/dialog-partes.component';

@NgModule({
  imports: [
    CommonModule,
    ProcessoRoutingModule
  ],
  declarations: [ProcessoComponent]
})
export class ProcessoModule { }