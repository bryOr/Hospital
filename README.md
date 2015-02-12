# HOSPITALES
===

**Supongamos que el ministerio de salud desea mantener un sistema de informacion relativoa a Hospitales.**

---

Se toma en cuenta las siguientes caracteristicas:

1. Cada hospital, se registra con un codigo, que lo identifica, nombre, direccion, telefono, cantidad de camas. Cada hospital tiene varias salas. Cada una de ellas pertenece a un solo hospital. En distintos hospitales puede haber salas con el mismo codigo, pero esto no puede ocurrir dentro de un hospital. Algunos usuarios requieren la zona de ubicacion del hospital para dirigirse al mas cercano.
2. Las Salas, tienen lo siguientes datos: Codigo, nombre, cantidad de camas.
3. De los mmedicos se registran su cedula de identidad, nombre, especialidad. Cada medico trabaja en un unico hospital.
4. Los laboratorios deben tener los datos: codigo, que lo identifica, nombre, direccion y telefono. Cada hospital trabaja con muchos laboratorios, y un laboratorio presta servicios a mas de un hospital. Es de real interes conocer la descripcion de cada servicio y la fecha en que se realizo.
5. De los pacientes, se debe registrar: cedula de identidad, numero de registro del hospital, nombre, numero de cama, direccion, fecha de nacimiento, sexo. Un paciente puede estar internado en una unica sala. Cada paciente puede ser atendido por mas de un medico y a su vez cada medico atendera varios pacientes. Interesa saber mas sobre el conocimiento de las fechas en las atenciones.
6. De los diagnosticos se requiere guardar un codigo, el tipo y las complicaciones. Ademas se sabe que cada paciente puede tener varios diagnosticos. Interesa saber tambien la fecha en que se realizo cada uno.
