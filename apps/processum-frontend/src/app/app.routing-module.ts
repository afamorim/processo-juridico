import { AutenticacaoComponent } from './autenticacao/autenticacao.component';
import { ProcessoComponent } from './processo/processo.component';
import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:'',redirectTo:'processo',pathMatch:'full'},
  {path:'auth', component: AutenticacaoComponent, loadChildren: './autenticacao/autenticacao.module#AutenticacaoModule'},
  {path:'processo', component: ProcessoComponent, loadChildren: './processo/processo.module#ProcessoModule'}
];
@NgModule({
  imports: [ RouterModule.forRoot(routes, { useHash: true }) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}