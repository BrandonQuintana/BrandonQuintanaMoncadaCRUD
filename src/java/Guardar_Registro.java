/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TheLostFloyd
 */
public class Guardar_Registro extends HttpServlet {

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
            
            
            //obtener los parametros que vienen por parte del formulario
            String nom, pass, email, pais;
            
            //debo obtener la solicitud (request) de esos parametros
            
            nom = request.getParameter("nombre");
            pass = request.getParameter("password");
            email = request.getParameter("email");
            pais = request.getParameter("pais");
            
            //necesito un objeto de alumno
            
            Alumno a = new Alumno();
            
            //enviar los datos de los parametros a la clase alumno
            a.setNombre(nom);
            a.setPassword(pass);
            a.setEmail(email);
            a.setPais(pais);
            
            //ejecutar el metodo para insertarlo
            int estatus = acciones_alumno.Guardar_alumno(a);
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alumno registrado</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if(estatus > 0){
            
            out.println("<h1>Alumno Registrado con exito</h1>");
            
            }else{
           
             out.println("<h1>No se pudo registrar el alumno</h1>");
                
            }
             out.println("<a href='index.html' >Regresar al menu principal</a>");
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