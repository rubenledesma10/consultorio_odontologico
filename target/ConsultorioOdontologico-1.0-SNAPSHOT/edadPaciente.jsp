<%-- 
    Document   : edadPaciente
    Created on : 8 sep. 2023, 16:34:11
    Author     : ledes
--%>

<%@page import="logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="components/header.jsp"%>
<%@include file="components/bodyPrimeraParteUser.jsp"%>
<h1>Ingrese la fecha de nacimiento del paciente</h1>
<%Odontologo odonto = (Odontologo) request.getSession().getAttribute("odoGet");%>
<form class="user" action="SvPacientes" method="POST">
    
    <div>
        <div class="col-sm-6 mb-3">
            <label for="exampleFormControlSelect1">Fecha nacimiento:</label>
            <input type="date" class="form-control form-control-user" name="fechanac"
                   placeholder="Fecha nacimiento" autocomplete="off">
        </div>
    </div> 
    
        <input type="hidden" name="id_odonto" value="<%=odonto.getId()%>">
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Dar  Turno
    </button>
</form>
<%@include file="components/bodyfinal.jsp"%>
