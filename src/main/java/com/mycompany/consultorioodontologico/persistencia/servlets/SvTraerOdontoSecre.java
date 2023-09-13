/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

/**
 *
 * @author ledes
 */
@WebServlet(name = "SvTraerOdontoSecre", urlPatterns = {"/SvTraerOdontoSecre"})
public class SvTraerOdontoSecre extends HttpServlet {

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
        response.sendRedirect("verOdonConHorarios.jsp");

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
