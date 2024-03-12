import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html'
})
export class ProductosComponent implements OnInit {

  lista: Producto[] = [];
  titulo: string = 'Lista de Productos';

  constructor(private service: ProductoService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista = lista);
  }

  public eliminar(producto: Producto): void {
    if (confirm(`¿Está seguro de eliminar a ${producto.nombre}?`)) {
      this.service.eliminar(producto.id).subscribe(() => {
        this.lista = this.lista.filter(p => p !== producto);
        alert(`Producto ${producto.nombre} eliminado con exito.`)
      });
    }
  }

}
