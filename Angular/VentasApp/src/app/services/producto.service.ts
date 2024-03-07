import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  //Ruta sobre la que corre el servicio-productos que se creó con Spring Boot.
  private urlEndPoint: string = 'http://localhost:8002'
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  //Colocando un objeto como parametro en el constructor es que se puede inyectar dentro de la clase.
  constructor(private http: HttpClient) { }

  //Método para listar todos los productos en el BackEnd.
  listar(): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.urlEndPoint);
  }

  //Método para ver los datos de un solo producto.
  ver(id: number): Observable<Producto> {
    return this.http.get<Producto>(`${this.urlEndPoint}/${id}`);
  }

  //Método para crear un nuevo producto.
  crear(producto: Producto): Observable<Producto> {
    return this.http.post<Producto>(this.urlEndPoint, producto, { headers: this.httpHeaders });
  }

  //Método para editar los datos de un producto.
  modificar(producto: Producto): Observable<Producto> {
    return this.http.put<Producto>(`${this.urlEndPoint}/${producto.id}`, producto, { headers: this.httpHeaders });
  }

  //Método para eliminar un producto.
  eliminar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.urlEndPoint}/${id}`, { headers: this.httpHeaders });
  }

}
