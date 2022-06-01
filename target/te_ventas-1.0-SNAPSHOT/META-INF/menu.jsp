<%
    String opcion = request.getParameter("opcion");
%>

<ul class="nav nav-tabs">
    
    <li class="nav-item">
        <a class="nav-link <%=  (opcion.equals("clientes")) ? "active" : "" %>" href="ClienteControlador">Participantes</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%=  (opcion.equals("ventas")) ? "active" : "" %>" href="VentaControlador">Seminarios</a>
    </li>
</ul>

