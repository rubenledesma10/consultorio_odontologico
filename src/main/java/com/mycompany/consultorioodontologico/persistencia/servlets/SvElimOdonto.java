package com.mycompany.consultorioodontologico.persistencia.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;

@WebServlet(name = "SvElimOdonto", urlPatterns = {"/SvElimOdonto"})
public class SvElimOdonto extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_odonto = Integer.parseInt(request.getParameter("id_odonto"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_horario = Integer.parseInt(request.getParameter("id_horario"));
        
        control.borrarOdonto(id_odonto);
        control.borrarHorario(id_horario);
        control.borrarUsuario(id_usuario);

        response.sendRedirect("SvAltaOdonto");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
