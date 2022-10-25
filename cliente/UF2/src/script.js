/* Declaramos el contructor para el objeto que nos guarda los pilotos y el tiempo. */
function Kart(id, piloto, tiempo) {
    this.id = id;
    this.piloto = piloto;
    this.tiempo = tiempo;
    this.push = function(karts) {
        // Este método es un poco contraintuitivo ya que el parametro a pasar
        // es el matriz que queremos enmendar.
        karts.push(this);
    }
    this.printInfo = function() {
        console.log("id: ", this.id);
        console.log("piloto: ", this.piloto);
        console.log("tiempo: ", this.tiempo);
    }
}

/* Creamos una matriz vacía que nos guardara los objetos Kart. */
const karts = [];

/* Creamos 5 datos ficticios. */
let kart = new Kart(89, "Gema", "03:49:9148");
kart.push(karts);
kart = new Kart(74, "Meri", "03:52:8394");
karts.push(kart);
kart = new Kart(12, "José", "03:54:2345");
kart.push(karts);
kart = new Kart(44, "Pepe", "04:02:7653");
karts.push(kart)
kart = new Kart(12, "Alex", "04:23:8746");
kart.push(karts);

/* Imprimimos la información de todos los karts en la consola. */
karts.forEach(kart => kart.printInfo());

/* Esta función nos llena una fila de la tabla*/
function plantillaFila(kart) {
    return `
      <tr class="data-row">
        <td class="data-kart data-ele">${kart.id}</td>
        <td class="data-piloto data-ele">${kart.piloto}</td>
        <td class="data-tiempo data-ele">${kart.tiempo}</td>
      </tr>
    `;
}

/* Ejecutamos el script con una función anónima una vez cargado el DOM. */
document.addEventListener("DOMContentLoaded", () => {
  /* Cargamos el HTML en el div identificado con `#tabla'. Utilizamos el
   * método `map' para iterar todos los elementos del matriz `karts', y 
   * ejecutamos la función `plantillaFila' en cada elemento. */
  document.getElementById("tabla").innerHTML = `
    <table>
      <tr id="encabezados">
        <th class="titulo">KART</th>
        <th class="titulo">PILOTO</th>
        <th class="titulo">TIEMPO</th>
      </tr>
    ${karts.map(plantillaFila, kart).join('')}
    </table>
  `;
});
