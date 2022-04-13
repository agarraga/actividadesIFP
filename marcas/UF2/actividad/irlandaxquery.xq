doc("irlanda.xml")/pais/coordenadas/latitud/text(),
doc("irlanda.xml")/pais/coordenadas/longitud/text(),
let $fotografias := doc("irlanda.xml")/pais/fotografias/fotografia
for $fotografia in $fotografias
    return
    <ul>
    <li>{$fotografia/nombre/text()}</li>
    <li>{$fotografia/descripcion/text()}</li>
    </ul>,
let $fotgrafias := doc("irlanda.xml")/pais/fotografias/fotografia
for $fotografia in $fotgrafias
    where $fotografia/url = ""
    return
    $fotografia
