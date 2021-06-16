import { Cliente } from 'src/app/core/model/cliente/cliente';
import { ClienteService } from '../../../core/model/cliente/cliente.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-cliente-tabela',
  templateUrl: './cliente-tabela.component.html',
  styleUrls: ['./cliente-tabela.component.scss'],
})
export class ClienteTabelaComponent implements OnInit {
  clientes: Cliente[];
  paginaAtual: number = 1;
  contador: number = 5;

  constructor(private clienteService: ClienteService) {}

  ngOnInit(): void {
    this.clienteService.list().subscribe((dados) => (this.clientes = dados));
  }

  deletaCliente(id) {
    this.clienteService.delete(id).subscribe(() => this.load());
  }

  load() {
    location.reload();
  }
}
