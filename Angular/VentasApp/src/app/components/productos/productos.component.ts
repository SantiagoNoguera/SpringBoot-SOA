import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/services/producto.service';
import Swal from 'sweetalert2';

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
    Swal.fire({
      title: 'Alerta!',
      text: `¿Está seguro de eliminar a ${producto.nombre}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085D6',
      cancelButtonColor: '#D33',
      confirmButtonText: 'Si, Eliminar!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.eliminar(producto.id).subscribe(() => {
          this.lista = this.lista.filter(p => p !== producto);
          Swal.fire('Eliminado:', `Producto ${producto.nombre} eliminado con exito.`, 'success');
        });
      }
    });

    // if (confirm(`¿Está seguro de eliminar a ${producto.nombre}?`)) {
    //   this.service.eliminar(producto.id).subscribe(() => {
    //     this.lista = this.lista.filter(p => p !== producto);
    //     Swal.fire('Eliminado:', `Producto ${producto.nombre} eliminado con exito.`, 'success');
    //   });
    // }
  }

}
