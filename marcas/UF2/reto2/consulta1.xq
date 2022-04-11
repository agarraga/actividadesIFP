let $libros:= doc("reto2UF2.xml")/libros/libro
for $libro in $libros
order by $libro/nombre descending
return
<infoautor>{$libro//autor/text()}({$libro/nombre/text()})</infoautor>