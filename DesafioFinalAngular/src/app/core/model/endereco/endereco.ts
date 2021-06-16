import { EnderecoDto } from './endereco-dto';
export class Endereco {
  id: number;
  logradouro: string;
  numero: number;
  bairro: string;
  cidade: string;
  cep: string;

  /** Do backend para o frontend */
  public static doDto(enderecoDto: EnderecoDto): Endereco {
    const dto = { ...enderecoDto };

    return dto;
  }

  /** Do frontend para o backend */
  public static paraDto(enderecoDto: EnderecoDto): EnderecoDto {
    const dto = { ...enderecoDto };

    return dto;
  }
}
