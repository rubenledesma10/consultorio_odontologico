package com.mycompany.consultorioodontologico.persistencia.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Odontologo;

@WebServlet(name = "SvAltaOdonto", urlPatterns = {"/SvAltaOdonto"})
public class SvAltaOdonto extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Odontologo> listaOdonto = new ArrayList<Odontologo>();
        listaOdonto = control.traerListaOdontologos();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaOdonto", listaOdonto);
        response.sendRedirect("verOdontologos.jsp");
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nombreOdonto = request.getParameter("nombreOdonto");
            String apellidoOdonto = request.getParameter("apellidoOdonto");
            String dniOdonto = request.getParameter("dni");
            String telefonoOdonto = request.getParameter("telefono");
            String direccionOdonto = request.getParameter("direccionOdonto");
            Date fecha_nac = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechanac"));
            String especialidad = request.getParameter("especialidad");
            String horario_entrada = request.getParameter("horario_inicio");
            String horario_salida = request.getParameter("horario_fin");
            String nombreUsu = request.getParameter("nombreUsuario");
            String contrasenia = request.getParameter("contrasenia");
            String rol = request.getParameter("rol");
            control.crearOdonto(nombreOdonto, apellidoOdonto, dniOdonto, telefonoOdonto, direccionOdonto, fecha_nac,
                    especialidad, horario_entrada, horario_salida, nombreUsu, contrasenia, rol);
            response.sendRedirect("index.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SvAltaOdonto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
