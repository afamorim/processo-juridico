import { LoadingIndicatorComponent } from './../uicomponents/loading-indicator/loading-indicator.component';
import { DialogPartesComponent } from './dialogs/dialog-partes/dialog-partes.component';
import { ApuracoesComponent } from './apuracoes/apuracoes.component';
import { CommonModule } from '@angular/common';
import { ProcessoPesquisaSolicitadosComponent } from './processo-pesquisa-solicitados/processo-pesquisa-solicitados.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProcessoPesquisaImportadosComponent } from './processo-pesquisa-importados/processo-pesquisa-importados.component';
import { ProcessoCadastroComponent } from './processo-cadastro/processo-cadastro.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import * as Prime from 'primeng/primeng';

const routes: Routes = [
  { path:'', redirectTo:'importados', pathMatch: 'full' },
  { path:'cadastro', component: ProcessoCadastroComponent },
  { path:'cadastro/:numero', component: ProcessoCadastroComponent },
  { path:'importados', component: ProcessoPesquisaImportadosComponent },
  { path:'solicitados', component: ProcessoPesquisaSolicitadosComponent },
  { path: 'apuracoes', component: ApuracoesComponent }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes),
    Prime.ButtonModule,
    Prime.InputTextModule,
    Prime.DropdownModule,
    Prime.FieldsetModule,
    Prime.AutoCompleteModule,
    Prime.SpinnerModule,
    Prime.CalendarModule,
    Prime.ToggleButtonModule,
    Prime.ListboxModule,
    Prime.DialogModule,
    Prime.DataTableModule,
    Prime.SelectButtonModule,
    Prime.InputMaskModule,
    Prime.MenuModule
  ],
  exports: [
    RouterModule,
    Prime.ButtonModule,
    Prime.InputTextModule,
    Prime.DropdownModule,
    Prime.FieldsetModule,
    Prime.AutoCompleteModule,
    Prime.SpinnerModule,
    Prime.ToggleButtonModule,
    Prime.ListboxModule,
    Prime.DialogModule,
    Prime.DataTableModule,
    Prime.SelectButtonModule,
    Prime.InputMaskModule,
    Prime.MenuModule
  ],
  declarations: [
    LoadingIndicatorComponent,
    ProcessoCadastroComponent,
    ProcessoPesquisaImportadosComponent,
    ProcessoPesquisaSolicitadosComponent,
    ApuracoesComponent,
    DialogPartesComponent],
  providers: []
})
export class ProcessoRoutingModule { }
