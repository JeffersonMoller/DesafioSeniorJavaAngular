import { Cliente } from 'src/app/core/model/cliente/cliente';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ClienteDto } from './cliente-dto';
import { tap } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  private readonly API = 'http://localhost:8080/cliente/';

  constructor(private http: HttpClient) {}

  list(): Observable<Cliente[]> {
    return this.http.get(this.API).pipe(tap(console.log));
  }


  create(cliente: ClienteDto) {
    return this.http.post(this.API, cliente);
  }

  getById(codigo: number) {
    return this.http.get(this.API + codigo);
  }

  update(cliente: ClienteDto) {
    return this.http.put(this.API + cliente.codigo, cliente);
  }

  delete(id: number) {
    return this.http.delete(this.API + id);
  }
}
