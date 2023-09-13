package com.mycompany.consultorioodontologico.persistencia.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Odontologo;
import logica.Turno;

@WebServlet(name = "SvOdontoPac", urlPatterns = {"/SvOdontoPac"})
public class SvOdontoPac extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_odonto = Integer.parseInt(request.getParameter("id_odonto"));
        
        Odontologo odonto = control.traerOdontologo(id_odonto);
        List<Turno> listaTurnos = new ArrayList<Turno>();
        listaTurnos = control.traerTurnos();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaTurnos", listaTurnos);
        misession.setAttribute("odoTraer",odonto );
        response.sendRedirect("verPacientesOdonto.jsp");
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
