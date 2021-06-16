import { ItensDePedidoDto } from './itens-pedido-dto';
import { Produto } from '../produto/produto';
import { Pedido } from '../pedido/pedido';

export class ItensDePedido {
  id: number;
  codigo: number;
  valorUnitario: number;
  unidadeMedida: string;
  produto: Produto;
  pedido: Pedido;

  /** Do backend para o frontend */
  public static doDto(itensDePedidoDto: ItensDePedidoDto): ItensDePedido {
    const dto = { ...itensDePedidoDto };

    return dto;
  }

  /** Do frontend para o backend */
  public static paraDto(itensDePedidoDto: ItensDePedidoDto): ItensDePedidoDto {
    const dto = { ...itensDePedidoDto };

    return dto;
  }
}
