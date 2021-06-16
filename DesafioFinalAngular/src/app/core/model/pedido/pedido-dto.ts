import { Cliente } from '../cliente/cliente';
import { Endereco } from '../endereco/endereco';

export class PedidoDto {
  id: number;
  situacaoPedidoEnum: string;
  dataCriacao: string;
  valorTotal: number;
  qtdTotal: number;
  desconto: number;
  endereco: Endereco;
  cliente: Cliente;
}
