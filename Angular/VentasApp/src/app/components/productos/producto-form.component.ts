import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/services/producto.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-producto-form',
  templateUrl: './producto-form.component.html'
})
export class ProductoFormComponent implements OnInit {

  titulo: string = 'Formulario de Productos';
  producto: Producto = new Producto();
  error: any;

  constructor(private service: ProductoService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear() {
    this.service.crear(this.producto).subscribe(producto => {
      Swal.fire('Nuevo:', `Producto ${producto.nombre} creado con exito!`, 'success');
      this.router.navigate(['/productos']);
    }, err => {
      if (err.status === 400) {
        this.error = err.error;
      }
    });
  }

  editar(): void {
    this.route.params.subscribe(params => {
      let id = params['id'];

      if (id) {
        this.service.ver(id).subscribe(producto => this.producto = producto);
      }
    });
  }

  modificar() {
    this.service.modificar(this.producto).subscribe(producto => {
      Swal.fire('Editar:', `Producto ${producto.nombre} actualizado con exito!`, 'success');
      this.router.navigate(['/productos']);
    }, err => {
      if (err.status === 400) {
        this.error = err.error;
      }
    });
  }

}
