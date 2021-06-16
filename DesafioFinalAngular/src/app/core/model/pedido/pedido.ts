import { PedidoDto } from './pedido-dto';
import { Cliente } from '../cliente/cliente';
import { Endereco } from '../endereco/endereco';

export class Pedido {
  id: number;
  situacaoPedidoEnum: string;
  valorTotal: number;
  qtdTotal: number;
  desconto: number;
  endereco: Endereco;
  cliente: Cliente;

  /** Do backend para o frontend */
  public static doDto(pedidoDto: PedidoDto): Pedido {
    const dto = { ...pedidoDto };

    return dto;
  }

  /** Do frontend para o backend */
  public static paraDto(pedidoDto: PedidoDto): PedidoDto {
    const dto = { ...pedidoDto };

    return dto;
  }
}
