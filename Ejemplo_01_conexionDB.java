/*
Este es un sencillo ejemplo para establecer una conexi�n con una base de datos
a trav�s de la API JDBC. Una vez creada la base de datos necesitamos saber cual
es el controlador y la URL de de esta.
Controlador -> "org.apache.derby.jdbc.EmbeddedDriver"
URL -> "jdbc:derby://localhost:1527/ejemploDB;create=true"
La forma para conectarse consiste en cargar el controlador en memoria a trav�s del
m�todo 'forName� de la clase 'Class' y a continuaci�n establecer la conexi�n mediante 
un objeto de la clase Connection
Excepciones:
ClassNotFoundException -> Lanzada por el m�todo 'forName' de la clase 'Class"
SQLException -> Lanzada por la clase Connection
*/
package Java_derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo_01_conexionDB {
    
   static final String DRIVER = ("org.apache.derby.jdbc.EmbeddedDriver"); 
   static final String URL = ("jdbc:derby://localhost:1527/ejemploDB;create=true");
   
   public static void main(String[] args){
       
       Connection cn = null;    //Clase Connection para manejar la conexi�n cnn la DDBB
       //Conectar con la DDBB
       try{
           //Carga del driver
           Class.forName(DRIVER);
           //Establece la conexi�n cn la DDBB
           cn = DriverManager.getConnection(URL);
           System.out.println("Conexion establecida con la bases de datos");
           
           //Cierre de la conexion
           cn.close();
       }
       catch(ClassNotFoundException ex){ System.out.println(ex.getMessage()); }
       catch(SQLException ex){ System.out.println(ex.getMessage()); }
    
   }//Fin main
} //Fin clase

/*
    En 4 pasos:
    1 - Cargar el Controlador para Java DB 
    3 - Establecer la conexion a trav�s de un objeto Connection
    3 - Crear objeto Statement a trav�s del cual se realizar�n las consultas
    4 - Objeto ResultSet para obtener resultado de la consulta
*/