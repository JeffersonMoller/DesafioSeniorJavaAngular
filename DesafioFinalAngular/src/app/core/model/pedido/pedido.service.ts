import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PedidoDto } from './pedido-dto';

@Injectable({
  providedIn: 'root',
})
export class PedidoService {
  private readonly API = 'http://localhost:8080/pedido/';
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get(this.API);
  }

  create(pedidoDto: PedidoDto) {
    return this.http.post(this.API, pedidoDto);
  }

  getById(id: number) {
    return this.http.get(this.API + id);
  }

  update(pedidoDto: PedidoDto) {
    return this.http.put(this.API + pedidoDto.id, pedidoDto);
  }

  delete(pedidoDto: PedidoDto) {
    return this.http.delete(this.API + pedidoDto.id);
  }
}
