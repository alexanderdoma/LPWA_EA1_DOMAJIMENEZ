<%@page import="bean.Cine"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8"%>

<br/><h1>Nuestros Cines</h1><br/>

<%
	List<Cine> listCine = (List<Cine>) session.getAttribute("data");
	for(Cine cine : listCine){
%>



<div class="contenido-cine">
	<img src="img/cine/<%= cine.getId() %>.1.jpg" width="227" height="170"/>
	<div class="datos-cine">
		<h4><%= cine.getRazonSocial() %></h4><br/>
		<span><%= cine.getDireccion() %><br/><br/><%= cine.getTelefonos()%></span>
	</div>
	<br/>
	<a href="svlCine?idCine=<%= cine.getId()%>&&id=buscarCine">
	<img src="img/varios/ico-info2.png" width="150" height="40"/>
	</a>
</div>
<div class="clearbox"><br/></div>
<%}%>