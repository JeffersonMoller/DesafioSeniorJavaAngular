import { ClienteDto } from './cliente-dto';

export class Cliente {
  codigo: number;
  nome: string;
  tipoEnum: string;
  documento: string;

  /** Do backend para o frontend */
  public static doDto(clienteDto: ClienteDto): Cliente {
    const dto = { ...clienteDto };

    return dto;
  }

  /** Do frontend para o backend */
  public static paraDto(clienteDto: ClienteDto): ClienteDto {
    const dto = { ...clienteDto };

    return dto;
  }
}
