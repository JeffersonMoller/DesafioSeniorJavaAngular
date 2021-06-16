import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Cliente } from 'src/app/core/model/cliente/cliente';
import { ClienteService } from '../../../core/model/cliente/cliente.service';
@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.scss'],
})
export class ClienteFormComponent implements OnInit {
  mensagem: string;
  formCliente: FormGroup;

  constructor(
    private clienteService: ClienteService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.createForm(new Cliente());
  }

  createForm(cliente: Cliente) {
    this.formCliente = this.formBuilder.group({
      nome: [cliente.nome],
      documento: [cliente.documento],
    });
  }

  criaCliente() {
    // tslint:disable-next-line: deprecation
    this.clienteService.create(this.formCliente.value).subscribe(
      () => this.load(),
      (resposta: HttpErrorResponse) => alert(resposta.error.erro)
    );
    // Usar o método reset para limpar os controles na tela
    this.formCliente.reset(new Cliente());
  }

  load() {
    location.reload();
  }
}
