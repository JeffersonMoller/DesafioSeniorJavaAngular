import { Pedido } from '../pedido/pedido';
import { Produto } from '../produto/produto';

export class ItensDePedidoDto {
  id: number;
  codigo: number;
  valorUnitario: number;
  unidadeMedida: string;
  produto: Produto;
  pedido: Pedido;
}
