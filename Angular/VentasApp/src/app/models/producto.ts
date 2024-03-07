import { EspecificacionTecnica } from "./especificacion-tecnica";

export class Producto {

    id: number = 0;
    nombre: string = '';
    cantidad: number = 0;
    precio: number = 0;
    createAt: string = '';
    especificacionTecnica: EspecificacionTecnica = new EspecificacionTecnica();

}
