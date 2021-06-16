import { ProdutoDto } from './produto-dto';

export class Produto {
  id: number;
  statusEnum: string;
  codigo: number;
  descricao: string;
  unidadeDeMedida: string;
  qtdTotal: number;

  /** Do backend para o frontend */
  public static doDto(produtoDto: ProdutoDto): Produto {
    const dto = { ...produtoDto };

    return dto;
  }

  /** Do frontend para o backend */
  public static paraDto(produtoDto: ProdutoDto): ProdutoDto {
    const dto = { ...produtoDto };

    return dto;
  }
}
