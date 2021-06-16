import { Observable } from 'rxjs';
import { Produto } from 'src/app/core/model/produto/produto';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProdutoDto } from './produto-dto';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ProdutoService {
  private readonly API = 'http://localhost:8080/produto/';

  constructor(private http: HttpClient) {}

  list(): Observable<Produto[]> {
    return this.http.get(this.API).pipe(tap(console.log));
  }

  create(produtoDto: ProdutoDto) {
    return this.http.post(this.API, produtoDto);
  }

  getById(id: number) {
    return this.http.get(this.API + id);
  }

  update(produtoDto: ProdutoDto) {
    return this.http.put(this.API + produtoDto.id, produtoDto);
  }

  delete(id: number){
    return this.http.delete(this.API + id);
  }
}
