import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ProdutoService } from '../../../core/model/produto/produto.service';
import { Produto } from 'src/app/core/model/produto/produto';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.scss'],
})
export class ProdutoFormComponent implements OnInit {
  mensagem: string;
  formProduto: FormGroup;

  constructor(
    private produtoService: ProdutoService,
    private formBuilder: FormBuilder,
  ) {}

  ngOnInit(): void {
    this.createForm(new Produto());
  }

  createForm(produto: Produto) {
    this.formProduto = this.formBuilder.group({
      codigo: [produto.codigo],
      descricao: [produto.descricao],
      qtdTotal: [produto.qtdTotal],
      unidadeDeMedida: [produto.unidadeDeMedida],
      statusEnum: [produto.statusEnum],
    });
  }

  criaProduto() {
    // tslint:disable-next-line: deprecation
    this.produtoService.create(this.formProduto.value).subscribe(
      () => this.load() ,
      (resposta: HttpErrorResponse) => alert(resposta.error.erro)


    );
    // Usar o método reset para limpar os controles na tela
    this.formProduto.reset(new Produto());
  }



load() {
  location.reload();
}
}
