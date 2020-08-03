/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TheLostFloyd
 */

import java.util.*;
import java.sql.*;

/*Esta clase va a representar todas las operaciones que se pueden realizar con
el alumno, dentro del programa, para poder establecer los metodosy/o operaciones
conforme al encapsulamiento
*/
public class acciones_alumno {
    //Clase conexion
    public static Connection getConnection(){
        String url, user, password;
        //Establecemos la ruta donde esta la bd
        url = "jdbc:mysql:3306/localhost/Alumnos";
        user = "root";
        password = "brandon1234";
        
        //creamos el objeto de conexion
        Connection con = null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            //Esteblecemos la conexion
            
            con = DriverManager.getConnection(url, user, password);
            //Responde si sí se conecto:
            System.out.println("Si se conecto la bd");
            
        }catch(Exception e){
           System.out.println("No se conecto la base de datos");
           System.out.println(e.getMessage());
           System.out.println(e.getStackTrace());
        }
        
        return con;
    }    


//guardar nuevo alumno

   public static int Guardar_alumno(Alumno a){
       int estatus = 0;
       try{
           //crear primero la conexion
           Connection con = acciones_alumno.getConnection();
           //creo querry
           String q = "insert into Alumnos (nom_alu, pass_alu, email_alu, pais_alu)"
                   +"values (?,?,?,?)";
           
           //obtener los elementos
           PreparedStatement ps = con.prepareStatement(q);
           //obtenemos los elementos obtenidos de la tabla alumno get y set
           ps.setString(1, a.getNombre());
           ps.setString(2, a.getPassword());
           ps.setString(3, a.getEmail());
           ps.setString(4, a.getPais());
           
           //ejecuto la querry
           estatus = ps.executeUpdate();
           
           //cerramos conexion
           con.close();
           
           System.out.println("Registro existoso");
          
           
           
       }catch(Exception e){
           System.out.println("No se encontro la tabla");
           System.out.println(e.getMessage());
           System.out.println(e.getStackTrace());
       }
       
       return estatus;
}
   

//editar datos de alumno
   public static int Actualizar_alumno(Alumno a){
       int estatus = 0;
       try{
           //crear primero la conexion
           Connection con = acciones_alumno.getConnection();
           //creo querry
           String q = "update Alumnos set nom_alu = ?"
                   +"pass_alu = ?"
                   +"email_alu = ?"
                   +"pais_alu= ? "
                   +"where id_alu = ?";
           
           //obtener los elementos
           PreparedStatement ps = con.prepareStatement(q);
           //obtenemos los elementos obtenidos de la tabla alumno get y set
           ps.setString(1, a.getNombre());
           ps.setString(2, a.getPassword());
           ps.setString(3, a.getEmail());
           ps.setString(4, a.getPais());
           ps.setInt(5, a.getId());
           
           //ejecuto la querry
           estatus = ps.executeUpdate();
           
           //cerramos conexion
           con.close();
           
           System.out.println("Registro existoso");
          
           
           
       }catch(Exception e){
           System.out.println("No se encontro la tabla");
           System.out.println(e.getMessage());
           System.out.println(e.getStackTrace());
       }
       
       return estatus;
}
   

//borrar un alumno
   public static int Borrar_alumno(int id){
       int estatus = 0;
       try{
           //crear primero la conexion
           Connection con = acciones_alumno.getConnection();
           //creo querry
           String q = "delete from Alumnos where id_alu = ?";
           //Si fuera procedimiento almacenado q = "call_borrarlu(?)"
           
           //obtener los elementos
           PreparedStatement ps = con.prepareStatement(q);
           //obtenemos los elementos obtenidos de la tabla alumno get y set
           ps.setInt(1, id);
           //ejecuto la querry
           estatus = ps.executeUpdate();
           
           //cerramos conexion
           con.close();
           
           System.out.println("Eliminacion Exitosa");
          
           
           
       }catch(Exception e){
           System.out.println("No se encontro la tabla");
           System.out.println(e.getMessage());
           System.out.println(e.getStackTrace());
       }
       
       return estatus;
}

   
//consultar alumno por id
   public static Alumno getAlumnoById(int id){
       Alumno a = new Alumno();
       try{
           //crear primero la conexion
           Connection con = acciones_alumno.getConnection();
           //creo querry
           String q = "select *from Alumnos where id_alu = ?";
           
           //obtener los elementos
           PreparedStatement ps = con.prepareStatement(q);
           //obtenemos los elementos obtenidos de la tabla alumno get y set
           ps.setInt(1, id);
           
           //ejecuto la consulta de querry
           ResultSet rs = ps.executeQuery();
           
           //buscar alumno por id
           if(rs.next()){
               //Obtiene los elementos de tabla a partit de mi objeto
               a.setId(rs.getInt(1));
               a.setNombre(rs.getString(2));
               a.setPassword(rs.getString(3));
               a.setEmail(rs.getString(4));
               a.setPais(rs.getString(5));
           }
           
           
           //cerramos conexion
           con.close();
           
           System.out.println("Registro existoso");
          
           
           
       }catch(Exception e){
           System.out.println("No se encontro la tabla");
           System.out.println(e.getMessage());
           System.out.println(e.getStackTrace());
       }
       
       return a;
}
   

//consulta general de alumno
   
   public static List<Alumno> getAllAlumnos(){
       List<Alumno> lista = new ArrayList<Alumno>();
       
       try{
           //crear primero la conexion
           Connection con = acciones_alumno.getConnection();
           //creo querry
           String q = "select *from Alumnos";
           
           //obtener los elementos
           PreparedStatement ps = con.prepareStatement(q);
           //obtenemos los elementos obtenidos de la tabla alumno get y set
           
           
           //ejecuto la consulta de querry
           ResultSet rs = ps.executeQuery();
           
           //obtener lista por tabla
           while(rs.next()){
               Alumno a = new Alumno();
               //Obtiene los elementos de tabla a partit de mi objeto
               a.setId(rs.getInt(1));
               a.setNombre(rs.getString(2));
               a.setPassword(rs.getString(3));
               a.setEmail(rs.getString(4));
               a.setPais(rs.getString(5));
               lista.add(a);
           }
           
           
           //cerramos conexion
           con.close();
           
           System.out.println("Registro existoso");
          
           
           
       }catch(Exception e){
           System.out.println("No se encontro la tabla");
           System.out.println(e.getMessage());
           System.out.println(e.getStackTrace());
       }
       
       return lista;
}
   
}