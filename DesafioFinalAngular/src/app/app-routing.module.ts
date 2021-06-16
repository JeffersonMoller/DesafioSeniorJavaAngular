import { PrincipalComponent } from './features/home/principal/principal.component';
import { CadastroClienteComponent } from './features/cliente/cadastro-cliente/cadastro-cliente.component';
import { CadastroProdutoComponent } from './features/produto/cadastro-produto/cadastro-produto.component';
import { ProdutoTabelaComponent } from './features/produto/produto-tabela/produto-tabela.component';
import { ClienteTabelaComponent } from './features/cliente/cliente-tabela/cliente-tabela.component';
import { ProdutoFormComponent } from './features/produto/produto-form/produto-form.component';
import { ClienteFormComponent } from './features/cliente/cliente-form/cliente-form.component';
import { NotFoundComponent } from './errors/not-found/not-found.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'home', component: PrincipalComponent },
  { path: 'cliente/cadastro', component: CadastroClienteComponent },
  { path: 'produto/cadastro', component: CadastroProdutoComponent },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule],
})
export class AppRoutingModule {}
