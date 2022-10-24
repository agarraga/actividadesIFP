/* Creamos una matriz con elementos. */
const paises = ["Andorra", "España", "Marruecos", "Portugal"];

/* Mostramos el número de elmentos. */
console.log(paises.length);

/* Mostramos todos los elementos. */
paises.forEach(pais => console.log(pais));

/* Mostramos los elementos en sentido inverso. utilizamos from para crear
 * un nuevo array*/
paises_inversos = Array.from(paises);
paises_inversos.reverse().forEach(pais => console.log(pais));

/* Mostramos los elementos ordenados sin ordenarlos. */
paises_ordenados = Array.from(paises);
paises_ordenados.sort().forEach(pais => console.log(pais));

/* Añadimos un elemento al principio. */
paises.unshift("Francia");

/* Añadimos un elemento al final. */
paises.push("Grecia");

/* Borramos un elemento al principio. */
paises.shift();

/* Borramos un elemento al final. */
paises.pop();

/* Mostramos elemento indicado por usuario. */
function mostrar_elemento(index) {
    console.log(paises[index]);
}

mostrar_elemento(2);

/* Mostramos indice de elemento indicado por usuario. */
function mostrar_indice(elemento) {
    console.log(paises.indexOf(elemento));
}

mostrar_indice("Marruecos");

/* Mostramos los elementos en el intervalo indicado por usuario. */
function mostrar_intervalo(desde, hasta) {
    console.log(paises.slice(desde, hasta));
}

mostrar_intervalo(1,3);
