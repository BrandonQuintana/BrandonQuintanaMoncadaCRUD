/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TheLostFloyd
 */
public class Consultar_Lista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //quiero poder ver toda la lista de alumnos, en pocas palabras
            //ocupar el metodo getAllAlumnos()
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista General de Alumnos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista General de Alumnos</h1>"
                    + "<br>"
                    + "<a href='index.html' >Regresar al menu principal</a>"
                    + "<br>"
                    + "<a href='Guardar_Registro' >Guardar Nuevo Alumno</a>");
            
            //obtener una lista de los alumnos
            List<Alumno> lista = acciones_alumno.getAllAlumnos();
            
            //dibujamos una tabla para mostrarlos
            out.println("<table border ='1'>");
            out.println("<tr>"
                    + "<th>ID</th>"
                    + "<th>Nombre</th>"
                    + "<th>Password</th>"
                    + "<th>Email</th>"
                    + "<th>Pais</th>"
                    + "</tr>");
            
            //tenemos que recorrer el tamaño de la tabla y obtener sus elementos
            for(Alumno a : lista){
                out.println("<tr>"
                        + "<td>"+a.getId()+"</td>"
                        + "<td>"+a.getNombre()+"</td>"
                        + "<td>"+a.getPassword()+"</td>"
                        + "<td>"+a.getEmail()+"</td>"
                        + "<td>"+a.getPais()+"</td>"
                        + "<td><a href='Editar_datos?id="+a.getId()+"' >Editar Datos del Alumno</a></td>"
                        + "<td><a href='Eliminar_datos?id="+a.getId()+"' >Eliminar Alumno</a></td>"
                        + "</tr>");
            }
            
            
            out.println("</table>");
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}