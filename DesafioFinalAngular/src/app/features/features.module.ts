import { ProdutoModule } from './produto/produto.module';
import { ClienteModule } from './cliente/cliente.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeModule } from './home/home.module';

@NgModule({
  declarations: [],
  imports: [CommonModule, HomeModule, ClienteModule, ProdutoModule],
  exports: [HomeModule, ClienteModule, ProdutoModule],
})
export class FeaturesModule {}
