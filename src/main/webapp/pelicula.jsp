<%@page import="bean.Pelicula"%>
<%@page pageEncoding="UTF-8"%>

<br/><h1>Información</h1><br/>

<%	
Pelicula objPelicula = (Pelicula) session.getAttribute("data");
%>
<div class="contenido-interno" id="contenido-interno">
<br/><h1>8</h1><br/>
<div class="contenido-pelicula">
	<div class="datos-pelicula">
		<h2><%= objPelicula.getTitulo() %></h2>
		<p><%= objPelicula.getSinopsis() %></p>
		<br/>
		<div class="tabla">
			<div class="fila">
				<div class="celda-titulo">Título Original :</div>
				<div class="celda"><%= objPelicula.getTitulo() %></div>
			</div>
			<div class="fila">
				<div class="celda-titulo">Estreno :</div>
				<div class="celda"><%= objPelicula.getFechaEstreno() %></div>
			</div>
			<div class="fila">
				<div class="celda-titulo">Género :</div>
				<div class="celda"><%objPelicula.getGeneros();%></div>
			</div>
			<div class="fila">
				<div class="celda-titulo">Director :</div>
				<div class="celda"><%= objPelicula.getDirector() %></div>
			</div>
			<div class="fila">
				<div class="celda-titulo">Reparto :</div>
				<div class="celda"><%= objPelicula.getReparto()%></div>
			</div>
		</div>
	</div>
	<img src="img/pelicula/<%= objPelicula.getId()%>.jpg" width="160" height="226"><br/><br/>
</div>
<div class="pelicula-video">
	<!-- <iframe width="580" height="400" src="http://www.youtube.com/v/6maujJFcuxA" frameborder="0" allowfullscreen></iframe> -->
		<embed src="http://www.youtube.com/v/6maujJFcuxAfs" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" width="580" height="400">
	</div>

</div>
