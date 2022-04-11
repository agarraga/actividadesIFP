let $libros:= doc("reto2UF2.xml")/libros/libro
for $libro in $libros
order by $libro/paginas ascending
return
if ($libro//autor!='Autor 1') then
(
<infolibro>{$libro/nombre/text()}<info>{$libro//sinopsis/text()}</info></infolibro>
) 
else
(
<infolibro>{$libro/nombre/text()}</infolibro>
