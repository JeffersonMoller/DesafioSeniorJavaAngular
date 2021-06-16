import { Router } from '@angular/router';
import { ProdutoService } from './../../../core/model/produto/produto.service';
import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/core/model/produto/produto';

@Component({
  selector: 'app-produto-tabela',
  templateUrl: './produto-tabela.component.html',
  styleUrls: ['./produto-tabela.component.scss'],
})
export class ProdutoTabelaComponent implements OnInit {
  produtos: Produto[];



  paginaAtual: number = 1;
  contador: number = 5;

  constructor(private produtoService: ProdutoService,
    private router: Router) {}

  ngOnInit(): void {
    this.produtoService.list().subscribe((dados) => (this.produtos = dados));
  }

  deletaProduto(id){
    this.produtoService.delete(id)
    .subscribe(() => this.load());
  }

  load() {
    location.reload();
  }
}
