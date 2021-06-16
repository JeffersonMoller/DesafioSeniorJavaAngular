import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EnderecoDto } from './endereco-dto';

@Injectable({
  providedIn: 'root',
})
export class EnderecoService {
  private readonly API = 'http://localhost:8080/endereco';

  constructor(private http: HttpClient) {}

  list() {
    return this.http.get(this.API);
  }

  create(enderecodto: EnderecoDto) {
    return this.http.post(this.API, enderecodto);
  }

  getById(id: number) {
    return this.http.get(this.API + id);
  }

  update(enderecodto: EnderecoDto) {
    return this.http.put(this.API + enderecodto.id, enderecodto);
  }

  delete(enderecodto: EnderecoDto) {
    return this.http.delete(this.API + enderecodto.id);
  }
}
