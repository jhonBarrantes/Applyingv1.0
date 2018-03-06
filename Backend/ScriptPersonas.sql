CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `nro_documento` varchar(25) DEFAULT NULL,
  `tipo_documento` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

CREATE TABLE `solicitud` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `institucion` varchar(45) DEFAULT NULL,
  `solicitante` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `persona` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

INSERT INTO `mydb`.`solicitud`
(`id`,
`nombre`,
`apellidos`,
`tipo_documento`,
`nro_documento`)
VALUES
(1,"Jhon",
"Barrantes",
"dni",
"57575469");

INSERT INTO `mydb`.`persona`
(`id`,
`nombre`,
`apellidos`,
`tipo_documento`,
`nro_documento`)
VALUES
(2,"Cesar",
"Cuba",
"dni",
"10739276");

INSERT INTO `mydb`.`solicitud`
(`id`,`institucion`,`solicitante`,`estado`,`persona`)
VALUES
(1,`Comisaria San Juan`,10,`REGISTRADO`,1);

INSERT INTO `mydb`.`solicitud`
(`id`,`institucion`,`solicitante`,`estado`,`persona`)
VALUES
(2,`Comisaria Miraflores`,11,`REGISTRADO`,1);

INSERT INTO `mydb`.`solicitud`
(`id`,`institucion`,`solicitante`,`estado`,`persona`)
VALUES
(3,`Comisaria Cercado`,12,`REGISTRADO`,2);

INSERT INTO `mydb`.`solicitud`
(`id`,`institucion`,`solicitante`,`estado`,`persona`)
VALUES
(4,`Comisaria Breña`,13,`REGISTRADO`,2);



