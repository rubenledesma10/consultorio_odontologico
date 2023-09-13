<%-- 
    Document   : verOdontos
    Created on : 11 sep. 2023, 13:48:13
    Author     : ledes
--%>

<%@page import="logica.Turno"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Odontologo"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyOdonto.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Odontologos</h1>
    <p class="mb-4">A continuación podra visualizar la lista completa de odontologos</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Odontologos</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido</th>
                        </tr>
                    </thead>
                    <%-- antes de entrar al body hacemos la solicitud java para traer la lista de usuarios correspondiente
                        hacemos que de la solicitud que manda el servlet al jsp, que traigamos de ahi la session
                        de la session traemos el atributo que guardamos en el servlet y hacemos un casteo para que convierta lo que trae en una lista y lo va a gurdar en la lista
                    --%>
                    <%                       
                        List<Odontologo> listaOdonto = (List) request.getSession().getAttribute("listaOdonto");
                    %>
                    <tbody>
                        <% SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); %>
                        <%-- recorremos la lista a traves de un for y que nos vaya trayendo los datos --%>
                        <% for (Odontologo odonto : listaOdonto) {%>
                        <tr>
                            <td><%=odonto.getNombre()%></td>
                            <td><%=odonto.getApellido()%></td>
                            <td style="display:flex; width:230px">
                                <form name="editar" action="SvOdontoPac" method="GET"><!-<!-- esto es para mandar el codigo al servlet -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-user"></i>Ver Pacientes</button>  
                                        <input type="hidden" name="id_odonto" value="<%=odonto.getId()%>">
                                </form>
                            </td>
                        </tr>
                        <% }%>
                        
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="components/bodyfinal.jsp"%>

