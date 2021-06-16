import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProdutoFormComponent } from './produto-form/produto-form.component';
import { ProdutoTabelaComponent } from './produto-tabela/produto-tabela.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { CadastroProdutoComponent } from './cadastro-produto/cadastro-produto.component';

@NgModule({
  declarations: [ProdutoFormComponent, ProdutoTabelaComponent, CadastroProdutoComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
  ],
  exports: [CadastroProdutoComponent],
})
export class ProdutoModule {}
