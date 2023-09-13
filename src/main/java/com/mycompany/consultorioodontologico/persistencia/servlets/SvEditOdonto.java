package com.mycompany.consultorioodontologico.persistencia.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Horario;
import logica.Odontologo;
import logica.Persona;
import logica.Usuario;

@WebServlet(name = "SvEditOdonto", urlPatterns = {"/SvEditOdonto"})
public class SvEditOdonto extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_odonto = Integer.parseInt(request.getParameter("id_odonto"));
        Odontologo odonto = control.traerOdontologo(id_odonto);
        HttpSession misession = request.getSession();
        misession.setAttribute("odoEdit", odonto);

        response.sendRedirect("editarOdontologo.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String nombreOdonto = request.getParameter("nombreOdonto");
            String apellidoOdonto = request.getParameter("apellidoOdonto");
            String dni = request.getParameter("dni");
            String telefono = request.getParameter("telefono");
            String direccionOdonto = request.getParameter("direccionOdonto");
            Date fechanac = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechanac"));
            String especialidad = request.getParameter("especialidad");
            String horario_inicio = request.getParameter("horario_inicio");
            String horario_fin = request.getParameter("horario_fin");
            String nombreUsuario = request.getParameter("nombreUsuario");
            String contrasenia = request.getParameter("contrasenia");
            String rol = request.getParameter("rol");

            int id_horario = Integer.parseInt(request.getParameter("id_horario"));
            Horario horario = control.traerHorario(id_horario);
            horario.setHorario_inicio(horario_inicio);
            horario.setHorario_fin(horario_fin);
            
            int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
            Usuario usu = control.traerUsuario(id_usuario);
            usu.setNombreUsuario(nombreUsuario);
            usu.setContrasenia(contrasenia);
            
            Odontologo odon = (Odontologo) request.getSession().getAttribute("odoEdit");
            odon.setNombre(nombreOdonto);
            odon.setApellido(apellidoOdonto);
            odon.setDni(dni);
            odon.setTelefono(telefono);
            odon.setDireccion(direccionOdonto);
            odon.setFecha_nac(fechanac);
            odon.setEspecialidad(especialidad);
            
            
            control.editarOdonto(horario, odon, usu);
            response.sendRedirect("SvAltaOdonto");

        } catch (ParseException ex) {
            Logger.getLogger(SvEditOdonto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
