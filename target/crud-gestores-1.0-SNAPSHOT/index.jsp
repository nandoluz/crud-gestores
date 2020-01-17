<%-- 
    Document   : index
    Created on : 14/01/2020, 11:01:48
    Author     : nando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestores</title>
        <script src="resource/assets/jquery/jquery-3.4.1.js"></script>
        <script src="resource/assets/jquery/popper.min.js"></script>
        <script src="resource/assets/bootstrap/js/bootstrap.js"></script>
        <link href="resource/assets/bootstrap/css/bootstrap.css" rel="stylesheet">        
        <link href="resource/assets/css/custom.css" rel="stylesheet">        
        <link rel="icon" href="favicon.ico">
    </head>
    <body class="text-center">
        <!-- inicio do menu -->
        <nav class="navbar navbar-expand-md navbar-dark bg-primary fixed-top">
            <a class="navbar-brand" href="#">GESTORES</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(atual)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="/crud-gestores" id="gestoresDrop" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestor</a>
                        <div class="dropdown-menu" aria-labelledby="gestoresDrop">
                            <a class="dropdown-item" href="resource/view/gestor/novo.jsp">Novo</a>
                            <a class="dropdown-item" href="resource/view/gestor/listar.jsp">Listar</a>
                        </div>
                    </li>
                </ul>
                <form action="/crud-gestores/resource/view/gestor/busca.jsp" class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Pesquisa gestor" name="por" aria-label="pesquisar">
                    <input type="hidden" name="action" value="pesquisar">
                    <button class="btn btn-dark my-2 my-sm-0" type="submit">Pesquisar</button>
                </form>
            </div>
        </nav>
        <!-- fim do menu -->
        <!-- corpo -->
        <div class="container d-flex h-100 align-items-center">
            <div class="w-100">   
                <h2>Sistema de Manutenção de Gestores</h2>
                <p class="lead">Este sistema contém as principais funções CRUD<br>Foi utilizado a tecnologia JSP</p>
            </div>
        </div>
        <div class="alert alert-danger">
            
        </div>
    </body>
</html>