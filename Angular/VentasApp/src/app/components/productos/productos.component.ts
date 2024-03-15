import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/services/producto.service';
import { PageEvent } from '@angular/material/paginator';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html'
})
export class ProductosComponent implements OnInit {

  lista: Producto[] = [];
  titulo: string = 'Lista de Productos';
  totalRegistros = 0;
  totalPorPagina = 5;
  paginaActual = 0;
  pageSizeOptions: number[] = [5, 10, 25, 100];

  constructor(private service: ProductoService) { }

  ngOnInit(): void {
    // this.service.listar().subscribe(lista => this.lista = lista);

    this.calcularRangos();
  }

  private calcularRangos() {
    this.service.listarPagina(this.paginaActual.toString(), this.totalPorPagina.toString()).subscribe(p => {
      this.lista = p.content as Producto[];
      this.totalRegistros = p.totalElements as number;
    });
  }

  public paginar(event: PageEvent): void {
    this.paginaActual = event.pageIndex;
    this.totalPorPagina = event.pageSize;
    this.calcularRangos();
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
          // this.lista = this.lista.filter(p => p !== producto);

          this.calcularRangos();
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
