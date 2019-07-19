package com.example.mapainteractivo.ConnBD;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String NOMBRE_BASE_DE_DATOS = "mapaescolar";

    private static final int VERSION_BASE_DE_DATOS = 1;

    public BaseDatos(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id text, nombre text, usuario text, contrasenia text, " +
                "tipousuario text, matricula text)", "usuarios"));
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id text, nombre text, desc text, latitud real, longitud real, " +
                "etiquetas text)", "edificios"));
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id text, idedificio integer, ruta text, desc text)", "fotos"));
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id text, idedificio integer, idevento integer)","deteventos"));
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id text, nombre text, desc text, fechai text, fechaf text)","eventos"));
        //db.execSQL("INSERT INTO HIPOTECA(_id, hip_nombre) VALUES(7,'Banco Popular')");

        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('1', 'Edificio T (Nuevo)', 'Aulas de Sistemas, TICs y laboratorios de redes.', 19.257016, -99.579539, '/edificios/T.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('2', 'Edificio B-1', 'Centro de computo.', 19.257679, -99.580574, '/edificios/B1-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('3', 'Edificio U', 'Aulas de Gestión y electrónica', 19.256826, -99.578848, '/edificios/U.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('4', 'Edificio A', 'Edificio Administrativo', 19.257391, -99.577843, '/edificios/A-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('5', 'Edificio A-1', 'Sanitarios alumnos', 19.256695, -99.578215, '/edificios/A1-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('6', 'Edificio B', 'Centro de Información', 19.257182, -99.578474, '/edificios/B-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('7', 'Edificio B-3', 'Posgrado en Investigación', 19.257587, -99.58118, '/edificios/B3-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('8', 'Edificio C-1', 'Unidad de apoyo tutorial (UAT) y orientación educativa', 19.257453, -99.578903, '/edificios/C1-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('9', 'Edificio C-2', 'Desarrollo académico y división de estudios profesionales', 19.257199, -99.57883, '/edificios/C2-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('10', 'Edificio C-3', 'Centro de enseñanza de lenguas extranjeras, sala de titulación', 19.257136, -99.579029, '/edificios/C3-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('12', 'Edificio K', 'Gestión tecnológica y vinculación, laboratorio de métodos, taller mecánico, centro de convenciones, y sala audiovisual', 19.25527, -99.578107, '/edificios/K-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('13', 'Edificio X', 'Servicios Escolares, Servicio médico y servicios estudiantiles', 19.256857, -99.577768, '/edificios/X-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('14', 'Edificio B-2', 'Aulas de ingeniería industrial.', 19.257092, -99.580378, '/edificios/B2-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('15', 'Edificio E', 'Aulas de electrónica', 19.256652, -99.578517, '/edificios/E.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('16', 'Edificio F', 'Ciencias básicas, laboratorio de física y laboratorio de sistemas', 19.256324, -99.578505, '/edificios/F-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('17', 'Edificio M', 'Aulas de electromecánica', 19.256009, -99.578166, '/edificios/M-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('18', 'Edificio P', 'Aulas de ingeniería química y CESA', 19.25642, -99.578028, '/edificios/P-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('19', 'Edificio Q', 'Aulas de ingeniería Química', 19.256687, -99.577878, '/edificios/Q-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('20', 'Edificio V', 'Departamento de ciencias económico-administrativas, cubículos de profesores', 19.256492, -99.578888, '/edificios/V.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('21', 'Edificio Y', 'Aulas de gestión empresarial', 19.256617, -99.579078, '/edificios/Y.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('22', 'Edificio D-3', 'Ingeniería mecatrónica', 19.254593, -99.579044, '/edificios/D3-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('23', 'Edificio B-4', 'Ingeniería logística y subdirección académica', 19.256781, -99.580164, '/edificios/B4-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('24', 'Edificio B-5', 'Laboratorio de ingeniería ambiental', 19.257076, -99.58122, '/edificios/B5-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('25', 'Edificio D', 'Jefatura y cubículos de ingeniería química', 19.255921, -99.577738, '/edificios/D-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('26', 'Edificio D-1', 'Jefatura y laboratorio de ingeniería electrónica', 19.254346, -99.578242, '/edificios/D1-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('27', 'Edificio G', 'Laboratorio de Análisis, sindicato', 19.256111, -99.578652, '/edificios/G.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('28', 'Edificio Z', 'Aulas gestión empresarial', 19.256616, -99.579077, '/edificios/Z.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('29', 'Edificio J', 'Laboratorio de química', 19.254898, -99.578514, '/edificios/J-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('30', 'Edificio N', 'Laboratorio de análisis y microbiología', 19.256206, -99.577856, '/edificios/N-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('31', 'Edificio R', 'Almacén general y departamento de mantenimiento', 19.254597, -99.577947, '/edificios/R-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('32', 'Edificio S', 'Laboratorios de Ingeniería electromecánica', 19.254889, -99.578534, '/edificios/S-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('33', 'Edificio H', 'Cafetería', 19.255763, -99.578642, '/edificios/H.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('34', 'Edificio O', 'Jefatura de Ingeniería electromecánica, cubículos, actividades extraescolares', 19.255281, -99.578664, '/edificios/O.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('35', 'Edificio T ', 'Gimnasio, auditorio y alberca', 19.257502, -99.579735, '/edificios/T-1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('36', 'C. D 1', 'Campo deportivo', 19.255611, -99.579724, '/edificios/CD1.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('37', 'C. D 1a', 'Campo deportivo', 19.255796, -99.580889, '/edificios/CD1A-2.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('38', 'C.D 2', 'Campo deportivo', 19.2574311, -99.5832864, '/edificios/CD2-3.jpg')"));
        db.execSQL(String.format("INSERT INTO edificios (id, nombre, desc, latitud, longitud, etiquetas) VALUES ('39', 'Edificio G-1, G-2', 'Gradas, vestidores y actividades extraescolares', 19.2553474, -99.5807856, '/edificios/G1-1.jpg')"));

        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('2', '36', '/edificios/CD1.jpg', 'Campo deportivo')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('3', '15', '/edificios/E.jpg', 'Edificio E')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('4', '27', '/edificios/G.jpg', 'Edificio G')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('5', '27', '/edificios/G2.jpg', 'Edificio G')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('6', '33', '/edificios/H.jpg', 'Edificio H')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('7', '34', '/edificios/O.jpg', 'Edificio O')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('8', '1', '/edificios/T.jpg', 'Edificio T')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('9', '1', '/edificios/T1.jpg', 'Edificio T')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('10', '3', '/edificios/U.jpg', 'Edificio U')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('11', '3', '/edificios/U1.jpg', 'Edificio U')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('12', '3', '/edificios/U3.jpg', 'Edificio U')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('13', '20', '/edificios/V.jpg', 'Edificio V')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('14', '21', '/edificios/Y.jpg', 'Edificio Y')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('15', '21', '/edificios/Y1.jpg', 'Edificio Y')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('16', '21', '/edificios/Y2.jpg', 'Edificio Y')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('17', '21', '/edificios/Y3.jpg', 'Edificio Y')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('18', '28', '/edificios/Z.jpg', 'Edificio Z')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('19', '28', '/edificios/Z1.jpg', 'Edificio Z')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('20', '28', '/edificios/Z2.jpg', 'Edificio Z')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('21', '4', '/edificios/A-1.jpg', 'Edificio A')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('22', '5', '/edificios/A1-1.jpg', 'Edificio A-1')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('23', '5', '/edificios/A1-2.jpg', 'Edificio A-1')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('24', '5', '/edificios/A1-3.jpg', 'Edificio A-1')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('25', '4', '/edificios/A-2.jpg', 'Edificio A')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('26', '4', '/edificios/A-3.jpg', 'Edificio A')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('27', '6', '/edificios/B-1.jpg', 'Edificio B')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('28', '6', '/edificios/B-2.jpg', 'Edificio B')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('29', '6', '/edificios/B-3.jpg', 'Edificio B')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('30', '2', '/edificios/B1-1.jpg', 'Edificio B-1')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('31', '2', '/edificios/B1-2.jpg', 'Edificio B-1')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('32', '2', '/edificios/B1-3.jpg', 'Edificio B-1')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('33', '14', '/edificios/B2-1.jpg', 'Edificio B-2')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('34', '14', '/edificios/B2-2.jpg', 'Edificio B-2')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('35', '14', '/edificios/B2-3.jpg', 'Edificio B-2')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('36', '7', '/edificios/B3-1.jpg', 'Edificio B-3')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('37', '7', '/edificios/B3-2.jpg', 'Edificio B-3')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('38', '7', '/edificios/B3-3.jpg', 'Edificio B-3')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('39', '23', '/edificios/B4-1.jpg', 'Edificio B-4')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('40', '23', '/edificios/B4-2.jpg', 'Edificio B-4')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('41', '23', '/edificios/B4-3.jpg', 'Edificio B-4')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('42', '24', '/edificios/B5-1.jpg', 'Edificio B-5')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('43', '24', '/edificios/B5-2.jpg', 'Edificio B-5')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('44', '24', '/edificios/B5-3.jpg', 'Edificio B-5')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('45', '8', '/edificios/C1-1.jpg', 'Edificio C-1')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('46', '8', '/edificios/C1-2.jpg', 'Edificio C-1')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('47', '8', '/edificios/C1-3.jpg', 'Edificio C-1')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('48', '9', '/edificios/C2-1.jpg', 'Edificio C-2')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('49', '9', '/edificios/C2-2.jpg', 'Edificio C-2')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('50', '9', '/edificios/C2-3.jpg', 'Edificio C-2')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('51', '10', '/edificios/C3-1.jpg', 'Edificio C-3')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('52', '10', '/edificios/C3-2.jpg', 'Edificio C-3')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('53', '10', '/edificios/C3-3.jpg', 'Edificio C-3')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('54', '37', '/edificios/CD1A-1.jpg', 'Campo deportivo')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('55', '37', '/edificios/CD1A-2.jpg', 'Campo deportivo')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('56', '37', '/edificios/CD1A-3.jpg', 'Campo deportivo')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('57', '38', '/edificios/CD2-1.jpg', 'Campo deportivo')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('58', '38', '/edificios/CD2-2.jpg', 'Campo deportivo')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('59', '38', '/edificios/CD2-3.jpg', 'Campo deportivo')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('60', '25', '/edificios/D-1.jpg', 'Edificio D')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('61', '25', '/edificios/D-2.jpg', 'Edificio D')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('62', '25', '/edificios/D-3.jpg', 'Edificio D')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('63', '26', '/edificios/D1-1.jpg', 'Edificio D-1')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('64', '26', '/edificios/D1-2.jpg', 'Edificio D-1')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('65', '26', '/edificios/D1-3.jpg', '')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('66', '22', '/edificios/D3-1.jpg', 'Edificio D-3')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('67', '22', '/edificios/D3-2.jpg', 'Edificio D-3')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('68', '22', '/edificios/D3-3.jpg', 'Edificio D-3')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('69', '15', '/edificios/E-1.jpg', 'Edificio E')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('70', '15', '/edificios/E-2.jpg', 'Edificio E')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('71', '15', '/edificios/E-3.jpg', 'Edificio E')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('72', '16', '/edificios/F-1.jpg', 'Edificio F')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('73', '16', '/edificios/F-2.jpg', 'Edificio F')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('74', '16', '/edificios/F-3.jpg', 'Edificio F')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('75', '27', '/edificios/G-1.jpg', 'Edificio G')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('76', '39', '/edificios/G1-1.jpg', 'Edificio G-1, G-2')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('77', '39', '/edificios/G1-2.jpg', 'Edificio G-1, G-2')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('78', '39', '/edificios/G1-3.jpg', 'Edificio G-1, G-2')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('79', '39', '/edificios/G1-4.jpg', 'Edificio G-1, G-2')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('80', '33', '/edificios/H-2.jpg', 'Edificio H')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('81', '33', '/edificios/H-3.jpg', 'Edificio H')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('82', '29', '/edificios/J-1.jpg', 'Edificio J')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('83', '29', '/edificios/J-2.jpg', 'Edificio J')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('84', '29', '/edificios/J-3.jpg', 'Edificio J')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('85', '12', '/edificios/K-1.jpg', 'Edificio K')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('86', '12', '/edificios/K-2.jpg', 'Edificio K')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('87', '12', '/edificios/K-3.jpg', 'Edificio K')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('88', '12', '/edificios/K-4.jpg', 'Edificio K')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('89', '17', '/edificios/M-1.jpg', 'Edificio M')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('90', '17', '/edificios/M-2.jpg', 'Edificio M')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('91', '17', '/edificios/M-3.jpg', 'Edificio M')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('92', '30', '/edificios/N-1.jpg', 'Edificio N')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('93', '30', '/edificios/N-2.jpg', 'Edificio N')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('94', '30', '/edificios/N-3.jpg', 'Edificio N')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('95', '34', '/edificios/O-1.jpg', 'Edificio O')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('96', '34', '/edificios/O-2.jpg', 'Edificio O')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('97', '34', '/edificios/O-3.jpg', 'Edificio O')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('98', '18', '/edificios/P-1.jpg', 'Edificio P')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('99', '18', '/edificios/P-2.jpg', 'Edificio P')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('100', '18', '/edificios/P-3.jpg', 'Edificio P')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('101', '19', '/edificios/Q-1.jpg', 'Edificio Q')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('102', '19', '/edificios/Q-2.jpg', 'Edificio Q')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('103', '19', '/edificios/Q-3.jpg', 'Edificio Q')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('104', '31', '/edificios/R-1.jpg', 'Edificio R')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('105', '31', '/edificios/R-2.jpg', 'Edificio R')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('106', '31', '/edificios/R-3.jpg', 'Edificio R')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('107', '32', '/edificios/S-1.jpg', 'Edificio S')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('108', '32', '/edificios/S-2.jpg', 'Edificio S')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('109', '32', '/edificios/S-3.jpg', 'Edificio S')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('110', '1', '/edificios/T2.jpg', 'Edificio T')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('111', '35', '/edificios/T-1.jpg', 'Edificio T')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('112', '35', '/edificios/T-2.jpg', 'Edificio T')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('113', '35', '/edificios/T-3.jpg', 'Edificio T')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('114', '20', '/edificios/V-1.jpg', 'Edificio V')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('115', '13', '/edificios/X-1.jpg', 'Edificio X')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('116', '13', '/edificios/X-2.jpg', 'Edificio X')"));
        db.execSQL(String.format("INSERT INTO fotos (id, idedificio, ruta, desc) VALUES ('117', '13', '/edificios/X-3.jpg', 'Edificio X')"));






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}


