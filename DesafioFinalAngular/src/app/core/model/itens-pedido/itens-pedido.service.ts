import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ItensDePedidoDto } from './itens-pedido-dto';

@Injectable({
  providedIn: 'root',
})
export class ItensDePedidoService {
  private readonly API = 'http://localhost:8080/itensdepedido/';

  constructor(private http: HttpClient) {}

  list() {
    return this.http.get(this.API);
  }

  create(itensDePedidoDto: ItensDePedidoDto) {
    return this.http.post(this.API, itensDePedidoDto);
  }

  getById(id: number) {
    return this.http.get(this.API + id);
  }

  update(itensDePedidoDto: ItensDePedidoDto) {
    return this.http.put(this.API + itensDePedidoDto.id, itensDePedidoDto);
  }

  delete(itensDePedidoDto: ItensDePedidoDto) {
    return this.http.delete(this.API + itensDePedidoDto.id);
  }
}
