<%-- 
    Document   : altas
    Created on : 29 ago. 2023, 11:33:35
    Author     : ledes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>
<h1>Alta Odontólogos</h1>
<form class="user" action="SvAltaOdonto" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreOdonto"
                   placeholder="Nombre" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellidoOdonto"
                   placeholder="Apellido" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni"
                   placeholder="DNI" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefono"
                   placeholder="Teléfono" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccionOdonto"
                   placeholder="Dirección" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" name="fechanac"
                   placeholder="Fecha nacimiento" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="especialidad"
                   placeholder="Especiliadad" autocomplete="off">
        </div>
        <%-- aca va a ir todo lo que respecta a horarios y usuario --%>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="horario_inicio"
                   placeholder="Horario entrada" autocomplete="off">
        </div> 
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="horario_fin"
                   placeholder="Horario Salida" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombreUsuario"
                   placeholder="Nombre Usuario" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" name="contrasenia"
                   placeholder="Contraseña" autocomplete="off">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="hidden" class="form-control form-control-user" name="rol" value="odonto">
        </div> <!-- esto es para que directamente el rol se mande como odontologo -->
    </div>
    <button type="submit" class="btn btn-primary btn-user btn-block">
        Crear Odontólogo
    </button>
</form>
<%@include file="components/bodyfinal.jsp"%>
