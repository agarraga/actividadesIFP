INSERT INTO localidad (CodLoc, NomLoc, DesLoc)
    VALUES
    ('53095', 'Calavira de la Cabara', 'Un precioso escondite rural en la pradera de los Pronios.'),
    ('54695', 'Hempera Troscados', 'Una bellísima aldea abandonada con una flora única.'),
    ('67865', 'Nostremiaro', NULL),
    ('86734', 'Bormenia', NULL),
    ('77324', 'Vinera de los Alamos', 'Hogar del enigmatico Lorem Ipsum, visto rumeando por las noches de luna llena')
    RETURNING *
;

INSERT INTO Viaje (CodVi, NomVi, DurVi)
    VALUES
    ('E0012', 'Andanza Cabarala', '14'),
    ('T0512', 'Menolo Deslizante', '1'),
    ('H9832', 'Camino de la pradera', '6'),
    ('L6453', 'El cruze de Borenia', '3'),
    ('Y2345', 'El misterioso Lorem', '8')
    RETURNING *
;

INSERT INTO Hotel (CodHo, NomHo, CatHo, DesHo, CodHR)
    VALUES
    ('765', 'La gran Estrella', DEFAULT, 'Establecimiento de lujo situado en la pradera', NULL),
    ('311', 'Bali Hyatt', 5, 'Establecimiento de lujo situado en una bella playa de la isla', '456'),
    ('456', 'Carlton', 4, 'Establecimiento de lujo situado en otra bella playa de la isla', NULL),
    ('100', 'Proprema', DEFAULT, NULL, '765'),
    ('567', 'La Palea de Mar', 1, NULL, '765')
    RETURNING *
;

INSERT INTO Jornada (CodVi, NumJo, CodLP, CodLL, CodHo, KmtJo)
    VALUES
    ('E0012', 1, '53095', '54695', '100', 12),
    ('E0012', 2, '54695', '67865', '567', 3),
    ('T0512', 1, '67865', '67865', NULL, 1),
    ('Y2345', 6, '77324', '77324', '311', 34),
    ('Y2345', 7, '77324', '77324', '311', 43)
    RETURNING *
;
