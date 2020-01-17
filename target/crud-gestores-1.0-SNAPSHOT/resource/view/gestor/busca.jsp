<%-- 
    Document   : busca
    Created on : 15/01/2020, 16:20:30
    Author     : nando
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Gestor"%>
<%@page import="model.dao.GestorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestores | Busca</title>        
        <script src="../../assets/jquery/jquery-3.4.1.js"></script>
        <script src="../../assets/jquery/popper.min.js"></script>
        <script src='../../assets/js/sweetalert.js'></script>
        <script src="../../assets/bootstrap/js/bootstrap.js"></script>
        <link href="../../assets/bootstrap/css/bootstrap.css" rel="stylesheet">        
        <link href="../../assets/css/custom.css" rel="stylesheet">        
        <link rel="icon" href="/crud-gestores/favicon.png">
    </head>
    <body>        
        <%@include file="../menu.jsp" %>
        <div class="container">
            <br>
            <div class="row col-12 justify-content-between">
                <h2>Resultado da busca</h2>
                <a class="btn btn-success btn-lg" href="/crud-gestores/resource/view/gestor/novo.jsp">Novo</a>
            </div>
            <br>
            <p></p>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Data de Nascimento</th>
                        <th scope="col">Matricula</th>
                        <th scope="col">Setor</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <%  
                        GestorDAO dao = new GestorDAO();
                        ArrayList<Gestor> lista = new ArrayList();
                        lista = dao.pesquisar(request.getParameter("por"));
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        for(Gestor gestor:lista){                       
                                out.print("<tr>");
                                out.print("<th scope='row'>" + gestor.getNome() + "</th>");
                                out.print("<td>" + sdf.format(gestor.getData_nascimento()) + "</td>");
                                out.print("<td>" + gestor.getMatricula()+ "</td>");
                                out.print("<td>" + gestor.getSetor() + "</td>");
                                out.print("<td><form id='form-delete-"+ gestor.getId() +"' action='/crud-gestores/gestorServlet.do?id=" + gestor.getId() + "&action=deletar' method='post'><input type='button' class='btn btn-danger' value='Apagar' onclick='really(" + gestor.getId() + ")'></form></td>");
                                out.print("<td><form action='/crud-gestores/resource/view/gestor/editar.jsp?id=" + gestor.getId() + "' method='post'><input type='submit' class='btn btn-primary' value=' Editar '></form></td>");
                                out.print("</tr>");
                        }
                    %>
                </tbody>
            </table>
        </div>
        
        <script>
            function really(id){
                event.preventDefault();
                Swal.fire({
                    title: 'Tem certeza?',
                    text: "Este gestor será apagado definitivamente!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Sim, apagar!'
                  }).then((result) => {
                    if (result.value) {
                        document.getElementById('form-delete-'+id).submit();
                    }
                })
            }
        </script>
    </body>
</html>