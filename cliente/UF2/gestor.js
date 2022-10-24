/*
 * He estado investigado formas que un objeto pueda tener dos constructores
 * distintos con el mismo nombre, un overloading vamos. Y en javaScript no hay
 * una forma elegante de hacerlo, he probado con Class y otros métodos pero
 * este me parece el más elegante.
 */
function Disco(nombre = "", artista = "", ap = "", genero = "", local = 0) {
        this.nombre = nombre
        this.artista = artista
        this.ap = ap
        this.genero = genero
        this.local = local;
        this.prestado = false;
        this.cambiar_local = function(local) {
            this.local = local;
        }
        this.cambiar_prestado = function(prestado) {
            this.prestado = prestado;
        }
        this.mostrar_info = function() {
            console.log("nombre: ", this.nombre);
            console.log("artista: ", this.artista);
            console.log("año publicación: ", this.ap);
            console.log("género: ", this.genero);
            console.log("localización: ", this.local);
            console.log("prestado: ", this.prestado);
        }
        
}

/* Creamos un disco con parametros. */
const disco = new Disco("Rejuvenation", "The Meters", "1978", "Funky", 1234);

/* Cambiamos la localización. */
console.log(disco.local);
disco.cambiar_local(4321);
console.log(disco.local);

/* Cambiamos el estado de prestación. */
console.log(disco.prestado);
disco.cambiar_prestado(true);
console.log(disco.prestado);

/* Mostramos toda la información del disco. */
disco.mostrar_info();

/* Creamos un disco sin parámetros y mostramos toda la información. */
const disco_vacio = new Disco();
disco_vacio.mostrar_info();
