<%-- 
    Document   : editarOdontologo
    Created on : 2 sep. 2023, 12:28:29
    Author     : ledes
--%>

<%@page import="logica.Horario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Odontologo"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>
<h1>Editar Usuarios</h1>
<!-- cuando cargue esta pagina que nos traiga de la session los datos del usuario que nos manda a traves de la session -->
<%Odontologo odonto = (Odontologo) request.getSession().getAttribute("odoEdit");%>
<form class="user" action="SvEditOdonto" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreOdonto"
                   placeholder="Nombre" value="<%=odonto.getNombre()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellidoOdonto"
                   placeholder="Apellido" value="<%=odonto.getApellido()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni"
                   placeholder="DNI" value="<%=odonto.getDni()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefono"
                   placeholder="Telefono" value="<%=odonto.getTelefono()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccionOdonto"
                   placeholder="Direccion" value="<%=odonto.getDireccion()%>" autocomplete="off">
        </div>
        <% SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");%>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" name="fechanac"
                   value="<%= formato.format(odonto.getFecha_nac())%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="especialidad"
                   placeholder="Especialidad" value="<%=odonto.getEspecialidad()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="horario_inicio"
                   placeholder="Horario inicio" value="<%=odonto.getUnHorario().getHorario_inicio()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="horario_fin"
                   placeholder="Horario Fin" value="<%=odonto.getUnHorario().getHorario_fin()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreUsuario"
                   placeholder="Nombre Usuario" value="<%=odonto.getUnUsuario().getNombreUsuario()%>" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" name="contrasenia"
                   placeholder="Contraseña" value="<%=odonto.getUnUsuario().getContrasenia()%>" autocomplete="off">
        </div>
        <input type="hidden" name="id_usuario" value="<%=odonto.getUnUsuario().getId_usuario()%>">
        <input type="hidden" name="id_horario" value="<%=odonto.getUnHorario().getId_horario()%>">

    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar Odontologo Modificado
    </button>
</form>
<%@include file="components/bodyfinal.jsp"%>
